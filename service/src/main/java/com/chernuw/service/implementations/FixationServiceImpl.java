package com.chernuw.service.implementations;

import com.chernuw.dao.interfaces.FixationDao;
import com.chernuw.model.Fixation;
import com.chernuw.service.interfaces.FixationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("fixationService")
@Transactional
public class FixationServiceImpl implements FixationService{

    @Autowired
    FixationDao dao;

    @Override
    public Fixation getFixationById(int id) {
        return dao.getById(id);
    }

    @Override
    public List<Fixation> getAllFixations() {
        return dao.getAll();
    }
}
