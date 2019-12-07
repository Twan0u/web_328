package com.spring.henallux.buyMyBag.dataAccess.repository;

import com.spring.henallux.buyMyBag.dataAccess.entity.ImageEntity;
import com.spring.henallux.buyMyBag.model.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IImageRepository extends JpaRepository<ImageEntity, Integer> {
    List<ImageEntity> findByProductName(String name);
}
