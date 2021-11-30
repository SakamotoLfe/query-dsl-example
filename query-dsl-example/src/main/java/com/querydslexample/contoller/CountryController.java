package com.querydslexample.contoller;

import com.querydslexample.model.Country;
import com.querydslexample.service.CountryService;
import com.querydslexample.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class CountryController created for...
 *
 * @version ALPHA-0.0.1
 * @since 2021-11-11
 */

@RestController
@RequestMapping("/countries")
public class CountryController extends GenericController<Country> {

    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    protected GenericService<Country> getGenericService() {
        return countryService;
    }
}
