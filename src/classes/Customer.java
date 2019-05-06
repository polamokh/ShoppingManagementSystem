package classes;
import java.util.List;


import java.util.ArrayList;

public class Customer {
	private String Name;
	private String Mobile;
	private String password;
	private String username;
	private Product product;
	private Order order;
	
	private ArrayList<Order> orders = new ArrayList<Order>();
	WebPage onlineShopping;
	
	public Customer(String Name,String Mobile,String password,String username)
	{
		this.Name=Name;
		this.Mobile=Mobile;
		this.password=password;
		this.username=username;
	}
    public void add(Order order)
    {
	   orders.add(order);
    }
    
    public void SetName(String Name)
    {
	   this.Name=Name;
    }
    public String GetName()
    {
    	return Name;
    }
    public void SetMobile(String Mobile)
    {
	   this.Mobile=Mobile;
    }
    public String GetMobile()
    {
    	return Mobile;
    }
    public void SetPassword(String password)
    {
	   this.password=password;
    }
    public String GetPassword()
    {
    	return password;
    }
    public void SetUserName(String username)
    {
	   this.username=username;
    }
    public String GetUserName()
    {
    	return username;
    }
    
    public void MakeOrder(Order order)
    {
    		orders.add(order);
    }
    public void RemoveOrder(Order order)
    {
    	orders.remove(order);
    }
    public ArrayList<MenuComponent> getCategory()
   	{
   		return onlineShopping.getCategory();
   	}
    public ArrayList<Order> getOrder()
    {
    	return orders;
    }
   	public ArrayList<MenuComponent> getCategoryProducts(MenuComponent _category)
   	{
   		return onlineShopping.getCategoryProducts(_category);
   	}

   	public ArrayList<Product> getProducts()
   	{
   		return onlineShopping.getProducts();
   	}

   	public Bill BuyProduct(ArrayList<String> _productsName, String _date)
   	{
   		return onlineShopping.BuyProduct(_productsName, this, _date);
   	}
//    public void ProductNotification(Product product)
//	{
//	      this.product = product;
//	      this.product.addproduct(this);
//	}
     
}
