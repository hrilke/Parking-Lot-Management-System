package Service.Strategy.BillCalculationStrategy;

import Model.Bill;
import Model.ParkingLot;
import Model.Ticket;

import java.time.LocalDateTime;

public interface BillCalculationStrategy {
    public final double luxuryCharge = 500.00;
    public final double EVCharge = 100.00;
    public final double handicappedCharge = 50.00;
    public final double generalCharge = 200.00;

    public final double timedLuxuryCharge = 100.00;
    public final double timedEVCharge = 20.00;
    public final double timedHandicappedCharge = 20.00;
    public final double timedGeneralCharge = 50.00;
    public double getAmount(Ticket ticket, LocalDateTime exitTime);
}
