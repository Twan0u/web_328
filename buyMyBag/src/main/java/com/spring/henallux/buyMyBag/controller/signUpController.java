package com.spring.henallux.buyMyBag.controller;

import com.spring.henallux.buyMyBag.ViewDTO.UserDTO;
import com.spring.henallux.buyMyBag.exception.EmailAlreadyExists;
import com.spring.henallux.buyMyBag.exception.UsernameAlreadyExists;
import com.spring.henallux.buyMyBag.model.UserModel;
import com.spring.henallux.buyMyBag.service.UserDetailsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    private UserDetailsServiceImplementation userService;

    @Autowired
    public signUpController(UserDetailsServiceImplementation userService){
        this.userService = userService;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String inscriptionPage(Model model){
        model.addAttribute("newUser",new UserDTO());
        return "integrated:signUp";
    }

    @RequestMapping(value="/submit", method=RequestMethod.POST)
    public String submitUserInscription(@ModelAttribute(value="newUser")@Valid UserDTO newUser, final BindingResult errors){
        if(errors.hasErrors()){
            System.out.println("has errors");
            System.out.println(errors.getPropertyEditorRegistry());
            System.out.println(errors.getTarget());
            System.out.println(errors.getModel());
            return "integrated:signUp";
        }
        if(!newUser.getPassword().equals(newUser.getValidationPassword())){
            errors.rejectValue("validationPassword", "Les mots de passe ne correspondent pas");
            System.out.println("password differents");
            return "integrated:signUp";
        }
        UserModel newUserModel = new UserModel();
        newUserModel.setUsername(newUser.getUsername());
        newUserModel.setPassword(new BCryptPasswordEncoder().encode(newUser.getPassword()));
        newUserModel.setEmail(newUser.getEmail());
        newUserModel.setStreetname(newUser.getStreetname());
        newUserModel.setStreetnumber(newUser.getStreetnumber());
        newUserModel.setGender(newUser.getGender());
        newUserModel.setFirst_name(newUser.getFirst_name());
        newUserModel.setLast_name(newUser.getLast_name());
        newUserModel.setLocality(newUser.getLocality());
        newUserModel.setPhone_number(newUser.getPhone_number());
        newUserModel.setPostal_code(newUser.getPostal_code());

        newUserModel.setEnabled(true);
        newUserModel.setAuthorities("ROLE_USER");
        newUserModel.setNon_expired(true);
        newUserModel.setNon_locked(true);
        newUserModel.setCredentials_non_expired(true);

        try{
            userService.registerNewUserAccount(newUserModel);
        }
        catch(UsernameAlreadyExists usernameAlreadyExists){
            System.out.println("username existe deja");
        }
        catch (EmailAlreadyExists emailAlreadyExists){
            System.out.println("email existe deja");
        }
        //redirect vers home ou la derniere page visitée
        return "integrated:index";
    }
}
