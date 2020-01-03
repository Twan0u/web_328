package com.spring.henallux.buyMyBag.model;

public class QuantityOrder {
    private int quantity;

    public QuantityOrder(){}

    public QuantityOrder(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
