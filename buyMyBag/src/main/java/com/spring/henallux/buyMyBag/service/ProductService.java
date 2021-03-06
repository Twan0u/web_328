package com.spring.henallux.buyMyBag.service;

import com.spring.henallux.buyMyBag.dataAccess.dao.ProductDAO;
import com.spring.henallux.buyMyBag.exception.ProductDAOException;
import com.spring.henallux.buyMyBag.model.ImageModel;
import com.spring.henallux.buyMyBag.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductDAO productDAO;
    private ImageService imageService;

    @Autowired
    public ProductService(ProductDAO productDAO, ImageService imageService){
        this.productDAO = productDAO;
        this.imageService = imageService;
    }
    public List<ProductModel> getAll(){
        List<ProductModel>productModels = productDAO.getAll();
        for(ProductModel productModel : productModels){
            productModel.setImages(getImagesOfProduct(productModel.getName()));
        }
        return productModels;
    }

    public ProductModel getByName(String name) throws ProductDAOException {
        ProductModel productModel = productDAO.getByName(name);
        productModel.setImages(getImagesOfProduct(name));
        return productModel;
    }

    public List<ProductModel> getByCategoryName(String name) throws ProductDAOException {
        List<ProductModel> productModels = productDAO.getByCategoryName(name);
        for(ProductModel productModel : productModels){
            productModel.setImages(getImagesOfProduct(productModel.getName()));
        }
        return productModels;
    }

    private List<String> getImagesOfProduct(String productName){
        return imageService.findByProductName(productName).stream().map(imageModel -> imageModel.getImage_uri()).collect(Collectors.toList());
    }
}
