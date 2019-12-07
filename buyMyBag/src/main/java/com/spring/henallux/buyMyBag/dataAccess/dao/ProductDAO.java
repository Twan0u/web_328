package com.spring.henallux.buyMyBag.dataAccess.dao;

import com.spring.henallux.buyMyBag.dataAccess.entity.ProductEntity;
import com.spring.henallux.buyMyBag.dataAccess.repository.IProductRepository;
import com.spring.henallux.buyMyBag.model.ProductModel;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductDAO implements IProductDataAccess {
    private IProductRepository productRepository;
    private DozerBeanMapper mapper;

    @Autowired
    public ProductDAO(IProductRepository productRespository){
        this.productRepository = productRespository;
        mapper = new DozerBeanMapper();
        mapper.setMappingFiles(Arrays.asList("dozerMapping\\product_mapping.xml"));
    }

    public List<ProductModel> getAll(){
        List<ProductEntity> productEntities = productRepository.findAll();
        List<ProductModel> productModels = new ArrayList<>();
        for(ProductEntity productEntity : productEntities){
            productModels.add(mapper.map(productEntity, ProductModel.class));
        }
        return productModels;
    }
}
