package us.plee19;

import java.util.Scanner;

public class Main {
    static Scanner keyboard = new Scanner(System.in);
    static boolean isValidOption = false;
    static CheckInATM checkIn = new CheckInATM();
    static CheckOutATM checkOut = new CheckOutATM();

    public static void main(String[] args) {
        checkOut.tickets = checkOut.loadExistingTickets();
        while (!checkIn.isClosed){
            ATM.mainScreen();
        }
    }
}