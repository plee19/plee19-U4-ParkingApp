package us.plee19;

import java.util.ArrayList;

public class CheckOutATM extends ATM {
    FileInput ticketFile = new FileInput("ticketFile.txt");

    public ArrayList<Ticket> loadExistingTickets() {
        String line;
        String[] fields;
        int count;
        ArrayList<Ticket> ticketList = new ArrayList<>();

        while ((line = ticketFile.fileReadLine()) != null) {
            fields = line.split(",");
            Ticket ticket = new Ticket(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), Integer.parseInt(fields[4]));
            Ticket.count = Integer.parseInt(fields[0]);
            ticketList.add(ticket);
        }
        return ticketList;
    }

    public static void getOutTime(Ticket ticket) {
        ticket.checkOutTime = (int) (Math.random() * ((23 - 13) + 1)) + 13;
    }

    public static void checkOut(Ticket ticket) {
        if (ticket.day > 0) {
            ticket.bill = 15;
        } else if (ticket.checkOutTime - ticket.checkInTime <= 3) {
            ticket.bill = 5;
        } else {
            ticket.bill = 5 + (ticket.checkOutTime - ticket.checkInTime - 3);
        }
        printScreen(ticket);
    }

    public static void printScreen(Ticket ticket) {
        System.out.println("Best Value Parking Garage\n\n=========================\n\n" +
                "Receipt for a vehicle id " + ticket.ticketNumber +
                "\n\n\n" + (ticket.checkOutTime - ticket.checkInTime) + "hours parked "
                + ticket.checkInTime + " - " + ticket.checkOutTime + "\n\n$" + ticket.bill);
    }

    public static void lostTicket(Ticket ticket) {
        ticket.bill = 25;
        System.out.println("Best Value Parking Garage\n\n=========================\n\n" +
                "Receipt for a vehicle id " + ticket.ticketNumber +
                "\n\n\nLost Ticket\n\n$" + ticket.bill);
    }

    @Override
    public void displayStartScreen() {
        System.out.print("Best Value Parking Garage\n\n=========================\n\n1 - Check/Out\n2 - Lost Ticket\n\n=>");
        boolean isValidNumber = false;
        boolean isValidTicket = false;
        while (!isValidNumber) {
            int inputNumber = keyboard.nextInt();

            // NEED TO REFACTOR/ADJUST
            switch (inputNumber) {
                case 1:
                    while (!isValidTicket) {
                        System.out.println("Enter ticket number: ");
                        int tickNum = keyboard.nextInt();
                        for (int i = 0; i < CheckOutATM.tickets.size(); i++) {
                            if (CheckOutATM.tickets.get(i).ticketNumber == tickNum) {
                                isValidTicket = true;
                                getOutTime(tickets.get(i));
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
                            //System.out.println("Please enter a valid option.");
                    }
            }
        }
    }
