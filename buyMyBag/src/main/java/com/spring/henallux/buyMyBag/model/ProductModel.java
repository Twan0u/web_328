package com.spring.henallux.buyMyBag.model;

import com.spring.henallux.buyMyBag.constants.Constants;

import java.util.ArrayList;
import java.util.List;

public class ProductModel {
    private String name;
    private List<TranslationModel>translations;
    private double price;
    private CategoryModel category;
    private List<String> images = new ArrayList<>();

    public ProductModel(){ }

    public ProductModel(String name, List<TranslationModel>translations, double price, CategoryModel category) {
        setName(name);
        setTranslations(translations);
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

    public List<TranslationModel> getTranslations() {
        return translations;
    }

    public String getDescription(String language){
        for(TranslationModel translation : translations){
            if(translation.getLanguage().getLanguage().equals(language))
                return translation.getProductDescriptionTranslation();
        }
        return "";
    }

    public void setTranslations(List<TranslationModel> translations) {
        this.translations = translations;
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
