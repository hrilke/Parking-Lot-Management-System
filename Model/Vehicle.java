package Model;

import Model.ENUM.VehicleType;

public class Vehicle extends BaseClass{
    private VehicleType vehicleType;
    private String registrationNumber;

    public Vehicle() {
    }

    public Vehicle(VehicleType vehicleType, String registrationNumber) {
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}
