package practice;

public class TicketCounter {
    private int ticketsAvailable;

    private int ticketsSold = 0;
    private int ticketsRemaining;

    // TODO: the constructor
    public TicketCounter(int ticketsAvailable) {
        this.ticketsAvailable = ticketsAvailable;

    }

    // TODO: the method sellTicket
    public void sellTicket() {
        ticketsSold = ticketsSold + Math.min(ticketsSold, ticketsAvailable);
        ticketsAvailable = ticketsAvailable - 1;
        ticketsAvailable = Math.max(ticketsAvailable, 0);
    }

    // TODO: the method makeMoreTicketsAvailable
    public void makeMoreTicketsAvailable(int amount) {
        ticketsAvailable = ticketsAvailable + amount;

    }

    // TODO: the method getTicketsSold
    public int getTicketsSold() {
        return ticketsSold;
    }

    // TODO: the method getTicketsRemaining
    public int getTicketsRemaining() {
        return ticketsAvailable;
    }


    public static void main(String[] args) {
        // You can put simple test code here.
        TicketCounter tc = new TicketCounter(1);

        tc.sellTicket();
        tc.sellTicket();

        System.out.print(tc.getTicketsRemaining());
    }
}