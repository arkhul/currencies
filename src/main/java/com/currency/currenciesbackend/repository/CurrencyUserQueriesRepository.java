package com.currency.currenciesbackend.repository;

import com.currency.currenciesbackend.model.CurrencyUserQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyUserQueriesRepository extends JpaRepository<CurrencyUserQuery, Long> {

    List<CurrencyUserQuery> findAllByOrderByIdDesc();
}
