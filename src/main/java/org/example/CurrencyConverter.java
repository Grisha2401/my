package org.example;

import java.util.Map;

public class CurrencyConverter {
    private final ExchangeRateProvider exchangeRateProvider;

    public CurrencyConverter(ExchangeRateProvider exchangeRateProvider) {
        this.exchangeRateProvider = exchangeRateProvider;
    }

    public double convect(double ammountRur, String targetCurrency) {
        Map<String, Double> rate = exchangeRateProvider.getExchangeRates();
        Double cur = rate.get(targetCurrency.toLowerCase());
        System.out.println(cur);
        if (rate == null) {
            throw new IllegalArgumentException("Unknown currency: " + targetCurrency);
        }
        return ammountRur/cur;
    }
}
