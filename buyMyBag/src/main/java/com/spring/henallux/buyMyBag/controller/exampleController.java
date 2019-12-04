package com.spring.henallux.buyMyBag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/test")
public class exampleController {
    @RequestMapping(method= RequestMethod.GET)
    public String home(Model model){
        return "examplePage";
    }
}
