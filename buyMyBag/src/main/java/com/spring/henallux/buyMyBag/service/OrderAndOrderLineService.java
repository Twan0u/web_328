package com.spring.henallux.buyMyBag.service;

import com.spring.henallux.buyMyBag.dataAccess.dao.OrderDAO;
import com.spring.henallux.buyMyBag.dataAccess.dao.OrderLineDAO;
import com.spring.henallux.buyMyBag.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderAndOrderLineService {

    private OrderDAO orderDAO;
    private OrderLineDAO orderLineDAO;

    @Autowired
    public OrderAndOrderLineService(OrderDAO orderDAO, OrderLineDAO orderLineDAO) {
        this.orderDAO = orderDAO;
        this.orderLineDAO = orderLineDAO;
    }

    public void saveOrderWithOrderLines(OrderModel order){
        orderDAO.saveOrder(order);
        orderLineDAO.saveOrderLines(order.getOrderLines());
    }
}
