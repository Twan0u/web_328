package com.spring.henallux.buyMyBag.model;

public class OrderLineModel {
    private int id;
    private int quantity;
    private double price;
    private OrderModel order_id;
    private ProductModel product_name;

    public OrderLineModel(){}

    public OrderLineModel(int id, int quantity, double price, OrderModel order_id, ProductModel product_name) {
        setId(id);
        setQuantity(quantity);
        setPrice(price);
        setOrder_id(order_id);
        setProduct_name(product_name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderModel getOrder_id() {
        return order_id;
    }

    public void setOrder_id(OrderModel order_id) {
        this.order_id = order_id;
        order_id.addOrderLine(this);
    }

    public ProductModel getProduct_name() {
        return product_name;
    }

    public void setProduct_name(ProductModel product_name) {
        this.product_name = product_name;
    }
}
