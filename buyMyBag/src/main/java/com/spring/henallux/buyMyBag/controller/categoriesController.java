package com.spring.henallux.buyMyBag.controller;

import com.spring.henallux.buyMyBag.service.CategoryService;
import com.spring.henallux.buyMyBag.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/catego")
public class categoriesController {
    private ProductService productService;
    private CategoryService categoryService;

    @Autowired
    public categoriesController(ProductService productService, CategoryService categoryService){
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String catego(Model model) {
        model.addAttribute("products", productService.getAll());
        model.addAttribute("categories", categoryService.getAll());
        return "integrated:category";
    }
}
