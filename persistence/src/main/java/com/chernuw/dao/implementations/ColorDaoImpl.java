package com.chernuw.dao.implementations;

import com.chernuw.dao.AbstractDao;
import com.chernuw.dao.interfaces.ColorDao;
import com.chernuw.dao.interfaces.FootwearTypeDao;
import com.chernuw.model.Color;
import com.chernuw.model.FootwearType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("colorDao")
public class ColorDaoImpl extends AbstractDao<Integer, Color> implements ColorDao {

    public Color getById(int id) {
        return getByKey(id);
    }

    public List<Color> getAll() {
        return (List<Color>) createEntityCriteria().list();
    }
}
