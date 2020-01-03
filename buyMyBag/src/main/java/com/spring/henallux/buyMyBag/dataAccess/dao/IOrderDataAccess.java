package com.spring.henallux.buyMyBag.dataAccess.dao;

import com.spring.henallux.buyMyBag.model.OrderModel;

public interface IOrderDataAccess {
    int saveOrder(OrderModel orderModel);
}
