package com.spring.henallux.buyMyBag.dataAccess.repository;

import com.spring.henallux.buyMyBag.dataAccess.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<CategoryEntity, String> {
}
