package com.querydslexample.repository;

import com.querydslexample.model.Country;
import java.util.Optional;

/**
 * This class is created to make a Repository for Country.
 *
 * @author Alfredo Marin
 * @version ALPHA-0.0.1
 * @see Country
 * @since 12/10/2019
 */

public interface CountryRepository extends GenericRepository<Country> {

    Optional<Country> findByInitials(char[] initials);
}
