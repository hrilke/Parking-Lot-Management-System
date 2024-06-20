package Repository;

import Exception.PaymentNotFoundException;
import Model.Payment;

import java.util.HashMap;

public class PaymentRepository {
    private HashMap<Integer, Payment> paymentHashMap;
    private static int idCounter;

    public PaymentRepository() {
        this.paymentHashMap = new HashMap<>();
    }

    public Payment add(Payment payment) {
        payment.setId(++idCounter);
        paymentHashMap.put(payment.getId(), payment);
        System.out.println("Collect your Payment Receipt");
        return paymentHashMap.get(idCounter);
    }

    public Payment get(int paymentId){
        Payment payment = paymentHashMap.get(paymentId);
        if (payment == null) {
            throw new PaymentNotFoundException("Payment receipt not found for id: "+ paymentId);
        }
        return payment;
    }
}
