package com.chernuw.dao.interfaces;

import com.chernuw.model.Provider;

import java.util.List;

public interface ProviderDao {

    Provider getById(int id);
    List<Provider> getAll();
}
