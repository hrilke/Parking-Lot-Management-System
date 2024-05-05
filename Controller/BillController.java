package Controller;

import Model.Bill;
import Service.BillService;

public class BillController {
    private BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    public Bill generateBill(){
        return billService.generateBill();
    }
}
