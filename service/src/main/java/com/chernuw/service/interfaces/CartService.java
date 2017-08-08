package com.chernuw.service.interfaces;


import com.chernuw.model.Sale;

import java.util.List;

public interface CartService {

    void addSale(Sale sale);

    void removeSale(Sale sale);

    int getFinalPrice();

    int getAmountOfSales();

    List<Sale> getSales();

    void removeAllSales();

}
