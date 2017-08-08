package com.chernuw.service.implementations;

import com.chernuw.dao.interfaces.ColorDao;
import com.chernuw.model.Color;
import com.chernuw.service.interfaces.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("colorService")
@Transactional
public class ColorServiceImpl implements ColorService{

    @Autowired
    ColorDao dao;

    @Override
    public Color getColorById(int id) {
        return dao.getById(id);
    }

    @Override
    public List<Color> getAllColors() {
        return dao.getAll();
    }
}
