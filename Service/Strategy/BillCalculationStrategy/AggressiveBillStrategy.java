package Service.Strategy.BillCalculationStrategy;

import Model.ENUM.ParkingSpotStatus;
import Model.ENUM.VehicleType;
import Model.ParkingFloor;
import Model.ParkingLot;
import Model.ParkingSpot;
import Model.Ticket;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class AggressiveBillStrategy implements BillCalculationStrategy {

    private ParkingLot parkingLot;
    private double occupancy;
    private double capacity;
    private static double surgeFactor;

    public AggressiveBillStrategy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.capacity = (double)parkingLot.getCapacity();
        this.occupancy = getOccupancy(parkingLot);
        this.surgeFactor = this.occupancy/this.capacity;

    }
    private static double getOccupancy(ParkingLot parkingLot){
        double occupancy = 0.00;
        List<ParkingFloor> floorList = parkingLot.getFloorList();

        for (ParkingFloor parkingFloor : floorList) {
            List<ParkingSpot> parkingSpotList = parkingFloor.getSpotList();
            for (ParkingSpot parkingSpot : parkingSpotList) {
                if (parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.OCCUPIED)) {
                    occupancy++;
                }
            }
        }
        return occupancy;
    }
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
        baseAmount = calculateSurgeAmount(baseAmount);
        double timeCharges = calculateAmount(vehicleType,ticket.getEntryTime(), exitTime);
        return timeCharges + baseAmount;
    }

    private static double calculateSurgeAmount(double baseAmount) {
        double finalAmount = baseAmount;
        if (surgeFactor > 0.5 && surgeFactor < 0.75) {
            finalAmount += baseAmount * 0.5 ;
        } else if (surgeFactor > 0.75 && surgeFactor < 0.90) {
            finalAmount += baseAmount * 0.75 ;
        } else if (surgeFactor > 0.9) {
            finalAmount += baseAmount;
        }
        return finalAmount;
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
