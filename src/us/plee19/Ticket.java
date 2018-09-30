package us.plee19;

public class Ticket {
    static int count;
    public int ticketNumber;
    public int checkInTime;
    public int checkOutTime;
    public int day = 0;
    public int bill;

    public Ticket(int inTime) {
        ticketNumber = count++;
        this.checkInTime = inTime;
    }

    public Ticket(int ticketNumber, int inTime, int outTime, int day, int bill) {
        this.ticketNumber = ticketNumber;
        inTime = checkInTime;
        outTime = checkOutTime;
        this.day = day;
        this.bill = bill;
    }

}
