package Service.Strategy.SpotAllocationStrategy;

import Model.ParkingSpot;
import Model.Vehicle;

public interface SpotAllocationStrategy {
    ParkingSpot allocateSpot(Vehicle vehicle);
}
