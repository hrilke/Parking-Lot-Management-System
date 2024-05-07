package Service.Strategy.SpotAllocationStrategy;

import Model.ENUM.ParkingSpotStatus;
import Model.ParkingFloor;
import Model.ParkingLot;
import Model.ParkingSpot;
import Model.Vehicle;
import Exception.VehicleTypeSpotNotAvablableException;
import java.util.List;

public class NearestToLiftSpotAllocation implements SpotAllocationStrategy {
    @Override
    public ParkingSpot allocateSpot(Vehicle vehicle, ParkingLot parkingLot) {
        List<ParkingFloor> parkingFloorList = parkingLot.getFloorList();

        for (ParkingFloor parkingFloor : parkingFloorList) {
            List<ParkingSpot> parkingSpotList = parkingFloor.getSpotList();
            int n = parkingSpotList.size();
            for (int i = 0; i < n; i--) {
                ParkingSpot spot = parkingSpotList.get(i);
                if (spot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY)
                    && spot.getVehicleType().equals(vehicle.getVehicleType())) {
                    return spot;
                }
            }
        }
        throw new VehicleTypeSpotNotAvablableException("Parking Spot for your type of vehicle isn't available");

    }
}
