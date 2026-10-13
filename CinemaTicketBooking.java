import java.util.Scanner;

public class CinemaTicketBooking {
    String movieName;
    double ticketPrice;
    int numberOfTickets;
    String customerName;

    CinemaTicketBooking(String movieName, double ticketPrice, int numberOfTickets, String customerName) {
        this.movieName = movieName.toUpperCase();
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
        this.customerName = customerName.toUpperCase();
    }

    CinemaTicketBooking(String movieName, double ticketPrice, String customerName) {
        this(movieName, ticketPrice, 1, customerName);
    }

    void bookTickets(String movieName, double ticketPrice, int numberOfTickets, String customerName) {
        this.movieName = movieName.toUpperCase();
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
        this.customerName = customerName.toUpperCase();
    }

    void bookTickets(String movieName, double ticketPrice, String customerName) {
        bookTickets(movieName, ticketPrice, 1, customerName);
    }

    boolean compareCustomer(String otherCustomer) {
        return this.customerName.equalsIgnoreCase(otherCustomer);
    }

    void displaySummary() {
        System.out.println("========== CINEMA TICKET BOOKING ==========");
        System.out.println("Customer Name   : " + customerName);
        System.out.println("Movie Name      : " + movieName);
        System.out.printf("Ticket Price    : Rs. %.2f\n", ticketPrice);
        System.out.println("Number of Tickets : " + numberOfTickets);

        if (numberOfTickets > 0) {
            System.out.println("Booking Status  : Booking Successful");
            double total = numberOfTickets * ticketPrice;
            double discount = (numberOfTickets >= 5) ? (total * 0.10) : 0.0;

            System.out.printf("Total Amount    : Rs. %.2f\n", total);
            System.out.printf("Discount        : Rs. %.2f\n", discount);
        } else {
            System.out.println("Booking Status  : Booking Failed");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer Name: ");
        String customer = sc.nextLine();

        System.out.print("Enter Movie Name: ");
        String movie = sc.nextLine();

        System.out.print("Enter Ticket Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Number of Tickets: ");
        int tickets = sc.nextInt();

        CinemaTicketBooking booking = new CinemaTicketBooking(movie, price, tickets, customer);
        booking.displaySummary();

        sc.close();
    }
}