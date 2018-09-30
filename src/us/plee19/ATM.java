package us.plee19;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class ATM {
    static ArrayList<Ticket> tickets = new ArrayList<>();
    static boolean isValidOption = false;
    static CheckInATM checkIn = new CheckInATM();
    static CheckOutATM checkOut = new CheckOutATM();
    static Scanner keyboard = new Scanner(System.in);

    /*public static void displayStartScreen() {
    }*/

    public abstract void displayStartScreen();
}
