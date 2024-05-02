package Model;

import Model.ENUM.ParkingSpotStatus;
import Model.ENUM.VehicleType;

public class ParkingSpot extends BaseClass{
    private int spotNo;
    private VehicleType vehicleType;
    private ParkingSpotStatus parkingSpotStatus;
    private Vehicle Vehicle;

    public ParkingSpot() {
    }

    public ParkingSpot(int spotNo, VehicleType vehicleType, ParkingSpotStatus parkingSpotStatus, Model.Vehicle vehicle) {
        this.spotNo = spotNo;
        this.vehicleType = vehicleType;
        this.parkingSpotStatus = parkingSpotStatus;
        Vehicle = vehicle;
    }

    public int getSpotNo() {
        return spotNo;
    }

    public void setSpotNo(int spotNo) {
        this.spotNo = spotNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public Model.Vehicle getVehicle() {
        return Vehicle;
    }

    public void setVehicle(Model.Vehicle vehicle) {
        Vehicle = vehicle;
    }
}
