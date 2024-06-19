package Service.Strategy.BillCalculationStrategy;

import Model.Bill;
import Model.ENUM.VehicleType;
import Model.ParkingLot;
import Model.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeBasedChargeBillStrategy implements BillCalculationStrategy {
    @Override
    public double getAmount(Ticket ticket, LocalDateTime exitTime) {
        double baseAmount = 0.00;
        VehicleType vehicleType = ticket.getVehicle().getVehicleType();
        if (VehicleType.LUXURY.equals(vehicleType)) {
            baseAmount = luxuryCharge;
        } else if (VehicleType.GENERAL.equals(vehicleType)) {
            baseAmount = generalCharge;
        } else if (VehicleType.HANDICAPPED.equals(vehicleType)) {
            baseAmount = handicappedCharge;
        } else if (VehicleType.ELECTRIC.equals(vehicleType)) {
            baseAmount = EVCharge;
        }

        double timeCharges = calculateAmount(vehicleType,ticket.getEntryTime(), exitTime);
        return timeCharges + baseAmount;
    }
    private static double calculateAmount(VehicleType vehicleType, LocalDateTime entryTime, LocalDateTime exitTime){
        Duration duration = Duration.between(entryTime,exitTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        if (minutes > 15) hours++;
        double timeCharge = 0;

        if (VehicleType.LUXURY.equals(vehicleType)) {
            timeCharge = timedLuxuryCharge;
        } else if (VehicleType.GENERAL.equals(vehicleType)) {
            timeCharge = timedGeneralCharge;
        } else if (VehicleType.ELECTRIC.equals(vehicleType)) {
            timeCharge = timedEVCharge;
        } else if (VehicleType.HANDICAPPED.equals(vehicleType)) {
            timeCharge = timedHandicappedCharge;
        }

        return timeCharge * (double)hours;
    }
}
