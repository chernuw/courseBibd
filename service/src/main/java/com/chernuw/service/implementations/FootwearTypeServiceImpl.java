package com.chernuw.service.implementations;

import com.chernuw.dao.interfaces.FootwearTypeDao;
import com.chernuw.model.FootwearType;
import com.chernuw.service.interfaces.FootwearTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("footweartypeService")
@Transactional
public class FootwearTypeServiceImpl implements FootwearTypeService {

    @Autowired
    private FootwearTypeDao dao;

    public FootwearType getFootwearTypeById(int id) {
        return dao.getById(id);
    }

    public List<FootwearType> getAllFootwearTypes() {
        return dao.getAll();
    }
}
