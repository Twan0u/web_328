package com.spring.henallux.buyMyBag.dataAccess.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="language")
public class LanguageEntity {
    @Id
    @Column
    private String language;
}
