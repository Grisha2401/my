package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму в рублях: ");
        double amountInRubles = scanner.nextDouble();

        System.out.print("Введите код валюты (например, USD, EUR): ");
        String targetCurrency = scanner.next().toUpperCase();

        ExchangeRateProvider exchangeRateProvider = new JsonFileExchangeRateProvider("/Users/alfa/go/currencyRate/src/main/resources/exchange_rates.json");
        CurrencyConverter converter = new CurrencyConverter(exchangeRateProvider);

        try {
            double convertedAmount = converter.convect(amountInRubles, targetCurrency);
            System.out.printf("Вы можете купить %.2f %s на %.2f рублей%n", convertedAmount, targetCurrency, amountInRubles);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }    }
}