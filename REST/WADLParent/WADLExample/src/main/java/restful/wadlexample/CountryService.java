/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.wadlexample;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Singleton;

/**
 *
 * @author danecek
 */
@Singleton
public class CountryService {

    public CountryService() {
        countries.put(1, new Country("USA"));
    }

    Map<Integer, Country> countries = new HashMap<>();

    public Country getCountry(int countryId) {
        return countries.get(countryId);
    }

    public Collection<Country> countries() {
        return countries.values();
    }

}
