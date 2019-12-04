package com.spring.henallux.buyMyBag.model;

public class ImageModel {
    private String image_uri;
    private CategoryModel category;
    private ProductModel product;

    public ImageModel(String image_uri, CategoryModel category, ProductModel product) {
        this.image_uri = image_uri;
        this.category = category;
        this.product = product;
    }

    public ImageModel(String image_uri, CategoryModel category) {
        this(image_uri, category, null);
    }

    public ImageModel(String image_uri, ProductModel product){
        this(image_uri, null, product);
    }
}
