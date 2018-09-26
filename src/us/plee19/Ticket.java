package us.plee19;

public class Ticket {
    static int count = 100;
    public int ticketNumber;
    public int checkInTime;
    public int checkOutTime;
    public int day = 0;
    public double bill;

    public Ticket(int inTime) {
        ticketNumber = count++;
        this.checkInTime = inTime;
    }

    public Ticket(int ticketNumber, int inTime, int outTime, int day, double bill) {
        this.ticketNumber = ticketNumber;
        inTime = checkInTime;
        outTime = checkOutTime;
        this.day = day;
        this.bill = bill;
    }
}
