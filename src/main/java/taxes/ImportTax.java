package taxes;

import goods.Product;

import java.math.BigDecimal;

public class ImportTax extends Tax{


    public ImportTax(Tax next) {
        super(next);
    }

    @Override
    public Product doCalculation(Product product) {
        product.setValueAfterTaxes((product.getValueAfterTaxes().add(product.getValue().multiply(new BigDecimal("0.05")))));
        return product;
    }



    @Override
    public boolean mustApply(Product product) {
        return product.isImported();
    }
}
