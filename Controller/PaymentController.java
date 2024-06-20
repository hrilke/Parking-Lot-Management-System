package Controller;

import Model.Bill;
import Model.ENUM.PaymentMode;
import Model.Payment;
import Service.PaymentService;

public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public Payment makePayment(Bill bill, String referenceNumber, PaymentMode paymentMode) {
        return paymentService.makePayment(bill,referenceNumber, paymentMode);
    }
}
