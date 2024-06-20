package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

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
        return "Ticket{" +
                " \nticketId = " + getId() +
                ", \nparkingSpot = " + parkingSpot.getSpotNo() +
                ", \nStaff_Help = " + getStaffName(parkingSpot) +
                ", \nvehicle = " + vehicle.getRegistrationNumber() +
                ", \nentryTime = " + entryTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) +
                ", \nentryGate = " + entryGate.getGateNum() +
                " \n- - - - - -" +
                '}';
    }
    private static String getStaffName(ParkingSpot parkingSpot){
        if (parkingSpot.getClass().equals(HandicapSpot.class)) {
            return ((HandicapSpot) parkingSpot).getWheelchairHelper().getName();
        }
        else if (parkingSpot.getClass().equals(EVSpot.class)) {
            return ((EVSpot) parkingSpot).getEvStationStaff().getName();
        }
        else if (parkingSpot.getClass().equals(LuxurySpot.class)) {
            return ((LuxurySpot) parkingSpot).getSecurityGuard().getName();
        }
        return "Not Applicable";
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
