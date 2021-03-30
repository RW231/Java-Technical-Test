package com.rosswildman.dresssearcherservice.rest;

import com.rosswildman.dresssearcherservice.datasource.ProductSource;
import com.rosswildman.dresssearcherservice.product.Dress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * A RESTful API for fetching dresses with price reductions
 */
@RestController
@RequestMapping("/dresses")
public class DressController {
    private ProductSource productSource;

    @Autowired
    public DressController(ProductSource productSource) {
        this.productSource = productSource;
    }

    /**
     * Gets a list of dresses with price reductions.
     * <p> The list is ordered to show dresses with the highest price reduction first.
     * @param labelType The price label format. Can be one of: ShowWasNow, ShowWasThen or
     *                  ShowPercDiscount. Defaults to ShowWasNow if not provided.
     * @return
     */
    @GetMapping("/reduced")
    public List<Dress> getDresses(@RequestParam(defaultValue = "ShowWasNow") String labelType) {
        // TODO
        return null;
    }

}
