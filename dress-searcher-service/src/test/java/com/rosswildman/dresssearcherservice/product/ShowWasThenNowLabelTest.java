package com.rosswildman.dresssearcherservice.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.rosswildman.dresssearcherservice.mother.ProductDataMother.*;

class ShowWasThenNowLabelTest {

    private final ShowWasThenNowLabel showWasThenNowLabel = new ShowWasThenNowLabel();

    @Test
    void createLabel_PriceThen2NotEmpty_ReturnsFormattedLabelUsingPriceThen2() {
        assertEquals("Was £30.00, then £15.00, now, £10.00",
            showWasThenNowLabel.createLabel(was30Then20Then15Now10()));
    }

    @Test
    void createLabel_PriceThen2Empty_ReturnsFormattedLabelUsingPriceThen1() {
        assertEquals("Was £50.00, then £45.00, now £40.00",
            showWasThenNowLabel.createLabel(was50Then45Now40()));
    }

    @Test
    void createLabel_NoThenPrice_ReturnsFormattedLabelWithoutThenPrice() {
        assertEquals("Was £10.00, now £5.00",
            showWasThenNowLabel.createLabel(was10Now5()));
    }
}