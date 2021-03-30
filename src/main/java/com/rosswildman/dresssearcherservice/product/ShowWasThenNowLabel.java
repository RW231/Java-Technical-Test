package com.rosswildman.dresssearcherservice.product;

import com.rosswildman.dresssearcherservice.datasource.PriceData;

import java.math.BigDecimal;

import static com.rosswildman.dresssearcherservice.product.Formatters.*;

/**
 * Creates a price label in the format "Was £x.xx, then £y.yy, now £z.zzz".
 */
public class ShowWasThenNowLabel implements PriceLabelStrategy{
    @Override
    public String createLabel(PriceData priceData) {
        String label = "Was £" + TWO_DECIMAL_PLACES.format(priceData.getWas());
        if(priceData.getThen2().compareTo(BigDecimal.ZERO) != 0) {
            label = label + ", then £" + TWO_DECIMAL_PLACES.format(priceData.getThen2());
        } else if(priceData.getThen1().compareTo(BigDecimal.ZERO) != 0) {
            label = label + ", then £" + TWO_DECIMAL_PLACES.format(priceData.getThen1());
        }
        return label + ", now £" + TWO_DECIMAL_PLACES.format(priceData.getNow());
    }
}