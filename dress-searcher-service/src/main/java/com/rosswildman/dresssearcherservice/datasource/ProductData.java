package com.rosswildman.dresssearcherservice.datasource;

import java.math.BigDecimal;
import java.util.List;

/**
 * POJO for unformatted product data originating from an external data source.
 */
public class ProductData {
    String productId;
    String title;
    List<ColorData> colorData;

    public class PriceData {
        BigDecimal priceWas;
        BigDecimal priceThen1;
        BigDecimal priceThen2;
        BigDecimal priceNow;
    }

    public class ColorData {
        String color;
        String basicColor;
        String skuId;
    }
}
