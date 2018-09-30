package us.plee19;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CheckInATM extends ATM {
    Scanner keyboard = new Scanner(System.in);
    public boolean isClosed = false;
    FileOutput ticketFile = new FileOutput("ticketFile.txt");
    FileInput ticketFileRead = new FileInput("ticketFile.txt");
    int paidTicketCount;
    int lostTicketCount;
    int paidTicketSum;

    public int getInTime() {
        return (int)(Math.random() * ((12 - 7) + 1)) + 7;
    }

    public void createTicket(int inTime) {
        Ticket newTicket = new Ticket(inTime);
        tickets.add(newTicket);
        System.out.println("Best Value Parking Garage\n\n=========================\n\nTicket number " + newTicket.ticketNumber + "\n\n\n\n");
        keyboard.nextLine();
    }

    public void closeGarage() {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).bill == 0) {
                tickets.get(i).day++;
            }
            ticketFile.fileWrite(tickets.get(i).ticketNumber + "," + tickets.get(i).checkInTime + "," + tickets.get(i).checkOutTime + "," + tickets.get(i).day + "," + tickets.get(i).bill);
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

        System.out.println("Best Value Parking Garage\n\n=========================\n\nActivity to Date\n\n");
        System.out.println("$" + paidTicketSum + " was collected from " + paidTicketCount + " Check Ins\n");
        System.out.println("$" + (lostTicketCount * 25) + " was collected from " + lostTicketCount + " Lost Tickets\n");
        System.out.println("$" + (paidTicketSum + (lostTicketCount * 25)) + " was collected overall");

        isClosed = true;
    }

    public void displayStartScreen() {
        System.out.print("Best Value Parking Garage\n\n=========================\n\n1 - Check/In\n\n3 - Close Garage\n\n=>");
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
