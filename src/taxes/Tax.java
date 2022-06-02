package taxes;

import goods.Product;

public abstract class Tax {

    protected Tax next;

    public Tax(Tax next){
        this.next = next;
    }

    public Product calculate(Product product){
        if(mustApply(product)){
            doCalculation(product);
        }
        return product;
    }

    protected abstract Product doCalculation(Product product);
    protected abstract boolean mustApply(Product product);
}
