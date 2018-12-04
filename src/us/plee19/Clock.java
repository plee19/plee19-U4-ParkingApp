package us.plee19;

/**
 * Singleton class Clock to be used in getting checkin and checkout times.
 * @author plee19
 * @version 1.0
 */

public class Clock {
    private static Clock ourInstance = new Clock();

    /**
     * Method to return instance of Clock as per Singleton pattern.
     * @return Clock instance
     */
    public static Clock getInstance() {
        return ourInstance;
    }

    /**
     * Private constructor for Clock.
     */
    private Clock() {
    }

    /**
     * Method to return a check-in time, used for Tickets.
     * @return int check-in time
     */
    public int getInTime() {
        return (int)(Math.random() * ((12 - 7) + 1)) + 7;
    }

    /**
     * Method to return a check-out time, used for Tickets.
     * @return int check-out time
     */
    public int getOutTime() {
        return (int)(Math.random() * ((23 - 13) + 1)) + 13;
    }
}
