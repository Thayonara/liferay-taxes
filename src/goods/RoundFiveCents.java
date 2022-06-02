package goods;

import java.math.BigDecimal;
import java.math.MathContext;

public class RoundFiveCents implements Round{

    @Override
    public BigDecimal roundFiveCents(BigDecimal afterTaxes) {
        int cents = new BigDecimal(afterTaxes.doubleValue() % 0.05 * 100).round(new MathContext(1)).intValue();
        int difference = 5 - cents;
        return new BigDecimal(afterTaxes.doubleValue() * 100 + difference).divide(new BigDecimal("100"));
    }
}
