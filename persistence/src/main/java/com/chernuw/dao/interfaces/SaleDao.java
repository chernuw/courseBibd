package com.chernuw.dao.interfaces;

import com.chernuw.model.Sale;

import java.util.List;

public interface SaleDao {

    void saveSale(Sale sale);
    Sale getById(int id);
    List<Sale> getAllSales();
    List getSalesByOrderId(Integer id);

}
