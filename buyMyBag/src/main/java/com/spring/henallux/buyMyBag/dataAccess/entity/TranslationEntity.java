package com.spring.henallux.buyMyBag.dataAccess.entity;
import javax.persistence.*;

@Entity
@Table(name="translation")
public class TranslationEntity {
    @Id
    @Column
    private int id;
    @ManyToOne
    @JoinColumn(name="language", referencedColumnName = "language")
    private LanguageEntity language;
    @ManyToOne
    @JoinColumn(name="product", referencedColumnName="name")
    private ProductEntity product;
    @Column
    private String product_description_translation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public String getProductDescriptionTranslation() {
        return product_description_translation;
    }

    public void setProductDescriptionTranslation(String product_description_translation) {
        this.product_description_translation = product_description_translation;
    }
}