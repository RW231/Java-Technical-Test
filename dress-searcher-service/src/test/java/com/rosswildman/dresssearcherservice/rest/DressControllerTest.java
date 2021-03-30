package com.rosswildman.dresssearcherservice.rest;

import com.rosswildman.dresssearcherservice.datasource.ProductApiSource;
import com.rosswildman.dresssearcherservice.product.Dress;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static com.rosswildman.dresssearcherservice.mother.ProductDataMother.*;

@ExtendWith(MockitoExtension.class)
class DressControllerTest {

    @Mock
    private ProductApiSource productApiSource;

    @InjectMocks
    private DressController dressController;

    @Test
    void getDresses_VaryingPriceReductions_OnlyReducedDressesReturned() {
        Mockito.doReturn(Arrays.asList(redDress(),theDress(),springDress(),sparklyDress()))
            .when(productApiSource).getDressData();
        List<Dress> dresses = dressController.getDresses("ShowWasNow");
        assertThat(dresses).extracting("title")
            .containsExactly("Red Dress", "The Dress");
    }

    @Test
    void getDresses_VaryingPriceReductions_DressesOrderedByPriceReduction() {
        Mockito.doReturn(Arrays.asList(blueDress(),theDress(),redDress(),greenDress()))
            .when(productApiSource).getDressData();
        List<Dress> dresses = dressController.getDresses("ShowWasNow");
        assertThat(dresses).extracting("title")
            .containsSequence("Green Dress", "Red Dress", "The Dress", "Blue Dress");
    }

    @Test
    void getDresses_LabelStrategyShowWasNow_PriceLabelFormat() {
        Mockito.doReturn(Arrays.asList(blueDress(),theDress(),redDress(),greenDress()))
            .when(productApiSource).getDressData();
        List<Dress> dresses = dressController.getDresses("ShowWasNow");
        assertThat(dresses).extracting("title", "priceLabel")
            .contains(
                tuple("Green Dress", "Was £30.00, now £10.00"),
                tuple("Red Dress", "Was £50.00, now £40.00"),
                tuple("The Dress", "Was £10.00, now £5.00"),
                tuple("Blue Dress", "Was £5.99, now £4.99")
            );
    }

    @Test
    void getDresses_LabelStrategyShowWasNowThen_PriceLabelFormat() {
        Mockito.doReturn(Arrays.asList(blueDress(),theDress(),redDress(),greenDress()))
            .when(productApiSource).getDressData();
        List<Dress> dresses = dressController.getDresses("ShowWasNow");
        assertThat(dresses).extracting("title", "priceLabel")
            .contains(
                tuple("Green Dress", "Was £30.00, then £15.00, now £10.00"),
                tuple("Red Dress", "Was £50.00, then £45.00, now £40.00"),
                tuple("The Dress", "Was £10.00, now £5.00"),
                tuple("Blue Dress", "Was £5.99, now £4.99")
            );
    }

    @Test
    void getDresses_LabelStrategyShowPercDiscount_PriceLabelFormat() {
        Mockito.doReturn(Arrays.asList(blueDress(),theDress(),redDress(),greenDress()))
            .when(productApiSource).getDressData();
        List<Dress> dresses = dressController.getDresses("ShowWasNow");
        assertThat(dresses).extracting("title", "priceLabel")
            .contains(
                tuple("Green Dress", "67% off - now £10.00"),
                tuple("Red Dress", "20% off - now £40.00"),
                tuple("The Dress", "50% off - now £5.00"),
                tuple("Blue Dress", "17% off - now £4.99")
            );
    }
}