package com.training.streams.dao;

import java.util.List;

import com.training.streams.domain.City;

/**
 *
 * @author Akhil Cherian (akhil7000@gmail.com)
 */
public interface CityDao {
    City findCityById(int id);

    City removeCity(City city);

    City addCity(City city);

    City updateCity(City city);

    List<City> findAllCities();

    List<City> findCitiesByCountryCode(String countryCode);
}