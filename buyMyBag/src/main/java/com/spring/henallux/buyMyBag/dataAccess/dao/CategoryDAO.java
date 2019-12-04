package com.spring.henallux.buyMyBag.dataAccess.dao;

import com.spring.henallux.buyMyBag.dataAccess.repository.IUserRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryDAO implements ICategoryDataAccess {
    private IUserRepository userRepository;

    private DozerBeanMapper mapper;

    @Autowired
    public CategoryDAO(IUserRepository userRepository){
        this.userRepository = userRepository;
        mapper = new DozerBeanMapper();
    }
}
