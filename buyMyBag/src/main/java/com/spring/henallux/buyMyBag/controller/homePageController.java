package com.spring.henallux.buyMyBag.controller;

import com.spring.henallux.buyMyBag.service.CategoryService;
import com.spring.henallux.buyMyBag.service.ProductService;
import com.spring.henallux.buyMyBag.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/")
public class homePageController  {
    private ProductService productService;
    private CategoryService categoryService;
    private PromotionService promotionService;

    @Autowired
    public homePageController(ProductService productService, CategoryService categoryService, PromotionService promotionService){
        this.productService = productService;
        this.categoryService = categoryService;
        this.promotionService = promotionService;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("products", productService.getAll());
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("promotions", promotionService.getAll());
        return "integrated:index";
    }
}
