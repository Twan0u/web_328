package com.spring.henallux.buyMyBag.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserEntity {
    @Column
    @Id
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String streetname;
    @Column
    private String streetnumber;
    @Column
    private String gender;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @Column
    private String locality;
    @Column
    private String phone_number;
    @Column
    private String postal_code;
    @Column
    private String authorities;
    @Column
    private boolean non_expired;
    @Column
    private boolean non_locked;
    @Column
    private boolean credentials_non_expired;
    @Column
    private boolean enabled;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getStreetnumber() {
        return streetnumber;
    }

    public void setStreetnumber(String streetnumber) {
        this.streetnumber = streetnumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public boolean isNon_expired() {
        return non_expired;
    }

    public void setNon_expired(int non_expired) {
        this.non_expired = non_expired == 1;
    }

    public boolean isNon_locked() {
        return non_locked;
    }

    public void setNon_locked(int non_locked) {
        this.non_locked = non_locked == 1;
    }

    public boolean isCredentials_non_expired() {
        return credentials_non_expired;
    }

    public void setCredentials_non_expired(int credentials_non_expired) {
        this.credentials_non_expired = credentials_non_expired == 1;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled == 1;
    }
}