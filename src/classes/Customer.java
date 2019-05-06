package classes;
import java.util.List;
import java.util.ArrayList;

public class Customer {
	
	private String Name;
	private String Mobile;
	private String password;
	private String username;
	
	private List<Order> orders = new ArrayList<Order>();
	WebPage onlineShopping;
	
	public Customer(String Name,String Mobile,String password,String username)
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
   
   
    
    
    public ArrayList<MenuComponent> getCategory()
	{
		return onlineShopping.getCategory();
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
}
