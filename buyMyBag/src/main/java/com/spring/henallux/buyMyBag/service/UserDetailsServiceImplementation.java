package com.spring.henallux.buyMyBag.service;

import com.spring.henallux.buyMyBag.dataAccess.dao.UserDAO;
import com.spring.henallux.buyMyBag.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
    private UserDAO userDAO;

    @Autowired
    public UserDetailsServiceImplementation(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userDAO.findByUserName(username);
        if(user != null){
            //caster user
            return user;
        }
        throw new UsernameNotFoundException("User not found");
    }
}
