package classes;

import java.util.List;

public class Product implements MenuComponent {
	private String name;
	private String description;
	private double price;
	private int quantity;
	
	public Product() {
		super();
	}

	public Product(String name, String description, double price, int quantity) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public MenuComponent getChild(int i) {
		return null;
	}

	@Override
	public List<MenuComponent> getProducts() {
		return null;
	}

	@Override
	public void add(MenuComponent menuComponent) { }

	@Override
	public void remove(MenuComponent menuComponent) { }
}
