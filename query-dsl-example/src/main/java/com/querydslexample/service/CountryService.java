package com.querydslexample.service;

import com.querydslexample.model.Country;
import com.querydslexample.predicate.criteria.SearchPredicate;
import com.querydslexample.predicate.impl.CountryPredicate;
import com.querydslexample.repository.CountryRepository;
import com.querydslexample.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class CountryService created for...
 *
 * @version ALPHA-0.0.1
 * @since 2021-11-11
 */

@Service
public class CountryService extends GenericService<Country> {

    private CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    protected GenericRepository getGenericRepository() {
        return countryRepository;
    }

    @Override
    protected SearchPredicate<Country> getSearchPredicate(String search) {
        return new CountryPredicate(search);
    }
}
