package com.spring.henallux.buyMyBag.dataAccess.dao;

import com.spring.henallux.buyMyBag.dataAccess.repository.ILanguageRepository;
import com.spring.henallux.buyMyBag.dataAccess.repository.IUserRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageDAO implements ILanguageDataAccess{
    private ILanguageRepository languageRepository;

    private DozerBeanMapper mapper;

    @Autowired
    public LanguageDAO(ILanguageRepository languageRepository){
        this.languageRepository = languageRepository;
        mapper = new DozerBeanMapper();
    }
}
