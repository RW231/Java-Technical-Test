package com.rosswildman.dresssearcherservice.product;

import org.junit.jupiter.api.Test;

import static com.rosswildman.dresssearcherservice.mother.ProductDataMother.*;
import static org.junit.jupiter.api.Assertions.*;

class ShowPercDiscountLabelTest {

    private final ShowPercDiscountLabel showPercDiscountLabel = new ShowPercDiscountLabel();

    @Test
    void createLabel_ValidPriceData_ReturnsFormattedLabel() {
        assertEquals("20% off - now £40.00",
            showPercDiscountLabel.createLabel(was50Then45Now40()));
        assertEquals("50% off - now £5.00",
            showPercDiscountLabel.createLabel(was10Now5()));
        assertEquals("67% off - now £10.00",
            showPercDiscountLabel.createLabel(was30Then20Then15Now10()));
        assertEquals("Now £20.00",
            showPercDiscountLabel.createLabel(is20()));
    }
}