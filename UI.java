package Collection;

import java.util.List;
import java.util.Scanner;

public class UI {
	Cart cart = new Cart();

	private static final int MENU_EXIT = 0;
	private static final int MENU_DISPLAY_PRODUCTS = 1;
	private static final int MENU_DISPLAY_CART = 2;
	private static final int SUBMENU_ADD_TO_CART = 1;
	private static final int SUBMENU_REMOVE_FROM_CART = 2;
	private static final int SUBMENU_BACK_TO_MAIN = 0;

	public UI() {
		menu();
	}

	public void menu() {
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			displayMainMenu();
			choice = getUserInput(scanner);

			switch (choice) {
				case MENU_DISPLAY_PRODUCTS:
					displayStoreProducts(scanner);
					break;
				case MENU_DISPLAY_CART:
					showCart();
					break;
				case MENU_EXIT:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
					break;
			}
		} while (true);
	}

	private void displayMainMenu() {
		System.out.println("1. Display Store Products");
		System.out.println("2. Display Cart");
		System.out.println("0. Exit");
	}

	private void displayStoreProducts(Scanner scanner) {
		List<Product> products = new Products().getProducts();
		System.out.println("Available Products:");
		for (Product prod : products) {
			System.out.println(
					prod.getPid() + "- " +
							prod.getName() + " " +
							prod.getPrice() + " " +
							prod.getStock()
			);
		}

		storeProductsMenu(scanner);
	}

	private void storeProductsMenu(Scanner scanner) {
		int innerChoice;
		do {
			System.out.println("1. Add to Cart");
			System.out.println("2. Remove From Cart");
			System.out.println("0. Back to Main Menu");

			innerChoice = getUserInput(scanner);

			switch (innerChoice) {
				case SUBMENU_ADD_TO_CART:
					addProductToCart(scanner);
					showCart();
					break;
				case SUBMENU_REMOVE_FROM_CART:
					removeProductFromCart(scanner);
					break;
				case SUBMENU_BACK_TO_MAIN:
					// Back to the main menu
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
					break;
			}
		} while (innerChoice != SUBMENU_BACK_TO_MAIN);
	}

	private int getUserInput(Scanner scanner) {
		int input = -1;
		try {
			input = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please enter a valid number.");
		}
		return input;
	}

	private void addProductToCart(Scanner scanner) {
		System.out.print("Enter the product ID to add to cart: ");
		int pid = getUserInput(scanner);
		cart.addProductToCartByPID(pid);
	}

	private void showCart() {
		List<Product> cartItems = cart.getCartItems();
		double totalAmount = calculateTotalAmount(cartItems);

		if (cartItems.isEmpty()) {
			System.out.println("Your cart is empty.");
		} else {
			System.out.println("Cart Contents:");
			for (Product prod : cartItems) {
				System.out.println(prod.getName());
			}
			System.out.println("Total Amount to Pay: $" + totalAmount);
		}
	}

	private double calculateTotalAmount(List<Product> cartItems) {
		double totalAmount = 0.0;
		for (Product product : cartItems) {
			totalAmount += product.getPrice();
		}
		return totalAmount;
	}

	private void removeProductFromCart(Scanner scanner) {
		System.out.print("Enter the product ID to remove from cart: ");
		int pid = getUserInput(scanner);
		cart.removeProductByPID(pid);
	}

	public Cart getCart() {
		return cart;
	}
}
