package com.spring.henallux.buyMyBag.dataAccess.dao;

import com.spring.henallux.buyMyBag.dataAccess.entity.OrderLineEntity;
import com.spring.henallux.buyMyBag.dataAccess.repository.IOrderLineRepository;
import com.spring.henallux.buyMyBag.model.OrderLineModel;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderLineDAO implements IOrderLineDataAccess {

    private IOrderLineRepository orderLineRepository;
    private DozerBeanMapper mapper;

    @Autowired
    public OrderLineDAO(IOrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
        this.mapper = new DozerBeanMapper();
    }

    @Transactional
    @Override
    public void saveOrderLine(OrderLineModel orderLine) {
        orderLineRepository.save(mapper.map(orderLine, OrderLineEntity.class));
    }
}
