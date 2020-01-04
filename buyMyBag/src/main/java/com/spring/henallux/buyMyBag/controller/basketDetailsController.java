package com.spring.henallux.buyMyBag.controller;

import com.spring.henallux.buyMyBag.constants.Constants;
import com.spring.henallux.buyMyBag.model.Basket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({Constants.BASKET})
@RequestMapping(value="/basketDetails")
public class basketDetailsController {
    @RequestMapping(method = RequestMethod.GET)
    public String basketDetails(Model model, @ModelAttribute(value = Constants.BASKET) Basket basket){
        model.addAttribute("basket", basket);
        return "integrated:cartDetailedPage";
    }
}
