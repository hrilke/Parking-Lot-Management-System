package Service.Strategy.BillCalculationStrategy;

import Model.Bill;
import Model.Ticket;

public class BaseChargeBillStrategy implements BillCalculationStrategy {
    @Override
    public Bill generateBill(Ticket ticket) {
        return null;
    }
}
