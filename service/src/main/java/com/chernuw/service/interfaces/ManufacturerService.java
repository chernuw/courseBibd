package com.chernuw.service.interfaces;


import com.chernuw.model.Manufacturer;

import java.util.List;

public interface ManufacturerService {

    Manufacturer getManufacturerById(int id);
    List<Manufacturer> getAllManufacturers();

}
