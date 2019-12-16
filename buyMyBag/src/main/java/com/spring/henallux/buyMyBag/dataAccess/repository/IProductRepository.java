package com.spring.henallux.buyMyBag.dataAccess.repository;
import com.spring.henallux.buyMyBag.dataAccess.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, String>{
    ProductEntity findByName(String name);
    List<ProductEntity>findByCategoryName(String categoryName);
}
