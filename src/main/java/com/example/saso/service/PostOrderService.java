package com.example.saso.service;

import com.example.saso.entity.Order;

public interface PostOrderService {

    int deleteOrder(int id, Order order);

    int modifyOrder(int id, Order order);

    int postOrder(Order order);
}
