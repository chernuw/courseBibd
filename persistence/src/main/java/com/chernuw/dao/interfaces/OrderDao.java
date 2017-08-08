package com.chernuw.dao.interfaces;

import com.chernuw.model.Order;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface OrderDao {

    int saveOrder(Order order);
    void deleteOrder(Order order);
    Order getById(int id);
    List<Order> getAllOrders();
    void updateStatus(int id, String status) throws UnsupportedEncodingException;

}
