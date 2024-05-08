package Controller;

import Model.Ticket;
import Model.Vehicle;
import Service.Strategy.SpotAllocationStrategy.SpotAllocationStrategyName;
import Service.TicketService;
import Exception.InvalidEntryDetailsException;
public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public Ticket generateTicket(Vehicle vehicle, int gateId, int parkingLotId, SpotAllocationStrategyName strategyName){
        if (gateId <= 0 || parkingLotId <= 0) {
            throw new InvalidEntryDetailsException("Invalid Entry GateId or Parking Lot Id");
        }
        return ticketService.generateTicket(vehicle,gateId,parkingLotId,strategyName);
    }
}
