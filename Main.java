import Controller.BillController;
import Controller.InitController;
import Controller.PaymentController;
import Controller.TicketController;
import Model.*;
import Model.ENUM.PaymentMode;
import Model.ENUM.PaymentStatus;
import Model.ENUM.VehicleType;
import Repository.*;
import Service.BillService;
import Service.InitService;
import Service.PaymentService;
import Service.Strategy.BillCalculationStrategy.BillingCalculationStrategyName;
import Service.Strategy.SpotAllocationStrategy.SpotAllocationStrategyName;
import Service.TicketService;

import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

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
        BillService billService = new BillService(billRepository,gateRepository,parkingLotRepository,ticketRepository);
        BillController billController = new BillController(billService);

        PaymentRepository paymentRepository = new PaymentRepository();
        PaymentService paymentService = new PaymentService(paymentRepository);
        PaymentController paymentController = new PaymentController(paymentService);

        BillingCalculationStrategyName billStrategyName = BillingCalculationStrategyName.BASE_CHARGE;
        int parkingLotID = 1;
        int entryGate = 1001;
        int exitGate = 1002;
        Random random = new Random();
        int paymentRefNo = random.nextInt(10000,99999);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Select Option" +
                                " \n 1 : CheckIN and Use Parking " +
                                " \n 2 : CheckOUT and Make Payment");
            int option = sc.nextInt();
            if (option == 1) {
                System.out.println("WELCOME To GTA Parking Lot" +
                        "\n Kindly Enter Vehicle Registration");
                String vehicleNumber = sc.next();
                System.out.println("Select and Choose Parking Spot Category" +
                        "\n 1 : HANDICAPPED CATEGORY " +
                        "\n 2 : LUXURY CATEGORY " +
                        "\n 3 : ELECTRIC VEHICLE CATEGORY"+
                        "\n 4 : GENERAL");
                int type = sc.nextInt();
                VehicleType vehicleType = VehicleType.GENERAL;
                if (type == 1) vehicleType = VehicleType.HANDICAPPED;
                else if (type == 2) vehicleType = VehicleType.LUXURY;
                else if (type == 3) vehicleType = VehicleType.ELECTRIC;
                SpotAllocationStrategyName strategyName = SpotAllocationStrategyName.SPECIAL_VEHICLE;
                if (vehicleType == VehicleType.GENERAL) {
                    System.out.println("Select Preferred Parking Spot" +
                            "\n 1 : NEAR LIFT " +
                            "\n 2 : NEAR EXIT " +
                            "\n 3 : ANYWHERE");
                    int strategy = sc.nextInt();
                    if (strategy == 1) strategyName = SpotAllocationStrategyName.NEAREST_TO_LIFT;
                    else if (strategy == 2) strategyName = SpotAllocationStrategyName.NEAREST_TO_EXIT;
                    else if (strategy == 3) strategyName = SpotAllocationStrategyName.LINEAR;
                }
                Vehicle vehicle = new Vehicle(vehicleType,vehicleNumber);
                Ticket ticket = ticketController.generateTicket(vehicle,entryGate,parkingLotID,strategyName);
                System.out.println(ticket.toString());
            }
            else if (option == 2) {
                System.out.println(" Please Enter your Ticket Number");
                int ticketId = sc.nextInt();
                Bill bill = billController.generateBill(ticketId,parkingLotID,exitGate,billStrategyName);
                System.out.println(bill.toString());
                System.out.println("Select Payment Mode to Make Payment" +
                                    " \n 1 : UPI" +
                                    " \n 2 : CARD" +
                                    " \n 3 : CASH");
                int paymentType = sc.nextInt();
                PaymentMode paymentMode = PaymentMode.CASH;
                if (paymentType == 1) paymentMode = PaymentMode.UPI;
                else if (paymentType == 2) paymentMode = PaymentMode.CARD;


                Payment payment = paymentController.makePayment(bill,String.valueOf(paymentRefNo),paymentMode);
                System.out.println(payment.toString());
                System.out.println("Thank You Visiting, Drive Safe");
            }
        }

    }
}
