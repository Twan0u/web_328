package com.spring.henallux.buyMyBag.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="image")
public class ImageEntity {
    @Id
    @Column
    private int id;
    @Column
    private String image_uri;
    @OneToOne
    @JoinColumn(name="category_name")
    private CategoryEntity category;
    @OneToOne
    @JoinColumn(name="product_name")
    private ProductEntity product;
}
