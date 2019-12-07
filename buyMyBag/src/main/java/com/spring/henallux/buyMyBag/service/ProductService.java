package com.spring.henallux.buyMyBag.service;

import com.spring.henallux.buyMyBag.dataAccess.dao.ProductDAO;
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
        List<String>image_urls;
        for(ProductModel productModel : productModels){
            image_urls = imageService.findByProductName(productModel.getName()).stream().map(imageModel -> imageModel.getImage_uri()).collect(Collectors.toList());
            productModel.setImages(image_urls);
        }
        return productModels;
    }
}
