package com.spring.henallux.buyMyBag.dataAccess.dao;

import com.spring.henallux.buyMyBag.model.OrderLineModel;

import java.util.List;

public interface IOrderLineDataAccess {
    void saveOrderLine(OrderLineModel orderLine);
}
