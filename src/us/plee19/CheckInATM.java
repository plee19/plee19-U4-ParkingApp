package us.plee19;

/**
 * Class extending ATM to serve as the Check-In ATM.
 * @author plee19
 * @version 1.0
 */
public class CheckInATM extends ATM {
    public static boolean isClosed = false;
    private int paidTicketCount;
    private int specialEventTicketCount;
    private int lostTicketCount;
    private int paidTicketSum;

    /**
     * Method to create a new instance of Ticket and print resulting ticket number to customer.
     */
    public void createTicket() {
        Ticket newTicket = new Ticket(Clock.getInstance().getInTime());
        tickets.add(newTicket);
        System.out.println("Best Value Parking Garage\n\n=========================\n\nTicket number " + newTicket.getTicketNumber() + "\n");
        keyboard.nextLine();
    }

    /**
     * Method to create a new instance of Ticket with the Special Event Fee Strategy, printing resulting ticket number to customer.
     */
    public void createSpecialEventTicket() {
        Ticket newTicket = new Ticket(0);
        newTicket.setFeeStrategy(new SpecialEventFeeStrategy());
        tickets.add(newTicket);
        System.out.println("Best Value Parking Garage\n\n=========================\n\nTicket number " + newTicket.getTicketNumber() + "\nSpecial Event Ticket\n");
    }

    /**
     * Method to write to file with ticket information and print resulting revenue.
     */
    public void closeGarage() {
        for (int i = 0; i < tickets.size(); i++) {
            Ticket ticket = tickets.get(i);
            // Unpaid tickets at close will default as LostTicket
            if (ticket.getBill() == 0) {
                ticket.setFeeStrategy(new LostTicketFeeStrategy());
                ticket.setBill(ticket.getFeeStrategy().getTicketFee(ticket.getCheckInTime(), ticket.getCheckOutTime()));
            }
            ticketFileOut.fileWrite(ticket.getTicketNumber() + "," + ticket.getCheckInTime() + "," + ticket.getCheckOutTime() + "," + ticket.getBill());
        }
        ticketFileOut.fileClose();

        String line;
        String[] fields;
        while ((line = ticketFile.fileReadLine()) != null) {
            fields = line.split(",");
            if (Integer.parseInt(fields[3]) == 25) {
                lostTicketCount++;
            } else if (Integer.parseInt(fields[3]) == 20) {
                specialEventTicketCount++;
            } else {
                paidTicketCount++;
                paidTicketSum += Integer.parseInt(fields[3]);
            }
        }

        System.out.println("Best Value Parking Garage\n\n=========================\n\nDaily Activity\n");
        System.out.println("$" + paidTicketSum + " was collected from " + paidTicketCount + " Check Ins\n");
        System.out.println("$" + (specialEventTicketCount * 20) + " was collected from " + specialEventTicketCount + " Special Events");
        System.out.println("$" + (lostTicketCount * 25) + " was collected from " + lostTicketCount + " Lost Tickets\n");
        System.out.println("$" + (paidTicketSum + (lostTicketCount * 25)) + " was collected overall");

        isClosed = true;
    }

    /**
     * Overridden method from ATM superclass to present menu and determine course of action.
     */
    @Override
    public void displayStartScreen() {
        System.out.print("Best Value Parking Garage\n\n=========================\n\n1 - Check/In\n2 - Special Event\n3 - Close Garage\n\n=>");
        boolean isValidNumber = false;
        while (isValidNumber == false) {
            int inputNumber = keyboard.nextInt();
            switch(inputNumber) {
                case 1:
                    isValidNumber = true;
                    createTicket();
                    break;
                case 2:
                    isValidNumber = true;
                    createSpecialEventTicket();
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
