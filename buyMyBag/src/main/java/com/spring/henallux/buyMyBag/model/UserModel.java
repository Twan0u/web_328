package com.spring.henallux.buyMyBag.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

public class UserModel implements UserDetails {
    @Size(min=2, max=32)
    @NotNull
    private String username;

    @Size(min=4, max=32)
    @NotNull
    private String password;

    @Size(min=4, max=32)
    @NotNull
    private String validationPassword;

    @NotNull
    @Email
    private String email;

    @Size(min=1, max=100)
    @NotNull
    private String streetname;

    @Size(min=1, max=10)
    @NotNull
    private String streetnumber;

    @Size(min=1, max=32)
    private String gender;

    @Size(min=4, max=32)
    @NotNull
    private String first_name;

    @Size(min=4, max=32)
    @NotNull
    private String last_name;

    @Size(min=1, max=32)
    @NotNull
    private String locality;

    @Size(min=1, max=32)
    @NotNull
    private String postal_code;

    @Size(min=5, max=25)
    @NotNull
    private String phone_number;

    private String authorities;
    private boolean non_expired;
    private boolean non_locked;
    private boolean credentials_non_expired;
    private boolean enabled;

    public UserModel(){

    }


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
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return non_expired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return non_locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentials_non_expired;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(this.authorities));
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public boolean isNon_expired() {
        return non_expired;
    }

    public void setNon_expired(boolean non_expired) {
        this.non_expired = non_expired;
    }

    public boolean isNon_locked() {
        return non_locked;
    }

    public void setNon_locked(boolean non_locked) {
        this.non_locked = non_locked;
    }

    public boolean isCredentials_non_expired() {
        return credentials_non_expired;
    }

    public void setCredentials_non_expired(boolean credentials_non_expired) {
        this.credentials_non_expired = credentials_non_expired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getValidationPassword() {
        return validationPassword;
    }

    public void setValidationPassword(String validationPassword) {
        this.validationPassword = validationPassword;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
