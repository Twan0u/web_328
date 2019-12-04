package com.spring.henallux.buyMyBag.controller;

import com.spring.henallux.buyMyBag.model.CategoryModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/home")
public class homePageController  {
    @RequestMapping(method= RequestMethod.GET)
    public String home(Model model){
        List<CategoryModel> categories = new ArrayList<>();
        categories.add(new CategoryModel("categorie1"));
        categories.add(new CategoryModel("categorie2"));
        categories.add(new CategoryModel("categorie3"));
        categories.add(new CategoryModel("categorie4"));
        categories.add(new CategoryModel("categorie5"));
        model.addAttribute("categories", categories);
        return "index";
    }
}
