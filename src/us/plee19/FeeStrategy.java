package us.plee19;

/**
 * Interface for Fee Strategies, requiring a getTicketFee method.
 * @author plee19
 * @version 1.0
 */
public interface FeeStrategy {
    /**
     * Method to return an integer ticket fee based on inTime and outTime parameters.
     * @param inTime int value for check-in time
     * @param outTime int value for check-out time
     * @return int ticket fee
     */
    int getTicketFee(int inTime, int outTime);
}
