package com.spring.henallux.buyMyBag.dataAccess.entity;

import com.spring.henallux.buyMyBag.model.CategoryModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    @Column(name="category_name")
    private CategoryModel category;
}
