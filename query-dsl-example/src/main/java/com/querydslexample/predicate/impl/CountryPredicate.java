package com.querydslexample.predicate.impl;

import com.querydslexample.model.Country;
import com.querydslexample.predicate.criteria.SearchPredicate;

/**
 * Class CountryPredicate created for...
 *
 * @version ALPHA-0.0.1
 * @since 2021-11-11
 */

public class CountryPredicate extends SearchPredicate<Country> {

    /**
     * Constructor with params.
     *
     * @param search        String Search that contains the criteira that is being searched.
     */
    public CountryPredicate(String search) {
        super(Country.class, search);
    }
}
