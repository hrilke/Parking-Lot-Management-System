package Controller;

import Model.Bill;
import Model.ParkingLot;
import Model.Ticket;
import Service.BillService;
import Service.Strategy.BillCalculationStrategy.BillingCalculationStrategyName;

import java.time.LocalDateTime;

public class BillController {
    private BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    public Bill generateBill(Ticket ticket, LocalDateTime exitTime, BillingCalculationStrategyName name, ParkingLot parkingLot, int exitGateId){

        return billService.generateBill(ticket,exitTime,name,parkingLot,exitGateId);
    }
}
