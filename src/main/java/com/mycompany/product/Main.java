package com.mycompany.product;

import com.mycompany.product.exceptions.ProductNotFondException;
import com.mycompany.product.model.Product;
import com.mycompany.product.model.ProductType;
import com.mycompany.product.services.ProductService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Product product = ProductService.findByName("Samsun");
            System.out.println(product);
        } catch (ProductNotFondException e) {
            System.out.println("Product not Found");
        }
        System.out.println("--------------------------------");
        try {
            List<Product> product = ProductService.findByType(ProductType.clothing);
            System.out.println(product);
        } catch (ProductNotFondException e) {
            System.out.println("--------------------------------");
        }
        System.out.println("--------------------------------");

        try {
            List<Product> product = ProductService.findByNameAndType( "Iphone" , ProductType.Digital);
            System.out.println(product);
        } catch (ProductNotFondException e) {
            System.out.println("--------------------------------");
        }
    }
}