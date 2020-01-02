package com.spring.henallux.buyMyBag.service;

import com.spring.henallux.buyMyBag.ViewDTO.UserDTO;
import com.spring.henallux.buyMyBag.dataAccess.dao.UserDAO;
import com.spring.henallux.buyMyBag.exception.EmailAlreadyExists;
import com.spring.henallux.buyMyBag.exception.UsernameAlreadyExists;
import com.spring.henallux.buyMyBag.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.Email;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
    private UserDAO userDAO;

    @Autowired
    public UserDetailsServiceImplementation(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.findByUserName(username);
    }

    @Transactional
    public void registerNewUserAccount(UserModel userModel) throws EmailAlreadyExists, UsernameAlreadyExists {
        if(userDAO.findByEmail(userModel.getEmail()) != null)
            throw new EmailAlreadyExists();
        if(userDAO.findByUserName(userModel.getUsername()) != null)
            throw new UsernameAlreadyExists();
        userDAO.save(userModel);
    }
}
