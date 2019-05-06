package classes;

import java.util.ArrayList;

public class DeliveryBoy {
	private String Name;
	private String Address;
	private String Mobile;
	private String Age;
	
	private Status BoyStatus;
	private ArrayList<Order> Orders;
	
	public DeliveryBoy() {}
	public DeliveryBoy(String _name, String _address, String _mobile, String _age)
	{
		this.Name = _name;
		this.Address = _address;
		this.Mobile = _mobile;
		this.Age = _age;
		
		BoyStatus = new Avalible();
		Orders = new ArrayList<Order>();
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	
	
	// Status Pattern
	
	public boolean NewOrder(Order newOrder)
	{
		if(BoyStatus == new Busy())
			return false;
		else
		{
			Orders.add(newOrder);
			if(Orders.size() == 2)
				BoyStatus = new Busy();
			return true;
		}
	}
	
	public Status getStatus()
	{
		return BoyStatus;
	}

	
}
