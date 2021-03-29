package com.rosswildman.dresssearcherservice.datasource;

import com.rosswildman.dresssearcherservice.ProductDataConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(properties = {"product.data.json.file=productsourcetests/valid-api-data.json"})
class ProductJsonFileSourceTest {

    @Autowired
    ProductDataConfig productDataConfig;

    @Autowired
    ProductJsonFileSource productJsonFileSource;

    @Test
    void getDressData_ValidSourceData_ReturnCompleteDressData() {
        List<ProductData> dressData = productJsonFileSource.getDressData();
        assertFalse(dressData.isEmpty());
        assertThat(dressData).extracting("productId","title")
            .contains(tuple("111222", "The Dress"),
                tuple("400", "Red Dress"),
                tuple("300", "Blue Dress"),
                tuple("200", "Green Dress"));
    }

}