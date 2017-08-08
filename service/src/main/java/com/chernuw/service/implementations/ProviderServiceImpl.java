package com.chernuw.service.implementations;

import com.chernuw.dao.interfaces.ProviderDao;
import com.chernuw.model.Provider;
import com.chernuw.service.interfaces.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("providerService")
@Transactional
public class ProviderServiceImpl implements ProviderService{

    @Autowired
    ProviderDao dao;

    @Override
    public Provider getProviderById(int id) {
        return dao.getById(id);
    }

    @Override
    public List<Provider> getAllProviders() {
        return dao.getAll();
    }
}
