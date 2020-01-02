package com.spring.henallux.buyMyBag.service;

import com.spring.henallux.buyMyBag.dataAccess.dao.PromotionDAO;
import com.spring.henallux.buyMyBag.model.PromotionModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PromotionService {
    private PromotionDAO promotionDAO;

    public  PromotionService(PromotionDAO promotionDAO){
        this.promotionDAO = promotionDAO;
    }

    public ArrayList<PromotionModel> getAll(){
        return promotionDAO.getAll();
    }
}
