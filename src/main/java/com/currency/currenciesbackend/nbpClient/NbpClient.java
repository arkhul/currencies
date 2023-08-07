package com.currency.currenciesbackend.nbpClient;

import com.currency.currenciesbackend.domain.NbpTable;
import com.currency.currenciesbackend.domain.Rates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class NbpClient {

    @Value("${nbp.api.endpoint}")
    private String nbpApiEndpoint;

    private final RestTemplate restTemplate;

    public NbpClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<NbpTable> getNbpTables() {
        NbpTable[] nbpResponse = restTemplate.getForObject(
                nbpApiEndpoint,
                NbpTable[].class
        );
        return Optional.ofNullable(nbpResponse)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());

    }

    public float getCurrencyValue(String currencyCode) {
        List<NbpTable> nbpTables = getNbpTables();
        List<Rates> ratesList = nbpTables.get(0).getRates().stream()
                .filter(e -> e.getCode().equalsIgnoreCase(currencyCode))
                .collect(Collectors.toList());
        return ratesList.get(0).getMid();
    }
}
