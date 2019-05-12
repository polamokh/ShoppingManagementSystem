package classes;
import java.util.List;

//import com.sun.glass.ui.Application;

//import com.sun.org.apache.xpath.internal.axes.OneStepIterator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Customer {
	private String Name;
	private String Mobile;
	private String password;
	private String username;

	private ArrayList<Bill> Bills = new ArrayList<Bill>();
	WebPage onlineShopping;

	public Customer() {}

	public Customer(String username, String password) {
		this.username = username;
		this.password = password;

		onlineShopping = new WebPage();
	}

	public Customer(String Name,String Mobile,String password,String username){
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
	
	public void addBill(Bill _Bill)
	{
		Bills.add(_Bill);
	}
	
	public ArrayList<Bill> getBill(Customer cus)
	{
		return onlineShopping.getCustomerBills(cus);
	}
	
	public Boolean removeBill(Bill bill)
	{
		return onlineShopping.removeCustomerBill(bill);
	}

	public void RemoveOrder(Bill _Bill)
	{
		Bills.remove(_Bill);
	}
	
	public ArrayList<MenuComponent> getCategory()
	{
		return onlineShopping.getCategory();
	}

	public ArrayList<Product> getCategoryProducts(String _categoryName)
	{
		return onlineShopping.getCategoryAvalibleProducts(_categoryName);
	}

	public ArrayList<Product> getProducts()
	{
		return onlineShopping.getAvalibleProducts();
	}

	public Bill BuyProduct(ArrayList<String> _productsName, String _date)
	{
		Bill newBill = onlineShopping.BuyProduct(_productsName, this, _date);
		addBill(newBill);
		return newBill;
	}

	public boolean returnBill(Bill bill) throws ParseException
	{
		boolean res = onlineShopping.returnBill(bill);
		return res;
	}
	
	public void deleteMyAccount() 
	{
		onlineShopping.unRegister(this.username);
	}
}
