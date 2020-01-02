package com.spring.henallux.buyMyBag.dataAccess.dao;

import com.spring.henallux.buyMyBag.model.UserModel;

import java.util.List;

public interface IUserDataAccess {
    List<UserModel> getAll();
    UserModel findByUserName(String username);
    UserModel findByEmail(String email);
    void save(UserModel userModel);
}
