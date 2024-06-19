package Service.Strategy.BillCalculationStrategy;

import Model.Bill;
import Model.Ticket;

import java.time.LocalDateTime;

public class AggressiveBillStrategy implements BillCalculationStrategy {
    @Override
    public Double getAmount(Ticket ticket, LocalDateTime exitTime, int parkingLot) {
        return null;
    }
}
