package com.spring.henallux.buyMyBag.model;

public class BasketItem {
    private ProductModel product;
    private int quantity;

    public BasketItem() { }

    public BasketItem(ProductModel product) {
        this.product = product;
    }

    public BasketItem(ProductModel product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
