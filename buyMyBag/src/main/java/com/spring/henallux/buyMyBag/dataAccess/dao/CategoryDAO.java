package com.spring.henallux.buyMyBag.dataAccess.dao;

import com.spring.henallux.buyMyBag.dataAccess.entity.CategoryEntity;
import com.spring.henallux.buyMyBag.dataAccess.repository.ICategoryRepository;
import com.spring.henallux.buyMyBag.dataAccess.repository.IUserRepository;
import com.spring.henallux.buyMyBag.model.CategoryModel;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryDAO implements ICategoryDataAccess {
    private ICategoryRepository categoryRepository;

    private DozerBeanMapper mapper;

    @Autowired
    public CategoryDAO(ICategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
        mapper = new DozerBeanMapper();
    }

    public List<CategoryModel> getAll(){
        List<CategoryEntity>categoryEntities = categoryRepository.findAll();
        List<CategoryModel>categoryModels = new ArrayList<>();
        for(CategoryEntity categoryEntity : categoryEntities){
            categoryModels.add(mapper.map(categoryEntity, CategoryModel.class));
        }
        return categoryModels;
    }
}
