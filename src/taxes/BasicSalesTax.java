package taxes;

import goods.Product;
import goods.ProductType;

import java.math.BigDecimal;

public class BasicSalesTax extends  Tax{

    public BasicSalesTax(Tax next) {
        super(next);
    }

    @Override
    public Product doCalculation(Product product) {
        product.setValueAfterTaxes((product.getValueAfterTaxes().add(product.getValueAfterTaxes().multiply(new BigDecimal("0.1")))));
        return product;
    }

    @Override
    public boolean mustApply(Product product) {
        return product.getType().equals(ProductType.GENERAL);
    }
}
