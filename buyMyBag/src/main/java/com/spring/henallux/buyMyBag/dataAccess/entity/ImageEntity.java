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
    @JoinColumn(name="category_name", referencedColumnName="name")
    private CategoryEntity category;
    @ManyToOne
    @JoinColumn(name="product_name", referencedColumnName="name")
    private ProductEntity product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage_uri() {
        return image_uri;
    }

    public void setImage_uri(String image_uri) {
        this.image_uri = image_uri;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
