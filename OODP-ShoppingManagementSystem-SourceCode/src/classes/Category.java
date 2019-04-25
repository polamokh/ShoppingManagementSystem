package classes;

import java.util.ArrayList;
import java.util.List;

public class Category extends MenuComponent {
	private String name;
	private List<MenuComponent> products = new ArrayList<>();
	
	public Category(String name) {
		super();
		this.name = name;
	}
	
	public void add(MenuComponent menuComponent) {
		this.products.add(menuComponent);
	}
	
	public void remove(MenuComponent menuComponent) {
		this.products.remove(menuComponent);
	}

	@Override
	public MenuComponent getChild(int i) {
		return this.products.get(i);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public double getPrice() {
		return -1;
	}

	@Override
	public int getQuantity() {
		return -1;
	}

	@Override
	public List<MenuComponent> getProducts() {
		return this.products;
	}
	
	
}
