package com.chernuw.service.interfaces;


import com.chernuw.model.Color;
import com.chernuw.model.Country;

import java.util.List;


public interface CountryService {

    Country getCountryById(int id);
    List<Country> getAllCountrys();

}
