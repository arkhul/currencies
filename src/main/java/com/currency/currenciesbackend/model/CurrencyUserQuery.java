package com.currency.currenciesbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "currency_user_queries")
public class CurrencyUserQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "currency")
    private String currency;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private String date;

    @Column(name = "value")
    private float value;

    public CurrencyUserQuery() {
    }

    public CurrencyUserQuery(String currency, String name, String date, float value) {
        this.currency = currency;
        this.name = name;
        this.date = date;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}

