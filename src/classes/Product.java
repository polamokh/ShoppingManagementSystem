package classes;

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

	@Override
	public MenuComponent getChild(int i) {
		return null;
	}

	@Override
	public List<MenuComponent> getProducts() {
		return null;
	}
//	public void removeproduct(Observer observer){
//        observers.remove(observer);		
//     }
//    public void addproduct(Observer observer){
//        observers.add(observer);		
//     }
	
	@Override
	public void remove(MenuComponent menuComponent) { }
	

	@Override
	public void add(MenuComponent menuComponent) {
		// TODO Auto-generated method stub
		
	}
	public void attach(Observer newObserver)
	{
		observers.add(newObserver);
	}
	
	public void notifyObservers()
	{
		for(int i = 0; i < observers.size(); i++)
		{
			observers.get(i).update(this);
		}
	}
	public void buyProduct()
	{
		setQuantity(this.quantity--);
	}
	public void ReturnProduct()
	{
		setQuantity(this.quantity++);
	}

}
