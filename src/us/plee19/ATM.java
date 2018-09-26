package us.plee19;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    static ArrayList<Ticket> tickets = new ArrayList<>();
    static boolean isValidOption = false;
    static CheckInATM checkIn = new CheckInATM();
    static CheckOutATM checkOut = new CheckOutATM();
    static Scanner keyboard = new Scanner(System.in);

    public void displayStartScreen() {
    }

    public static void mainScreen() {
        System.out.print("Best Value Parking Garage\n\n=========================\n\n1 - Check/In\n2 - Check/Out\n\n=>");
        while (!isValidOption) {
            switch(keyboard.nextInt()) {
                case 1:
                    checkIn.displayStartScreen();
                    isValidOption = true;
                    break;
                case 2:
                    isValidOption = true;
                    checkOut.displayStartScreen();
                    break;
                default:
                    System.out.println("Please select a valid option.");
            }
        }
        isValidOption = false;
    }
}
