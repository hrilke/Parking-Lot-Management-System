package Service;

import Model.Bill;
import Model.ENUM.PaymentMode;
import Model.ENUM.PaymentStatus;
import Model.Payment;
import Repository.PaymentRepository;

import java.time.LocalDateTime;

public class PaymentService {
    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment makePayment(Bill bill, String referenceNumber, PaymentMode paymentMode) {
        Payment payment = new Payment();
        payment.setAmount(bill.getAmount());
        payment.setPaymentMode(paymentMode);
        payment.setReferenceNum(referenceNumber);
        payment.setPaymentStatus(PaymentStatus.PAID);
        payment.setBill(bill);
        payment.setTimeOfPayment(LocalDateTime.now());
        paymentRepository.add(payment);

        return payment;
    }
}
