package Service.Strategy.SpotAllocationStrategy;
import Exception.VehicleTypeSpotNotAvablableException;
import Model.*;
import Model.ENUM.ParkingSpotStatus;
import Model.ENUM.VehicleType;

import java.util.List;

public class SpecialSpotAllocation implements SpotAllocationStrategy {
    @Override
    public ParkingSpot allocateSpot(Vehicle vehicle, ParkingLot parkingLot) {
        List<ParkingFloor> floors = parkingLot.getFloorList();

        if (vehicle.getVehicleType() == VehicleType.ELECTRIC) {
            for (ParkingFloor parkingFloor : floors) {
                ParkingSpot spot = parkingFloor.getSpotList().get(4);
                if (spot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY)) {
                    return spot;
                }
            }
        }
        else if (vehicle.getVehicleType() == VehicleType.HANDICAPPED) {
            for (ParkingFloor parkingFloor : floors) {
                ParkingSpot spot = parkingFloor.getSpotList().get(0);
                if (spot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY)
                    && spot.getClass().equals(HandicapSpot.class)) {
                    return spot;
                }
            }
        }
        else if (vehicle.getVehicleType() == VehicleType.LUXURY) {
            List<ParkingSpot> spots = parkingLot.getFloorList().get(0).getSpotList();
            for (ParkingSpot spot : spots) {
                if (spot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY)
                  && spot.getClass().equals(LuxurySpot.class)) {
                    return spot;
                }
            }
        }
        throw new VehicleTypeSpotNotAvablableException("Parking spot Not Available for this Vehicle type");
    }
}
