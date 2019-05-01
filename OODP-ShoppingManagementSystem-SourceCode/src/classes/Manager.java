package classes;

import java.util.ArrayList;

public class Manager
{
	private ArrayList<DeliveryBoy> list=new ArrayList <DeliveryBoy>();
	 
	
	public  ArrayList<DeliveryBoy> getEmployee() 
	{
		return list;
	}

	public void setEmployee(DeliveryBoy boy)
	{
		
		list.add(boy);
	}
     public void Remove(DeliveryBoy boy) 
     {
    	list.remove(boy);
     }
     
}
