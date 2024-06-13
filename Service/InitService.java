package Service;

import Model.*;
import Model.ENUM.*;
import Repository.*;


import java.util.ArrayList;
import java.util.List;

public class InitService {

    private static int parkingLotId ;
    private GateRepository gateRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private ParkingLotRepository parkingLotRepository;
    private ParkingSpotRepository parkingSpotRepository;

    public InitService
            (GateRepository gateRepository,
             ParkingFloorRepository parkingFloorRepository,
             ParkingLotRepository parkingLotRepository,
             ParkingSpotRepository parkingSpotRepository) {
        this.gateRepository = gateRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public ParkingLot init() {
        System.out.println("*******  Parking Lot Initialization  *******");

        ParkingLot parkingLot = new ParkingLot(++parkingLotId);
        parkingLot.setName("GTA PARKING LOT");
        parkingLot.setAddress("Vice City");
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        parkingLot.setCapacity(100);
        parkingLot.setVehicleTypeList(List.of(VehicleType.LUXURY, VehicleType.ELECTRIC, VehicleType.HANDICAPPED, VehicleType.GENERAL));

        List<ParkingFloor> parkingFloorList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setId(i);
            parkingFloor.setFloorNo(i);
            parkingFloor.setParkingFloorStatus(ParkingFloorStatus.AVAILABLE);
            List<ParkingSpot> parkingSpotList = new ArrayList<>();
            for (int j = 1; j <= 10; j++) {
                ParkingSpot parkingSpot;
                if (i == 1) {
                    parkingSpot = new LuxurySpot();
                    parkingSpot.setVehicleType(VehicleType.LUXURY);
                }
                else if (j == 1 && i != 1) {
                    parkingSpot = new HandicapSpot();
                    parkingSpot.setVehicleType(VehicleType.HANDICAPPED);
                } else if (j == 5 && i != 1) {
                    parkingSpot = new EVSpot();
                    parkingSpot.setVehicleType(VehicleType.ELECTRIC);
                }  else {
                    parkingSpot = new ParkingSpot();
                    parkingSpot.setVehicleType(VehicleType.GENERAL);
                }

                parkingSpot.setId((i * 100) + j);
                parkingSpot.setSpotNo((i * 100) + j);
                parkingSpot.setParkingSpotStatus(ParkingSpotStatus.EMPTY);
                parkingSpotList.add(parkingSpot);
                parkingSpotRepository.add(parkingSpot);
            }
            parkingFloor.setSpotList(parkingSpotList);

            Gate entryGate = new Gate(GateType.ENTRY, (i * 1000) + 1, GateStatus.OPEN);
            parkingFloor.setEntryGate(entryGate);
            gateRepository.add(entryGate);

            Gate exitGate = new Gate(GateType.EXIT, (i * 1000) + 2, GateStatus.OPEN);
            parkingFloor.setExitGate(exitGate);
            gateRepository.add(exitGate);

            parkingFloorList.add(parkingFloor);
            parkingFloorRepository.add(parkingFloor);
        }
        parkingLot.setFloorList(parkingFloorList);
        parkingLotRepository.add(parkingLot);
        return parkingLotRepository.get(1);
    }
}