package com.spring.henallux.buyMyBag.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="clientorder")
public class OrderLineEntity {
    @Id
    @Column
    private int id;
    @Column
    private int quantity;
    @Column
    private double price;
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private OrderEntity order_id;
    @ManyToOne
    @JoinColumn(name = "product_name", referencedColumnName = "name")
    private ProductEntity product_name;

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

    public OrderEntity getOrder_id() {
        return order_id;
    }

    public void setOrder_id(OrderEntity order_id) {
        this.order_id = order_id;
    }

    public ProductEntity getProduct_name() {
        return product_name;
    }

    public void setProduct_name(ProductEntity product_name) {
        this.product_name = product_name;
    }
}
