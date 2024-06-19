package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket extends BaseClass{
    private ParkingSpot parkingSpot;

    private Vehicle vehicle;

    private LocalDateTime entryTime;

    private Gate entryGate;

    public Ticket(){}

    public Ticket(ParkingSpot parkingSpot, Vehicle vehicle, LocalDateTime entryTime, Gate entryGate) {
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        this.entryTime = entryTime;
        this.entryGate = entryGate;
    }

    @Override
    public String toString() {
        return '{' +
                " \nticketId=" + getId() +
                ", \nparkingSpot=" + parkingSpot.getSpotNo() +
                ", \nvehicle=" + vehicle.getRegistrationNumber() +
                ", \nentryTime=" + DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").format(entryTime) +
                ", \nentryGate=" + entryGate.getGateNum() +
                " \n" +
                '}';
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
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
