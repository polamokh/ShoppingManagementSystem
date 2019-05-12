package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Bill 
{
	private int BillId;
	private Order order;
	private Customer customer;
	private DeliveryBoy delivaryBoy;
	private String billDate;
	private double totalPrice;

	public void setBillId(int _billId)
	{
		this.BillId = _billId;
	}

	public int getBillId()
	{
		return this.BillId;
	}

	public void setOrder(Order _order)
	{
		this.order = _order;
	}

	public Order getOrder()
	{
		return this.order;
	}

	public void setCustomer(Customer _customer)
	{
		this.customer = _customer;
	}

	public Customer getCustomer()
	{
		return this.customer;
	}

	public void setDelivaryBoy(DeliveryBoy _boy) 
	{
		this.delivaryBoy = _boy;
	}

	public DeliveryBoy getDelivaryBoy()
	{
		return this.delivaryBoy;
	}

	public void setDate(String _date)
	{
		this.billDate = _date;
	}

	public String getDate() 
	{
		return this.billDate;
	}

	public void setTotalPrice(double _totalPrice)
	{
		this.totalPrice = _totalPrice;
	}

	public double getTotalPrice() 
	{
		return this.totalPrice;
	}

	public double calculateTotal(Order order)
	{
		double totalPrice = 0;
		for(int i = 0; i < order.getProducts().size(); i++){
			totalPrice = totalPrice + order.getProducts().get(i).getPrice();
		}
		this.totalPrice = totalPrice;
		return totalPrice;
	}

}
