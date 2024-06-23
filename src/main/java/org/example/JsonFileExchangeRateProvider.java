package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonFileExchangeRateProvider implements ExchangeRateProvider{
    private final String filePath;

    public JsonFileExchangeRateProvider(String filePath) {
        this.filePath = filePath;
    }
    @Override
    public Map getExchangeRates() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File("/Users/alfa/go/currencyRate/src/main/resources/exchange_rates.json"),Map.class);
        } catch (IOException e) {
            throw new RuntimeException("Не удалось прочитать курсы валют из файла.", e);
        }
    }
}
