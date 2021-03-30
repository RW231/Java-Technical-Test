package com.rosswildman.dresssearcherservice.product;

import com.rosswildman.dresssearcherservice.datasource.ColorData;
import lombok.Getter;

import java.util.AbstractMap;
import java.util.Map;

@Getter
public class ColorSwatch {
    private final String color;
    private final String rbgColor;
    private final String skuId;

    /**
     * Constructs a new ColorSwatch from {@link ColorData}.
     * @param colorData raw color data.
     */
    public ColorSwatch(ColorData colorData) {
        this.color = colorData.getColor() != null && !colorData.getColor().isBlank() ?
            colorData.getColor() : colorData.getBasicColor();
        this.rbgColor = convertColorToRGB(colorData.getBasicColor());
        this.skuId = colorData.getSkuId();
    }

    /**
     * Coverts a basic color name into its RGB value in a hexadecimal format.
     * <p> Defaults to 000000 if the color cannot be resolved.
     * @param basicColor The color to convert to RBG
     * @return The RGB value of the color
     */
    public static String convertColorToRGB(String basicColor) {
        return ColorDatabase.getHexRgbColorMap()
            .entrySet()
            .stream()
            .filter(entry -> basicColor.equals(entry.getKey()))
            .findFirst()
            .orElse(new AbstractMap.SimpleEntry<>("Black", "000000"))
            .getValue();
    }

    private static class ColorDatabase {
        private static final Map<String, String> hexRgbColorMap = Map.ofEntries(
            Map.entry("Black", "000000"),
            Map.entry("White", "FFFFFF"),
            Map.entry("Red", "FF0000"),
            Map.entry("Lime", "00FF00"),
            Map.entry("Blue", "0000FF"),
            Map.entry("Yellow", "FFFF00"),
            Map.entry("Gold", "FFD700"),
            Map.entry("Cyan", "00FFFF"),
            Map.entry("Magenta", "FF00FF"),
            Map.entry("Silver", "C0C0C0"),
            Map.entry("Gray", "808080"),
            Map.entry("Maroon", "800000"),
            Map.entry("Olive", "808000"),
            Map.entry("Green", "008000"),
            Map.entry("Purple", "800080"),
            Map.entry("Teal", "008080"),
            Map.entry("Navy", "000080")
        );

        static Map<String, String> getHexRgbColorMap() {
            return hexRgbColorMap;
        }
    }
}
