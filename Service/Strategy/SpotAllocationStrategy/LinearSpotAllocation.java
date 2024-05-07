package Service.Strategy.SpotAllocationStrategy;

import Model.ENUM.ParkingSpotStatus;
import Model.ParkingFloor;
import Model.ParkingLot;
import Model.ParkingSpot;
import Model.Vehicle;
import Exception.VehicleTypeSpotNotAvablableException;
import java.util.List;

public class LinearSpotAllocation implements SpotAllocationStrategy{
    @Override
    public ParkingSpot allocateSpot(Vehicle vehicle, ParkingLot parkingLot) {
        List <ParkingFloor> parkingFloorArrayList = parkingLot.getFloorList();

        for (ParkingFloor parkingFloor : parkingFloorArrayList) {
            for (ParkingSpot parkingSpot : parkingFloor.getSpotList()) {
                if (parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY)
                    && parkingSpot.getVehicleType().equals(vehicle.getVehicleType())) {
                    return parkingSpot;
                }
            }
        }
        throw new VehicleTypeSpotNotAvablableException("Parking Spot for your type of vehicle aren't available");
    }
}
