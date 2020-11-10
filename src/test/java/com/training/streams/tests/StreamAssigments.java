package com.training.streams.tests;

import com.training.streams.dao.InMemoryWorldDao;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StreamAssigments {

//
//    @Test
//    public void student() {
//        AtomicInteger sum = new AtomicInteger();
//        InMemoryWorldDao obj = InMemoryWorldDao.getInstance();
//
//        obj.getAllContinents().stream().forEach(continent -> {
//            obj.findCountriesByContinent(continent).stream().forEach(country -> {
//                sum.set(sum.get() + country.getCities().stream().collect(Collectors.toList()).size());
//            });
//            totalCitiesInOneContinent.add(sum.get());
//        });
//        System.out.println(totalCitiesInOneContinent);
//    }

    @Test
    public void streamAPIFirst() {
        ArrayList<Integer> totalCitiesInOneContinent = new ArrayList<>();

        /**
         * To get total cities from one continent, storing that in array list
         */
        AtomicInteger sum = new AtomicInteger();
        InMemoryWorldDao obj = InMemoryWorldDao.getInstance();

        obj.getAllContinents().stream().forEach(continent -> {
            System.out.println(continent);
            obj.findCountriesByContinent(continent).stream().forEach(country -> {
                sum.set(sum.get() + country.getCities().stream().collect(Collectors.toList()).size());
            });
            totalCitiesInOneContinent.add(sum.get());
        });
        System.out.println(totalCitiesInOneContinent);

/**
 * Finding max city in continent
 */


        Map<String, Integer> continentCountry = new HashMap<>();

        obj.getAllContinents().stream().forEach(continent -> {
            AtomicInteger citiesCounter = new AtomicInteger();
            int[] max = {0};
            AtomicInteger totalCitiesInOneContinentCounter = new AtomicInteger();

            obj.findCountriesByContinent(continent).stream().forEach(country -> {
                country.getCities().stream().forEach(city -> {

                    if (city.getPopulation() > max[0]) {

                        max[0] = city.getPopulation();
                    }
                    if ((totalCitiesInOneContinent.get(totalCitiesInOneContinentCounter.get())) == (citiesCounter.get() + 1)) {
                        continentCountry.put(continent, max[0]);
                    }
                    citiesCounter.getAndIncrement();
                });
            });
            totalCitiesInOneContinentCounter.getAndIncrement();
        });
        System.out.println(continentCountry);
    }
}
