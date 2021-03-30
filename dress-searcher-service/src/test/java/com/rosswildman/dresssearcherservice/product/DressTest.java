package com.rosswildman.dresssearcherservice.product;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static com.rosswildman.dresssearcherservice.mother.ProductDataMother.*;

class DressTest {

    @Test
    void dressConstructor_ValidData_dressObject() {
        Dress dress = new Dress(theDress());
        assertAll("dress",
            () -> assertEquals("111222", dress.getProductId()),
            () -> assertEquals("The Dress", dress.getTitle()),
            () -> assertEquals("£10", dress.getNowPrice()),
            () -> assertEquals("Was £10.00, now £5.00", dress.getPriceLabel()),
            () -> assertEquals(BigDecimal.valueOf(5), dress.getPriceReduction())
        );
    }

    @Test
    void dressConstructor_NowPriceGreaterThan10_IntegerNowPrice() {
        Dress dress = new Dress(redDress());
        assertEquals("£40", dress.getNowPrice());
    }

    @Test
    void dressConstructor_NowPriceEquals10_IntegerNowPrice() {
        Dress dress = new Dress(greenDress());
        assertEquals("£10", dress.getNowPrice());
    }

    @Test
    void dressConstructor_NowPriceLessThan10_DecimalNowPrice() {
        Dress dress = new Dress(blueDress());
        assertEquals("£4.99", dress.getNowPrice());
    }

    @Test
    void dressConstructor_DefaultStrategy_PriceLabelFormat() {
        Dress dress = new Dress(theDress(), new ShowWasNowLabel());
        assertEquals("Was £10.00, now £5.00", dress.getPriceLabel());
    }

    @Test
    void dressConstructor_LabelStrategyShowWasNow_PriceLabelFormat() {
        Dress dress = new Dress(theDress(), new ShowWasNowLabel());
        assertEquals("Was £10.00, now £5.00", dress.getPriceLabel());
    }

    @Test
    void dressConstructor_LabelStrategyShowWasThenNow_PriceLabelFormat() {
        Dress dress = new Dress(redDress());
        assertEquals("Was £50.00, then £45.00, now £40.00", dress.getPriceLabel());
    }

    @Test
    void dressConstructor_LabelStrategyShowPercDiscount_PriceLabelFormat() {
        Dress dress = new Dress(greenDress());
        assertEquals("17% off - now £4.99", dress.getPriceLabel());
    }
}