package pl.bkoteluk.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TaxServiceTest {
    TaxService tax;

    @BeforeEach
    void setUp() {
        tax = new TaxService();
    }

    @Test
    void whenRevenueIsUnderThresholdTenThousand_shouldReturnTax1244() {
        long revenue = 10_000L;
        long expectedResult = 1_244L;

        Assertions.assertEquals(expectedResult, tax.calculateTax(revenue));
    }

    @Test
    void whenRevenueIsEqualRevenueThreshold_shouldReturnTax14_839() {
        long expectedResult = 14_839L;
        assertThat(expectedResult).isEqualTo(tax.calculateTax(tax.REVENUE_THRESHOLD));
    }

    @Test
    void whenRevenueIsOverRevenueThreshold90_000_shouldReturnTax17_870() {
        long revenue = 95_001L;
        long expectedResult = 17_870L;
//        assertThat(expectedResult).isEqualTo(tax.calculateTax(revenue));
        Assertions.assertEquals(expectedResult, tax.calculateTax(revenue));
    }
}