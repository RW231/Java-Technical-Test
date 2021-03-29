package com.rosswildman.dresssearcherservice.datasource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductApiSourceIT {
    @Autowired
    ProductApiSource productApiSource;

    @Test
    void getDressData() {
        List<ProductData> dressData = productApiSource.getDressData();
        assertFalse(dressData.isEmpty());
    }

}