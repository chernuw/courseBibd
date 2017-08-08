package com.chernuw.dao.implementations;

import com.chernuw.dao.AbstractDao;
import com.chernuw.dao.interfaces.FixationDao;
import com.chernuw.dao.interfaces.MaterialDao;
import com.chernuw.model.Fixation;
import com.chernuw.model.Material;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("materialDao")
public class MaterialDaoImpl extends AbstractDao<Integer, Material> implements MaterialDao {

    public Material getById(int id) {
        return getByKey(id);
    }

    public List<Material> getAll() {
        return (List<Material>) createEntityCriteria().list();
    }
}
