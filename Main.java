package Collection;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		UI ui = new UI();

		// Display the cart items and total amount to pay
		displayCart(ui.getCart());
	}

	public static void displayCart(Cart cart) {
		List<Product> cartItems = cart.getCartItems();
		double totalAmount = calculateTotalAmount(cartItems);

		System.out.println("Cart Items:");
		for (Product product : cartItems) {
			System.out.println(product.getName() + " - $" + product.getPrice());
		}

		System.out.println("Total Amount to Pay: $" + totalAmount); // Added this line to print total amount
	}

	public static double calculateTotalAmount(List<Product> cartItems) {
		double totalAmount = 0.0;
		for (Product product : cartItems) {
			totalAmount += product.getPrice();
		}
		return totalAmount;
	}
}
