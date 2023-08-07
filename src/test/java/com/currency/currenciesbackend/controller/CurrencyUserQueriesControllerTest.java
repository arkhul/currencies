package com.currency.currenciesbackend.controller;

import com.currency.currenciesbackend.model.CurrencyUserQuery;
import com.currency.currenciesbackend.nbpClient.NbpClient;
import com.currency.currenciesbackend.repository.CurrencyUserQueriesRepository;
import com.google.gson.Gson;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(CurrencyUserQueriesController.class)
class CurrencyUserQueriesControllerTest {

    @Autowired
    private CurrencyUserQueriesController currencyUserQueriesController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CurrencyUserQueriesRepository currencyUserQueriesRepository;

    @MockBean
    private NbpClient nbpClient;

    @Test
    void getAllEmployees() throws Exception {
        // Given
        URI getUri = new URI("http://localhost:8080/currencies/requests");
        when(currencyUserQueriesController.getAllQueries()).thenReturn(
                List.of(new CurrencyUserQuery("EUR", "John Rambo", "2023-08-01", 4.56F)));

        // When & Then
        mockMvc
                .perform(MockMvcRequestBuilders.get(getUri)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].currency", Matchers.is("EUR")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("John Rambo")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].date", Matchers.is("2023-08-01")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].value", Matchers.is(4.56)));
    }

    /* uncomment when you change the return type from float to CurrencyUserQuery
    @Test
    void createCurrencyUserQuery() throws Exception {
        // Given
        URI postUri = new URI("http://localhost:8080/currencies/get-current-currency-value-command");
        CurrencyUserQuery currencyUserQuery = new CurrencyUserQuery(
                "USD", "Al Pacino", "2023-08-04", 5.1565f
        );
        Gson gson = new Gson();
        String jsonContent = gson.toJson(currencyUserQuery);
        when(nbpClient.getCurrencyValue(currencyUserQuery.getCurrency())).thenReturn(5.1565f);

        // When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post(postUri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("Al Pacino")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency", Matchers.is("USD")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.value", Matchers.is(5.1565)));
    }
    */
}