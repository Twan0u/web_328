package com.spring.henallux.buyMyBag.service;

import com.spring.henallux.buyMyBag.dataAccess.dao.OrderDAO;
import com.spring.henallux.buyMyBag.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private OrderDAO orderDAO;

    @Autowired
    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public int saveOrder(OrderModel orderModel){
        return orderDAO.saveOrder(orderModel);
    }
}
