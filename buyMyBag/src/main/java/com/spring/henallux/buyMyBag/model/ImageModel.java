package com.spring.henallux.buyMyBag.model;

public class ImageModel {
    private String image_uri;
    private CategoryModel category;
    private ProductModel product;

    public ImageModel(){

    }

    public ImageModel(String image_uri, CategoryModel category, ProductModel product) {
        setImage_uri(image_uri);
        setCategory(category);
        setProduct(product);
    }

    public String getImage_uri() {
        return image_uri;
    }

    public void setImage_uri(String image_uri) {
        this.image_uri = image_uri;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
        product.addImage(image_uri);
    }

    public ImageModel(String image_uri, CategoryModel category) {
        this(image_uri, category, null);
    }

    public ImageModel(String image_uri, ProductModel product){
        this(image_uri, null, product);
    }
}
