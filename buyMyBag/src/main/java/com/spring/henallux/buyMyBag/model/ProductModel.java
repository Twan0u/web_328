package com.spring.henallux.buyMyBag.model;

import java.util.ArrayList;
import java.util.List;

public class ProductModel {
    private String name;
    private String description;
    private double price;
    private CategoryModel category;
    private List<String> images = new ArrayList<>();

    public ProductModel(){

    }

    public ProductModel(String name, String description, double price, CategoryModel category) {
        setName(name);
        setDescription(description);
        setPrice(price);
        setCategory(category);
    }


    public void setImages(List<String> images) {
        this.images = images;
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

    public List<String> getImages() {
        return images;
    }

    public void addImage(String image){
        this.images.add(image);
    }

    public String getFirstImage(){
        if(images.size() > 0)
            return images.get(0);
        return "";
    }
}
