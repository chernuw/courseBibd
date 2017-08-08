package com.chernuw.dao.implementations;

import com.chernuw.dao.AbstractDao;
import com.chernuw.dao.interfaces.CountryDao;
import com.chernuw.dao.interfaces.FixationDao;
import com.chernuw.model.Country;
import com.chernuw.model.Fixation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("fixationDao")
public class FixationDaoImpl extends AbstractDao<Integer, Fixation> implements FixationDao {

    public Fixation getById(int id) {
        return getByKey(id);
    }

    public List<Fixation> getAll() {
        return (List<Fixation>) createEntityCriteria().list();
    }
}
