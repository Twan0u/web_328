package com.spring.henallux.buyMyBag.service;

import com.spring.henallux.buyMyBag.dataAccess.dao.OrderLineDAO;
import com.spring.henallux.buyMyBag.model.OrderLineModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderLineService {

    private OrderLineDAO orderLineDAO;

    @Autowired
    public OrderLineService(OrderLineDAO orderLineDAO) {
        this.orderLineDAO = orderLineDAO;
    }

    public void saveOrderLines(ArrayList<OrderLineModel> orderLines){
        orderLineDAO.saveOrderLines(orderLines);
    }
}
