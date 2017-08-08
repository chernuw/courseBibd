package com.chernuw.service.interfaces;

import com.chernuw.model.Sale;

import java.util.List;

public interface SaleService {

    void saveSale(Sale sale);
    Sale getSaleById(int id);
    List<Sale> getAllSales();
    List<Sale> getSalesByOrderId(Integer id);

}
