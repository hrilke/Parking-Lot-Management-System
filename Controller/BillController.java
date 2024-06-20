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

    public Bill generateBill(int ticketId,  int parkingLotId, int exitGateId,BillingCalculationStrategyName billStrategyName){

        return billService.generateBill(ticketId, parkingLotId, exitGateId, billStrategyName);
    }
}
