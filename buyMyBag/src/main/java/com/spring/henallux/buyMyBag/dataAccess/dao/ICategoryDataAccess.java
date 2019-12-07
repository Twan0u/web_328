package com.spring.henallux.buyMyBag.dataAccess.dao;

import com.spring.henallux.buyMyBag.model.CategoryModel;

import java.util.List;

public interface ICategoryDataAccess {
    List<CategoryModel> getAll();
}
