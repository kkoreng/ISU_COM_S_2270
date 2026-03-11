package hw1;

/**
 * Model of a Monopoly-like game. Two players take turns
 * rolling dice to move around a board. The game ends
 * when one of the players has at least MONEY_TO_WIN
 * money or one of the players goes bankrupt (they have
 * negative money).
 * 
 * @author Heeryun Cho
 */
public class CyGame {
	/**
	 * The endzone square type.
	 */
	public static final int ENDZONE = 0;
	/**
	 * The CyTown square type.
	 */
	public static final int CYTOWN = 1;
	/**
	 * The pay rent square type.
	 */
	public static final int PAY_RENT = 2;
	/**
	 * The fall behind square type.
	 */
	public static final int FALL_BEHIND = 3;
	/**
	 * The blizzard square type.
	 */
	public static final int BLIZZARD = 4;
	/**
	 * The pass class square type.
	 */
	public static final int PASS_CLASS = 5;



	/**
	 * Points awarded when landing on or passing over the endzone square.
	 */
	public static final int ENDZONE_PRIZE = 200;
	/**
	 * The standard rent payed to the other player when landing on a
	 * pay rent square.
	 */
	public static final int STANDARD_RENT_PAYMENT = 80;
	/**
	 * The cost to by CyTown.
	 */
	public static final int CYTOWN_COST = 200;
	/**
	 * The amount of money required to win.
	 */
	public static final int MONEY_TO_WIN = 400;


	// TODO: EVERYTHING ELSE
	// Note that this code will not compile until you have put in stubs for all
	// the required methods.

	// The toString method below is provided for you and you should not modify
	// it. The compile errors will go away after you have written stubs for the
	// rest of the API methods.

	private int numSquares;
	private int currentPlayer;

	private int player1Square;
	private int player2Square;

	private int player1Money;
	private int player2Money;

	private int cyTownOwner;
	private boolean canBuyCyTown;


	public CyGame(int numSquares, int startingMoney) {
		this.numSquares = numSquares;

		this.player1Money = startingMoney;
		this.player2Money = startingMoney;

		this.currentPlayer = 1;

		this.player1Square = 0;
		this.player2Square = 0;

		this.cyTownOwner = 0;
		this.canBuyCyTown = false;
	}

	public void buyCyTown() {
		if (getPlayerSquare(currentPlayer) != numSquares - 1) return;
		if (!canBuyCyTown) return;
		if (cyTownOwner != 0) return;
		if (getPlayerMoney(currentPlayer) < CYTOWN_COST) return;

		if (currentPlayer == 1) {
			player1Money -= CYTOWN_COST;
			cyTownOwner = 1;
		} else {
			player2Money -= CYTOWN_COST;
			cyTownOwner = 2;
		}

		endTurn();
	}

	public void endTurn() {
		canBuyCyTown = false;

		if (currentPlayer == 1) {
			currentPlayer = 2;
		} else if (currentPlayer == 2) {
			currentPlayer = 1;
		}
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public int getOtherPlayer() {
		if (currentPlayer == 1) {
			return 2;
		} else if (currentPlayer == 2) {
			return 1;
		}
		return 0;
	}

	public int getPlayerMoney(int player) {
		if (player == 1) {
			return player1Money;
		} else if (player == 2) {
			return  player2Money;
		}
		return 0;
	}

	public int getPlayerSquare(int player) {
		if (player == 1) {
			return player1Square;
		} else if (player == 2) {
			return player2Square;
		}
		return 0;
	}

	public int getSquareType(int square) {
		if (square == 0) {
			return ENDZONE;
		} else if (square == numSquares-1) {
			return CYTOWN;
		} else if (square % 5 == 0) {
			return PAY_RENT;
		} else if (square % 7 == 0 || square % 11 == 0) {
			return FALL_BEHIND;
		} else if (square % 3 == 0) {
			return BLIZZARD;
		} else {
			return PASS_CLASS;
		}
	}

	public boolean isGameEnded() {
        return player1Money >= MONEY_TO_WIN || player2Money >= MONEY_TO_WIN || player1Money < 0 || player2Money < 0;
    }

	public boolean isPlayer1CyTownOwner() {
        return cyTownOwner == 1;
	}

	public boolean isPlayer2CyTownOwner() {
		return cyTownOwner == 2;
	}

	public void roll(int value) {
		if (isGameEnded()) {
			return;
		}

		canBuyCyTown = false;

		int currentSquare = getPlayerSquare(currentPlayer);

		if (getSquareType(currentSquare) == BLIZZARD && value % 2 == 0) {
			endTurn();
			return;
		}

		int newSquare = (currentSquare + value) %numSquares;

		if (currentSquare + value >= numSquares) {
			if (currentPlayer == 1) {
				player1Money += ENDZONE_PRIZE;
			} else {
				player2Money += ENDZONE_PRIZE;
			}
		}

		if (currentPlayer == 1) {
			player1Square = newSquare;
		} else {
			player2Square = newSquare;
		}

		if (getSquareType(newSquare) == CYTOWN) {
			if (cyTownOwner == 0) {
				canBuyCyTown = true;
			}
			return;
		}

		int newSquareType = getSquareType(newSquare);

		if (newSquareType == PAY_RENT) {
			payRent();
		} else if (newSquareType == FALL_BEHIND) {
			fallBehind();
		} else if (newSquareType == PASS_CLASS) {
			passClass();
		}

		if (!canBuyCyTown) {
			endTurn();
		}
	}

	private void payRent() {
		if (currentPlayer == 1) {
			player1Money -= STANDARD_RENT_PAYMENT;
			player2Money += STANDARD_RENT_PAYMENT;
			if (isPlayer2CyTownOwner()) {
				player1Money -= STANDARD_RENT_PAYMENT;
				player2Money += STANDARD_RENT_PAYMENT;
			}
		} else if (currentPlayer == 2) {
			player2Money -= STANDARD_RENT_PAYMENT;
			player1Money += STANDARD_RENT_PAYMENT;
			if (isPlayer1CyTownOwner()) {
				player2Money -= STANDARD_RENT_PAYMENT;
				player1Money += STANDARD_RENT_PAYMENT;
			}
		}
	}

	private void fallBehind() {
		int newSquare = getPlayerSquare(currentPlayer) - 1;

		if (newSquare < 0) {
			newSquare = numSquares - 1;
		}

		if (currentPlayer == 1) {
			player1Square = newSquare;
		} else {
			player2Square = newSquare;
		}

		int type = getSquareType(newSquare);

		if (type == FALL_BEHIND || type == PASS_CLASS) {
			return;
		}

		if (type == PAY_RENT) {
			payRent();
		} else if (type == CYTOWN) {
			if (cyTownOwner == 0) {
				canBuyCyTown = true;
			}
		} else if (type == ENDZONE) {
			if (currentPlayer == 1) {
				player1Money += ENDZONE_PRIZE;
			} else {
				player2Money += ENDZONE_PRIZE;
			}
		}
	}

	private void passClass() {
		int currentSquare = getPlayerSquare(currentPlayer);
		int newSquare = (currentSquare + 4) % numSquares;

		if (currentSquare + 4 >= numSquares) {
			if (currentPlayer == 1) {
				player1Money += ENDZONE_PRIZE;
			} else {
				player2Money += ENDZONE_PRIZE;
			}
		}

		if (currentPlayer == 1) {
			player1Square = newSquare;
		} else {
			player2Square = newSquare;
		}

		int type = getSquareType(newSquare);

		if (type == FALL_BEHIND || type == PASS_CLASS) {
			return;
		}

		if (type == PAY_RENT) {
			payRent();
		} else if (type == CYTOWN) {
			if (cyTownOwner == 0) {
				canBuyCyTown = true;
			}
		}
	}


	/**
	 * Returns a one-line string representation of the current game state. The
	 * format is:
	 * <p>
	 * <tt>Player 1*: (0, false, $0) Player 2: (0, false, $0)</tt>
	 * <p>
	 * The asterisks next to the player's name indicates which players turn it
	 * is. The values (0, false, $0) indicate which square the player is on,
	 * if the player is the owner of CyTown, and how much money the player has
	 * respectively.
	 * 
	 * @return one-line string representation of the game state
	 */
	public String toString() {
		String fmt = "Player 1%s: (%d, %b, $%d) Player 2%s: (%d, %b, $%d)";
		String player1Turn = "";
		String player2Turn = "";
		if (getCurrentPlayer() == 1) {
			player1Turn = "*";
		} else {
			player2Turn = "*";
		}
		return String.format(fmt,
				player1Turn, getPlayerSquare(1), isPlayer1CyTownOwner(), getPlayerMoney(1),
				player2Turn, getPlayerSquare(2), isPlayer2CyTownOwner(), getPlayerMoney(2));
	}



}
