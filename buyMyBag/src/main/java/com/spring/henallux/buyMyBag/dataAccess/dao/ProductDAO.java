package com.spring.henallux.buyMyBag.dataAccess.dao;

import com.spring.henallux.buyMyBag.dataAccess.entity.ProductEntity;
import com.spring.henallux.buyMyBag.dataAccess.repository.IProductRepository;
import com.spring.henallux.buyMyBag.exception.ProductDAOException;
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
    public ProductDAO(IProductRepository productRepository){
        this.productRepository = productRepository;
        mapper = new DozerBeanMapper();
        mapper.setMappingFiles(Arrays.asList("dozerMapping\\product_mapping.xml"));
    }

    public List<ProductModel> getAll(){
        List<ProductEntity> productEntities = productRepository.findAll();
        List<ProductModel> productModels = entityListToModelList(productEntities);
        return productModels;
    }

    public ProductModel getByName(String name) throws ProductDAOException{
        ProductEntity productEntity = productRepository.findByName(name);
        if(productEntity == null){
            throw new ProductDAOException("Ce produit est introuvable");
        }
        ProductModel productModel =  mapper.map(productEntity, ProductModel.class);
        return productModel;
    }

    public List<ProductModel> getByCategoryName(String name) throws ProductDAOException{
        List<ProductEntity> productEntities = productRepository.findByCategoryName(name);
        List<ProductModel> productModels = entityListToModelList(productEntities);
        if(productModels.size() == 0){
            throw new ProductDAOException("Aucun produit n'est disponible pour cette catégorie");
        }
        return productModels;
    }

    private List<ProductModel> entityListToModelList(List<ProductEntity>productEntities){
        List<ProductModel> productModels = new ArrayList<>();
        for(ProductEntity productEntity : productEntities){
            productModels.add(mapper.map(productEntity, ProductModel.class));
        }
        return productModels;
    }
}
