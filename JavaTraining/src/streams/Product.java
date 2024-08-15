package streams;

public class Product {
	
	private String name;
	private String brand;
	private  double price;
	private double rating;
	
	public Product(String name, String brand, double price, double rating) {
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", brand=" + brand + ", price=" + price + ", rating=" + rating + "]";
	}
	
	
	
	

}
