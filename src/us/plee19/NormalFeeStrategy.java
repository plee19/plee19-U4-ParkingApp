package us.plee19;

public class NormalFeeStrategy implements FeeStrategy {
    public int getTicketFee(int inTime, int outTime) {
        int bill = 0;
        if (outTime - inTime <= 3) {
            bill = 5;
        } else {
            if ((5 + (outTime - inTime - 3)) < 15) {
                bill = (5 + (outTime - inTime - 3));
            } else {
                bill = 15;
            }
        }
        return bill;
    }
}
