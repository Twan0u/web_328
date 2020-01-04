package com.spring.henallux.buyMyBag.controller;

import com.spring.henallux.buyMyBag.constants.Constants;
import com.spring.henallux.buyMyBag.model.Basket;
import com.spring.henallux.buyMyBag.model.ProductModel;
import com.spring.henallux.buyMyBag.model.QuantityOrder;
import com.spring.henallux.buyMyBag.service.CategoryService;
import com.spring.henallux.buyMyBag.exception.ProductDAOException;
import com.spring.henallux.buyMyBag.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/detail")
@SessionAttributes({Constants.BASKET})
public class productDetailController {

    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public productDetailController(ProductService productService, CategoryService categoryService){
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @RequestMapping(value="/{name}", method=RequestMethod.GET)
    public String productDetails(Model model, @PathVariable("name") String name,
                                 @ModelAttribute(value = Constants.BASKET)Basket basket){
        ProductModel product;
        try {
            product = productService.getByName(name);
        } catch (ProductDAOException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "integrated:error";
        }
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("orderQuantity", new QuantityOrder());
        model.addAttribute("basket", basket);
        return "integrated:item";
    }

    @RequestMapping(value="/{name}/addToBasket", method = RequestMethod.POST)
    public String addProductToBasket(@PathVariable("name")String name , @ModelAttribute(value = "orderQuantity")QuantityOrder quantityOrder, @ModelAttribute(value = Constants.BASKET) Basket basket, Model model){
        try {
            ProductModel product;
            product = productService.getByName(name);
            basket.addProduct(product, quantityOrder.getQuantity());
            return "redirect:/";
        } catch (ProductDAOException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "integrated:error";
        }
    }
}
