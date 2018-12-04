package us.plee19;

/**
 * Ticket class with constructors for creation of Ticket objects to be used by ATMs.
 * @author plee19
 * @version 1
 */
public class Ticket {
    private static int count = 100;
    private int ticketNumber;
    private int checkInTime;
    private int checkOutTime;
    private int bill;
    private FeeStrategy feeStrategy;


    /**
     * Single parameter constructor for Ticket, leaving other values null or 0.
     * @param inTime int calculated start time of the ticket
     */
    public Ticket(int inTime) {
        setTicketNumber(count++);
        this.setCheckInTime(inTime);
    }

    public Ticket(Ticket ticket, FeeStrategy feeStrategy) {
        this.ticketNumber = ticket.getTicketNumber();
        this.checkInTime = ticket.getCheckInTime();
        this.checkOutTime = ticket.getCheckOutTime();
        this.feeStrategy = feeStrategy;
    }

    /**
     * Constructor for building Ticket ArrayList from CSV file.
     * @param ticketNumber int ticket number
     * @param inTime int calculated start time of the ticket
     * @param outTime int calculated end time of the ticket
     * @param bill int calculated bill of the ticket
     */
    public Ticket(int ticketNumber, int inTime, int outTime, int bill) {
        this.setTicketNumber(ticketNumber);
        this.setCheckInTime(inTime);
        this.setCheckOutTime(outTime);
        this.setBill(bill);
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(int checkInTime) {
        this.checkInTime = checkInTime;
    }

    public int getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(int checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public FeeStrategy getFeeStrategy() {
        return feeStrategy;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
