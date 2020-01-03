package com.spring.henallux.buyMyBag.dataAccess.dao;

import com.spring.henallux.buyMyBag.dataAccess.entity.OrderEntity;
import com.spring.henallux.buyMyBag.dataAccess.repository.IOrderRepository;
import com.spring.henallux.buyMyBag.model.OrderModel;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderDAO implements IOrderDataAccess{

    private IOrderRepository orderRepository;
    private DozerBeanMapper mapper;

    @Autowired
    public OrderDAO(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.mapper = new DozerBeanMapper();
    }

    @Override
    @Transactional
    public int saveOrder(OrderModel orderModel) {
        OrderEntity orderEntity = mapper.map(orderModel, OrderEntity.class);
        return orderRepository.save(orderEntity).getId();
    }
}
