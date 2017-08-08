package com.chernuw.dao.implementations;

import com.chernuw.dao.AbstractDao;
import com.chernuw.dao.interfaces.ColorDao;
import com.chernuw.dao.interfaces.CountryDao;
import com.chernuw.model.Color;
import com.chernuw.model.Country;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("countryDao")
public class CountryDaoImpl extends AbstractDao<Integer, Country> implements CountryDao {

    public Country getById(int id) {
        return getByKey(id);
    }

    public List<Country> getAll() {
        return (List<Country>) createEntityCriteria().list();
    }
}
