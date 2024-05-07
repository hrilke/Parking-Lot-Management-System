package Service;

import Model.Ticket;
import Model.Vehicle;

import java.time.LocalDateTime;

public class TicketService {

    public Ticket generateTicket(Vehicle vehicle, int GateId, int ParkingLotId){
        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(LocalDateTime.now());
        ticket.setParkingSpot();

    }
}
