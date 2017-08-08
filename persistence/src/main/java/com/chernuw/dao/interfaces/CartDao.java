package com.chernuw.dao.interfaces;


import com.chernuw.model.Sale;

import java.util.List;

public interface CartDao {

    void addSale(Sale sale);

    void removeSale(Sale sale);

    int getFinalPrice();

    int getAmountOfSales();

    List<Sale> getSales();

    void removeAllSales();

}
