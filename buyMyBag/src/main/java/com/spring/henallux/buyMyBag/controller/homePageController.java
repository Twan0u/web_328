package com.spring.henallux.buyMyBag.controller;

import com.spring.henallux.buyMyBag.constants.Constants;
import com.spring.henallux.buyMyBag.model.Basket;
import com.spring.henallux.buyMyBag.model.ProductModel;
import com.spring.henallux.buyMyBag.service.CategoryService;
import com.spring.henallux.buyMyBag.service.ProductService;
import com.spring.henallux.buyMyBag.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({Constants.BASKET, Constants.CHOSEN_LANGUAGE})
@RequestMapping(value="/")
public class homePageController  {
    private ProductService productService;
    private CategoryService categoryService;
    private PromotionService promotionService;

    @ModelAttribute(Constants.BASKET)
    public Basket basket(){
        return new Basket();
    }
    @ModelAttribute(Constants.CHOSEN_LANGUAGE)
    public String chosenLanguage(){
        return Constants.FRENCH;
    }

    @Autowired
    public homePageController(ProductService productService, CategoryService categoryService, PromotionService promotionService){
        this.productService = productService;
        this.categoryService = categoryService;
        this.promotionService = promotionService;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String home(Model model, @ModelAttribute(value = Constants.BASKET)Basket basket,
                       @ModelAttribute(value = Constants.CHOSEN_LANGUAGE)String chosenLanguage) {
        model.addAttribute("products", productService.getAll());
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("promotions", promotionService.getAll());
        System.out.println("nb articles in basket in home before adding : " + basket.getNumberOfArticles());
        model.addAttribute("basket", basket);
        System.out.println("nb articles in basket in home after adding : " + basket.getNumberOfArticles());
        model.addAttribute("chosenLanguage", chosenLanguage);
        return "integrated:index";
    }
}
