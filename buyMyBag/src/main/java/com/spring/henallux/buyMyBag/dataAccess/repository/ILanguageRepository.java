package com.spring.henallux.buyMyBag.dataAccess.repository;

import com.spring.henallux.buyMyBag.dataAccess.entity.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILanguageRepository extends JpaRepository<LanguageEntity, String> {
}
