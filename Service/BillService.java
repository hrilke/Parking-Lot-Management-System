package Service;

import Controller.TicketController;
import Model.Bill;
import Model.Gate;
import Model.ParkingLot;
import Model.Ticket;
import Repository.BillRepository;
import Repository.GateRepository;
import Repository.ParkingLotRepository;
import Repository.TicketRepository;
import Service.Strategy.BillCalculationStrategy.BillCalculationStrategy;
import Service.Strategy.BillCalculationStrategy.BillCalculationStrategyFactory;
import Service.Strategy.BillCalculationStrategy.BillingCalculationStrategyName;

import java.time.LocalDateTime;

public class BillService {
    private ParkingLotRepository parkingLotRepository;
    private BillRepository billRepository;
    private GateRepository gateRepository;
    private TicketRepository ticketRepository;

    public BillService(BillRepository billRepository, GateRepository gateRepository, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository) {
        this.billRepository = billRepository;
        this.ticketRepository = ticketRepository;
        this.gateRepository = gateRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    public Bill generateBill(int ticketId, int parkingLotId, int exitGateId, BillingCalculationStrategyName name){
        Ticket ticket = ticketRepository.get(ticketId);
        LocalDateTime exitTime = LocalDateTime.now();
        ParkingLot parkingLot = parkingLotRepository.get(parkingLotId);
        BillCalculationStrategy billCalculationStrategy = BillCalculationStrategyFactory.getBillCalculationStrategy(name, parkingLot);
        Double amount = billCalculationStrategy.getAmount(ticket,exitTime);

        Bill bill = new Bill();
        bill.setAmount(amount);
        bill.setExitGate(gateRepository.get(exitGateId));
        bill.setTicket(ticket);
        bill.setExitTime(exitTime);
        billRepository.add(bill);

        return bill;
    }
}
