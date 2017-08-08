package com.chernuw.dao.interfaces;

import com.chernuw.model.Material;

import java.util.List;

public interface MaterialDao {

    Material getById(int id);
    List<Material> getAll();
}
