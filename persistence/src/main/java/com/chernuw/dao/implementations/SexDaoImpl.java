package com.chernuw.dao.implementations;

import com.chernuw.dao.AbstractDao;
import com.chernuw.dao.interfaces.MaterialDao;
import com.chernuw.dao.interfaces.SexDao;
import com.chernuw.model.Material;
import com.chernuw.model.Sex;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("sexDao")
public class SexDaoImpl extends AbstractDao<Integer, Sex> implements SexDao {

    public Sex getById(int id) {
        return getByKey(id);
    }

    public List<Sex> getAll() {
        return (List<Sex>) createEntityCriteria().list();
    }
}
