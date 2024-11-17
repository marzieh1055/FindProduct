package com.mycompany.product.exceptions;

public class ProductTypeNotFondException extends RuntimeException {
    public ProductTypeNotFondException(String message){
        super(message);
    }
}
