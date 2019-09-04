package pl.bkoteluk.taxcalculator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TaxServiceTest {
    TaxService taxService;

    @BeforeEach
    void setUp() {
        taxService = new TaxService();
    }
    @Test
    void whenRevenueIsTen_shouldReturnTaxZero() {
        long revenue = 10L;
        long expectedResult = 0L;

        assertEquals(expectedResult, taxService.calculateTax(revenue));
    }

    @Test
    void whenRevenueIsUnderThresholdTenThousand_shouldReturnTax1244() {
        long revenue = 10_000L;
        long expectedResult = 1_244L;

        assertEquals(expectedResult, taxService.calculateTax(revenue));
    }

    @Test
    void whenRevenueIsEqualRevenueThreshold_shouldReturnTax14_839() {
        long expectedResult = 14_839L;
        assertThat(expectedResult).isEqualTo(taxService.calculateTax(taxService.REVENUE_THRESHOLD));
    }

    @Test
    void whenRevenueIsOverRevenueThreshold90_000_shouldReturnTax17_870() {
        long revenue = 95_001L;
        long expectedResult = 17_870L;
        assertEquals(expectedResult, taxService.calculateTax(revenue));
    }
}