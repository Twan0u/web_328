package com.spring.henallux.buyMyBag.dataAccess.repository;
import com.spring.henallux.buyMyBag.dataAccess.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, String>{
}
