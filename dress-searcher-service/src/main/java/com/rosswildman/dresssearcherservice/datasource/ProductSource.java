package com.rosswildman.dresssearcherservice.datasource;

/**
 * Retrieves product data from an external data source.
 */
public interface ProductSource {

    /**
     * Retrieves product data for all dresses from the external data source.
     * @return Dress product data
     */
    public ProductData getDressData();
}
