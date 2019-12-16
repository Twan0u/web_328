package com.spring.henallux.buyMyBag.exception;

public class ProductDAOException extends Exception {

    private String message;

    public ProductDAOException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
