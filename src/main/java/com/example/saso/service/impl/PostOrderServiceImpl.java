package com.example.saso.service.impl;

import com.example.saso.entity.Order;
import com.example.saso.mapper.OrderMapper;
import com.example.saso.service.PostOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostOrderServiceImpl implements PostOrderService {
    @Autowired
    private OrderMapper orderMapper;
    /**
     * @return
     */
    @Override
    public int deleteOrder(int id,Order order) {
        order.setId(id);
        return orderMapper.deleteByPrimaryKey(id);
    }

    /**
     *
     */
    @Override
    public int modifyOrder(int id,Order order) {
        order.setId(id);
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    /**
     * @return
     */
    @Override
    public int postOrder(Order order) {
        return orderMapper.insert(order);
    }
}
