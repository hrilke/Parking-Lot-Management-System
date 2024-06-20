package Model;

import Model.ENUM.PaymentMode;
import Model.ENUM.PaymentStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Payment extends BaseClass{
    private Bill bill;
    private Double amount;
    private PaymentMode paymentMode;
    private String referenceNum;
    private PaymentStatus paymentStatus;
    private LocalDateTime timeOfPayment;

    @Override
    public String toString() {
        return "Payment Receipt{" +
                ", \nPaymentId = " + id +
                ", \nBillId = " + bill.getId() +
                ", \namount = " + amount +
                ", \npaymentMode = " + paymentMode +
                ", \nreferenceNum = " + referenceNum  +
                ", \npaymentStatus = " + paymentStatus +
                ", \ntimeOfPayment = " + timeOfPayment.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) +
                "  \n- - - - - -" +
                '}';
    }

    public Payment() {
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
