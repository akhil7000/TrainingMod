package com.training.streams.tests;

import com.training.streams.dao.InMemoryWorldDao;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class StreamAssigments {

    @Test
    public void streamAPIFirst() {
        InMemoryWorldDao obj = InMemoryWorldDao.getInstance();

        obj.getAllContinents().stream().forEach(continent -> {
            AtomicInteger maxxx = new AtomicInteger();
            obj.findCountriesByContinent(continent).stream().map(country -> {
                if (country.getPopulation() > maxxx.get()){
                    System.out.println("xx="+country.getPopulation());
                }
                return null;
            });
            System.out.println("max = " +maxxx);
        });





//        Iterator<String> continentItr = allContinent.iterator();
//        List<Country> country = null;
//
//        while (continentItr.hasNext()) {
//            country = obj.findCountriesByContinent(continentItr.next());
//
//            Iterator<Country> countryItr = country.iterator();
//
//            int maximumPopulation = 0;
//
//            while (countryItr.hasNext()) {
//                int pop = countryItr.next().getPopulation();
//                if (pop > maximumPopulation) {
//                    maximumPopulation = pop;
//                }
//            }
//            System.out.println("maximumPopulation = " + maximumPopulation);
//        }
    }
}
