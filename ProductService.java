package com.day02.macbook;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
	
	List<Product> products = new ArrayList<>();

	public void addProduct(Product p) {
		products.add(p);
	}
	
	public List<Product> getAllProducts(){
		return products;
	}
	
	public List<Product> getProductWithText(String text) {
        String str = text.toLowerCase();
        List<Product> prods = new ArrayList<>();

        for(Product p : products){
            String name = p.getName().toLowerCase();
            String type = p.getType().toLowerCase();
            String place = p.getPlace().toLowerCase();
            if(name.contains(str) || type.contains(str) || place.contains(str))
                prods.add(p);
        }
        return prods;

    }
	
	
	
	
	//Return Products searched by place 
	public List<Product> getProductWithPlace(String text) {
        String str = text.toLowerCase();
        List<Product> prods = new ArrayList<>();

        for(Product p : products){
            String place = p.getPlace().toLowerCase();
            if( place.contains(str))
                prods.add(p);
        }
        return prods;

    }	
	
	
	//Returns List of all Products with expired Warranty 
	public List<Product> getProductWithExpiredWarranty(List<Product> products) {
         
        List<Product> prods = new ArrayList<>();

        for(Product p1 : products){
        	int warranty = p1.getWarranty();
            if(warranty  < Year.now().getValue())
                prods.add(p1);
        }
        return prods;

    }
	
}
   