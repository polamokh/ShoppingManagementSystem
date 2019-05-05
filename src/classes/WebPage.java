package classes;

import java.util.ArrayList;

public class WebPage implements Observer 
{
	private ArrayList<Product> allProducts;
	private ArrayList<MenuComponent> allCategory;
	private ArrayList<Order> allOrders;
	private ArrayList<DeliveryBoy> allBoys;
	private Accountant accountant;
	
	public WebPage()
	{
		allProducts = new ArrayList<Product>();
		allCategory = new ArrayList<MenuComponent>();
		allOrders = new ArrayList<Order>();
		allBoys = new ArrayList<DeliveryBoy>();
		accountant = new Accountant();
	}
	
	public void update(Product product)
	{
		for(int i = 0; i < allProducts.size(); i++)
		{
			if(allProducts.get(i) == product)
			{
				allProducts.set(i, product);
			}
				
		}
	}
	
	// Summary
	// Customer Function
	// Summary
	
	public ArrayList<MenuComponent> getCategory()
	{
		return allCategory;
	}

	public ArrayList<MenuComponent> getCategoryProducts(MenuComponent _category)
	{
		ArrayList<MenuComponent> categoryProducts = new ArrayList<MenuComponent>();
		
		for(int i = 0; i < allCategory.size(); i++)
		{
			if(allCategory.get(i) == _category)
			{
				categoryProducts.addAll(allCategory.get(i).getProducts());
			}
		}
		return categoryProducts;
	}

	public ArrayList<Product> getProducts()
	{
		return allProducts;
	}

	public Bill BuyProduct(ArrayList<String> _productsName, Customer _customer, String _date)
	{
		ArrayList<Product> _productBuy = new ArrayList<Product>();
		for(int i = 0; i < _productsName.size(); i ++)
		{
			for(int y = 0; y < allProducts.size(); y++)
			{
				if(_productsName.get(i) == allProducts.get(y).getName())
				{
					_productBuy.add(allProducts.get(y));
					allProducts.get(i).buyProduct();
				}
			}
		}
		
		Order newOrder = new Order();
		newOrder.SetOrder(_customer.GetName());
		for(int i = 0; i < _productBuy.size(); i++)
			newOrder.add(_productBuy.get(i));
		
		int BillId = accountant.getBillId();
		
		DeliveryBoy boy = new DeliveryBoy();
		for(int i = 0; i < allBoys.size(); i++)
		{
			if(allBoys.get(i).NewOrder(newOrder) == true)
				boy = allBoys.get(i);
		}
		
		Bill customerBill = accountant.prepareBill(BillId, _customer, newOrder, boy, _date);
		
		return customerBill;
	}

	/// Summary
	/// Manger Function
	// Summary

	public void addProduct(Product _product) 
	{
		allProducts.add(_product);
	}
	
	public void addCategory(MenuComponent _category)
	{
		allCategory.add(_category);
		for(int i = 0; i < _category.getProducts().size(); i++)
			allProducts.add((Product) _category.getChild(i));
	}

	public void RemoveProduct(Product _product)
	{
		allProducts.remove(_product);
	}
	
	public void RemoveCategory(MenuComponent _category)
	{
		allCategory.remove(_category);
		for(int i = 0; i<_category.getProducts().size(); i++)
			allProducts.remove(_category.getChild(i));
	}
	
	public ArrayList<Order> getOrders()
	{
		return allOrders;
	}

	public ArrayList<Bill> getBills()
	{
		return accountant.getBills();
	}

	public void addDelivayBoy(DeliveryBoy _boy)
	{
		allBoys.add(_boy);

	}

	public ArrayList<DeliveryBoy> getDelivaryBoys() 
	{
		return allBoys;
	}
	
	public void RemoveDelivaryBoy(DeliveryBoy _boy)
	{
		allBoys.remove(_boy);
	}

}