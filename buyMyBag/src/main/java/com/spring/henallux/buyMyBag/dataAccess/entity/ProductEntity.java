package com.spring.henallux.buyMyBag.dataAccess.entity;

import com.spring.henallux.buyMyBag.model.CategoryModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="product")
public class ProductEntity {
    @Id
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private double price;
    @ManyToOne
    @JoinColumn(name="category_name", referencedColumnName="name")
    private CategoryEntity category;

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

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
