package com.chernuw.dao.interfaces;

import com.chernuw.model.Sex;

import java.util.List;

public interface SexDao {

    Sex getById(int id);
    List<Sex> getAll();
}
