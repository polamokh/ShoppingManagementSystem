package classes;

import java.util.ArrayList;

public class Accountant 
{
	private ArrayList<Bill> Bills;
	
	public Accountant()
	{
		Bills = new ArrayList<Bill>();
	}
	
	public Bill prepareBill(int _billId, Customer _customer,  Order _order,

							DeliveryBoy _boy, String _date)
	{
		Bill newBill = new Bill();
		newBill.setBillId(_billId);
		newBill.setCustomer(_customer);
		newBill.setOrder(_order);
		newBill.setDelivaryBoy(_boy);
		newBill.setDate(_date);
		newBill.calculateTotal();
		newBill.SaveBill();
		
		Bills.add(newBill);
		
		return newBill;
	}

	public int getBillId()
	{
		return Bills.size()+1;
	}

	public ArrayList<Bill> getBills()
	{
		return Bills;
	}
}
