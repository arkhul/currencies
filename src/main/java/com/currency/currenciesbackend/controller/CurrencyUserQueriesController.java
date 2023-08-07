package com.currency.currenciesbackend.controller;

import com.currency.currenciesbackend.domain.CurrencyCodes;
import com.currency.currenciesbackend.exception.CreateCurrencyUserQueryException;
import com.currency.currenciesbackend.model.CurrencyUserQuery;
import com.currency.currenciesbackend.nbpClient.NbpClient;
import com.currency.currenciesbackend.repository.CurrencyUserQueriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/currencies/")
public class CurrencyUserQueriesController {

    @Autowired
    private CurrencyUserQueriesRepository currencyUserQueriesRepository;

    @Autowired
    private NbpClient nbpClient;

    private CurrencyCodes currencyCodes = new CurrencyCodes();

    @GetMapping("/requests")
    public List<CurrencyUserQuery> getAllQueries() {
        return currencyUserQueriesRepository.findAllByOrderByIdDesc();
    }

    @PostMapping("/get-current-currency-value-command")
    public float createCurrencyUserQuery(@RequestBody CurrencyUserQuery currencyUserQuery) throws CreateCurrencyUserQueryException {
        if (isCurrencyCodeCorrect(currencyUserQuery)) {
            throw new CreateCurrencyUserQueryException();
        } else {
            setCurrencyUserQueryValues(currencyUserQuery);
            currencyUserQueriesRepository.save(currencyUserQuery);
            return currencyUserQuery.getValue();
        }
    }

    private boolean isCurrencyCodeCorrect(CurrencyUserQuery currencyUserQuery) {
        return currencyCodes.getCurrencyCodes().stream()
                .filter(cc -> cc.equalsIgnoreCase(currencyUserQuery.getCurrency()))
                .collect(Collectors.toList()).isEmpty();
    }

    private void setCurrencyUserQueryValues(CurrencyUserQuery currencyUserQuery) {
        if (currencyUserQuery.getName() == null) {
            currencyUserQuery.setName("Anonymous");
        }
        currencyUserQuery.setCurrency(currencyUserQuery.getCurrency().toUpperCase());
        currencyUserQuery.setValue(nbpClient.getCurrencyValue(currencyUserQuery.getCurrency()));
        currencyUserQuery.setDate(LocalDateTime.now() + "Z");
    }
}
