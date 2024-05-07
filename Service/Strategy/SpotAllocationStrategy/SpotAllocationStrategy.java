package Service.Strategy.SpotAllocationStrategy;

import Model.ParkingLot;
import Model.ParkingSpot;
import Model.Vehicle;

public interface SpotAllocationStrategy {
    ParkingSpot allocateSpot(Vehicle vehicle, ParkingLot parkingLot);
}
