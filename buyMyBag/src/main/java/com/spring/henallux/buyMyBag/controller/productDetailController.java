package com.spring.henallux.buyMyBag.controller;

import com.spring.henallux.buyMyBag.service.CategoryService;
import com.spring.henallux.buyMyBag.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/detail")
public class productDetailController {

    private CategoryService categoryService;

    @Autowired
    public productDetailController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @RequestMapping(value="/{name}", method=RequestMethod.GET)
    public String productDetails(@PathVariable("name") String name, Model model){
        model.addAttribute("categories", categoryService.getAll());
        return "integrated:item";
    }

}
