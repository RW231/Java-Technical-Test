package com.rosswildman.dresssearcherservice.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.rosswildman.dresssearcherservice.mother.ProductDataMother.*;

class ShowWasNowLabelTest {

    private final ShowWasNowLabel showWasNowLabel = new ShowWasNowLabel();

    @Test
    void createLabel_ValidPriceData_ReturnsFormattedLabel() {
        assertEquals("Was £10.00, now £5.00", showWasNowLabel.createLabel(was10Now5()));
    }
}