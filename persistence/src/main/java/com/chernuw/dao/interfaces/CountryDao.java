package com.chernuw.dao.interfaces;

import com.chernuw.model.Country;

import java.util.List;

public interface CountryDao {
    Country getById(int id);
    List<Country> getAll();
}
