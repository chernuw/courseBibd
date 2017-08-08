package com.chernuw.service.interfaces;

import com.chernuw.model.Order;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface OrderService {

    int saveOrder(Order order);
    void deleteOrder(Order order);
    Order getOrderById(int id);
    List<Order> getAllOrders();
    void updateStatus(int id, String status) throws UnsupportedEncodingException;
}
