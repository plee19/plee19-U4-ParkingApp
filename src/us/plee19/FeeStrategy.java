package us.plee19;

public interface FeeStrategy {
    int getTicketFee(int inTime, int outTime);
}
