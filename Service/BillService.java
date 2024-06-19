package Service;

import Controller.TicketController;
import Model.Bill;
import Model.Gate;
import Model.Ticket;
import Repository.BillRepository;
import Repository.GateRepository;
import Repository.TicketRepository;
import Service.Strategy.BillCalculationStrategy.BillCalculationStrategy;
import Service.Strategy.BillCalculationStrategy.BillCalculationStrategyFactory;
import Service.Strategy.BillCalculationStrategy.BillingCalculationStrategyName;

import java.time.LocalDateTime;

public class BillService {

    private BillRepository billRepository;
    private GateRepository gateRepository;

    public BillService(BillRepository billRepository, GateRepository gateRepository) {
        this.billRepository = billRepository;
        this.gateRepository = gateRepository;
    }

    public Bill generateBill(Ticket ticket, LocalDateTime exitTime, BillingCalculationStrategyName name, int parkingLot, int exitGateId){
        BillCalculationStrategy billCalculationStrategy = BillCalculationStrategyFactory.getBillCalculationStrategy(name);
        Double amount = billCalculationStrategy.getAmount(ticket,exitTime,parkingLot);

        Bill bill = new Bill();
        bill.setAmount(amount);
        bill.setExitGate(gateRepository.get(exitGateId));
        bill.setTicket(ticket);
        bill.setExitTime(exitTime);

        return bill;
    }
}
