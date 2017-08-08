package com.chernuw.service.implementations;

import com.chernuw.dao.interfaces.SaleDao;
import com.chernuw.model.Sale;
import com.chernuw.service.interfaces.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("saleService")
@Transactional
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleDao dao;

    public void saveSale(Sale sale) {
        dao.saveSale(sale);
    }

    @Override
    public Sale getSaleById(int id) {
        return dao.getById(id);
    }

    @Override
    public List<Sale> getAllSales() {
        return dao.getAllSales();
    }

    @Override
    public List<Sale> getSalesByOrderId(Integer id) {
        return dao.getSalesByOrderId(id);
    }


}
