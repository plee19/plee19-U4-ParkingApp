package us.plee19;

import java.util.ArrayList;

public class CheckOutATM extends ATM {
    int lostTicketCount;
    int ticketsPaidCount;

    public void loadExistingTickets() {

    }

    public void getOutTime(Ticket ticket) {
        ticket.checkOutTime = (int)(Math.random() * ((23 - 13) + 1)) + 13;
    }

    public void calculateBill(Ticket ticket) {
        if (ticket.day > 0) {
            ticket.bill = 15;
        } else if (ticket.checkOutTime - ticket.checkInTime <= 3){
            ticket.bill = 5;
        } else {
            ticket.bill = 5 + (ticket.checkOutTime - ticket.checkInTime - 3);
        }
        System.out.println("Best Value Parking Garage\n\n=========================\n\n" +
                "Receipt for a vehicle id " + ticket.ticketNumber +
                "\n\n\n" + (ticket.checkOutTime - ticket.checkInTime) + "hours parked "
                + ticket.checkInTime + " - " + ticket.checkOutTime + "\n\n$" + ticket.bill);
    }

    public void lostTicket(Ticket ticket) {
        ticket.bill = 25;
        lostTicketCount++;
        System.out.println("Best Value Parking Garage\n\n=========================\n\n" +
                "Receipt for a vehicle id " + ticket.ticketNumber +
                "\n\n\nLost Ticket\n\n$" + ticket.bill);
    }

    @Override
    public void displayStartScreen() {
        System.out.print("Best Value Parking Garage\n\n=========================\n\n1 - Check/Out\n2 - Lost Ticket\n\n=>");
    }

    public void payBill(Ticket ticket) {
        System.out.println("Thanks for your payment.");
        // Remove from ArrayList
    }

    public void payLostTicket(Ticket ticket) {
        System.out.println("Thanks for your payment.");
        // Remove from ArrayList
    }
}
