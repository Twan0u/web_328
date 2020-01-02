package com.spring.henallux.buyMyBag.controller;

import com.spring.henallux.buyMyBag.exception.ProductDAOException;
import com.spring.henallux.buyMyBag.service.CategoryService;
import com.spring.henallux.buyMyBag.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/category")
public class categoryController {
    private ProductService productService;
    private CategoryService categoryService;

    @Autowired
    public categoryController(ProductService productService, CategoryService categoryService){
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @RequestMapping(value="/{name}", method= RequestMethod.GET)
    public String category(Model model, @PathVariable String name) {
        try {
            model.addAttribute("products", productService.getByCategoryName(name));
            model.addAttribute("categories", categoryService.getAll());
            model.addAttribute("categoryName",name);
            return "integrated:category";
        } catch (ProductDAOException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "integrated:error";
        }
    }

}
