package goods;

import java.math.BigDecimal;

public class Product {

    private String description;
    private BigDecimal value;
    private BigDecimal valueAfterTaxes;
    private ProductType type;
    private boolean isImported;

    public Product(String description, BigDecimal value, BigDecimal valueAfterTaxes, ProductType type, boolean isImported) {
        this.description = description;
        this.value = value;
        this.valueAfterTaxes = valueAfterTaxes;
        this.type = type;
        this.isImported = isImported;
    }

    public BigDecimal getValueAfterTaxes() {
        return valueAfterTaxes;
    }

    public void setValueAfterTaxes(BigDecimal valueAfterTaxes) {
        this.valueAfterTaxes = valueAfterTaxes;
    }

    public String getDescription() {
        return description;
    }

    public boolean isImported() {
        return isImported;
    }

    public void setImported(boolean imported) {
        isImported = imported;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
}
