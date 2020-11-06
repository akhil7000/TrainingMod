package com.training.streams.dao;

import java.util.List;
import java.util.Set;

import com.training.streams.domain.Country;

/**
 *
 * @author Akhil Cherian (akhil7000@gmail.com)
 */
public interface CountryDao {
    Country findCountryByCode(String code);

    Country removeCountry(Country country);

    Country addCountry(Country country);

    Country updateCountry(Country country);

    List<Country> findAllCountries();

    List<Country> findCountriesByContinent(String continent);

    Set<String> getAllContinents();
}