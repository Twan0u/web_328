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
    @JoinColumn(name="category_name")
    private CategoryEntity category;
    @Column
    private String category_name_traduction;
}
