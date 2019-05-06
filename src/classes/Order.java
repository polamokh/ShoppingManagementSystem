package classes;

import java.util.ArrayList;
import java.util.List;

public class Order {
	String order;
	String ordernumber;
	private List<Product> products = new ArrayList<Product>();
	public Product product;
	void add(Product product)
	{
		products.add(product);
	}
	
	void SetOrdernumber(String ordernumber)
	{
		this.ordernumber=ordernumber;
	}
	String GetOrdernumber()
	{
		return ordernumber;
	}
	void SetOrder(String order)
	{
		this.order=order;
	}
	String GetOrder()
	{
		return order;
	}
    public boolean CheckProduct(String name)
     {
    	for(int i = 0; i < products.size(); i++)
		{
    		if(products.get(i).getName()==name&&products.get(i).getQuantity()>0)
    		{
    			return true;
    		}
		}
    	 return false;
    	
     }
    public List<Product> getProducts()
    {
    	return products;
    }

}
