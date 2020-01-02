package com.spring.henallux.buyMyBag.dataAccess.dao;

import com.spring.henallux.buyMyBag.model.PromotionModel;

import java.util.List;

public interface IPromotionDataAccess {
    List<PromotionModel> getAll();
}
