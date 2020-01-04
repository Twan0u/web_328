package com.spring.henallux.buyMyBag.controller;

import com.spring.henallux.buyMyBag.constants.Constants;
import com.spring.henallux.buyMyBag.model.Basket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({Constants.BASKET})
@RequestMapping(value="/removeOne")
public class RemoveOneToBasketItemController {
    @RequestMapping(value = "/{productName}", method = RequestMethod.GET)
    public String removeOne(@ModelAttribute(value = Constants.BASKET) Basket basket, @PathVariable String productName){
        basket.removeOne(productName);
        return "redirect:/basketDetails";
    }
}
