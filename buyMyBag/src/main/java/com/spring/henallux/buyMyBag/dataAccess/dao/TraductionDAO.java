package com.spring.henallux.buyMyBag.dataAccess.dao;

import com.spring.henallux.buyMyBag.dataAccess.repository.ITraductionRepository;
import com.spring.henallux.buyMyBag.dataAccess.repository.IUserRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraductionDAO implements  ITraductionDataAccess {
    private ITraductionRepository traductionRepository;

    private DozerBeanMapper mapper;

    @Autowired
    public TraductionDAO(ITraductionRepository traductionRepository){
        this.traductionRepository = traductionRepository;
        mapper = new DozerBeanMapper();
    }
}
