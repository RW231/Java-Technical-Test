package com.rosswildman.dresssearcherservice.datasource;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ColorData {
    String color;
    String basicColor;
    String skuId;
}
