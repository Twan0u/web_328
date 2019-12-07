package com.spring.henallux.buyMyBag.dataAccess.dao;

import com.spring.henallux.buyMyBag.model.ImageModel;

import java.util.List;

public interface IImageDataAccess {
    List<ImageModel>findByProductName(String name);
}
