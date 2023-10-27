package Collection;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private final List<Product> cartItems = new ArrayList<>();

	public void addProductToCartByPID(int pid) {
		Product product = getProductByProductID(pid);
		if (product != null) {
			cartItems.add(product);
		}
	}

	public void removeProductByPID(int pid) {
		Product productToRemove = getProductByProductID(pid);
		if (productToRemove != null) {
			cartItems.remove(productToRemove);
		}
	}

	public void printCartItems() {
		for (Product prod : cartItems) {
			System.out.println(prod.getName());
		}
	}

	public List<Product> getCartItems() {
		return cartItems;
	}

	private Product getProductByProductID(int pid) {
		for (Product prod : new Products().getProducts()) {
			if (prod.getPid() == pid) {
				return prod;
			}
		}
		return null; // Product not found
	}
}
