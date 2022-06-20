package taxes;

import goods.Product;

public final class TaxCalculator {

    public static Product calculate(Product product){
        product = new BasicSalesTax(new ImportTax(new DutyFree())).calculate(product);
        return product;
    }

}
