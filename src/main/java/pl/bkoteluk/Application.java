package pl.bkoteluk;

import pl.bkoteluk.service.TaxService;

public class Application {
    public static void main(String[] args) {
        long amount = 123_456L;
        TaxService taxService = new TaxService();
        System.out.println("Podatek dla kwoty przychodu " + amount + " jest równy: " + taxService.calculateTax(amount));
    }
}
