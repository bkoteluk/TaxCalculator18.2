package pl.bkoteluk.service;

public class TaxService {
    public static int REVENUE_THRESHOLD = 85_528;
    public static double TAX_FREE_AMOUNT = 556.02;
    public static int TAX_UNDER_THRESHOLD = 18;
    public static int TAX_OVER_THRESHOLD = 32;

    public long calculateTax(double revenue) {
        double tax = REVENUE_THRESHOLD - revenue >= 0 ? underTaxThreshold(revenue)
                : underTaxThreshold(REVENUE_THRESHOLD) + overTaxThreshold(revenue - REVENUE_THRESHOLD);
        return roundCalculatedTax(tax);
    }

    private long roundCalculatedTax(double tax) {
        return Math.round(tax);
    }

    private double underTaxThreshold(double number) {
        return (number*TAX_UNDER_THRESHOLD)/100 - TAX_FREE_AMOUNT;
    }

    private double overTaxThreshold(double number) {
        return (number*TAX_OVER_THRESHOLD)/100;
    }
}
