package com.rosswildman.dresssearcherservice.product;

import com.rosswildman.dresssearcherservice.datasource.PriceData;

/**
 * Creates a price label in the format "Was £x.xx, then £y.yy, now £z.zzz".
 */
public class ShowWasThenNowLabel implements PriceLabelStrategy{
    @Override
    public String createLabel(PriceData priceData) {
        return null;
    }
}