package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sun.org.apache.regexp.internal.recompile;

public class Manager
{
	private String Name;
	private String Mobile;
	private String password;
	private String username;
	
	private WebPage onlineShopping;
	 
	public Manager() 
	{
		onlineShopping = new WebPage();
	}
	
	public Manager(String username, String password) {
		onlineShopping = new WebPage();
		this.username = username;
		this.password = password;
	}
	
	public Manager(String Name,String Mobile,String password,String username)
	{
		this.Name=Name;
		this.Mobile=Mobile;
		this.password=password;
		this.username=username;
		
		onlineShopping = new WebPage();
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
	public Manager(WebPage _OnlineShopping)
	{
		this.onlineShopping = _OnlineShopping;
	}
    
	public void addProduct(Product _product, String _categoryName) 
	{
		onlineShopping.addProduct(_product, _categoryName);
	}
	
	public void addCategory(MenuComponent _category)
	{
		onlineShopping.addCategory(_category);
	}

	public void RemoveProduct(String _productName)
	{
		onlineShopping.RemoveProduct(_productName);
	}
	
	public void RemoveCategory(String _categoryName)
	{
		onlineShopping.RemoveCategory(_categoryName);
	}
	
	public ArrayList<MenuComponent> getCategory()
	{
		return onlineShopping.getCategory();
	}

	public ArrayList<Product> getCategoryProducts(String _categoryName)
	{
		return onlineShopping.getCategoryProducts(_categoryName);
	}

	public ArrayList<Product> getProducts()
	{
		return onlineShopping.getProducts();
	}
	
	public ArrayList<Bill> getBills()
	{
		return onlineShopping.getBills();
	}
	public void updateStock(String _productName, int NewQuantity)
	{
		onlineShopping.updateQuantity(_productName, NewQuantity);
	}
	
	public void addDelivayBoy(DeliveryBoy _boy)
	{
		onlineShopping.addDelivayBoy(_boy);

	}

	public ArrayList<DeliveryBoy> getDelivaryBoys() 
	{
		return onlineShopping.getDelivaryBoys();
	}
	
	public void RemoveDelivaryBoy(String _boyName)
	{
		onlineShopping.RemoveDelivaryBoy(_boyName);
	}
	
	public boolean login(String _userName, String _password)
   	{
		boolean res = checkExist(_userName, _password);
		return res;
   	}
	
	public boolean checkExist(String _userName, String _password)
   	{
   		ArrayList<Manager> allManager = new Controls().selectManager();
   		for(int i = 0; i < allManager.size(); i++) 
   		{
   			if(allManager.get(i).GetUserName().matches(_userName)) {
   				if(allManager.get(i).GetPassword().matches(_password)){
   					return true;
   				}
   			}
   		}
   		return false;
   	}
}
