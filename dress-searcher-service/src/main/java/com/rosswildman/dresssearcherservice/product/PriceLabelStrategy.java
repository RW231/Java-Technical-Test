package com.rosswildman.dresssearcherservice.product;

/**
 * Creates price labels for products.
 *
 * The price label is formatted to the chosen specification.
 */
public interface PriceLabelStrategy {
    String createLabel();
}
