package com.rosswildman.dresssearcherservice.rest;

import com.rosswildman.dresssearcherservice.product.Dress;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@Slf4j
@SpringBootTest
@Profile("api")
public class DressControllerApiIT {

    @Autowired
    DressController dressController;

    @Test
    void getDresses_stdInputs_DressesOrderedByPriceReduction() {
        List<Dress> dresses = dressController.getDresses("ShowWasNow");
        assertFalse(dresses.isEmpty());
        assertThat(dresses)
            .isSortedAccordingTo(Comparator.comparing(Dress::getPriceReduction).reversed());
        //Print dress names to console.
        for (Dress dress : dresses) {
            log.info("Dress: {}, Reduction: {}",dress.getTitle(), dress.getPriceReduction());
        }
    }
}
