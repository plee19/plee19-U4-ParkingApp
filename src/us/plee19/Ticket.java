package us.plee19;

/**
 * Ticket class with constructors for creation of Ticket objects to be used by ATMs.
 * @author plee19
 * @version 1
 */
public class Ticket {
    static int count = 100;
    public int ticketNumber;
    public int checkInTime;
    public int checkOutTime;
    public int bill;

    /**
     * Single parameter constructor for Ticket, leaving other values null or 0.
     * @param inTime int calculated start time of the ticket
     */
    public Ticket(int inTime) {
        ticketNumber = count++;
        this.checkInTime = inTime;
    }

    /**
     * Constructor for building Ticket ArrayList from CSV file.
     * @param ticketNumber int ticket number
     * @param inTime int calculated start time of the ticket
     * @param outTime int calculated end time of the ticket
     * @param bill int calculated bill of the ticket
     */
    public Ticket(int ticketNumber, int inTime, int outTime, int bill) {
        this.ticketNumber = ticketNumber;
        inTime = checkInTime;
        outTime = checkOutTime;
        this.bill = bill;
    }

}
