package Controller;

import Model.Ticket;
import Service.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public Ticket generateTicket(){
        return ticketService.generateTicket();
    }
}
