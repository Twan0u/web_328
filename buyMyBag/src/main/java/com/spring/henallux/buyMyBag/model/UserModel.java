package com.spring.henallux.buyMyBag.model;

public class UserModel {
    private String login;
    private String password;
    private String email;
    private String streetname;
    private String streetnumber;
    private String gender;
    private String first_name;
    private String last_name;
    private String locality;
    private String postal_code;
    private String username;
    private String authorities;
    private boolean non_expired;
    private boolean non_locked;
    private boolean credentials_non_expired;
    private boolean enabled;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
}
