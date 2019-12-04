package com.spring.henallux.buyMyBag.dataAccess.repository;

import com.spring.henallux.buyMyBag.dataAccess.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageRepository extends JpaRepository<ImageEntity, Integer> {
}
