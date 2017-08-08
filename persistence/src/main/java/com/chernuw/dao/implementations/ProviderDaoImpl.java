package com.chernuw.dao.implementations;

import com.chernuw.dao.AbstractDao;
import com.chernuw.dao.interfaces.ProviderDao;
import com.chernuw.model.Provider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("providerDao")
public class ProviderDaoImpl extends AbstractDao<Integer, Provider> implements ProviderDao{
    @Override
    public Provider getById(int id) {
        return getByKey(id);
    }

    @Override
    public List<Provider> getAll() {
        return (List<Provider>) createEntityCriteria().list() ;
    }
}
