package com.spring.henallux.buyMyBag.controller;

import com.spring.henallux.buyMyBag.constants.Constants;
import com.spring.henallux.buyMyBag.model.Basket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({Constants.BASKET})
@RequestMapping(value="/addOne")
public class addOneToBasketItemController {
    @RequestMapping(value = "/{productName}", method = RequestMethod.GET)
    public String addOne(@ModelAttribute(value = Constants.BASKET) Basket basket , @PathVariable String productName){
        basket.addOne(productName);
        return "redirect:/basketDetails";
    }
}
