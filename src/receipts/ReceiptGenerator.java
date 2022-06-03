package receipts;

import goods.RoundFiveCents;
import taxes.TaxCalculator;

import java.math.BigDecimal;
import java.util.List;

public class ReceiptGenerator {

    private List<Sale> sales;

    public ReceiptGenerator(List<Sale> sales) {
        this.sales = sales;
    }

    public Receipt execute(){
        BigDecimal tax = new BigDecimal("0");
        BigDecimal total = new BigDecimal("0");
        String description = "";

        return new Receipt(description, tax, total);
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }


}
