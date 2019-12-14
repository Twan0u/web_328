package com.spring.henallux.buyMyBag.dataAccess.dao;

import com.spring.henallux.buyMyBag.dataAccess.repository.ITranslationRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslationDAO implements ITranslationDataAccess {
    private ITranslationRepository translationRepository;

    private DozerBeanMapper mapper;

    @Autowired
    public TranslationDAO(ITranslationRepository translationRepository){
        this.translationRepository = translationRepository;
        mapper = new DozerBeanMapper();
    }
}
