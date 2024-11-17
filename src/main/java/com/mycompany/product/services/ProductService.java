package com.mycompany.product.services;

import com.mycompany.product.exceptions.ProductNotFondException;
import com.mycompany.product.exceptions.ProductTypeNotFondException;
import com.mycompany.product.model.Product;
import com.mycompany.product.model.ProductType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
	private static List<Product> products;

	static {
		products = new ArrayList<>();
		products.add(new Product("Samsung A50", ProductType.Digital, 5.5, false));
		products.add(new Product("Iphone12", ProductType.Digital, 6.5, true));
		products.add(new Product("Iphone13", ProductType.Digital, 6.5, true));

		products.add(new Product("dreses", ProductType.clothing, 3, false));

	}

	public static Product findByName(String name) {
		return products.stream().filter(x -> x.Name().contains(name)).findFirst()
				.orElseThrow(() -> new ProductNotFondException("product by name " + name + " not found"));
	}

	public static List<Product> findByType(ProductType type) {
		List<Product> findType = products.stream().filter(t -> t.Type() == type).collect(Collectors.toList());
		if (findType.size() == 0) {
			throw new ProductTypeNotFondException("This category has no products");
		}
		return findType;
	}

	public static List<Product> findByNameAndType(String name, ProductType type) {
	    List<Product> out = products.stream()
	            .filter(p -> p.Name().contains(name) && p.Type() == type)
	            .collect(Collectors.toList());
	    if (out.isEmpty()) {
	        throw new ProductTypeNotFondException("Product by name " + name + " and Type " + type + " not found.");
	    }
	    return out;
	}

	
	
	
	
	public static List<Product> findAll() {
		return products;
	}
}
