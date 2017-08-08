package com.chernuw.dao.implementations;

import com.chernuw.dao.AbstractDao;
import com.chernuw.dao.interfaces.SaleDao;
import com.chernuw.model.Sale;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("saleDao")
public class SaleDaoImpl extends AbstractDao<Integer, Sale> implements SaleDao {

    public void saveSale(Sale sale) {
        save(sale);
    }

    public Sale getById(int id) {
        return getByKey(id);
    }

    public List<Sale> getAllSales() {
        return createEntityCriteria().list();
    }

    public List<Sale> getSalesByOrderId(Integer id){
        Criteria criteria = getSession().createCriteria(Sale.class);
        //return criteria.add(Restrictions.eq("order",id)).list();
        Query query = getSession().createQuery("from Sale s where s.order.id = :id");
        query.setParameter("id", id);
        return query.list();
        /*String hqlUpdate = "update orders c set c.status = '" + new String (status.getBytes("iso-8859-1"), "UTF-8") + "' where c.id = " + id;
        getSession().createSQLQuery(hqlUpdate).executeUpdate();*/
    }
}
