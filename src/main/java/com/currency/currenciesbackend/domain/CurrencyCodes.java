package com.currency.currenciesbackend.domain;

import java.util.Arrays;
import java.util.List;

public class CurrencyCodes {

    public CurrencyCodes() {
        getCurrencyCodes();
    }

    public List<String> getCurrencyCodes() {
        return Arrays.asList(
                "EUR", "USD", "THB", "AUD", "HKD", "CAD", "NZD", "SGD", "HUF", "CHF", "GBP", "UAH", "JPY", "CZK",
                "DKK", "'SK", "NOK", "SEK", "RON", "BGN", "TRY", "ILS", "CLP", "PHP", "MXN", "ZAR", "BRL", "MYR",
                "IDR", "INR", "KRW", "CNY", "XDR"
        );
    }
}
