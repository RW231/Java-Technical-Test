package com.rosswildman.dresssearcherservice.product;

import com.rosswildman.dresssearcherservice.datasource.PriceData;

/**
 * Creates price labels for products.
 *
 * The price label is formatted to the chosen specification.
 */
public interface PriceLabelStrategy {
    String createLabel(PriceData priceData);
}
