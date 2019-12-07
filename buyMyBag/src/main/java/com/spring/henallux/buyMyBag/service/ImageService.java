package com.spring.henallux.buyMyBag.service;

import com.spring.henallux.buyMyBag.dataAccess.dao.ImageDAO;
import com.spring.henallux.buyMyBag.model.ImageModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    private ImageDAO imageDAO;

    public ImageService(ImageDAO imageDAO){
        this.imageDAO = imageDAO;
    }

    public List<ImageModel>findByProductName(String name){
        return imageDAO.findByProductName(name);
    }
}
