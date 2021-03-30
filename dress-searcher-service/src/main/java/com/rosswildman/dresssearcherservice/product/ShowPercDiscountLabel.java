package com.rosswildman.dresssearcherservice.product;

import com.rosswildman.dresssearcherservice.datasource.PriceData;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.rosswildman.dresssearcherservice.product.Formatters.*;

/**
 * Creates a price label in the format "x% off - now £y.yy".
 *
 * The percentage is displayed as whole number, with decimals rounded half-up.
 *
 * If the priceData.was value == 0, "Now £x.xx" is returned"
 */
public class ShowPercDiscountLabel implements PriceLabelStrategy{
    @Override
    public String createLabel(PriceData priceData) {
        if(priceData.getWas().compareTo(BigDecimal.ZERO) == 0) {
            return "Now £" + TWO_DECIMAL_PLACES.format(priceData.getNow());
        }
        BigDecimal percentOff = priceData.getWas()
            .subtract(priceData.getNow())
            .divide(priceData.getWas(), 2, RoundingMode.HALF_UP)
            .multiply(new BigDecimal(100));
        return WHOLE_NUMBER.format(percentOff) + "% off - now £"
            + TWO_DECIMAL_PLACES.format(priceData.getNow());
    }
}
