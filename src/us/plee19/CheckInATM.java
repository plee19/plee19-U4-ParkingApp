package us.plee19;

import java.util.Scanner;

public class CheckInATM extends ATM {
    Scanner keyboard = new Scanner(System.in);

    public int getInTime() {
        return (int)(Math.random() * ((12 - 7) + 1)) + 7;
    }

    public void createTicket(int inTime) {
        Ticket newTicket = new Ticket(inTime);
    }

    public void closeGarage() {
        System.out.println("Best Value Parking Garage\n\n=========================\n\nActivity to Date\n\n\n");

        // Print total $ collected, count of check-ins, lost tickets collected, total lost tickets, total overall
    }

    @Override
    public void displayStartScreen() {
        System.out.print("Best Value Parking Garage\n\n=========================\n\n1 - Check/In\n\n3 - Close Garage\n\n=>");
        boolean isValidNumber = false;
        while (!isValidNumber) {
            int inputNumber = keyboard.nextInt();
            switch(inputNumber) {
                case 1:
                    isValidNumber = true;
                    createTicket(this.getInTime());
                    break;
                case 3:
                    isValidNumber = true;
                    this.closeGarage();
                    break;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
    }
}
