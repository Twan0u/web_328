package com.spring.henallux.buyMyBag.dataAccess.dao;

import com.spring.henallux.buyMyBag.dataAccess.entity.UserEntity;
import com.spring.henallux.buyMyBag.model.UserModel;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface IUserDataAccess {
    List<UserModel> getAll();
    UserModel findByUserName(String username);
}
