package us.plee19;

public class Ticket {
    static int count = 0;
    public int ticketNumber;
    public int checkInTime;
    public int checkOutTime;
    public int day = 0;
    public int bill;

    public Ticket(int inTime) {
        ticketNumber = count++;
        this.checkInTime = inTime;
    }
}
