package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Bill extends BaseClass{
    private Double amount;
    private LocalDateTime exitTime;
    private Ticket ticket;
    private Gate exitGate;

    public Bill() {
    }

    public Bill(Double amount, LocalDateTime exitTime, Ticket ticket, Gate exitGate) {
        this.amount = amount;
        this.exitTime = exitTime;
        this.ticket = ticket;
        this.exitGate = exitGate;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "amount=" + amount +
                ", entryTime=" + ticket.getEntryTime().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) +
                ", exitTime=" + exitTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) +
                ", ticketId=" + ticket.getId() +
                ", Vehicle=" + ticket.getVehicle().getRegistrationNumber() +
                ", exitGate=" + exitGate.getGateNum() +
                ", id=" + id +
                '}';
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }
}
