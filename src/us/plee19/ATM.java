package us.plee19;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Abstract class to serve as superclass of Check-In and Check-Out ATMs, with static tickets ArrayList and Scanner.
 * @author plee19
 * @version 1
 */
public abstract class ATM {
    static ArrayList<Ticket> tickets = new ArrayList<>();
    static Scanner keyboard = new Scanner(System.in);
    static FileInput ticketFile = new FileInput("ticketFile.txt");
    static FileOutput ticketFileOut = new FileOutput("ticketFile.txt");

    public abstract void displayStartScreen();
}
