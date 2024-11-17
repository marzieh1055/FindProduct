package com.mycompany.product.exceptions;

public class ProductNotFondException extends RuntimeException {
    public ProductNotFondException(String message){
        super(message);
    }
}
