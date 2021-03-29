package com.rosswildman.dresssearcherservice.mother;

import com.rosswildman.dresssearcherservice.datasource.ColorData;
import com.rosswildman.dresssearcherservice.datasource.PriceData;
import com.rosswildman.dresssearcherservice.datasource.ProductData;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

public class ProductDataMother {

    private ProductDataMother(){}

    public static ProductData theDress() {
        return ProductData.builder()
                .productId("111222")
                .title("The Dress")
                .colorData(Arrays.asList(blackBlue(),whiteGold()))
                .priceData(was10Now5())
                .build();
    }

    public static ProductData redDress() {
        return ProductData.builder()
                .productId("400")
                .title("Red Dress")
                .colorData(Collections.singletonList(red()))
                .priceData(was50Then45Now40())
                .build();
    }

    public static ProductData blueDress() {
        return ProductData.builder()
                .productId("300")
                .title("Blue Dress")
                .colorData(Collections.singletonList(blue()))
                .priceData(was5d99Now4d99())
                .build();
    }

    public static ProductData greenDress() {
        return ProductData.builder()
                .productId("200")
                .title("Green Dress")
                .colorData(Collections.singletonList(green()))
                .priceData(was30Then20Then15Now10())
                .build();
    }

    public static ColorData blackBlue() {
        return ColorData.builder()
                .color("Black and Blue")
                .basicColor("Blue")
                .skuId("909")
                .build();
    }

    public static ColorData whiteGold() {
        return ColorData.builder()
                .color("White and Gold")
                .basicColor("Gold")
                .skuId("101")
                .build();
    }

    public static ColorData red() {
        return ColorData.builder()
                .color("Red")
                .basicColor("Red")
                .skuId("4")
                .build();
    }

    public static ColorData blue() {
        return ColorData.builder()
                .color("Blue")
                .basicColor("Blue")
                .skuId("3")
                .build();
    }

    public static ColorData green() {
        return ColorData.builder()
                .color("Green")
                .basicColor("Green")
                .skuId("2")
                .build();
    }

    public static ColorData pink() {
        return ColorData.builder()
            .basicColor("Pink")
            .skuId("88")
            .build();
    }

    public static ColorData gurple() {
        return ColorData.builder()
            .color("Greeny-purple")
            .basicColor("Gurple")
            .skuId("123456789")
            .build();
    }

    public static PriceData was10Now5() {
        return PriceData.builder()
                .was(new BigDecimal(10))
                .now(new BigDecimal(5))
                .build();
    }

    public static PriceData was5d99Now4d99() {
        return PriceData.builder()
                .was(new BigDecimal("5.99"))
                .now(new BigDecimal("4.99"))
                .build();
    }

    public static PriceData was50Then45Now40() {
        return PriceData.builder()
                .was(new BigDecimal(50))
                .then1(new BigDecimal(45))
                .now(new BigDecimal(40))
                .build();
    }

    public static PriceData was30Then20Then15Now10() {
        return PriceData.builder()
                .was(new BigDecimal(30))
                .then1(new BigDecimal(20))
                .then2(new BigDecimal(15))
                .now(new BigDecimal(10))
                .build();
    }


}
