package com.chernuw.service.implementations;

import com.chernuw.dao.interfaces.SexDao;
import com.chernuw.model.Sex;
import com.chernuw.service.interfaces.SexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("sexService")
@Transactional
public class SexServiceImpl implements SexService{

    @Autowired
    SexDao dao;

    @Override
    public Sex getSexById(int id) {
        return dao.getById(id);
    }

    @Override
    public List<Sex> getAllSexs() {
        return dao.getAll();
    }
}
