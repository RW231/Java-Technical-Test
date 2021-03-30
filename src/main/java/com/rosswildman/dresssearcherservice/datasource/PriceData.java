package com.rosswildman.dresssearcherservice.datasource;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class PriceData {
    BigDecimal was;
    BigDecimal then1;
    BigDecimal then2;
    BigDecimal now;
}
