package com.spring.henallux.buyMyBag.model;

import java.util.ArrayList;
import java.util.Date;

public class OrderModel {
    private int id;
    private boolean is_payed;
    private Date creation_date;
    private UserModel user_login;
    private ArrayList<OrderLineModel> orderLines = new ArrayList<>();

    public OrderModel(){}

    public OrderModel(int id, boolean is_payed, Date creation_date, UserModel user_login) {
        this.id = id;
        this.is_payed = is_payed;
        this.creation_date = creation_date;
        this.user_login = user_login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIs_payed() {
        return is_payed;
    }

    public void setIs_payed(boolean is_payed) {
        this.is_payed = is_payed;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public UserModel getUser_login() {
        return user_login;
    }

    public void setUser_login(UserModel user_login) {
        this.user_login = user_login;
    }

    public ArrayList<OrderLineModel> getOrderLines() {
        return orderLines;
    }

    public void addOrderLine(OrderLineModel orderLine){
        orderLines.add(orderLine);
    }
}
