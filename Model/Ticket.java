package Model;

import java.time.LocalDateTime;

public class Ticket extends BaseClass{
    private ParkingSpot parkingSpot;

    private Vehicle vehicle;

    private LocalDateTime entryTime;

    public Ticket(){}

    public Ticket(ParkingSpot parkingSpot, Vehicle vehicle, LocalDateTime entryTime) {
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        this.entryTime = entryTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }
}
