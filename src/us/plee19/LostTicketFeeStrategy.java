package us.plee19;

/**
 * Lost Ticket Fee Strategy implementing FeeStrategy interface and its getTicketFee method.
 * @author plee19
 * @version 1.0
 */
public class LostTicketFeeStrategy implements FeeStrategy {
    /**
     * Method to return an integer ticket fee based on inTime and outTime parameters.
     * @param inTime int value for check-in time
     * @param outTime int value for check-out time
     * @return int ticket fee of 25 for lost tickets
     */
    public int getTicketFee(int inTime, int outTime) {
        return 25;
    }

    /**
     * Overridden toString method for use in the ATM scripts.
     * @return String of Lost Ticket
     */
    @Override
    public String toString() {
        String toString = "Lost Ticket";
        return toString;
    }
}
