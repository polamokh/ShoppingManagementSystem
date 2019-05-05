package classes;

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
	
	public void setOrder(Order _order)
	{
		this.order = _order;
	}
	
	public void setCustomer(Customer _customer)
	{
		this.customer = _customer;
	}
	
	public void setDelivaryBoy(DeliveryBoy _boy) 
	{
		this.delivaryBoy = _boy;
	}

	public void setDate(String _date)
	{
		this.billDate = _date;
	}
	
	public double calculateTotal()
	{
		double totalPrice = 0;
		
		for(int i = 0; i < order.getProducts().size(); i++)
		{
			totalPrice = totalPrice + order.getProducts().get(i).getPrice();
		}
		
		this.totalPrice = totalPrice;
		
		return totalPrice;
	}

	public void SaveBill()
	{
		// Write the Code To Save the Bill In DataBase;
		System.out.println("Saveing The Bill in DataBase. ");
	}
}
