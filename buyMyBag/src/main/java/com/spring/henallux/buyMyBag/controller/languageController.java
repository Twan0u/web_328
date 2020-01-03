package com.spring.henallux.buyMyBag.controller;

import com.spring.henallux.buyMyBag.constants.Constants;
import com.spring.henallux.buyMyBag.model.ChosenLanguage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({Constants.CHOSEN_LANGUAGE})
@RequestMapping(value="/language/{code}")
public class languageController {
    @RequestMapping(method = RequestMethod.GET)
    public String home(@ModelAttribute(value = Constants.CHOSEN_LANGUAGE) ChosenLanguage chosenLanguage, @PathVariable String code) {
        chosenLanguage.setLanguage((code.equals("en") ? Constants.ENGLISH : Constants.FRENCH));
        return "redirect:/";
    }
}
