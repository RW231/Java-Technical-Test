package com.rosswildman.dresssearcherservice.datasource;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * POJO for unformatted product data originating from an external data source.
 */
@Builder
@Getter
public class ProductData {
    String productId;
    String title;
    List<ColorData> colorData;
    PriceData priceData;
}
