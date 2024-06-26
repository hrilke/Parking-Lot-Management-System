package Repository;

import Model.ParkingLot;
import Exception.ParkingLotNotFoundException;
import java.sql.SQLOutput;
import java.util.HashMap;

public class ParkingLotRepository {
    private HashMap<Integer, ParkingLot> parkingLotHashMap;
    private static int idCounter = 0;

    public ParkingLotRepository() {
        this.parkingLotHashMap = new HashMap<>();
    }

    public void add(ParkingLot parkingLot){
        parkingLot.setId(++idCounter);
        parkingLotHashMap.put(parkingLot.getId(), parkingLot);
        System.out.println("Parking Lot "+ parkingLot.getName() +" Has been Initialized to the Database"
                            + " \n- - - - - - - - ");

    }
    public ParkingLot get(int parkingLotId){
        ParkingLot newParkingLot = parkingLotHashMap.get(parkingLotId);
        if (newParkingLot == null) {
            throw new ParkingLotNotFoundException("Parking lot not found for id: "+ parkingLotId);
        }
        return newParkingLot;
    }
}
