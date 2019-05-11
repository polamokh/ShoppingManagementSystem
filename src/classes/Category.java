package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Category implements MenuComponent 
{
	private String name;
	private List<MenuComponent> products = new ArrayList<>();

	public Category() {}
	
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
	
	public void setProducts(List<MenuComponent> _products)
	{
		this.products = _products;
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
