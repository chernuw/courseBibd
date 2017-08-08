package com.chernuw.dao.implementations;

import com.chernuw.dao.AbstractDao;
import com.chernuw.dao.interfaces.FootwearTypeDao;
import com.chernuw.model.FootwearType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("footwearTypeDao")
public class FootwearTypeDaoImpl extends AbstractDao<Integer, FootwearType> implements FootwearTypeDao {

    public FootwearType getById(int id) {
        return getByKey(id);
    }

    public List<FootwearType> getAll() {
        return (List<FootwearType>) createEntityCriteria().list();
    }
}
