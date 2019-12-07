package com.spring.henallux.buyMyBag.dataAccess.dao;

import com.spring.henallux.buyMyBag.model.ProductModel;

import java.util.List;

public interface IProductDataAccess {
    List<ProductModel> getAll();
}
