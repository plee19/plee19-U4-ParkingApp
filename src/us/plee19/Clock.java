package us.plee19;

public class Clock {
    private static Clock ourInstance = new Clock();

    public static Clock getInstance() {
        return ourInstance;
    }

    private Clock() {
    }

    public int getInTime() {
        return (int)(Math.random() * ((12 - 7) + 1)) + 7;
    }

    public int getOutTime() {
        return (int)(Math.random() * ((23 - 13) + 1)) + 13;
    }
}
