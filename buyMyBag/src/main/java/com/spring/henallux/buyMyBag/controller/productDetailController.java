package com.spring.henallux.buyMyBag.controller;

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
@RequestMapping(value="/detail")
public class productDetailController {

    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public productDetailController(ProductService productService, CategoryService categoryService){
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @RequestMapping(value="/{name}", method=RequestMethod.GET)
    public String productDetails(Model model, @PathVariable("name") String name){
        try {
            model.addAttribute("product", productService.getByName(name));
        } catch (ProductDAOException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "integrated:error";
        }
        model.addAttribute("categories", categoryService.getAll());
        return "integrated:item";
    }

}
