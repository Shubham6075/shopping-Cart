package Collection;

import java.util.ArrayList;
import java.util.List;

public class Products {
	private final List<Product> products = new ArrayList<Product>();

	public Products() {
		products.add(new Product(1, "Lux Soap", 40.00d, 10));
		products.add(new Product(2, "Fair n Lovely", 60.00d, 6));
		products.add(new Product(3, "MTR", 30.00d, 10));
		products.add(new Product(4, "Colgate Toothpaste", 50.00d, 15));
		products.add(new Product(5, "Dove Shampoo", 120.00d, 8));
		products.add(new Product(6, "Tata Tea", 80.00d, 20));
		products.add(new Product(7, "Lays Chips", 20.00d, 30));
		products.add(new Product(8, "Maggi Noodles", 25.00d, 12));
		products.add(new Product(9, "Amul Milk", 45.00d, 25));
		products.add(new Product(10, "Red Bull Energy Drink", 90.00d, 10));
	}

	public List<Product> getProducts() {
		return products;
	}

}
