package Repository;

import Exception.BillNotFoundException;
import Model.Bill;

import java.util.HashMap;

public class BillRepository {
    private HashMap<Integer, Bill> billHashMap;
    private static int idCounter;

    public BillRepository() {
        this.billHashMap = new HashMap<>();
    }

    public Bill add(Bill bill) {
        bill.setId(++idCounter);
        billHashMap.put(bill.getId(), bill);
        System.out.println("Collect your bill");
        return billHashMap.get(idCounter);
    }

    public Bill get(int billId)  {
        Bill bill = billHashMap.get(billId);
        if (bill == null) {
            throw new BillNotFoundException("Bill not found for id: "+ billId);
        }
        return bill;
    }
}
