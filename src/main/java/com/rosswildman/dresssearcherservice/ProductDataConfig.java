package com.rosswildman.dresssearcherservice;

import com.rosswildman.dresssearcherservice.datasource.ProductDataConverter;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Getter
@Configuration
public class ProductDataConfig {
    @Value("${product.data.api.url}")
    private String productDataApiUrl;
    @Value("${product.data.json.file}")
    private String productDataJsonFile;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
            .additionalMessageConverters(ProductDataConverter.createProductDataConverter())
            .build();
    }
}
