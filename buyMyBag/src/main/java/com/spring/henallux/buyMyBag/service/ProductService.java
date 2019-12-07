package com.spring.henallux.buyMyBag.service;

import com.spring.henallux.buyMyBag.dataAccess.dao.ProductDAO;
import com.spring.henallux.buyMyBag.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductDAO productDAO;

    @Autowired
    public ProductService(ProductDAO productDAO){
        this.productDAO = productDAO;
    }
    public List<ProductModel> getAll(){
        return productDAO.getAll();
    }
}
