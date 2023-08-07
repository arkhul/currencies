package com.currency.currenciesbackend.domain;

public class Rates {

    private String currency;
    private String code;
    private float mid;

    public Rates(String currency, String code, float mid) {
        this.currency = currency;
        this.code = code;
        this.mid = mid;
    }

    public Rates() {
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public float getMid() {
        return mid;
    }
}
