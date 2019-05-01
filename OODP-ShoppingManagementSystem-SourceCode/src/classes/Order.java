package classes;

public class Order {
	Product p;
    public boolean CheckProduct()
     {
    	int x=p.getQuantity();
    	 if(x>0)
    	 {
    		 return true;
    	 }
    	 else return false; 
     }
	

}
