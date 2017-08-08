package com.chernuw.dao.interfaces;

import com.chernuw.model.Manufacturer;

import java.util.List;

public interface ManufacturerDao {

    Manufacturer getById(int id);
    List<Manufacturer> getAll();

}
