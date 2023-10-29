package Collection;

import java.util.Objects;

public class Product {
	private final Integer pid;
	private final String name;
	private final Double price;
	private final Integer stock;

	public Product(Integer pid, String name, Double price, Integer stock) {
		this.pid = pid;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public Integer getPid() {
		return pid;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getStock() {
		return stock;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Product)) return false;
		Product product = (Product) o;
		return Objects.equals(getPid(), product.getPid()) && Objects.equals(getName(), product.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getPid(), getName());
	}

	@Override
	public String toString() {
		return "Product{" +
				"pid=" + pid +
				", name='" + name + '\'' +
				", price=" + price +
				", stock=" + stock +
				'}';
	}

}
