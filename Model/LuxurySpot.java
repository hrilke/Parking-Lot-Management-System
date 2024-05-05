package Model;

import Model.ENUM.ParkingSpotStatus;
import Model.ENUM.VehicleType;

public class LuxurySpot extends ParkingSpot{
    private Staff SecurityGuard;


    public LuxurySpot(Staff securityGuard) {
        SecurityGuard = securityGuard;
    }

    public LuxurySpot(int spotNo, VehicleType vehicleType, ParkingSpotStatus parkingSpotStatus, Model.Vehicle vehicle, Staff securityGuard) {
        super(spotNo, vehicleType, parkingSpotStatus, vehicle);
        SecurityGuard = securityGuard;
    }

    public Staff getSecurityGuard() {
        return SecurityGuard;
    }

    public void setSecurityGuard(Staff securityGuard) {
        SecurityGuard = securityGuard;
    }
}
