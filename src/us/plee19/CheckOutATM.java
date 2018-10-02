package us.plee19;

import java.util.ArrayList;

/**
 * Class extending ATM to serve as the check-out ATM.
 * @author plee19
 * @version 1
 */
public class CheckOutATM extends ATM {
    FileInput ticketFile = new FileInput("ticketFile.txt");

    /**
     * Method to read from CSV file of tickets and return an ArrayList of ticket objects.
     * @return ArrayList of ticket objects
     */
    public void loadExistingTickets() {
        String line;
        String[] fields;
        ArrayList<Ticket> ticketList = new ArrayList<>();

        while ((line = ticketFile.fileReadLine()) != null) {
            fields = line.split(",");
            Ticket ticket = new Ticket(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), Integer.parseInt(fields[3]));
            Ticket.count = Integer.parseInt(fields[0]);
            ticketList.add(ticket);
        }
        ATM.tickets = ticketList;
    }

    /**
     * Method to calculate the end time of the ticket and place it in the checkOutTime field.
     * @param ticket Ticket object
     */
    public static void getOutTime(Ticket ticket) {
        ticket.checkOutTime = (int) (Math.random() * ((23 - 13) + 1)) + 13;
    }

    /**
     * Method to calculate bill, leading into the printScreen method to display result to customer
     * @param ticket Ticket object with valid checkOutTime
     */
    public static void checkOut(Ticket ticket) {
        if (ticket.checkOutTime - ticket.checkInTime <= 3) {
            ticket.bill = 5;
        } else {
            ticket.bill = 5 + (ticket.checkOutTime - ticket.checkInTime - 3);
        }
        // Max rate per day
        if (ticket.bill > 15) {
            ticket.bill = 15;
        }
        printScreen(ticket);
    }

    /**
     * Method to display bill to customer based on ticket.
     * @param ticket Ticket object
     */
    public static void printScreen(Ticket ticket) {
        System.out.println("Best Value Parking Garage\n\n=========================\n\n" +
                "Receipt for a vehicle id " + ticket.ticketNumber +
                "\n\n\n" + (ticket.checkOutTime - ticket.checkInTime) + " hours parked "
                + ticket.checkInTime + " - " + ticket.checkOutTime + "\n\n$" + ticket.bill);
    }

    /**
     * Method to set a ticket as lost and display the result to the customer.
     * @param ticket Ticket object
     */
    public static void lostTicket(Ticket ticket) {
        ticket.bill = 25;
        System.out.println("Best Value Parking Garage\n\n=========================\n\n" +
                "Receipt for a vehicle id " + ticket.ticketNumber +
                "\n\nLost Ticket\n\n$" + ticket.bill);
    }

    /**
     * Overridden method from ATM superclass to present menu and determine course of action.
     */
    @Override
    public void displayStartScreen() {
        System.out.print("Best Value Parking Garage\n\n=========================\n\n1 - Check/Out\n2 - Lost Ticket\n\n=>");
        boolean isValidNumber = false;
        boolean isValidTicket = false;
        while (!isValidNumber) {
            int inputNumber = keyboard.nextInt();

            switch (inputNumber) {
                case 1:
                    isValidNumber = true;
                    while (!isValidTicket) {
                        System.out.println("Enter ticket number or 0 to quit: ");
                        int tickNum = keyboard.nextInt();
                        if (tickNum == 0) {
                            isValidTicket = true;
                            continue;
                        }
                        for (int i = 0; i < CheckOutATM.tickets.size(); i++) {
                            if (CheckOutATM.tickets.get(i).ticketNumber == tickNum) {
                                isValidTicket = true;
                                getOutTime(tickets.get(i));
                                checkOut(tickets.get(i));
                            }
                        }
                        if (!isValidTicket) {
                            System.out.println("Invalid ticket");
                        }
                    }
                case 2:
                    while (!isValidTicket) {
                        System.out.println("Enter ticket number or 0 to quit: ");
                        int tickNum = keyboard.nextInt();
                        for (int i = 0; i < CheckOutATM.tickets.size(); i++) {
                            if (CheckOutATM.tickets.get(i).ticketNumber == tickNum) {
                                lostTicket(tickets.get(i));
                                isValidTicket = true;
                                break;
                            } else if (tickNum == 0) {
                                isValidTicket = true;
                                break;
                            }
                        }
                        if (!isValidTicket) {
                             System.out.println("Invalid ticket");
                             isValidTicket = false;
                             break;
                        }
                        isValidNumber = true;
                        break;
                    }
            }
        }
    }
}
