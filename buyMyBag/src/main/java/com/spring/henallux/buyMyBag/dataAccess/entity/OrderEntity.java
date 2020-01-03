package com.spring.henallux.buyMyBag.dataAccess.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="clientorder")
public class OrderEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean is_payed;
    @Column
    private Date creation_date;
    @ManyToOne
    @JoinColumn(name = "user_login", referencedColumnName = "username")
    private UserEntity user_login;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public UserEntity getUser_login() {
        return user_login;
    }

    public void setUser_login(UserEntity user_login) {
        this.user_login = user_login;
    }

    public boolean isIs_payed() {
        return is_payed;
    }

    public void setIs_payed(boolean is_payed) {
        this.is_payed = is_payed;
    }
}
