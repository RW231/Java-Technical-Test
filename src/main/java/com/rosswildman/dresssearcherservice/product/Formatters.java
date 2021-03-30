package com.rosswildman.dresssearcherservice.product;

import java.text.DecimalFormat;

public final class Formatters {
    public static final DecimalFormat WHOLE_NUMBER = new DecimalFormat("0");
    public static final DecimalFormat TWO_DECIMAL_PLACES = new DecimalFormat("0.00");

    private Formatters() {}
}
