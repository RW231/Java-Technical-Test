package com.rosswildman.dresssearcherservice.product;

import com.rosswildman.dresssearcherservice.datasource.ProductData;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class Dress {
    String productId;
    String title;
    List<ColorSwatch> colorSwatches;
    String nowPrice;
    String priceLabel;
    BigDecimal priceReduction;

    /**
     * Constructs a new Dress from {@link ProductData}, with the default @{link
     * {@link ShowWasNowLabel}} price label strategy.
     * @see #Dress(ProductData, PriceLabelStrategy)
     * @param productData The raw product data
     */
    public Dress(ProductData productData) {
        this(productData, new ShowWasNowLabel());
    }

    /**
     * Constructs a new Dress from {@link ProductData}.
     * <p>
     * The {@code nowPrice} field is formatted as a integer for prices of £10 or over, and as
     * decimal for prices less than £10. e.g. £10 or £2.00.
     * <p>
     * The {@code priceLabel} field is formatted to the specification provided by the
     * {@link PriceLabelStrategy}.
     * @param productData The raw product data
     * @param priceLabelStrategy The price label formatting strategy
     */
    public Dress(ProductData productData,PriceLabelStrategy priceLabelStrategy) {
        // TODO
    }
}
