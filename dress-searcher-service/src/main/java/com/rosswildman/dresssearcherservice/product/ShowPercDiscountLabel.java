package com.rosswildman.dresssearcherservice.product;

import com.rosswildman.dresssearcherservice.datasource.ProductData;

/**
 * Creates a price label in the format "x% off - now £y.yy".
 */
public class ShowPercDiscountLabel implements PriceLabelStrategy{
    @Override
    public String createLabel(ProductData.PriceData priceData) {
        return null;
    }
}
