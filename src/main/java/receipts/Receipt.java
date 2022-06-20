package receipts;

import java.math.BigDecimal;

public class Receipt {

    private String description;
    private BigDecimal tax;
    private BigDecimal total;

    public Receipt(String description, BigDecimal tax, BigDecimal total) {
        this.description = description;
        this.tax = tax;
        this.total = total;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
