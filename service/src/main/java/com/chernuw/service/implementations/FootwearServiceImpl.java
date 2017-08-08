package com.chernuw.service.implementations;

import com.chernuw.dao.interfaces.FootwearDao;
import com.chernuw.model.Footwear;
import com.chernuw.service.interfaces.FootwearService;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Service("footwearService")
@Transactional
public class FootwearServiceImpl implements FootwearService {

    @Autowired
    private FootwearDao dao;

    public Footwear getFootwearById(int id) {
        return dao.getById(id);
    }

    public List<Footwear> getAllFootwear(int numberOfPage, int amountOnPage) {
        return dao.getAll(numberOfPage, amountOnPage);
    }

    public List<Footwear> getAllFootwear() {
        return dao.getAll();
    }

    public List<Footwear> getFootwearsByFootwearType(int idOfFootwearType) {
        Criterion criterion = Restrictions.eq("footwearType.id", idOfFootwearType);
        return dao.getByCriterion(criterion);
    }

    public List<Footwear> getFootwearsByFootwearType(int idOfFootwearType, int numberOfPage, int amountOnPage) {
        Criterion criterion = Restrictions.eq("footwearType.id", idOfFootwearType);
        return dao.getByCriterion(criterion, numberOfPage, amountOnPage);
    }

    public List<Footwear> getFootwearsByManufacturer(int idOfManufacturer) {
        Criterion criterion = Restrictions.eq("manufacturer.id", idOfManufacturer);
        return dao.getByCriterion(criterion);
    }

    public List<Footwear> getFootwearsByManufacturer(int idOfManufacturer, int numberOfPage, int amountOnPage) {
        Criterion criterion = Restrictions.eq("manufacturer.id", idOfManufacturer);
        return dao.getByCriterion(criterion, numberOfPage, amountOnPage);
    }

    public List<Footwear> getFootwearsBySearch(String searchString) {
        Criterion criterion = Restrictions.ilike("name", searchString, MatchMode.ANYWHERE);
        return dao.getByCriterion(criterion);
    }

    public List<Footwear> getFootwearsBySearch(String searchString, int numberOfPage, int amountOnPage) {
        Criterion criterion = Restrictions.ilike("name", searchString, MatchMode.ANYWHERE);
        return dao.getByCriterion(criterion, numberOfPage, amountOnPage);
    }

    @Override
    public void updateFootwear(Footwear footwear){
//        dao.updateFootwear(footwear);
        Footwear entity = dao.getById(footwear.getId());
        if(entity!=null){
            entity.setName(footwear.getName());
            entity.setManufacturer(footwear.getManufacturer());
            entity.setFootwearType(footwear.getFootwearType());
            entity.setProvider(footwear.getProvider());
            entity.setSex(footwear.getSex());
            entity.setColor(footwear.getColor());
            entity.setFixation(footwear.getFixation());
            entity.setMaterial(footwear.getMaterial());
            entity.setPrice(footwear.getPrice());
        }
    }

    @Override
    public void deleteFootwear(Footwear footwear) {
        dao.deleteFootwear(footwear);
    }

    public int saveFootwear(Footwear footwear){
        return dao.saveFootwear(footwear);
    }
}
