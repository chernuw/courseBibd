package com.chernuw.dao.interfaces;


import com.chernuw.model.FootwearType;

import java.util.List;


public interface FootwearTypeDao {

    FootwearType getById(int id);
    List<FootwearType> getAll();

}
