package org.example;

import java.util.Map;

public interface ExchangeRateProvider {
    Map<String, Double> getExchangeRates();

}
