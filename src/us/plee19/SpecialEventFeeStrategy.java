package us.plee19;

public class SpecialEventFeeStrategy implements FeeStrategy {
    public int getTicketFee(int inTime, int outTime) {
        return 20;
    }

    @Override
    public String toString() {
        String toString = "Special Event";
        return toString;
    }
}
