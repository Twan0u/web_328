package com.spring.henallux.buyMyBag.controller;

import com.spring.henallux.buyMyBag.model.UserModel;
import com.spring.henallux.buyMyBag.service.CategoryService;
import com.spring.henallux.buyMyBag.exception.ProductDAOException;
import com.spring.henallux.buyMyBag.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/signUp")
public class signUpController {

    @RequestMapping(value="/signUp", method= RequestMethod.GET)
    public String inscriptionPage(Model model){
        model.addAttribute("newUser",new UserModel());
        return "integrated:signUp";
    }

}
