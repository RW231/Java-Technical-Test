package com.rosswildman.dresssearcherservice.datasource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.rosswildman.dresssearcherservice.ProductDataConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProductJsonFileSource implements ProductSource {

    final String jsonFilePath;

    @Autowired
    public ProductJsonFileSource(ProductDataConfig productDataConfig) {
        this.jsonFilePath = productDataConfig.getProductDataJsonFile();
    }

    @Override
    public List<ProductData> getDressData() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("CustomDeserializer");
        module.addDeserializer(List.class, new ProductDataConverter.ProductDataDeserializer());
        mapper.registerModule(module);
        List<ProductData> productData = new ArrayList<>();
        try {
            File jsonFile = new File(getClass().getClassLoader().getResource(jsonFilePath).getFile());
            productData = mapper.readValue(jsonFile, new TypeReference<>(){});
        } catch (IOException e) {
           log.error("Failed to map data", e);
        }
        return productData;
    }
}
