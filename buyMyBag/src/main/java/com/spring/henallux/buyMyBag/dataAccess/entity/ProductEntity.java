package com.spring.henallux.buyMyBag.dataAccess.entity;

import com.spring.henallux.buyMyBag.model.CategoryModel;

import javax.persistence.*;

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
}
