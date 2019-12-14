package com.spring.henallux.buyMyBag.model;

public class TranslationModel {
    private LanguageModel language;
    private ProductModel product;
    private String product_description_translation;

    public LanguageModel getLanguage() {
        return language;
    }

    public void setLanguage(LanguageModel language) {
        this.language = language;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public String getProductDescriptionTranslation() {
        return product_description_translation;
    }

    public void setProductDescriptionTranslation(String product_description_translation) {
        this.product_description_translation = product_description_translation;
    }
}
