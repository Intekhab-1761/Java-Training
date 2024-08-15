package collection;

import java.util.ArrayList;

public class WorkshopApp {
	
	public static void main(String[] args) {
		ArrayList<Product> products = new ArrayList<>();
		
		products.add(new Product("Fidget spinner",3.99, "It's fun!"));
		products.add(new Product("Ear bud",13.99, "Sounds better!"));
		products.add(new Product("Fidget spinner",3.99, "It's fun!"));
 
		products.add(1, new Product("36 AAA Batteries", 10.99, "High performance alkaline batteries."));
		
		products.set(3, new Product("Rubber Duck", 5.99, "You can't have both without this"));
		System.out.println(products);
		
		for(Product product: products) {
			System.out.println(product);

		}
		
		System.out.println("The third element in the list is:");
		System.out.println(products.get(2));
		
		System.out.println(products.size() +" "+"products are their in the list.");
	}

}
