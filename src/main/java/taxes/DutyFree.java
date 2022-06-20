package taxes;

import goods.Product;

public class DutyFree extends Tax{

    public DutyFree() {
        super(null);
    }

    @Override
    public Product doCalculation(Product product) {
        return product;
    }

    @Override
    public boolean mustApply(Product product) {
        return true;
    }
}
