package com.spring.henallux.buyMyBag.dataAccess.dao;

import com.spring.henallux.buyMyBag.dataAccess.entity.UserEntity;
import com.spring.henallux.buyMyBag.dataAccess.repository.IUserRepository;
import com.spring.henallux.buyMyBag.model.UserModel;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDAO implements IUserDataAccess {
    private IUserRepository userRepository;

    private DozerBeanMapper mapper;

    @Autowired
    public UserDAO(IUserRepository userRepository){
        this.userRepository = userRepository;
        mapper = new DozerBeanMapper();
    }

    @Override
    public List<UserModel> getAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserModel> userModels = new ArrayList<>();
        for(UserEntity userEntity : userEntities){
            userModels.add(mapper.map(userEntity, UserModel.class));
        }
        return userModels;
    }

    @Override
    public UserModel findByUserName(String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        UserModel userModel = mapper.map(userEntity, UserModel.class);
        return userModel;
    }
}
