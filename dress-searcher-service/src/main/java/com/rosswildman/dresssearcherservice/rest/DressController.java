package com.rosswildman.dresssearcherservice.rest;

import com.rosswildman.dresssearcherservice.datasource.ProductSource;
import com.rosswildman.dresssearcherservice.product.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A RESTful API for fetching dresses with price reductions
 */
@RestController
@RequestMapping("/dresses")
public class DressController {
    private final ProductSource productSource;
    private final Map<String, PriceLabelStrategy> priceStrategyMap;

    @Autowired
    public DressController(ProductSource productSource) {
        this.productSource = productSource;
        this.priceStrategyMap = Map.ofEntries(
            Map.entry("ShowWasNow", new ShowWasNowLabel()),
            Map.entry("ShowWasThenNow", new ShowWasThenNowLabel()),
            Map.entry("ShowPercDiscount", new ShowPercDiscountLabel())
        );
    }

    /**
     * Gets a list of dresses with price reductions.
     * <p> The list is ordered to show dresses with the highest price reduction first.
     * @param labelType The price label format. Can be one of: ShowWasNow, ShowWasThenNow or
     *                  ShowPercDiscount. Defaults to ShowWasNow if label is not provided or not
     *                  recognised.
     * @return List of reduced dresses.
     */
    @GetMapping("/reduced")
    public List<Dress> getDresses(@RequestParam(defaultValue = "ShowWasNow") String labelType) {
        return productSource.getDressData()
            .stream()
            .map(dressData -> new Dress(
                dressData, priceStrategyMap.getOrDefault(labelType, new ShowWasNowLabel())))
            .filter(dress -> dress.getPriceReduction().compareTo(BigDecimal.ZERO) > 0)
            .sorted(Comparator.comparing(Dress::getPriceReduction).reversed())
            .collect(Collectors.toList());
    }

}
