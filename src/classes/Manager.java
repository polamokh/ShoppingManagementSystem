package classes;

import java.util.ArrayList;

public class Manager
{
	private WebPage onlineShopping;
	 
	
	public Manager(WebPage _OnlineShopping)
	{
		this.onlineShopping = _OnlineShopping;
	}
    
	public void addProduct(Product _product) 
	{
		onlineShopping.addProduct(_product);
	}
	
	public void addCategory(MenuComponent _category)
	{
		onlineShopping.addCategory(_category);
	}

	public void RemoveProduct(Product _product)
	{
		onlineShopping.RemoveProduct(_product);
	}
	
	public void RemoveCategory(MenuComponent _category)
	{
		onlineShopping.RemoveCategory(_category);
	}
	
	public ArrayList<Order> getOrders()
	{
		return onlineShopping.getOrders();
	}

	public ArrayList<Bill> getBills()
	{
		return onlineShopping.getBills();
	}

	public void addDelivayBoy(DeliveryBoy _boy)
	{
		onlineShopping.addDelivayBoy(_boy);

	}

	public ArrayList<DeliveryBoy> getDelivaryBoys() 
	{
		return onlineShopping.getDelivaryBoys();
	}
	
	public void RemoveDelivaryBoy(DeliveryBoy _boy)
	{
		onlineShopping.RemoveDelivaryBoy(_boy);
	}
}
