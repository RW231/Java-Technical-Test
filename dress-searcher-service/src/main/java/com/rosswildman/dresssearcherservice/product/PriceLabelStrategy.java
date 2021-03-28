package com.rosswildman.dresssearcherservice.product;

import com.rosswildman.dresssearcherservice.datasource.ProductData;

/**
 * Creates price labels for products.
 *
 * The price label is formatted to the chosen specification.
 */
public interface PriceLabelStrategy {
    String createLabel(ProductData.PriceData priceData);
}
