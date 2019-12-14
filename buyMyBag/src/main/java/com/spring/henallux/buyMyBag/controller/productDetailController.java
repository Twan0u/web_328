package com.spring.henallux.buyMyBag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/detail")
public class productDetailController {
    @RequestMapping(value="/{name}", method=RequestMethod.GET)
    public String productDetails(@PathVariable("name") String name){
        return "integrated:item";
    }
}
