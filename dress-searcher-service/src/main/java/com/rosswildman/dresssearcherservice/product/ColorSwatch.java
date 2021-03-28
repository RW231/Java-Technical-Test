package com.rosswildman.dresssearcherservice.product;

import com.rosswildman.dresssearcherservice.datasource.ProductData;

public class ColorSwatch {
    String color;
    String rbgColor;
    String skuId;

    /**
     * Constructs a new ColorSwatch from {@link ProductData.ColorData}.
     * @param colorData raw color data.
     */
    public ColorSwatch(ProductData.ColorData colorData) {

    }

    /**
     * Coverts a basic color name into its RGB value.
     * @param basicColor The color to convert to RBG
     * @return The RGB value of the color
     */
    public static String convertColorToRGB(String basicColor) {
        // TODO
        return "";
    }
}
