package classes;

import java.util.ArrayList;
import java.util.List;

public class Order {
	Product p;
	String order;
	private List<Product> products = new ArrayList<Product>();
	
	void add(Product product)
	{
		products.add(product);
	}
	
	void SetOrder(String order)
	{
		this.order=order;
	}
	
	String GetOrder()
	{
		return order;
	}
	
	
    public boolean CheckProduct()
     {
    	
    	int x=p.getQuantity();
    	
    	 if(x>0)
    	 {
    		 return true;
    	 }
    	 else return false; 
     }

    
    public List<Product> getProducts()
    {
    	return products;
    }

}
