package com.rosswildman.dresssearcherservice.product;

import com.rosswildman.dresssearcherservice.datasource.PriceData;

import static com.rosswildman.dresssearcherservice.product.Formatters.*;

/**
 * Creates a price label in the format "Was £x.xx, now £y.yyy".
 */
public class ShowWasNowLabel implements PriceLabelStrategy {
    @Override
    public String createLabel(PriceData priceData) {
        return "Was £" + TWO_DECIMAL_PLACES.format(priceData.getWas()) + ", now £"
            + TWO_DECIMAL_PLACES.format(priceData.getNow());
    }
}
