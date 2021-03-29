package com.rosswildman.dresssearcherservice.product;

import com.rosswildman.dresssearcherservice.datasource.ColorData;

public class ColorSwatch {
    String color;
    String rbgColor;
    String skuId;

    /**
     * Constructs a new ColorSwatch from {@link ColorData}.
     * @param colorData raw color data.
     */
    public ColorSwatch(ColorData colorData) {

    }

    /**
     * Coverts a basic color name into its RGB value in a hexadecimal format.
     * <p> Defaults to 000000 if the color cannot be resolved.
     * @param basicColor The color to convert to RBG
     * @return The RGB value of the color
     */
    public static String convertColorToRGB(String basicColor) {
        // TODO
        return "";
    }
}
