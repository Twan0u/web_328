package com.spring.henallux.buyMyBag.dataAccess.dao;

import com.spring.henallux.buyMyBag.dataAccess.entity.ImageEntity;
import com.spring.henallux.buyMyBag.dataAccess.repository.IImageRepository;
import com.spring.henallux.buyMyBag.model.ImageModel;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageDAO implements IImageDataAccess{
    private IImageRepository imageRepository;

    private DozerBeanMapper mapper;

    @Autowired
    public ImageDAO(IImageRepository imageRepository){
        this.imageRepository = imageRepository;
        mapper = new DozerBeanMapper();
    }

    public List<ImageModel> findByProductName(String name){
        List<ImageEntity>imageEntities = imageRepository.findByProductName(name);
        List<ImageModel>imageModels = new ArrayList<>();
        for(ImageEntity imageEntity : imageEntities){
            imageModels.add(mapper.map(imageEntity, ImageModel.class));
        }
        return imageModels;
    }
}
