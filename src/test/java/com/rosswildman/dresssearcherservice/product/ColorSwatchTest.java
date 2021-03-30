package com.rosswildman.dresssearcherservice.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.rosswildman.dresssearcherservice.mother.ProductDataMother.*;

class ColorSwatchTest {

    @Test
    void colorSwatchConstructor_SimpleValues_ConstructsColorSwatch() {
        ColorSwatch colorSwatch = new ColorSwatch(whiteGold());
        assertAll("colorSwatch",
            () -> assertEquals("White and Gold", colorSwatch.getColor()),
            () -> assertEquals("FFD700", colorSwatch.getRbgColor()),
            () -> assertEquals("101",colorSwatch.getSkuId())
        );
    }

    @Test
    void colorSwatchConstructor_WithColorAndBasicColor_ConstructsColorSwatchWithColor() {
        ColorSwatch colorSwatch = new ColorSwatch(blackBlue());
        assertEquals("Black and Blue", colorSwatch.getColor());
    }

    @Test
    void colorSwatchConstructor_WithOnlyBasicColor_ConstructColorSwatchWithBasicColor() {
        ColorSwatch colorSwatch = new ColorSwatch(pink());
        assertEquals("Pink", colorSwatch.getColor());
    }

    @Test
    void convertColorToRGB_SimpleColors_returnsValidHex() {
        ColorSwatch colorSwatch = new ColorSwatch(red());
        assertEquals("FF0000", colorSwatch.getRbgColor());
    }

    @Test
    void convertColorToRGB_UnknownColor_returnsDefaultHex() {
        ColorSwatch colorSwatch = new ColorSwatch(gurple());
        assertEquals("000000", colorSwatch.getRbgColor());
    }
    
}