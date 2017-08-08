package com.chernuw.dao.implementations;

import com.chernuw.dao.AbstractDao;
import com.chernuw.dao.interfaces.ManufacturerDao;
import com.chernuw.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("manufacturerDao")
public class ManufacturerDaoImpl extends AbstractDao<Integer, Manufacturer> implements ManufacturerDao {

    public Manufacturer getById(int id) {
        return getByKey(id);
    }

    public List<Manufacturer> getAll() {
        return (List<Manufacturer>) createEntityCriteria().list();
    }
}
