import Controller.InitController;
import Model.ParkingLot;
import Repository.GateRepository;
import Repository.ParkingFloorRepository;
import Repository.ParkingLotRepository;
import Repository.ParkingSpotRepository;
import Service.InitService;

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


    }
}
