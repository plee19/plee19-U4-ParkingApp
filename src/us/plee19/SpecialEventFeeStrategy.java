package us.plee19;

/**
 * Special Event Fee Strategy implementing FeeStrategy and its getTicketFee method
 * @author plee19
 * @version 1.0
 */

public class SpecialEventFeeStrategy implements FeeStrategy {
    /**
     * Implemented getTicketFee method returning a ticket fee for Special Events
     * @param inTime int value for check-in time
     * @param outTime int value for check-out time
     * @return int value of ticket fee
     */
    public int getTicketFee(int inTime, int outTime) {
        return 20;
    }

    /**
     * Overridden toString method for use in the ATM scripts.
     * @return String of Special Event
     */
    @Override
    public String toString() {
        String toString = "Special Event";
        return toString;
    }
}