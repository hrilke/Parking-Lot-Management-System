package Model;

import Model.ENUM.ParkingSpotStatus;
import Model.ENUM.VehicleType;

public class LuxurySpot extends ParkingSpot{
    private String SecurityGuard;

    public LuxurySpot() {
    }

    public LuxurySpot(int spotNo, VehicleType vehicleType, ParkingSpotStatus parkingSpotStatus, Model.Vehicle vehicle, String securityGuard) {
        super(spotNo, vehicleType, parkingSpotStatus, vehicle);
        SecurityGuard = securityGuard;
    }

    public String getSecurityGuard() {
        return SecurityGuard;
    }

    public void setSecurityGuard(String securityGuard) {
        SecurityGuard = securityGuard;
    }
}
