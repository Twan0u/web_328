package com.spring.henallux.buyMyBag.controller;

import com.spring.henallux.buyMyBag.constants.Constants;
import com.spring.henallux.buyMyBag.model.Basket;
import com.spring.henallux.buyMyBag.service.CategoryService;
import com.spring.henallux.buyMyBag.service.ProductService;
import com.spring.henallux.buyMyBag.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({Constants.BASKET})
@RequestMapping(value="/")
public class homePageController  {
    private ProductService productService;
    private CategoryService categoryService;
    private PromotionService promotionService;

    @ModelAttribute(Constants.BASKET)
    public Basket basket(){
        return new Basket();
    }

    @Autowired
    public homePageController(ProductService productService, CategoryService categoryService, PromotionService promotionService){
        this.productService = productService;
        this.categoryService = categoryService;
        this.promotionService = promotionService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, @ModelAttribute(value = Constants.BASKET)Basket basket) {
        model.addAttribute("products", productService.getAll());
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("promotions", promotionService.getAll());
        model.addAttribute("basket", basket);
        return "integrated:index";
    }
}
