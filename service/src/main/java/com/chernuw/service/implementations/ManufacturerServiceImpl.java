package com.chernuw.service.implementations;

import com.chernuw.dao.interfaces.ManufacturerDao;
import com.chernuw.model.Manufacturer;
import com.chernuw.service.interfaces.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("manufacturerService")
@Transactional
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    private ManufacturerDao dao;

    public Manufacturer getManufacturerById(int id) {
        return dao.getById(id);
    }

    public List<Manufacturer> getAllManufacturers() {
        return dao.getAll();
    }
}
