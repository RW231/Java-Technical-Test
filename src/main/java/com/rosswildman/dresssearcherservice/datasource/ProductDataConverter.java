package com.rosswildman.dresssearcherservice.datasource;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductDataConverter {

    public static MappingJackson2HttpMessageConverter createProductDataConverter() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("ProductDataDeserializer");
        module.addDeserializer(List.class, new ProductDataDeserializer());
        mapper.registerModule(module);
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(mapper);
        return converter;
    }

    static class ProductDataDeserializer extends StdDeserializer<List<ProductData>> {

        public ProductDataDeserializer() {
            this(null);
        }

        protected ProductDataDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public List<ProductData> deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            ObjectCodec codec = parser.getCodec();
            JsonNode rootNode = codec.readTree(parser);
            JsonNode productsNode = rootNode.get("products");
            List<ProductData> productData = new ArrayList<>();
            for (JsonNode productNode : productsNode) {
                JsonNode colorsNode = productNode.get("colorSwatches");
                List<ColorData> colorData = new ArrayList<>();
                for (JsonNode colorNode : colorsNode) {
                    colorData.add(
                        ColorData.builder()
                            .color(safeString(colorNode.get("color").textValue()))
                            .basicColor(safeString(colorNode.get("basicColor").textValue()))
                            .skuId(safeString(colorNode.get("skuId").textValue()))
                            .build()
                    );
                }
                JsonNode priceNode = productNode.get("price");
                PriceData priceData = PriceData.builder()
                    .was(safeBigDecimal(priceNode.get("was").textValue()))
                    .then1(safeBigDecimal(priceNode.get("then1").textValue()))
                    .then2(safeBigDecimal(priceNode.get("then2").textValue()))
                    .now(safeBigDecimal(priceNode.get("now").textValue()))
                    .build();
                productData.add(
                    ProductData.builder()
                        .productId(safeString(productNode.get("productId").textValue()))
                        .title(safeString(productNode.get("title").textValue()))
                        .colorData(colorData)
                        .priceData(priceData)
                        .build()
                );
            }
            return productData;
        }

        /**
         * Converts null Strings to "" to avoid deserialization errors.
         */
        private String safeString(String str) {
            return str == null ? "" : str;
        }

        /**
         * Checks String is not empty or null before converting to a {@link BigDecimal} to avoid
         * errors. If the String is empty, then default to zero.
         * <p>
         * The function could be improved by checking if the String is a valid decimal, but it does
         * the job for this project!
         */
        private BigDecimal safeBigDecimal(String str) {
            return new BigDecimal(str == null || str.isBlank() ? "0" : str);
        }
    }
}
