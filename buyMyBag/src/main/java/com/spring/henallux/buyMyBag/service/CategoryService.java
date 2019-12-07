package com.spring.henallux.buyMyBag.service;

import com.spring.henallux.buyMyBag.dataAccess.dao.CategoryDAO;
import com.spring.henallux.buyMyBag.model.CategoryModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryDAO categoryDAO;

    public CategoryService(CategoryDAO categoryDAO){
        this.categoryDAO = categoryDAO;
    }

    public List<CategoryModel> getAll(){
        return categoryDAO.getAll();
    }
}
