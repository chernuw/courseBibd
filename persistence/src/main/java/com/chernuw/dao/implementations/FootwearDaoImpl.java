package com.chernuw.dao.implementations;

import com.chernuw.dao.AbstractDao;
import com.chernuw.dao.interfaces.FootwearDao;
import com.chernuw.model.Footwear;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Repository("footwearDao")
public class FootwearDaoImpl extends AbstractDao<Integer, Footwear> implements FootwearDao {

    public Footwear getById(int id) {
        return getByKey(id);
    }

    public List<Footwear> getAll(int numberOfPage, int amountOnPage) {
        Criteria criteria = createEntityCriteria();
        criteria.setFirstResult(numberOfPage * amountOnPage - amountOnPage);
        criteria.setMaxResults(amountOnPage);
        return (List<Footwear>) criteria.list();
    }

    public List<Footwear> getAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Footwear>) criteria.list();
    }

    public List<Footwear> getByCriterion(Criterion criterion, int numberOfPage, int amountOnPage) {
        Criteria criteria = createEntityCriteria();
        criteria.setFirstResult(numberOfPage * amountOnPage - amountOnPage);
        criteria.setMaxResults(amountOnPage);
        return (List<Footwear>) criteria.add(criterion).list();
    }

    @Override
    public void deleteFootwear(Footwear footwear) {
        delete(footwear);
    }

    /*@Override
    public void updateFootwear(Footwear footwear) {
        update(footwear);
    }*/

    public List<Footwear> getByCriterion(Criterion criterion) {
        Criteria criteria = createEntityCriteria();
        return (List<Footwear>) criteria.add(criterion).list();
    }

    public int saveFootwear(Footwear footwear){
        return save(footwear);
    }


    /*@Override
    public void updateFootwear(int id, Model model) throws UnsupportedEncodingException {
        String hqlUpdate = "update footwear c set c.";
        getSession().createSQLQuery(hqlUpdate).executeUpdate();
    }*/
}
