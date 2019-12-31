package com.spring.henallux.buyMyBag.controller;

import com.spring.henallux.buyMyBag.ViewDTO.UserDTO;
import com.spring.henallux.buyMyBag.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value="/signUp")
public class signUpController {

    @RequestMapping(method= RequestMethod.GET)
    public String inscriptionPage(Model model){
        model.addAttribute("newUser",new UserDTO());
        return "integrated:signUp";
    }

    @RequestMapping(value="/submit", method=RequestMethod.POST)
    public String submitUserInscription(@Valid @ModelAttribute(value="newUser") UserModel newUser, final BindingResult errors){
        if(errors.hasErrors()){
            return "integrated:signUp";
        }
        if(!newUser.getPassword().equals(newUser.getValidationPassword())){
            errors.rejectValue("validationPassword", "Les mots de passe ne correspondent pas");
            return "integrated:signUp";
        }
        //redirect vers home ou la derniere page visitée
        return "integrated:index";
    }
}
