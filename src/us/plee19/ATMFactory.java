package us.plee19;

public class ATMFactory {
    public ATM getATM(ATMType atm) {
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
