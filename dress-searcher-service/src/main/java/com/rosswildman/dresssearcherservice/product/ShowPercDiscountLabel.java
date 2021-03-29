package com.rosswildman.dresssearcherservice.product;

import com.rosswildman.dresssearcherservice.datasource.PriceData;

/**
 * Creates a price label in the format "x% off - now £y.yy".
 */
public class ShowPercDiscountLabel implements PriceLabelStrategy{
    @Override
    public String createLabel(PriceData priceData) {
        return null;
    }
}
