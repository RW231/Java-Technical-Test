package com.rosswildman.dresssearcherservice.product;

import com.rosswildman.dresssearcherservice.datasource.ProductData;

/**
 * Creates a price label in the format "Was £x.xx, then £y.yy, now £z.zzz".
 */
public class ShowWasThenNowLabel implements PriceLabelStrategy{
    @Override
    public String createLabel(ProductData.PriceData priceData) {
        return null;
    }
}