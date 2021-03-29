package com.rosswildman.dresssearcherservice.datasource;

import java.util.List;

/**
 * Retrieves product data from an external data source.
 */
public interface ProductSource {

    /**
     * Retrieves product data for all dresses from the external data source.
     * @return List of product data for dresses
     */
    List<ProductData> getDressData();
}
