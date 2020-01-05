package com.spring.henallux.buyMyBag.controller;

import com.spring.henallux.buyMyBag.constants.Constants;
import com.spring.henallux.buyMyBag.model.Basket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({Constants.BASKET})
@RequestMapping(value="/paymentSuccess")
public class paymentSuccessController {

    @RequestMapping(method = RequestMethod.GET)
    public String paymentSuccess(Model model, @ModelAttribute(value = Constants.BASKET) Basket basket){
        basket.emptyBasket();
        model.addAttribute("basket", basket);
        return "integrated:paymentSuccess";
    }
}
