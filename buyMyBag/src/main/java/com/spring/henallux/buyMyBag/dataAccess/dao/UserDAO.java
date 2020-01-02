package com.spring.henallux.buyMyBag.dataAccess.dao;

import com.spring.henallux.buyMyBag.dataAccess.entity.UserEntity;
import com.spring.henallux.buyMyBag.dataAccess.repository.IUserRepository;
import com.spring.henallux.buyMyBag.model.UserModel;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
        if(userEntity == null)
            return null;
        return mapper.map(userEntity, UserModel.class);
    }

    @Override
    public UserModel findByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        if(userEntity == null)
            return null;
        return mapper.map(userEntity, UserModel.class);
    }

    @Override
    public void save(UserModel userModel) {
        UserEntity userEntity = mapper.map(userModel, UserEntity.class);
        userRepository.save(userEntity);
    }
}
