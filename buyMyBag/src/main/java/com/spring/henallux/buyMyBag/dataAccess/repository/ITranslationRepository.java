package com.spring.henallux.buyMyBag.dataAccess.repository;

import com.spring.henallux.buyMyBag.dataAccess.entity.TranslationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITranslationRepository extends JpaRepository<TranslationEntity, Integer> {
}
