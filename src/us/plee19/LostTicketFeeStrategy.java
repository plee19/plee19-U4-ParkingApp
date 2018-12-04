package us.plee19;

public class LostTicketFeeStrategy implements FeeStrategy {
    public int getTicketFee(int inTime, int outTime) {
        return 25;
    }

    @Override
    public String toString() {
        String toString = "Lost Ticket";
        return toString;
    }
}
