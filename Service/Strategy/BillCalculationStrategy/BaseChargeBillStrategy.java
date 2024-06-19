package Service.Strategy.BillCalculationStrategy;

import Model.Bill;
import Model.Ticket;
import Model.Vehicle;

import java.time.LocalDateTime;

public class BaseChargeBillStrategy implements BillCalculationStrategy {

    @Override
    public Double getAmount(Ticket ticket, LocalDateTime exitTime, int parkingLot) {

        switch (ticket.getVehicle().getVehicleType()) {
            case LUXURY : return luxuryCharge;
            case GENERAL: return generalCharge;
            case HANDICAPPED: return handicappedCharge;
            case ELECTRIC: return EVCharge;
        }
        return null;
    }
}
