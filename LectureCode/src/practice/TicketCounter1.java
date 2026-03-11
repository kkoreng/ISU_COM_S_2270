package practice;

public class TicketCounter1 {
    private int ticketsAvailable;
    private int ticketsSold;

    public TicketCounter1(int ticketsAvailable) {
        this.ticketsAvailable = ticketsAvailable;
    }

    public void sellTicket() {
        ticketsSold = Math.min(ticketsSold + 1, ticketsSold + ticketsAvailable);
        ticketsAvailable = Math.max(ticketsAvailable - 1, 0);
    }

    public void makeMoreTicketsAvailable(int amount) {
        ticketsAvailable += amount;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    public int getTicketsRemaining() {
        return ticketsAvailable;
    }

    public static void main(String[] args) {
        // Simple test code (optional for students)
        TicketCounter counter = new TicketCounter(2);
        counter.sellTicket();
        System.out.println("Tickets sold: " + counter.getTicketsSold() + " expected 1.");
        System.out.println("Tickets remaining: " + counter.getTicketsRemaining() + " expected 1.");
        counter.makeMoreTicketsAvailable(2);
        counter.sellTicket();
        counter.sellTicket();
        counter.sellTicket();
        counter.sellTicket(); // note that this is the 5th sell, but only 4 have ever been made available
        System.out.println("Tickets sold: " + counter.getTicketsSold() + " expected 4.");
        System.out.println("Tickets remaining: " + counter.getTicketsRemaining() + " expected 0.");
    }
}
