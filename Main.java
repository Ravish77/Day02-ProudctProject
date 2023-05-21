package com.day02.macbook;

import java.time.Year;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
	
		ProductService service = new ProductService();
		
		service.addProduct(new Product("Type C", "Cable", "Black Drawer", 2024));
        service.addProduct(new Product("Mac Studio", "Computer", "White Table", 2025));
        service.addProduct(new Product("Focusrite Mixer", "Audio System", "White Table", 2025));
        service.addProduct(new Product("Asus Vivobook", "Laptop", "Brown Drawer", 2021));
        service.addProduct(new Product("Asus Rog", "Laptop", "Black Table", 2021));
        service.addProduct(new Product("Macbook pro", "Laptop", "Brown Drawer", 2022));
        service.addProduct(new Product("Wacom Pad", "Writing Pad", "Black Drawer", 2020));
        service.addProduct(new Product("Apple Keyboard", "Keyboard", "White Table", 2022));
        service.addProduct(new Product("Logitech Keyboard", "Keyboard", "Black Table", 2024));
        service.addProduct(new Product("Hdmi cable", "Cable", "Black Drawer", 2024));
        service.addProduct(new Product("Java Black Book", "Cable", "Shelf", 2024));
        service.addProduct(new Product("Logi Mouse", "Mouse", "Black Table", 2022));
        service.addProduct(new Product("Apple Mouse", "Mouse", "White Table", 2022));
        service.addProduct(new Product("Lenovo Mouse", "Mouse", "Black Drawer", 2022));
        service.addProduct(new Product("BlackBeast", "Computer", "White Table", 2020));
        
        
        //A list contains all products
        System.out.println();
        System.out.println("================================================================");
        System.out.println("ALL AVAILABLE PRODUCTS: ");
        System.out.println("================================================================");
        List<Product> products = service.getAllProducts();
        //printing all products using for each loop
        for(Product p : products) {
        	System.out.println(p);
        }
        
        
        //To get products with particular text
	System.out.println();
        System.out.println("================================================================");
        System.out.println("PRODUCTS WITH SPECIFIC PLACE: ");
        System.out.println("================================================================");
        List<Product> prods = service.getProductWithText("black");
        for(Product product : prods){
            System.out.println(product);
        }
        
        
        
        //To get products , searched by place -Assignment01
        System.out.println();
        System.out.println("================================================================");
        System.out.println("PRODUCTS WITH SPECIFIC PLACE: ");
        System.out.println("================================================================");
        for(Product p : service.getProductWithPlace("white table")) {
        	System.out.println(p);
        }
        
        
        //To get all products with less than 2023-Assignment02
        System.out.println();
        System.out.println("================================================================");
        System.out.println("PRODUCTS WITH EXPIRED WARRANTY: ");
        System.out.println("================================================================");
        List<Product> productsWithExpiredWarranty = service.getProductWithExpiredWarranty(products);
        for(Product p: productsWithExpiredWarranty) {
        	System.out.println(p);
        }
        
        
        //Work with List products using Stream API-Assignment03
        System.out.println();
        System.out.println("================================================================");
        System.out.println("PRODUCTS WITH SPECIFIC PLACE USING STREAM API: ");
        System.out.println("================================================================");
        String place = "Black Drawer".toUpperCase();
        Stream<Product> stream = products.stream();
        Stream<Product> filter = stream.filter(n-> n.getPlace().toUpperCase().contains(place));
        filter.forEach(n -> System.out.println(n));
        
        
        System.out.println();
        System.out.println("================================================================");
        System.out.println("PRODUCTS WITH EXPIRED WARRANTY USING STREAM API: ");
        System.out.println("================================================================");
        int year = Year.now().getValue();
        Stream<Product> stream1 = products.stream();
        Stream<Product> filter1 = stream1.filter(n-> n.getWarranty() < year );
        filter1.forEach(n -> System.out.println(n));
        
		
	}

}
