import Controller.InitController;
import Model.ENUM.VehicleType;
import Model.ParkingLot;
import Model.Ticket;
import Model.Vehicle;
import Repository.*;
import Service.InitService;
import Service.Strategy.SpotAllocationStrategy.SpotAllocationStrategyName;
import Service.TicketService;

public class Main {
    public static void main(String[] args) {
        System.out.println("WELCOME TO Parking Lot Management System");
        GateRepository gateRepository = new GateRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        InitService initService = new InitService(
                gateRepository,
                parkingFloorRepository,
                parkingLotRepository,
                parkingSpotRepository
                );
        InitController initController = new InitController(initService);
        ParkingLot GTA = initController.init();
        TicketRepository ticketRepository = new TicketRepository();
        TicketService ticketService = new TicketService(
                parkingSpotRepository,
                parkingLotRepository,
                gateRepository,
                ticketRepository
        );
        Vehicle vehicle = new Vehicle(VehicleType.HANDICAPPED,"MH14DW6561");

        Ticket ticket = ticketService.generateTicket(vehicle,1001,1, SpotAllocationStrategyName.SPECIAL_VEHICLE);
        System.out.println( ticket.toString());
    }
}
