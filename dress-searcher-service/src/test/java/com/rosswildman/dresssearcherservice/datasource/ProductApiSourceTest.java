package com.rosswildman.dresssearcherservice.datasource;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.anything;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@SpringBootTest
class ProductApiSourceTest {
    @Autowired
    ProductApiSource productApiSource;
    private final MockRestServiceServer mockServer;
    private final String testDir = "productsourcetests/";

    @Autowired
    ProductApiSourceTest(RestTemplate restTemplate) {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @AfterEach
    void verify() {
        mockServer.verify();
    }

    private void setupMockServerWithFile(String file) throws IOException {
        String jsonString = getJsonFileContentAsString(testDir + file);
        mockServer.expect(ExpectedCount.once(), anything())
            .andRespond(withSuccess()
                .contentType(MediaType.APPLICATION_JSON)
                .body(jsonString));
    }

    @Test
    void getDressData_ValidSourceData_ReturnCompleteDressData() throws IOException {
        setupMockServerWithFile("valid-api-data.json");
        List<ProductData> dressData = productApiSource.getDressData();
        assertFalse(dressData.isEmpty());
        assertThat(dressData).extracting("productId","title")
            .contains(tuple("111222", "The Dress"),
                tuple("400", "Red Dress"),
                tuple("300", "Blue Dress"),
                tuple("200", "Green Dress"));
    }

    @Test
    void getDressData_InvalidProductId_WriteTitleAsEmptyString() throws IOException {
        setupMockServerWithFile("bad-productId-api-data.json");
        List<ProductData> dressData = productApiSource.getDressData();
        assertEquals(2, dressData.size());
        assertThat(dressData).extracting("productId","title")
            .contains(tuple("", "The Dress"),
                tuple("", "Red Dress"));
    }

    @Test
    void getDressData_InvalidTitle_WriteTitleAsEmptyString() throws IOException {
        setupMockServerWithFile("bad-title-api-data.json");
        List<ProductData> dressData = productApiSource.getDressData();
        assertEquals(2, dressData.size());
        assertThat(dressData).extracting("productId","title")
            .contains(tuple("111222", ""),
                tuple("400", ""));
    }

    @Test
    void getDressData_InvalidPriceWas_WritePriceWasAsZero() throws IOException {
        setupMockServerWithFile("bad-price-was-api-data.json");
        List<ProductData> dressData = productApiSource.getDressData();
        assertEquals(1, dressData.size());
        for(ProductData dress : dressData) {
            assertEquals(BigDecimal.ZERO, dress.getPriceData().getWas());
        }
    }

    @Test
    void getDressData_InvalidPriceThen1_WritePriceThen2AsZero() throws IOException {
        setupMockServerWithFile("bad-price-then1-api-data.json");
        List<ProductData> dressData = productApiSource.getDressData();
        assertEquals(1, dressData.size());
        for(ProductData dress : dressData) {
            assertEquals(BigDecimal.ZERO, dress.getPriceData().getThen1());
        }
    }

    @Test
    void getDressData_InvalidPriceThen2_WritePriceThen2AsZero() throws IOException {
        setupMockServerWithFile("bad-price-then2-api-data.json");
        List<ProductData> dressData = productApiSource.getDressData();
        assertEquals(1, dressData.size());
        for(ProductData dress : dressData) {
            assertEquals(BigDecimal.ZERO, dress.getPriceData().getThen2());
        }
    }

    @Test
    void getDressData_InvalidPriceNow_WritePriceNowAsZero() throws IOException {
        setupMockServerWithFile("bad-price-now-api-data.json");
        List<ProductData> dressData = productApiSource.getDressData();
        assertEquals(1, dressData.size());
        for(ProductData dress : dressData) {
            assertEquals(BigDecimal.ZERO, dress.getPriceData().getNow());
        }
    }

    @Test
    void getDressData_InvalidColor_WriteColorAsEmptyString() throws IOException {
        setupMockServerWithFile("bad-color-api-data.json");
        List<ProductData> dressData = productApiSource.getDressData();
        assertEquals(1, dressData.size());
        for(ProductData dress: dressData) {
            for (ColorData color: dress.getColorData()) {
                assertEquals("", color.getColor());
            }
        }
    }

    @Test
    void getDressData_InvalidBasicColor_WriteBasicColorAsEmptyString() throws IOException {
        setupMockServerWithFile("bad-basicColor-api-data.json");
        List<ProductData> dressData = productApiSource.getDressData();
        assertEquals(1, dressData.size());
        for(ProductData dress: dressData) {
            for (ColorData color: dress.getColorData()) {
                assertEquals("", color.getBasicColor());
            }
        }
    }

    @Test
    void getDressData_InvalidSkuId_WriteSkuIdAsEmptyString() throws IOException {
        setupMockServerWithFile("bad-skuId-api-data.json");
        List<ProductData> dressData = productApiSource.getDressData();
        assertEquals(1, dressData.size());
        for(ProductData dress: dressData) {
            for (ColorData color: dress.getColorData()) {
                assertEquals("", color.getSkuId());
            }
        }
    }

    private String getJsonFileContentAsString(String filePath) throws IOException {
        return Files.readString(
            Path.of(getClass().getClassLoader().getResource(filePath)
                .getPath()));
    }
}