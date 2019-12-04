package com.spring.henallux.buyMyBag.dataAccess.repository;

import com.spring.henallux.buyMyBag.dataAccess.entity.TraductionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITraductionRepository extends JpaRepository<TraductionEntity, Integer> {
}
