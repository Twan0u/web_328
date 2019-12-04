package com.spring.henallux.buyMyBag.model;

public class TraductionModel {
    private LanguageModel language;
    private CategoryModel category;
    private String category_name_traduction;

    public LanguageModel getLanguage() {
        return language;
    }

    public void setLanguage(LanguageModel language) {
        this.language = language;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public String getCategory_name_traduction() {
        return category_name_traduction;
    }

    public void setCategory_name_traduction(String category_name_traduction) {
        this.category_name_traduction = category_name_traduction;
    }
}
