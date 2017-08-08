package com.chernuw.dao.interfaces;

import com.chernuw.model.Color;

import java.util.List;

public interface ColorDao {

    Color getById(int id);
    List<Color> getAll();
}
