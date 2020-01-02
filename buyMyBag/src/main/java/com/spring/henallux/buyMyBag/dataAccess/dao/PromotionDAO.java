package com.spring.henallux.buyMyBag.dataAccess.dao;

import com.spring.henallux.buyMyBag.dataAccess.entity.PromotionEntity;
import com.spring.henallux.buyMyBag.dataAccess.repository.IPromotionRepository;
import com.spring.henallux.buyMyBag.model.PromotionModel;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromotionDAO implements IPromotionDataAccess{

    private IPromotionRepository promotionRepository;
    private DozerBeanMapper mapper;

    @Autowired
    public PromotionDAO(IPromotionRepository promotionRepository){
            this.promotionRepository = promotionRepository;
            mapper = new DozerBeanMapper();
    }

    @Override
    public ArrayList<PromotionModel> getAll() {
        List<PromotionEntity>promotionEntities = promotionRepository.findAll();
        ArrayList<PromotionModel>promotionModels = new ArrayList<>();
        for(PromotionEntity promotionEntity : promotionEntities){
            promotionModels.add(mapper.map(promotionEntity, PromotionModel.class));
        }
        return promotionModels;
    }
}
