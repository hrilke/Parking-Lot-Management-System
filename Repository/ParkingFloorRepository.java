package Repository;

import Model.ParkingFloor;
import Exception.ParkingFloorNotFoundException;
import java.util.HashMap;

public class ParkingFloorRepository {
    private HashMap<Integer, ParkingFloor> parkingFloorHashMap;

    public ParkingFloorRepository() {
        this.parkingFloorHashMap = new HashMap<>();
    }

    public void add(ParkingFloor parkingFloor){
        parkingFloorHashMap.put(parkingFloor.getId(), parkingFloor);
        System.out.println("Parking Floor "+parkingFloor.getFloorNo() +" has been initialized to the Database");
    }

    public ParkingFloor get(int parkingFloorId){
        ParkingFloor newParkingFloor = parkingFloorHashMap.get(parkingFloorId);
        if (newParkingFloor == null) {
            throw new ParkingFloorNotFoundException("Parking Floor not found for id: "+ parkingFloorId);
        }
        return newParkingFloor;
    }
}
