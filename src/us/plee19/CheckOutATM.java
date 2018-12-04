package us.plee19;

import java.util.ArrayList;

/**
 * Class extending ATM to serve as the check-out ATM.
 * @author plee19
 * @version 1.0
 */
public class CheckOutATM extends ATM {


    /**
     * Method to read from CSV file of tickets and return an ArrayList of ticket objects.
     * @return ArrayList of ticket objects
     */
    public static void loadTickets() {
        String line;
        String[] fields;
        ArrayList<Ticket> ticketList = new ArrayList<>();

        while ((line = ticketFile.fileReadLine()) != null) {
            fields = line.split(",");
            Ticket ticket = new Ticket(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), Integer.parseInt(fields[3]));
            ticket.setCount(Integer.parseInt(fields[0]));
            ticketList.add(ticket);
        }
        ATM.tickets = ticketList;
    }

    /**
     * Method to display bill to customer based on ticket.
     * @param ticket Ticket object
     */
    public static void printScreen(Ticket ticket) {
        System.out.println("Best Value Parking Garage\n\n=========================\n\nReceipt for a vehicle id " + ticket.getTicketNumber() +
                "\n\n\n");
        if (ticket.getBill() >= 5 && ticket.getBill() <= 15 ) {
            System.out.println(ticket.getCheckOutTime() - ticket.getCheckInTime() + " hours parked "
                    + ticket.getCheckInTime() + " - " + ticket.getCheckOutTime() + "\n\n$" + ticket.getFeeStrategy().getTicketFee(ticket.getCheckInTime(), ticket.getCheckOutTime()));
        } else {
            System.out.println(ticket.getFeeStrategy().toString() + "\n\n" + ticket.getBill());
        }
        /*if (ticket.getBill() == 20) {
            System.out.println("Special Event\n\n$" + ticket.getBill());
        } else if (ticket.getBill() == 15) {
            System.out.println("Lost Ticket\n\n$" + ticket.getBill());
        } else {
            System.out.println(ticket.getCheckOutTime() - ticket.getCheckInTime() + " hours parked "
                + ticket.getCheckInTime() + " - " + ticket.getCheckOutTime() + "\n\n$" + ticket.getFeeStrategy().getTicketFee(ticket.getCheckInTime(), ticket.getCheckOutTime()));
        }*/
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
                            if (CheckOutATM.tickets.get(i).getTicketNumber() == tickNum) {
                                Ticket ticket = tickets.get(i);
                                isValidTicket = true;
                                ticket.setCheckOutTime(Clock.getInstance().getOutTime());
                                if (ticket.getFeeStrategy() == null) {
                                    ticket.setFeeStrategy(new NormalFeeStrategy());
                                    ticket.setBill(ticket.getFeeStrategy().getTicketFee(ticket.getCheckInTime(), ticket.getCheckOutTime()));
                                    printScreen(ticket);
                                }
                                if (ticket.getFeeStrategy().toString() == "Special Event") {
                                    ticket.setBill(ticket.getFeeStrategy().getTicketFee(ticket.getCheckInTime(), ticket.getCheckOutTime()));
                                    printScreen(ticket);
                                }
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
                            if (CheckOutATM.tickets.get(i).getTicketNumber() == tickNum) {
                                Ticket ticket = tickets.get(i);
                                ticket.setFeeStrategy(new LostTicketFeeStrategy());
                                ticket.setBill(ticket.getFeeStrategy().getTicketFee(ticket.getCheckInTime(), ticket.getCheckOutTime()));
                                isValidTicket = true;
                                printScreen(ticket);
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