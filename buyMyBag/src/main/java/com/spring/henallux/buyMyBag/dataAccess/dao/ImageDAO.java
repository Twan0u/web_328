package com.spring.henallux.buyMyBag.dataAccess.dao;

import com.spring.henallux.buyMyBag.dataAccess.repository.IImageRepository;
import com.spring.henallux.buyMyBag.dataAccess.repository.IUserRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageDAO implements IImageDataAccess{
    private IImageRepository imageRepository;

    private DozerBeanMapper mapper;

    @Autowired
    public ImageDAO(IImageRepository imageRepository){
        this.imageRepository = imageRepository;
        mapper = new DozerBeanMapper();
    }
}
