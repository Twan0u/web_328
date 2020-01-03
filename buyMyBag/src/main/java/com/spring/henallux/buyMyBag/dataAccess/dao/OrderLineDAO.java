package com.spring.henallux.buyMyBag.dataAccess.dao;

import com.spring.henallux.buyMyBag.dataAccess.entity.OrderLineEntity;
import com.spring.henallux.buyMyBag.dataAccess.repository.IOrderLineRepository;
import com.spring.henallux.buyMyBag.model.OrderLineModel;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderLineDAO implements IOrderLineDataAccess {

    private IOrderLineRepository orderLineRepository;
    private DozerBeanMapper mapper;

    @Autowired
    public OrderLineDAO(IOrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
        this.mapper = new DozerBeanMapper();
    }

    @Override
    public void saveOrderLines(List<OrderLineModel> orderLines) {
        List<OrderLineEntity>orderLineEntities = new ArrayList<>();
        for(OrderLineModel orderLineModel : orderLines){
            System.out.println(orderLineModel.getProduct_name().getName());
            orderLineEntities.add(mapper.map(orderLineModel, OrderLineEntity.class));
        }
        for(OrderLineEntity orderLineEntity : orderLineEntities){
            orderLineRepository.save(orderLineEntity);
        }
    }
}
