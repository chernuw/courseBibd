package com.chernuw.service.implementations;

import com.chernuw.dao.interfaces.MaterialDao;
import com.chernuw.model.Material;
import com.chernuw.service.interfaces.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("materialService")
@Transactional
public class MaterialServiceImpl implements MaterialService{

    @Autowired
    MaterialDao dao;

    @Override
    public Material getMaterialById(int id) {
        return dao.getById(id);
    }

    @Override
    public List<Material> getAllMaterials() {
        return dao.getAll();
    }
}
