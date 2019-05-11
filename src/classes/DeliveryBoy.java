package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//import com.sun.javafx.css.converters.StringConverter;

public class DeliveryBoy {
	private String Name;
	private String Address;
	private String Mobile;
	private int Age;
	
	private Status BoyStatus;
	private ArrayList<Order> Orders;
	
	public DeliveryBoy() {
		
	}
	
	public DeliveryBoy(String _name, String _address, String _mobile, int _age)
	{
		this.Name = _name;
		this.Address = _address;
		this.Mobile = _mobile;
		this.Age = _age;
		
		BoyStatus = new Avalible();
		Orders = new ArrayList<Order>();
	}
	
	public DeliveryBoy(String _name, String _address, String _mobile, int _age, String _Status, ArrayList<Order> _Orders)
	{
		this.Name = _name;
		this.Address = _address;
		this.Mobile = _mobile;
		this.Age = _age;
		this.Orders = _Orders;
		if(_Status.matches("A"))
			this.BoyStatus = new Avalible();
		else
			this.BoyStatus = new Busy();
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
	public int getAge() {
		return Age;
	}
	
	public void setAge(int age) {
		Age = age;
	}
	public Status getStatus()
	{
		return BoyStatus;
	}
	
	public ArrayList<Order> getOrders()
	{
		return Orders;
	}
	
	public boolean canTakeOrder()
	{
		if(BoyStatus.ToString().matches("Busy"))
			return false;
		else
			return true;
	}
	
	public void NewOrder(Bill bill)
	{
		Orders.add(bill.getOrder());
		new Controls().insertBoyOrder(bill);
		if(Orders.size() == 2){
			BoyStatus = new Busy();
			BoyStatus.updateStatus(this.Name);
		}				
	}
	
	
	
	
	
	
}
