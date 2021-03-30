package com.rosswildman.dresssearcherservice.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rosswildman.dresssearcherservice.datasource.ProductData;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static com.rosswildman.dresssearcherservice.product.Formatters.*;

@Getter
public class Dress {
    String productId;
    String title;
    List<ColorSwatch> colorSwatches;
    String nowPrice;
    String priceLabel;
    @JsonIgnore
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
        this.productId = productData.getProductId();
        this.title = productData.getTitle();
        this.colorSwatches = productData.getColorData()
            .stream()
            .map(ColorSwatch::new)
            .collect(Collectors.toList());
        this.nowPrice = formatNowPrice(productData.getPriceData().getNow());
        this.priceLabel = priceLabelStrategy.createLabel(productData.getPriceData());
        this.priceReduction = productData.getPriceData().getWas()
            .subtract(productData.getPriceData().getNow());
    }

    private String formatNowPrice(BigDecimal nowPrice) {
        if (nowPrice.compareTo(BigDecimal.TEN) >= 0) {
            return "£" + WHOLE_NUMBER.format(nowPrice);
        }
        return "£" + TWO_DECIMAL_PLACES.format(nowPrice);
    }
}
