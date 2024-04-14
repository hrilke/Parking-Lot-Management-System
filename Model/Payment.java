package Model;

import Model.ENUM.PaymentMode;
import Model.ENUM.PaymentStatus;

import java.time.LocalDateTime;

public class Payment extends BaseClass{
    private Bill bill;
    private Double amount;
    private PaymentMode paymentMode;
    private String referenceNum;
    private PaymentStatus paymentStatus;
    private LocalDateTime timeOfPayment;

    public Payment(Bill bill, Double amount, PaymentMode paymentMode, String referenceNum, PaymentStatus paymentStatus, LocalDateTime timeOfPayment) {
        this.bill = bill;
        this.amount = amount;
        this.paymentMode = paymentMode;
        this.referenceNum = referenceNum;
        this.paymentStatus = paymentStatus;
        this.timeOfPayment = timeOfPayment;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getReferenceNum() {
        return referenceNum;
    }

    public void setReferenceNum(String referenceNum) {
        this.referenceNum = referenceNum;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getTimeOfPayment() {
        return timeOfPayment;
    }

    public void setTimeOfPayment(LocalDateTime timeOfPayment) {
        this.timeOfPayment = timeOfPayment;
    }
}
