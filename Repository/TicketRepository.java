package Repository;

import Model.Ticket;
import Exception.TicketNotFoundException;
import java.util.HashMap;

public class TicketRepository {
    private HashMap<Integer, Ticket> ticketHashMap;
    private static int idCounter;

    public TicketRepository() {
        this.ticketHashMap = new HashMap<>();
    }

    public Ticket add(Ticket ticket) {
        ticket.setId(++idCounter);
        ticketHashMap.put(ticket.getId(), ticket);
        System.out.println("Collect your ticket");
        return ticketHashMap.get(idCounter);
    }

    public Ticket get(int ticketId){
        Ticket ticket = ticketHashMap.get(ticketId);
        if (ticket == null) {
            throw new TicketNotFoundException("Ticket not found for id: "+ ticketId);
        }
        return ticket;
    }
}
