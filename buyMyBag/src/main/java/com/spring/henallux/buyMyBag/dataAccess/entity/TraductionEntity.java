package com.spring.henallux.buyMyBag.dataAccess.entity;
import javax.persistence.*;

@Entity
@Table(name="traduction")
public class TraductionEntity {
    @Id
    @Column
    private int id;
    @ManyToOne
    @JoinColumn
    private LanguageEntity language;
    @ManyToOne
    @JoinColumn(name="category_name", referencedColumnName="name")
    private CategoryEntity category;
    @Column
    private String category_name_traduction;

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

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public String getCategory_name_traduction() {
        return category_name_traduction;
    }

    public void setCategory_name_traduction(String category_name_traduction) {
        this.category_name_traduction = category_name_traduction;
    }
}