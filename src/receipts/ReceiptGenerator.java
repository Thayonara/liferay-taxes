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

        for(Sale s: sales){
            s.setProduct(TaxCalculator.calculate(s.getProduct()));

            //round only when the product was taxed
            if (s.getProduct().getValueAfterTaxes().subtract(s.getProduct().getValue()).multiply(s.getQuantity()).doubleValue() != 0){
                s.getProduct().setValueAfterTaxes(s.getProduct().getValue().add(new RoundFiveCents().roundFiveCents((s.getProduct().getValueAfterTaxes()).subtract(s.getProduct().getValue()).multiply(s.getQuantity()))));
            }
            tax = tax.add(((s.getProduct().getValueAfterTaxes()).subtract(s.getProduct().getValue())).multiply(s.getQuantity()));
            total = total.add(s.getProduct().getValue().add((s.getProduct().getValueAfterTaxes()).subtract(s.getProduct().getValue())).multiply(s.getQuantity()));
            description = description + "\n" + s.getQuantity() + " " + s.getProduct().getDescription() + ": $" + String.format("%.2f", s.getProduct().getValueAfterTaxes().multiply(s.getQuantity()));

        }
        return new Receipt(description, tax, total);
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }


}
