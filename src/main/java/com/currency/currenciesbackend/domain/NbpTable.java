package com.currency.currenciesbackend.domain;

import java.util.List;

public class NbpTable {

    private String table;
    private String no;
    private String effectiveDate;
    private List<Rates> rates;

    public NbpTable(String table, String no, String effectiveDate, List<Rates> rates) {
        this.table = table;
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.rates = rates;
    }

    public NbpTable() {
    }

    public String getTable() {
        return table;
    }

    public String getNo() {
        return no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public List<Rates> getRates() {
        return rates;
    }


}
