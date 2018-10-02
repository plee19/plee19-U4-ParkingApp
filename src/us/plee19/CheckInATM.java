package us.plee19;

import java.util.Scanner;

/**
 * Class extending ATM to serve as the Check-In ATM.
 * @author plee19
 * @version 1
 */
public class CheckInATM extends ATM {
    Scanner keyboard = new Scanner(System.in);
    public boolean isClosed = false;
    FileOutput ticketFile = new FileOutput("ticketFile.txt");
    FileInput ticketFileRead = new FileInput("ticketFile.txt");
    int paidTicketCount;
    int lostTicketCount;
    int paidTicketSum;

    /**
     * Method to calculate start time of ticket, prior to ticket creation.
     * @return int check-in time to be used in ticket creation
     */
    public int getInTime() {
        return (int)(Math.random() * ((12 - 7) + 1)) + 7;
    }

    /**
     * Method to create a new instance of Ticket and print resulting ticket number to customer.
     * @param inTime int check-in time to be used in ticket creation
     */
    public void createTicket(int inTime) {
        Ticket newTicket = new Ticket(inTime);
        tickets.add(newTicket);
        System.out.println("Best Value Parking Garage\n\n=========================\n\nTicket number " + newTicket.ticketNumber + "\n");
        keyboard.nextLine();
    }

    /**
     * Method to write to file with ticket information and print resulting revenue.
     */
    public void closeGarage() {
        for (int i = 0; i < tickets.size(); i++) {
            // Unpaid tickets at close will default as LostTicket
            if (tickets.get(i).bill == 0) {
                tickets.get(i).bill = 25;
            }
            ticketFile.fileWrite(tickets.get(i).ticketNumber + "," + tickets.get(i).checkInTime + "," + tickets.get(i).checkOutTime + "," + tickets.get(i).bill);
        }
        ticketFile.fileClose();

        String line;
        String[] fields;
        while ((line = ticketFileRead.fileReadLine()) != null) {
            fields = line.split(",");
            if (Integer.parseInt(fields[4]) == 25) {
                lostTicketCount++;
            } else if (Integer.parseInt(fields[4]) != 0) {
                paidTicketCount++;
                paidTicketSum += Integer.parseInt(fields[4]);
            }
        }

        System.out.println("Best Value Parking Garage\n\n=========================\n\nDaily Activity\n");
        System.out.println("$" + paidTicketSum + " was collected from " + paidTicketCount + " Check Ins\n");
        System.out.println("$" + (lostTicketCount * 25) + " was collected from " + lostTicketCount + " Lost Tickets\n");
        System.out.println("$" + (paidTicketSum + (lostTicketCount * 25)) + " was collected overall");

        isClosed = true;
    }

    /**
     * Overridden method from ATM superclass to present menu and determine course of action.
     */
    @Override
    public void displayStartScreen() {
        System.out.print("Best Value Parking Garage\n\n=========================\n\n1 - Check/In\n3 - Close Garage\n\n=>");
        boolean isValidNumber = false;
        while (isValidNumber == false) {
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
