package us.plee19;

/**
 * ATM Factory class with a method to create a certain type of ATM based on the ATMType given
 * @author plee19
 * @version 1.0
 */
public class ATMFactory {

    /**
     * Method to create an ATM, taking in an ATMType as a parameter and returning an ATM instance.
     * @param atm ATMType type of ATM to be created
     * @return ATM instance
     */
    public ATM createATM(ATMType atm) {
        switch(atm) {
            case CHECKIN:
                return new CheckInATM();
            case CHECKOUT:
                return new CheckOutATM();
            default:
                return null;
        }
    }
}
