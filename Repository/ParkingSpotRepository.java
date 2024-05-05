package Repository;

import Model.ParkingSpot;
import Exception.ParkingSpotNotFoundException;
import java.util.HashMap;

public class ParkingSpotRepository {
    private HashMap<Integer, ParkingSpot> parkingSpotHashMap;

    public ParkingSpotRepository() {
        this.parkingSpotHashMap = new HashMap<>();
    }

    public void add(ParkingSpot parkingSpot) {
        parkingSpotHashMap.put(parkingSpot.getId(), parkingSpot);
        System.out.println("Parking Spot Has been initialized to the Database");
    }
    public ParkingSpot get(int parkingSpotId){
        ParkingSpot newParkingSpot = parkingSpotHashMap.get(parkingSpotId);
        if (newParkingSpot == null) {
            throw new ParkingSpotNotFoundException("Parking Spot not found for id: "+ parkingSpotId);
        }
        return newParkingSpot;
    }
}
