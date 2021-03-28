package com.rosswildman.dresssearcherservice.product;

import com.rosswildman.dresssearcherservice.datasource.ProductData;

/**
 * Creates a price label in the format "Was £x.xx, now £y.yyy".
 */
public class ShowWasNowLabel implements PriceLabelStrategy {
    @Override
    public String createLabel(ProductData.PriceData priceData) {
        return null;
    }
}
