package com.rosswildman.dresssearcherservice.datasource;

import com.rosswildman.dresssearcherservice.ProductDataConfig;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductApiSource implements ProductSource {
    final private RestTemplate restTemplate;
    final private String url;

    public ProductApiSource(RestTemplate restTemplate, ProductDataConfig productDataConfig) {
        this.restTemplate = restTemplate;
        this.url = productDataConfig.getProductDataApiUrl();
    }

    @Override
    public List<ProductData> getDressData() {
        return restTemplate.exchange(
            url,HttpMethod.GET,null,
            new ParameterizedTypeReference<List<ProductData>>(){}
        ).getBody();
    }
}
