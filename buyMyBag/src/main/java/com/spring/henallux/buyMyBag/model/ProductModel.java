package com.spring.henallux.buyMyBag.model;

public class ProductModel {
    private String name;
    private String description;
    private double price;
    private CategoryModel category;

    public ProductModel(String name, String description, double price, CategoryModel category) {
        setName(name);
        setDescription(description);
        setPrice(price);
        setCategory(category);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }
}
