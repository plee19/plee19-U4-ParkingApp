package us.plee19;

/**
 * Normal Fee Strategy implementing FeeStrategy and its getTicketFee method to return a fee amount as bill.
 * @author plee19
 * @version 1.0
 */
public class NormalFeeStrategy implements FeeStrategy {

    /**
     * Implemented getTicketFee method returning a ticket fee as bill variable
     * @param inTime int value for check-in time
     * @param outTime int value for check-out time
     * @return int value of bill for ticket fee
     */
    public int getTicketFee(int inTime, int outTime) {
        int bill;
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
