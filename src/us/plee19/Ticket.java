package us.plee19;

/**
 * Ticket class with constructors for creation of Ticket objects to be used by ATMs.
 * @author plee19
 * @version 1.0
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

    /**
     * Getter method for ticketNumber, returning an int.
     * @return int value of ticketNumber
     */
    public int getTicketNumber() {
        return ticketNumber;
    }

    /**
     * Setter method for ticketNumber, taking in an int.
     * @param ticketNumber int value of ticketNumber
     */
    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    /**
     * Getter method for checkInTime, returning an int.
     * @return int value of checkInTime
     */
    public int getCheckInTime() {
        return checkInTime;
    }

    /**
     * Setter method for checkInTime, taking in an int.
     * @param checkInTime int value of checkInTime
     */
    public void setCheckInTime(int checkInTime) {
        this.checkInTime = checkInTime;
    }

    /**
     * Getter method for checkOutTime, returning an int.
     * @return int value of checkOutTime
     */
    public int getCheckOutTime() {
        return checkOutTime;
    }

    /**
     * Setter method for checkOutTime, taking in an int.
     * @param checkOutTime int value of checkOutTime
     */
    public void setCheckOutTime(int checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    /**
     * Getter method for bill, returning an int.
     * @return int value of bill
     */
    public int getBill() {
        return bill;
    }

    /**
     * Setter method for bill, taking in an int.
     * @param bill int value of bill
     */
    public void setBill(int bill) {
        this.bill = bill;
    }

    /**
     * Setter method for feeStrategy, taking in a FeeStrategy.
     * @param feeStrategy FeeStrategy instance
     */
    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    /**
     * Getter method for feeStrategy, returning a FeeStrategy.
     * @return feeStrategy FeeStrategy instance
     */
    public FeeStrategy getFeeStrategy() {
        return feeStrategy;
    }

    /**
     * Getter method for count used for where to start ticket numbers, returning an int.
     * @return count int value for ticket number start
     */
    public int getCount() {
        return count;
    }

    /**
     * Setter method for count used for where to start ticket numbers, taking in an int.
     * @param count int value for ticket number start
     */
    public void setCount(int count) {
        this.count = count;
    }
}
