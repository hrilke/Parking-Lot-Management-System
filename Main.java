import Controller.BillController;
import Controller.InitController;
import Controller.TicketController;
import Model.Bill;
import Model.ENUM.VehicleType;
import Model.ParkingLot;
import Model.Ticket;
import Model.Vehicle;
import Repository.*;
import Service.BillService;
import Service.InitService;
import Service.Strategy.BillCalculationStrategy.BillingCalculationStrategyName;
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
        TicketController ticketController = new TicketController(ticketService);

        BillRepository billRepository = new BillRepository();
        BillService billService = new BillService(billRepository,gateRepository);
        BillController billController = new BillController(billService);

        Vehicle vehicle = new Vehicle(VehicleType.LUXURY,"MH14DW6561");

        Ticket ticket = ticketController.generateTicket(vehicle,1001,1, SpotAllocationStrategyName.SPECIAL_VEHICLE);
        System.out.println( ticket.toString());

        Vehicle vehicle1 = new Vehicle(VehicleType.HANDICAPPED,"MH14DW6562");

        Ticket ticket1 = ticketController.generateTicket(vehicle1,1001,1, SpotAllocationStrategyName.SPECIAL_VEHICLE);
        System.out.println( ticket1.toString());

        Vehicle vehicle2 = new Vehicle(VehicleType.ELECTRIC,"MH14DW6563");

        Ticket ticket2 = ticketController.generateTicket(vehicle2,1001,1, SpotAllocationStrategyName.SPECIAL_VEHICLE);
        System.out.println( ticket2.toString());

        Vehicle vehicle3 = new Vehicle(VehicleType.GENERAL,"MH14DW6564");

        Ticket ticket3 = ticketController.generateTicket(vehicle3,1001,1, SpotAllocationStrategyName.LINEAR);
        System.out.println( ticket3.toString());

        Bill bill = billController.generateBill(ticket, ticket.getEntryTime().plusMinutes(70), BillingCalculationStrategyName.AGGRESSIVE_BUSINESS_CHARGE,parkingLotRepository.get(1), 1002);
        System.out.println(bill.toString());

        Bill bill1 = billController.generateBill(ticket1, ticket.getEntryTime().plusMinutes(243), BillingCalculationStrategyName.AGGRESSIVE_BUSINESS_CHARGE,parkingLotRepository.get(1),1002);
        System.out.println(bill1.toString());

        Bill bill2 = billController.generateBill(ticket2, ticket.getEntryTime().plusMinutes(80), BillingCalculationStrategyName.AGGRESSIVE_BUSINESS_CHARGE,parkingLotRepository.get(1),1002);
        System.out.println(bill2.toString());

        Bill bill3 = billController.generateBill(ticket3, ticket.getEntryTime().plusMinutes(129), BillingCalculationStrategyName.AGGRESSIVE_BUSINESS_CHARGE,parkingLotRepository.get(1),1002);
        System.out.println(bill3.toString());
    }
}
