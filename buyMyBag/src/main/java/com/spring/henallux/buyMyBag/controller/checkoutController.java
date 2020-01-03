package com.spring.henallux.buyMyBag.controller;

import com.spring.henallux.buyMyBag.constants.Constants;
import com.spring.henallux.buyMyBag.model.*;
import com.spring.henallux.buyMyBag.service.OrderLineService;
import com.spring.henallux.buyMyBag.service.OrderService;
import com.spring.henallux.buyMyBag.service.UserDetailsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@Controller
@SessionAttributes({Constants.BASKET, Constants.CHOSEN_LANGUAGE})
@RequestMapping(value="/checkout")
public class checkoutController {

    private OrderService orderService;
    private OrderLineService orderLineService;
    private UserDetailsServiceImplementation userService;

    @Autowired
    public checkoutController(OrderService orderService, OrderLineService orderLineService, UserDetailsServiceImplementation userService) {
        this.orderService = orderService;
        this.orderLineService = orderLineService;
        this.userService = userService;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String checkout(@ModelAttribute(value = Constants.BASKET) Basket basket, Model model){
        if(basket == null)
            return "redirect:/";

        Date now = new Date(System.currentTimeMillis());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        try{
            OrderModel orderModel = new OrderModel(0, false, now, (UserModel)userService.loadUserByUsername(username));
            int orderId = orderService.saveOrder(orderModel);
            orderModel.setId(orderId);

            ArrayList<OrderLineModel> orderLines = new ArrayList<>();
            for(Map.Entry<ProductModel, Integer> entry : basket.getAllProductsWithQt().entrySet()){
                orderLines.add(new OrderLineModel(0, entry.getValue(), entry.getKey().getPrice(), orderModel, entry.getKey()));
            }
            orderLineService.saveOrderLines(orderLines);
            basket.emptyBasket();
        }
        catch (UsernameNotFoundException e){
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
