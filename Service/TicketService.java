package Service;

import Model.ENUM.ParkingSpotStatus;
import Model.ParkingLot;
import Model.ParkingSpot;
import Model.Ticket;
import Model.Vehicle;
import Repository.GateRepository;
import Repository.ParkingLotRepository;
import Repository.ParkingSpotRepository;
import Repository.TicketRepository;
import Service.Strategy.SpotAllocationStrategy.SpotAllocationStrategy;
import Service.Strategy.SpotAllocationStrategy.SpotAllocationStrategyFactory;
import Service.Strategy.SpotAllocationStrategy.SpotAllocationStrategyName;

import java.time.LocalDateTime;

public class TicketService {
    private ParkingSpotRepository parkingSpotRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;
    private GateRepository gateRepository;

    public TicketService(ParkingSpotRepository parkingSpotRepository, ParkingLotRepository parkingLotRepository, GateRepository gateRepository, TicketRepository ticketRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
        this.gateRepository = gateRepository;
    }

    public Ticket generateTicket(Vehicle vehicle, int GateNumber, int parkingLotId, SpotAllocationStrategyName strategy){

        SpotAllocationStrategy spotAllocationStrategy = SpotAllocationStrategyFactory.getSpotAllocationStartegy(strategy);
        ParkingLot parkingLot = parkingLotRepository.get(parkingLotId);
        ParkingSpot allocatedSpot = spotAllocationStrategy.allocateSpot(vehicle,parkingLot);
        allocatedSpot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
        allocatedSpot.setVehicle(vehicle);
        parkingSpotRepository.saveChanges(allocatedSpot);


        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(LocalDateTime.now());
        ticket.setParkingSpot(allocatedSpot);
        ticket.setEntryGate(gateRepository.get(GateNumber));
        return ticketRepository.add(ticket);
    }

}
