package us.plee19;

import java.util.Scanner;

public class CheckOutATM extends ATM {
    int lostTicketCount;
    int ticketsPaidCount;
    Scanner keyboard = new Scanner(System.in);

    public void loadExistingTickets() {

    }

    public void checkOut(Ticket ticket) {
        ticket.checkOutTime = (int) (Math.random() * ((23 - 13) + 1)) + 13;
    }

    public void calculateBill(Ticket ticket) {
        if (ticket.day > 0) {
            ticket.bill = 15;
        } else if (ticket.checkOutTime - ticket.checkInTime <= 3) {
            ticket.bill = 5;
        } else {
            ticket.bill = 5 + (ticket.checkOutTime - ticket.checkInTime - 3);
        }
        System.out.println("Best Value Parking Garage\n\n=========================\n\n" +
                "Receipt for a vehicle id " + ticket.ticketNumber +
                "\n\n\n" + (ticket.checkOutTime - ticket.checkInTime) + "hours parked "
                + ticket.checkInTime + " - " + ticket.checkOutTime + "\n\n$" + ticket.bill);
        // Remove from ArrayList
    }

    public void lostTicket(Ticket ticket) {
        ticket.bill = 25;
        lostTicketCount++;
        System.out.println("Best Value Parking Garage\n\n=========================\n\n" +
                "Receipt for a vehicle id " + ticket.ticketNumber +
                "\n\n\nLost Ticket\n\n$" + ticket.bill);
        // Remove from ArrayList
    }

    @Override
    public void displayStartScreen() {
        System.out.print("Best Value Parking Garage\n\n=========================\n\n1 - Check/Out\n2 - Lost Ticket\n\n=>");
        boolean isValidNumber = false;
        boolean isValidTicket = false;
        while (!isValidNumber) {
            int inputNumber = keyboard.nextInt();
            switch (inputNumber) {
                case 1:
                    while (!isValidTicket) {
                        System.out.println("Enter ticket number: ");
                        int tickNum = keyboard.nextInt();
                        for (int i = 0; i < CheckOutATM.tickets.size(); i++) {
                            if (CheckOutATM.tickets.get(i).ticketNumber == tickNum) {
                                isValidTicket = true;
                                checkOut(tickets.get(i));
                            } else {
                                System.out.println("Invalid number");
                                isValidTicket = false;
                            }
                        }
                        isValidNumber = true;
                        break;
                    }
                case 2:
                    while (!isValidTicket) {
                        System.out.println("Enter ticket number: ");
                        int tickNum = keyboard.nextInt();
                        for (int i = 0; i < CheckOutATM.tickets.size(); i++) {
                            if (CheckOutATM.tickets.get(i).ticketNumber == tickNum) {
                                isValidTicket = true;
                                lostTicket(tickets.get(i));
                            } else {
                                System.out.println("Invalid number");
                                isValidTicket = false;
                            }
                        }
                        isValidNumber = true;
                        break;
                    }
                    default:
                            System.out.println("Please enter a valid option.");
                    }
            }
        }
    }
