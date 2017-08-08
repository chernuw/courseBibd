package com.chernuw.dao.interfaces;

import com.chernuw.model.Fixation;

import java.util.List;

public interface FixationDao {
    Fixation getById(int id);
    List<Fixation> getAll();
}
