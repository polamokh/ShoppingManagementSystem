package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
                                                                                                                                                                                                              
public class Product implements MenuComponent {
	private String name;
	private String description;
	private double price;
	private int quantity;
	
	private List<Observer> observers=new ArrayList<Observer>();
	public Product() {
		super();
		observers = new ArrayList<Observer>();
	}

	public Product(String name, String description, double price, int quantity) {
		super();
		observers = new ArrayList<Observer>();
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

	public void updateStock(String productName, int Quantity) {
		int oldQuantity = this.getQuantity();
		setQuantity(oldQuantity + Quantity);
		new Controls().updateQuantity(productName, this.getQuantity());
	}
	
	public void attach(Observer newObserver) {
		observers.add(newObserver);
	}
	
	public void notifyObservers() {
		for(int i = 0; i < observers.size(); i++){
			observers.get(i).update(this);
		}
	}
	
	@Override
	public void remove(MenuComponent menuComponent) {
		// TODO Auto-generated method stub	
	}
	

	@Override
	public void add(MenuComponent menuComponent) {
		// TODO Auto-generated method stub	
	}
	
	@Override
	public MenuComponent getChild(int i) {
		return null;
	}

	@Override
	public List<MenuComponent> getProducts() {
		return null;
	}
	
}
