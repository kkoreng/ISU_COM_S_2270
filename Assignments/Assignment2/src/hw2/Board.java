package hw2;

import static api.Direction.*;
import static api.Orientation.*;

import java.util.ArrayList;

import api.Boulder;
import api.Cell;
import api.Direction;
import api.Move;

/**
 * Represents a board in the game. A board contains a 2D grid of cells and a
 * list of boulders that slide over the cells.
 *
 * @author Heeryun Cho
 */
public class Board {
	/**
	 * 2D array of cells, the indexes signify (row, column) with (0, 0) representing
	 * the upper-left corner of the board.
	 */
	private Cell[][] grid;

	/**
	 * A list of boulders that are positioned on the board.
	 */
	private ArrayList<Boulder> boulders;

	/**
	 * A list of moves that have been made in order to get to the current position
	 * of boulders on the board.
	 */
	private ArrayList<Move> moveHistory;
	
	/**
	 * The boulder currently grabbed by the user, or null if none is grabbed.
	 */
	private Boulder grabbedBoulder;
	/**
	 * Total number of successful moves made on this board.
	 */
	private int moveCount;
	/**
	 * True when a boulder is currently positioned over an exit cell.
	 */
	private boolean gameOver;
	
	/**
	 * Constructs a new board from a given 2D array of cells and list of boulders. The
	 * cells of the grid should be updated to indicate which cells have boulders
	 * placed over them (i.e., placeBoulder() method of Cell). The move history should
	 * be initialized as empty.
	 * 
	 * @param grid   a 2D array of cells which is expected to be a rectangular shape
	 * @param boulders list of boulders already containing row-column position which
	 *               should be placed on the board
	 */
	public Board(Cell[][] grid, ArrayList<Boulder> boulders) {
		this.grid = grid;
		this.boulders = boulders;
		moveHistory = new ArrayList<Move>();
		grabbedBoulder = null;
		moveCount = 0;
		gameOver = false;

		for (Boulder boulder : boulders) {
			placeBoulderOnGrid(boulder);
		}
		gameOver = hasBoulderOnExit();
	}

	/**
	 * DO NOT MODIFY THIS CONSTRUCTOR
	 * <p>
	 * Constructs a new board from a given 2D array of String descriptions.
	 * 
	 * @param desc 2D array of descriptions
	 */
	public Board(String[][] desc) {
		this(GridUtil.createGrid(desc), GridUtil.findBoulders(desc));
	}

	/**
	 * Returns the number of rows of the board.
	 * 
	 * @return number of rows
	 */
	public int getRowSize() {
		return grid.length;
	}

	/**
	 * Returns the number of columns of the board.
	 * 
	 * @return number of columns
	 */
	public int getColSize() {
		return grid[0].length;
	}

	/**
	 * Returns the cell located at a given row and column.
	 * 
	 * @param row the given row
	 * @param col the given column
	 * @return the cell at the specified location
	 */
	public Cell getCellAt(int row, int col) {
		return grid[row][col];
	}

	/**
	 * Returns the total number of moves (calls to moveGrabbedBoulder which
	 * resulted in a boulder being moved) made so far in the game.
	 * 
	 * @return the number of moves
	 */
	public int getMoveCount() {
		return moveCount;
	}

	/**
	 * Returns a list of all boulders on the board.
	 * 
	 * @return a list of all boulders
	 */
	public ArrayList<Boulder> getBoulders() {
		return boulders;
	}

	/**
	 * Returns true if the player has completed the puzzle by positioning a boulder
	 * over an exit, false otherwise.
	 * 
	 * @return true if the game is over
	 */
	public boolean isGameOver() {
		return gameOver;
	}
	
	/**
	 * Models the user grabbing (mouse button down) a boulder over the given row and
	 * column. The purpose of grabbing a boulder is for the user to be able to drag
	 * the boulder to a new position, which is performed by calling
	 * moveGrabbedBoulder().
	 * <p>
	 * This method should find which boulder has been grabbed (if any) and record
	 * that boulder as grabbed in some way.
	 * 
	 * @param row row to grab the boulder from
	 * @param col column to grab the boulder from
	 */
	public void grabBoulderAt(int row, int col) {
		grabbedBoulder = null;
		if (row < 0 || row >= getRowSize() || col < 0 || col >= getColSize()) {
			return;
		}

		if (grid[row][col].hasBoulder()) {
			grabbedBoulder = grid[row][col].getBoulder();
		}
	}

	/**
	 * Models the user releasing (mouse button up) the currently grabbed boulder
	 * (if any). Update the object accordingly to indicate no boulder is
	 * currently being grabbed.
	 */
	public void releaseBoulder() {
		grabbedBoulder = null;
	}

	/**
	 * Returns the currently grabbed boulder. If there is no currently grabbed
	 * boulder the method return null.
	 * 
	 * @return the currently grabbed boulder or null if none
	 */
	public Boulder getGrabbedBoulder() {
		return grabbedBoulder;
	}

	/**
	 * Returns true if the cell at the given row and column is available for a
	 * boulder to be placed over it. Boulders can only be placed over ground
	 * and exits. Additionally, a boulder cannot be placed over a cell that is
	 * already occupied by another boulder.
	 * 
	 * @param row row location of the cell
	 * @param col column location of the cell
	 * @return true if the cell is available for a boulder, otherwise false
	 */
	public boolean isAvailable(int row, int col) {
		if (row < 0 || row >= getRowSize() || col < 0 || col >= getColSize()) {
			return false;
		}

		Cell cell = grid[row][col];
		return !cell.isWall() && !cell.hasBoulder();
	}

	/**
	 * Moves the currently grabbed boulder by one cell in the given direction. A
	 * horizontal boulder is only allowed to move right and left and a vertical boulder
	 * is only allowed to move up and down. A boulder can only move over a cell that
	 * is a floor or exit and is not already occupied by another boulder. The method
	 * does nothing under any of the following conditions:
	 * <ul>
	 * <li>The game is over.</li>
	 * <li>No boulder is currently grabbed by the user.</li>
	 * <li>A boulder is currently grabbed by the user, but the boulder is not allowed to
	 * move in the given direction.</li>
	 * </ul>
	 * If none of the above conditions are meet, the method does at least the following:
	 * <ul>
	 * <li>Moves the boulder object by calling its move() method.</li>
	 * <li>Calls placeBoulder() for the grid cell that the boulder is being moved into.</li>
	 * <li>Calls removeBoulder() for the grid cell that the boulder is being moved out of.</li>
	 * <li>Adds the move (as a Move object) to the end of the move history list.</li>
	 * <li>Increments the count of total moves made in the game.</li>
	 * </ul>
	 * 
	 * @param dir the direction to move
	 */
	public void moveGrabbedBoulder(Direction dir) {
		// Hint: this is the longest method, no matter which way you approach it
		// there will need to be a significant amount of logic to check every case.
		// Take it step-by-step and check your progress with simple tests as you go.
		if (gameOver || grabbedBoulder == null) {
			return;
		}

		// Determine which cell the boulder will enter and which cell it will leave.
		int enterRow = grabbedBoulder.getFirstRow();
		int enterCol = grabbedBoulder.getFirstCol();
		int exitRow = grabbedBoulder.getFirstRow();
		int exitCol = grabbedBoulder.getFirstCol();

		if (grabbedBoulder.getOrientation() == HORIZONTAL) {
			if (dir == RIGHT) {
				enterCol = grabbedBoulder.getFirstCol() + grabbedBoulder.getLength();
				exitCol = grabbedBoulder.getFirstCol();
			} else if (dir == LEFT) {
				enterCol = grabbedBoulder.getFirstCol() - 1;
				exitCol = grabbedBoulder.getFirstCol() + grabbedBoulder.getLength() - 1;
			} else {
				return;
			}
		} else {
			if (dir == DOWN) {
				enterRow = grabbedBoulder.getFirstRow() + grabbedBoulder.getLength();
				exitRow = grabbedBoulder.getFirstRow();
			} else if (dir == UP) {
				enterRow = grabbedBoulder.getFirstRow() - 1;
				exitRow = grabbedBoulder.getFirstRow() + grabbedBoulder.getLength() - 1;
			} else {
				return;
			}
		}

		if (!isAvailable(enterRow, enterCol)) {
			return;
		}

		// Update both the grid cells and the boulder's stored position together.
		grid[exitRow][exitCol].removeBoulder();
		grabbedBoulder.move(dir);
		grid[enterRow][enterCol].placeBoulder(grabbedBoulder);
		moveHistory.add(new Move(grabbedBoulder, dir));
		moveCount++;
		gameOver = hasBoulderOnExit();
	}

	/**
	 * Resets the state of the game back to the start, which includes the move
	 * count, the move history, and whether the game is over. The method calls the
	 * reset method of each boulder object. It also updates each grid cells by calling
	 * their placeBoulder method to either set a boulder if one is located over the cell
	 * or set null if no boulder is located over the cell.
	 */
	public void reset() {
		moveCount = 0;
		gameOver = false;
		grabbedBoulder = null;
		moveHistory.clear();

		for (Cell[] row : grid) {
			for (Cell cell : row) {
				cell.removeBoulder();
			}
		}

		for (Boulder boulder : boulders) {
			boulder.reset();
			placeBoulderOnGrid(boulder);
		}
		gameOver = hasBoulderOnExit();
	}

	/**
	 * Returns a list of all legal moves that can be made by any boulder on the
	 * current board.
	 * 
	 * @return a list of legal moves
	 */
	public ArrayList<Move> getAllPossibleMoves() {
		ArrayList<Move> moves = new ArrayList<Move>();
		if (gameOver) {
			return moves;
		}

		for (Boulder boulder : boulders) {
			if (boulder.getOrientation() == HORIZONTAL) {
				if (isAvailable(boulder.getFirstRow(), boulder.getFirstCol() - 1)) {
					moves.add(new Move(boulder, LEFT));
				}
				if (isAvailable(boulder.getFirstRow(), boulder.getFirstCol() + boulder.getLength())) {
					moves.add(new Move(boulder, RIGHT));
				}
			} else {
				if (isAvailable(boulder.getFirstRow() - 1, boulder.getFirstCol())) {
					moves.add(new Move(boulder, UP));
				}
				if (isAvailable(boulder.getFirstRow() + boulder.getLength(), boulder.getFirstCol())) {
					moves.add(new Move(boulder, DOWN));
				}
			}
		}

		return moves;
	}

	/**
	 * Gets the list of all moves performed to get to the current position on the
	 * board.
	 * 
	 * @return a list of moves performed to get to the current position
	 */
	public ArrayList<Move> getMoveHistory() {
		return new ArrayList<Move>(moveHistory);
	}

	/**
	 * This method is only used by the Solver.
	 * <p>
	 * Undo the previous move. The method gets the last move on the moveHistory list
	 * and performs the opposite actions of that move, which are the following:
	 * <ul>
	 * <li>grabs the moved boulder and calls moveGrabbedBoulder passing the opposite
	 * direction</li>
	 * <li>decreases the total move count by two to undo the effect of calling
	 * moveGrabbedBoulder twice</li>
	 * <li>if required, sets is game over to false</li>
	 * <li>removes the move from the moveHistory list</li>
	 * </ul>
	 * If the moveHistory list is empty this method does nothing.
	 */
	public void undoMove() {
		if (moveHistory.isEmpty()) {
			return;
		}

		// Remove the last move, then move that same boulder one cell in the opposite direction.
		Move move = moveHistory.remove(moveHistory.size() - 1);
		grabbedBoulder = move.getBoulder();
		gameOver = false;

		if (move.getDirection() == RIGHT) {
			moveGrabbedBoulder(LEFT);
		} else if (move.getDirection() == LEFT) {
			moveGrabbedBoulder(RIGHT);
		} else if (move.getDirection() == UP) {
			moveGrabbedBoulder(DOWN);
		} else if (move.getDirection() == DOWN) {
			moveGrabbedBoulder(UP);
		}

		moveCount -= 2;
		moveHistory.remove(moveHistory.size() - 1);
		grabbedBoulder = null;
		gameOver = hasBoulderOnExit();
	}

	/**
	 * Places the given boulder onto each grid cell it currently occupies.
	 *
	 * @param boulder boulder to place on the grid
	 */
	private void placeBoulderOnGrid(Boulder boulder) {
		if (boulder.getOrientation() == HORIZONTAL) {
			for (int col = boulder.getFirstCol(); col < boulder.getFirstCol() + boulder.getLength(); col++) {
				grid[boulder.getFirstRow()][col].placeBoulder(boulder);
			}
		} else {
			for (int row = boulder.getFirstRow(); row < boulder.getFirstRow() + boulder.getLength(); row++) {
				grid[row][boulder.getFirstCol()].placeBoulder(boulder);
			}
		}
	}

	/**
	 * Determines whether any exit cell is currently occupied by a boulder.
	 *
	 * @return true if a boulder is on an exit, false otherwise
	 */
	private boolean hasBoulderOnExit() {
		for (Cell[] row : grid) {
			for (Cell cell : row) {
				if (cell.isExit() && cell.hasBoulder()) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		boolean first = true;
		for (Cell row[] : grid) {
			if (!first) {
				buff.append("\n");
			} else {
				first = false;
			}
			for (Cell cell : row) {
				buff.append(cell.toString());
				buff.append(" ");
			}
		}
		return buff.toString();
	}
}