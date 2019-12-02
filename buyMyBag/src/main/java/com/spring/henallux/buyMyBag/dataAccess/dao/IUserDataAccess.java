package com.spring.henallux.buyMyBag.dataAccess.dao;

import com.spring.henallux.buyMyBag.model.UserModel;

import java.util.List;

public interface IUserDataAccess {
    public List<UserModel> getAll();
}
