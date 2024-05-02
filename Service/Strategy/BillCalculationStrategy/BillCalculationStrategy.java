package Service.Strategy.BillCalculationStrategy;

import Model.Bill;
import Model.Ticket;

public interface BillCalculationStrategy {
    public Bill generateBill(Ticket ticket);
}
