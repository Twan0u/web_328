package com.spring.henallux.buyMyBag.dataAccess.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="product")
public class ProductEntity {
    @Id
    @Column
    private String name;
    @Column
    private double price;
    @ManyToOne
    @JoinColumn(name="category_name", referencedColumnName="name")
    private CategoryEntity category;
    @OneToMany(mappedBy = "product")
    private Set<TranslationEntity>translations;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public Set<TranslationEntity> getTranslations() {
        return translations;
    }

    public void setTranslations(Set<TranslationEntity> translations) {
        this.translations = translations;
    }
}
