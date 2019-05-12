package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Controls 
{
	private String ConnectionURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String ConnectionUserName = "hr";
	private String ConnectionPassword = "hr";
	
	public void insertProduct(MenuComponent _product, String _category)
	{
		try
		{
		  Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
		  PreparedStatement preparedStatement = null;
		  
          String strQuery="INSERT INTO PRODUCT VALUES (?, ?, ?, ?, ?)";

          preparedStatement = conn.prepareStatement(strQuery);
          preparedStatement.setObject(1, _product.getName());
          preparedStatement.setObject(2, _product.getDescription());
          preparedStatement.setObject(3, _product.getPrice());
          preparedStatement.setObject(4, _product.getQuantity());
          preparedStatement.setObject(5, _category);
	     
          preparedStatement.executeQuery();
	    }
	    catch (Exception e)
	    {
	      System.err.println("insert product D'oh! Got an exception!"); 
	      System.err.println(e.getMessage()); 
	    } 
	}
	
	public void deleteProduct(String _productName) 
	{
		try
		{
		  Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
		  PreparedStatement preparedStatement = null;
		  
          String strQuery="DELETE FROM BILLPRODUCT WHERE PRODUCTNAME = ?";
          preparedStatement = conn.prepareStatement(strQuery);
          preparedStatement.setObject(1, _productName);
          preparedStatement.executeQuery();
          
          conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
          preparedStatement = null;
          strQuery= "DELETE FROM PRODUCT WHERE PRODUCTNAME = ?";
          preparedStatement = conn.prepareStatement(strQuery);
          preparedStatement.setObject(1, _productName);
         
          preparedStatement.executeQuery();
	    }
	    catch (Exception e)
	    {
	      System.err.println("delete product D'oh! Got an exception!"); 
	      System.err.println(e.getMessage()); 
	    } 
	}
	
	public ArrayList<Product> selectProduct(String _categoryName)
	{
		ArrayList<Product> products = new ArrayList<Product>();
		try
		{
		  Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
		  PreparedStatement preparedStatement = null;
		  
          String strQuery="Select * From PRODUCT WHERE CATEGORYNAME = ?";
          preparedStatement = conn.prepareStatement(strQuery);
          preparedStatement.setObject(1, _categoryName);
          
          ResultSet res = preparedStatement.executeQuery();
          while(res.next())
          {
        	  products.add(new Product(res.getString("PRODUCTNAME"), res.getString("DESCRIPTION"),
        			  res.getInt("PRICE"), res.getInt("QUANTITY")));
          }
          conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("select prodruct(Category Name) D'oh! Got an exception!"); 
	      System.err.println(e.getMessage()); 
	    }
		
		return products;
	}
	
	public ArrayList<Product> selectAvalibleProduct(String _categoryName)
	{
		ArrayList<Product> products = new ArrayList<Product>();
		try
		{
		  Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
		  PreparedStatement preparedStatement = null;
		  
          String strQuery="Select * From PRODUCT WHERE CATEGORYNAME = ? and QUANTITY > ?";
          preparedStatement = conn.prepareStatement(strQuery);
          preparedStatement.setObject(1, _categoryName);
          preparedStatement.setObject(2, 0);
          
          ResultSet res = preparedStatement.executeQuery();
          while(res.next())
          {
        	  products.add(new Product(res.getString("PRODUCTNAME"), res.getString("DESCRIPTION"),
        			  res.getInt("PRICE"), res.getInt("QUANTITY")));
          }
          conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("select prodruct(Category Name) D'oh! Got an exception!"); 
	      System.err.println(e.getMessage()); 
	    }
		
		return products;
	}
	
	public ArrayList<Product> selectProduct()
	{
		ArrayList<Product> products = new ArrayList<Product>();
		try
		{
		  Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
		  PreparedStatement preparedStatement = null;
		  
          String strQuery="Select * From PRODUCT";
          preparedStatement = conn.prepareStatement(strQuery);
          
          ResultSet res = preparedStatement.executeQuery();
          while(res.next())
          {
        	  products.add(new Product(res.getString("PRODUCTNAME"), res.getString("DESCRIPTION"),
        			  res.getInt("PRICE"), res.getInt("QUANTITY")));
          }
          conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("select product () D'oh! Got an exception!"); 
	      System.err.println(e.getMessage()); 
	    }
		
		return products;
	}
	
	public ArrayList<Product> selectAvalibleProduct()
	{
		ArrayList<Product> products = new ArrayList<Product>();
		try
		{
		  Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
		  PreparedStatement preparedStatement = null;
		  
          String strQuery="Select * From PRODUCT WHERE QUANTITY > ?";
          preparedStatement = conn.prepareStatement(strQuery);
          preparedStatement.setObject(1, 0);
          
          ResultSet res = preparedStatement.executeQuery();
          while(res.next())
          {
        	  products.add(new Product(res.getString("PRODUCTNAME"), res.getString("DESCRIPTION"),
        			  res.getInt("PRICE"), res.getInt("QUANTITY")));
          }
          conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("select Avalibe product () D'oh! Got an exception!"); 
	      System.err.println(e.getMessage()); 
	    }
		
		return products;
	}
	
	public void updateQuantity(String _productName, int _newQuantity)
	{
		try
		{
		  Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
		  PreparedStatement preparedStatement = null;
		  
          String strQuery="update PRODUCT set QUANTITY = ? WHERE PRODUCTNAME = ?";

          preparedStatement = conn.prepareStatement(strQuery);
          preparedStatement.setObject(1, _newQuantity);
          preparedStatement.setObject(2, _productName);
         
          preparedStatement.executeQuery();
	    }
	    catch (Exception e)
	    {
	      System.err.println("D'oh! Got an exception!"); 
	      System.err.println(e.getMessage()); 
	    } 
	}

	public void insertCategory(String _gategoryName)
	{
		try
		{	
		  Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
	      Statement stmt = conn.createStatement();  
          stmt.executeUpdate("INSERT INTO PCATEGORY " + "VALUES ('" + _gategoryName + "')");    
	    }
	    catch (Exception e)
	    {
	      System.err.println("D'oh! Got an exception!"); 
	      System.err.println(e.getMessage()); 
	    } 
	}
	
	public void deleteCategory(String _gategoryName)
	{
		try
		{
			Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
			PreparedStatement preparedStatement = null;
	        String strQuery="DELETE PCATEGORY WHERE CATEGORYNAME = ?";
	        preparedStatement = conn.prepareStatement(strQuery);
	        preparedStatement.setObject(1, _gategoryName);
	        preparedStatement.executeQuery();
	        
	    }
		
	    catch (Exception e)
	    {
	      System.err.println("D'oh! Got an exception!"); 
	      System.err.println(e.getMessage()); 
	    } 
	}
	
	public ArrayList<MenuComponent> selectCategory()
	{
		ArrayList<MenuComponent> allCategory = new ArrayList<MenuComponent>();
		try
		{
		  Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
		  PreparedStatement preparedStatement = null;
		  
          String strQuery="Select CATEGORYNAME FROM PCATEGORY";

          preparedStatement = conn.prepareStatement(strQuery);
          
          ResultSet res = preparedStatement.executeQuery();
          
          while(res.next())
          {
        	  Category c = new Category(res.getString("CATEGORYNAME"));
        	  ArrayList<Product> categoryProduct = selectProduct(res.getString("CATEGORYNAME"));
        	  for(int i = 0; i < categoryProduct.size(); i++)
        		  c.add(categoryProduct.get(i));
        	  allCategory.add(c);
          }
          conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("select category() D'oh! Got an exception!"); 
	      System.err.println(e.getMessage()); 
	    }
		
		return allCategory;
	}

	public void insertCustomer(Customer _customer)
	{
		try
		{
			Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
			PreparedStatement preparedStatement = null;

			String strQuery="INSERT INTO USERES VALUES (?, ?, ?, ?, ?)";

			preparedStatement = conn.prepareStatement(strQuery);
			preparedStatement.setObject(1, _customer.GetUserName());
			preparedStatement.setObject(2, _customer.GetPassword());
			preparedStatement.setObject(3, _customer.GetName());
			preparedStatement.setObject(4, _customer.GetMobile());
			preparedStatement.setObject(5, "CUSTOMER");

			preparedStatement.executeQuery();
		}
		catch (Exception e)
		{
			System.err.println("D'oh! Got an exception!"); 
			System.err.println(e.getMessage());
		} 
	}

	public void deleteCustomer(String _customerName)
	{
		try
		{
			Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
			PreparedStatement preparedStatement = null;

			String strQuery="DELETE FROM USERES WHERE USERNAME = ? AND USERTYPE = ?";

			preparedStatement = conn.prepareStatement(strQuery);
			preparedStatement.setObject(1, _customerName);
			preparedStatement.setObject(2, "CUSTOMER");

			preparedStatement.executeQuery();
		}
		catch (Exception e)
		{
			System.err.println("D'oh! Got an exception!"); 
			System.err.println(e.getMessage());
		} 
	}

	public Customer selectCustomer(String _customerUserName)
	{
		Customer customer = new Customer();
		try 
		{  
			Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
			PreparedStatement preparedStatement = null;

			String strQuery="SELECT * FROM USERES WHERE USERTYPE = 'CUSTOMER' AND USERNAME = ?";
			preparedStatement = conn.prepareStatement(strQuery);
			preparedStatement.setObject(1, _customerUserName);

			ResultSet res = preparedStatement.executeQuery();
			while(res.next())
			{
				customer.SetUserName(res.getString("USERNAME"));
				customer.SetPassword(res.getString("USERPASSWORD"));
				customer.SetMobile(res.getString("MOBILENUMBER"));
				customer.SetName(res.getString("FULLNAME"));
			}
			conn.close();

		}
		catch (Exception e)
		{
			System.err.println("select customer()D'oh! Got an exception!"); 
			System.err.println(e.getMessage()); 
		}
		return customer;
	}

	public ArrayList<Customer> selectCustomer()
	{
		ArrayList<Customer> allCustomer = new ArrayList<Customer>();
		try 
		{  
			Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
			PreparedStatement preparedStatement = null;

			String strQuery="SELECT * FROM USERES WHERE USERTYPE = 'CUSTOMER'";
			preparedStatement = conn.prepareStatement(strQuery);

			ResultSet res = preparedStatement.executeQuery();
			while(res.next())
			{
				Customer customer = new Customer();
				customer.SetUserName(res.getString("USERNAME"));
				customer.SetPassword(res.getString("USERPASSWORD"));
				customer.SetMobile(res.getString("MOBILENUMBER"));
				customer.SetName(res.getString("FULLNAME"));
				allCustomer.add(customer);
			}
			conn.close();
		}
		catch (Exception e)
		{
			System.err.println("D'oh! Got an exception!"); 
			System.err.println(e.getMessage()); 
		}

		return allCustomer;
	}

	public Manager selectManager(String _ManagerUserName)
   	{
		Manager manager = new Manager();
   		try 
		{  
			Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
			PreparedStatement preparedStatement = null;
			  
	        String strQuery="SELECT * FROM USERES WHERE USERTYPE = 'MANAGER' AND USERNAME = ?";
             preparedStatement = conn.prepareStatement(strQuery);
             preparedStatement.setObject(1, _ManagerUserName);
             
             ResultSet res = preparedStatement.executeQuery();
             while(res.next())
             {
            	 manager.SetUserName(res.getString("USERNAME"));
            	 manager.SetPassword(res.getString("USERPASSWORD"));
            	 manager.SetMobile(res.getString("MOBILENUMBER"));
            	 manager.SetName(res.getString("FULLNAME"));
             }
             
    	    }
    	    catch (Exception e)
    	    {
    	      System.err.println("Select Manager()'oh! Got an exception!"); 
    	      System.err.println(e.getMessage()); 
    	    }
   		return manager;
   	}
   	
   	public ArrayList<Manager> selectManager()
   	{
   		ArrayList<Manager> allManager = new ArrayList<Manager>();
   		try 
		{  
			Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
			PreparedStatement preparedStatement = null;
			  
	        String strQuery="SELECT * FROM USERES WHERE USERTYPE = ?";
             preparedStatement = conn.prepareStatement(strQuery);
             preparedStatement.setObject(1, "MANAGER");
             ResultSet res = preparedStatement.executeQuery();
             while(res.next())
             {
            	 Manager manager = new Manager();
            	 
            	 manager.SetUserName(res.getString("USERNAME"));
            	 manager.SetPassword(res.getString("USERPASSWORD"));
            	 manager.SetMobile(res.getString("MOBILENUMBER"));
            	 manager.SetName(res.getString("FULLNAME"));
            	 
            	allManager.add(manager);
             }
             
    	    }
    	    catch (Exception e)
    	    {
    	      System.err.println("D'oh! Got an exception!"); 
    	      System.err.println(e.getMessage()); 
    	    }
   		
   		return allManager;
   	}
   	
   	
    
   	public void insertManager(Manager _manager)
   	{
   		try
		{
		  Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
		  PreparedStatement preparedStatement = null;
		  
          String strQuery="INSERT INTO USERES VALUES (?, ?, ?, ?, ?)";

          preparedStatement = conn.prepareStatement(strQuery);
          preparedStatement.setObject(1,  _manager.GetUserName());
          preparedStatement.setObject(2,  _manager.GetPassword());
          preparedStatement.setObject(3,  _manager.GetName());
          preparedStatement.setObject(4,  _manager.GetMobile());
          preparedStatement.setObject(5, "MANAGER");
          
          preparedStatement.executeQuery();
	    }
	    catch (Exception e)
	    {
	      System.err.println("D'oh! Got an exception!"); 
	      System.err.println(e.getMessage()); 
	    } 
	}
   	
   	public Order selectBillOrder(int billId)
    {
    	Order order = new Order();
    	try 
		{  
			Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
			PreparedStatement preparedStatement = null;
			  
	        String strQuery="SELECT P.ProductName, P.Description, P.Price, P.Quantity, B.BILLID, B.PRODUCTNAME  FROM BILLPRODUCT B, PRODUCT P WHERE B.BILLID = ? AND P.ProductName = B.PRODUCTNAME";
             preparedStatement = conn.prepareStatement(strQuery);
             preparedStatement.setObject(1, billId);
             ResultSet res = preparedStatement.executeQuery();
             while(res.next())
             {
            	
            	Product p = new Product(res.getString("PRODUCTNAME"), res.getString("DESCRIPTION"),
          			  res.getInt("PRICE"), res.getInt("QUANTITY"));
 
            	order.add(p);
            	
             }
             conn.close();
    	  }
    	    catch (Exception e)
    	    {
    	      System.err.println("select bill order D'oh! Got an exception!"); 
    	      System.err.println(e.getMessage()); 
    	    } 
    	return order;
    }
   	
   	public void insertDelivaryBoy(DeliveryBoy _boy)
	{
		try
		{
		  Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
		  PreparedStatement preparedStatement = null;
		  
          String strQuery="INSERT INTO DELIVERYBOY VALUES (?, ?, ?, ?, ?)";

          preparedStatement = conn.prepareStatement(strQuery);
          preparedStatement.setObject(1, _boy.getName());
          preparedStatement.setObject(2, _boy.getMobile());
          preparedStatement.setObject(3, _boy.getAddress());
          preparedStatement.setObject(4, _boy.getAge());
          preparedStatement.setObject(5, "A");
          
          preparedStatement.executeQuery();
	    }
	    catch (Exception e)
	    {
	      System.err.println("D'oh! Got an exception!"); 
	      System.err.println(e.getMessage()); 
	    } 
	}
	
	
	public void deleteDelivaryBoy(String _boyName)
	{
		try
		{
		  Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
		  PreparedStatement preparedStatement = null;
		  
          String strQuery="DELETE DELIVERYBOY WHERE BOYNAME = ?";
          preparedStatement = conn.prepareStatement(strQuery);
          preparedStatement.setObject(1, _boyName);
          preparedStatement.executeQuery();
          
	    }
	    catch (Exception e)
	    {
	      System.err.println("D'oh! Got an exception!"); 
	      System.err.println(e.getMessage()); 
	    } 
	}
	
	
	public ArrayList<DeliveryBoy> selectDelivaryBoy()
	{
		ArrayList<DeliveryBoy> Boys = new ArrayList<DeliveryBoy>();
		
		try
		{
		  Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
		  PreparedStatement preparedStatement = null;
		  
          String strQuery="Select * From DELIVERYBOY";
          preparedStatement = conn.prepareStatement(strQuery);
          ResultSet res = preparedStatement.executeQuery();
          while(res.next())
          {
        	  Boys.add(new DeliveryBoy(res.getString("BoyName"),res.getString("MOBILENUMBER"), res.getString("ADDRESS"),
        			   res.getInt("AGE"), res.getString("STATUS"), selectBoyOrder(res.getString("BoyName"))));
          }
          conn.close();
	    }
		
	    catch (Exception e)
	    {
	      System.err.println("select delivayboyD'oh! Got an exception!"); 
	      System.err.println(e.getMessage()); 
	    }
		
		return Boys;
		
	}
	
	
	public DeliveryBoy selectDelivaryBoy(String _boyName)
	{
		DeliveryBoy boy = new DeliveryBoy();
		
		try
		{
		  Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
		  PreparedStatement preparedStatement = null;
		  
          String strQuery="Select * From DELIVERYBOY WHERE BOYNAME = ?";
          preparedStatement = conn.prepareStatement(strQuery);
          preparedStatement.setObject(1, _boyName);
          ResultSet res = preparedStatement.executeQuery();
          while(res.next())
          {
        	  boy = new DeliveryBoy(res.getString("BOYNAME"),res.getString("MOBILENUMBER"), res.getString("ADDRESS"),
        			   res.getInt("AGE"), res.getString("STATUS"), selectBoyOrder(res.getString("BoyName")));
          }
          conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("select boy(boyName) D'oh! Got an exception!"); 
	      System.err.println(e.getMessage()); 
	    }
		
		return boy;
		
	}
	
	public void insertBoyOrder(Bill _bill)
	{
		try
		{
		  Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
		  PreparedStatement preparedStatement = null;
		  
          String strQuery="INSERT INTO BOYORDER VALUES (?, ?, ?)";

          preparedStatement = conn.prepareStatement(strQuery);
          preparedStatement.setObject(1, _bill.getBillId());
          preparedStatement.setObject(2, _bill.getDelivaryBoy().getName());
          preparedStatement.setObject(3, "W");
          
          preparedStatement.executeQuery();
          
          conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Insert Boy Order D'oh! Got an exception!"); 
	      System.err.println(e.getMessage()); 
	    } 
	}

	public ArrayList<Order> selectBoyOrder(String _boyName)
	{
		ArrayList<Order> boyOrder = new ArrayList<Order>();
		
		
		try
		{
		  Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
		  PreparedStatement preparedStatement = null;
		  
          String strQuery="Select * From BOYORDER WHERE STATUS = ? and BOYNAME = ?";
          preparedStatement = conn.prepareStatement(strQuery);
          preparedStatement.setObject(1, "W");
          preparedStatement.setObject(2, _boyName);
          ResultSet res = preparedStatement.executeQuery();
          while(res.next())
          {
        	  Order o = selectBillOrder(res.getInt("BILLID"));
        	  boyOrder.add(o);
          }
          conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("select boy order  D'oh! Got an exception!"); 
	      System.err.println(e.getMessage()); 
	    }
		
		return boyOrder;
	}
	
	public void updateStatus(String _boyName, String _Sataus)
	{
		try
		{
		  Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
		  PreparedStatement preparedStatement = null;
		  
          String strQuery="update DELIVERYBOY set STATUS = ? WHERE BOYNAME = ?";

          preparedStatement = conn.prepareStatement(strQuery);
          preparedStatement.setObject(1, _Sataus);
          preparedStatement.setObject(2, _boyName);
          preparedStatement.executeQuery();
	    }
	    catch (Exception e)
	    {
	      System.err.println("D'oh! Got an exception!"); 
	      System.err.println(e.getMessage()); 
	    } 
	}
	
	public void insertBill(Bill _bill)
	{
		try
		{
			Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
			PreparedStatement preparedStatement = null;

			String strQuery="INSERT INTO BILL VALUES(?, ?, ?, ?, ?)";

			preparedStatement = conn.prepareStatement(strQuery);
			preparedStatement.setObject(1, _bill.getBillId());
			preparedStatement.setObject(2, _bill.getDate());
			preparedStatement.setObject(3, _bill.getCustomer().GetUserName());
			preparedStatement.setObject(4, _bill.getDelivaryBoy().getName());
			preparedStatement.setObject(5, _bill.getTotalPrice());

			preparedStatement.executeQuery();

			for(int i = 0; i < _bill.getOrder().getProducts().size(); i++)
			{
				try {

					preparedStatement = null;

					strQuery="INSERT INTO BILLPRODUCT VALUES(?, ?)";
					preparedStatement = conn.prepareStatement(strQuery);
					preparedStatement.setObject(1, _bill.getBillId());
					preparedStatement.setObject(2, _bill.getOrder().getProducts().get(i).getName());
					preparedStatement.executeQuery();
				}
				catch (Exception e)
				{
					System.err.println("D'oh! Got an exception!"); 
					System.err.println(e.getMessage()); 
				}  
			}
			conn.close();
		}
		catch (Exception e)
		{
			System.err.println("D'oh! Got an exception!"); 
			System.err.println(e.getMessage()); 
		} 
	}
	public void deleteBill(int _billId)
	{
		try
		{
		  Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
		  PreparedStatement preparedStatement = null;
          String strQuery="DELETE FROM BILLPRODUCT WHERE BILLID = ?";
          preparedStatement = conn.prepareStatement(strQuery);
          preparedStatement.setObject(1, _billId);
          preparedStatement.executeQuery();
          conn.close();
          
          conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
		  preparedStatement = null;
          strQuery="DELETE FROM BOYORDER WHERE BILLID = ?";
          preparedStatement = conn.prepareStatement(strQuery);
          preparedStatement.setObject(1, _billId);
          preparedStatement.executeQuery();
          conn.close();
          
          conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
		  preparedStatement = null;
          strQuery="DELETE FROM BILL WHERE BILLID = ?";
          preparedStatement = conn.prepareStatement(strQuery);
          preparedStatement.setObject(1, _billId);
          preparedStatement.executeQuery();
          conn.close();
          
    
	    }
	    catch (Exception e)
	    {
	      System.err.println("delete Bill D'oh! Got an exception!"); 
	      System.err.println(e.getMessage()); 
	    } 
	}
	public ArrayList<Bill> selectBill()
	{
		ArrayList<Bill> Bills = new ArrayList<Bill>();

		try 
		{  
			Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
			PreparedStatement preparedStatement = null;

			String strQuery="SELECT * FROM BILL";

			preparedStatement = conn.prepareStatement(strQuery);
			ResultSet res = preparedStatement.executeQuery();
			while(res.next())
			{
				Bill b = new Bill();
				b.setBillId(res.getInt("BILLID"));
				b.setDate(res.getString("BILLDATE"));
				b.setTotalPrice(res.getDouble("TOTALPRICE"));
				b.setCustomer(selectCustomer(res.getString("CUSTOMER")));
				b.setDelivaryBoy(selectDelivaryBoy(res.getString("DELIVERYBOY")));
				b.setOrder(selectBillOrder(b.getBillId()));
				Bills.add(b);

			}
			conn.close();
		}
		catch (Exception e)
		{
			System.err.println("select bill() D'oh! Got an exception!"); 
			System.err.println(e.getMessage()); 
		} 
		return Bills;
	}

	public Bill selectBill(int billId)
	{
		Bill b = new Bill();

		try 
		{  
			Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
			PreparedStatement preparedStatement = null;

			String strQuery="SELECT * FROM BILL WHERE BILLID = ?";

			preparedStatement = conn.prepareStatement(strQuery);
			preparedStatement.setObject(1, billId);
			ResultSet res = preparedStatement.executeQuery();
			while(res.next())
			{

				b.setBillId(res.getInt("BILLID"));
				b.setDate(res.getString("BILLDATE"));
				b.setTotalPrice(res.getDouble("TOTALPRICE"));
				b.setCustomer(selectCustomer(res.getString("CUSTOMER")));
				b.setDelivaryBoy(selectDelivaryBoy(res.getString("DELIVERYBOY")));
				b.setOrder(selectBillOrder(b.getBillId()));

			}
			conn.close();
		}
		catch (Exception e)
		{
			System.err.println("select bill(bill id) D'oh! Got an exception!"); 
			System.err.println(e.getMessage()); 
		} 
		return b;
	}
	
	public void insertCard(Card _Card)
   	{
   		try
		{
		  Connection conn = DriverManager.getConnection(ConnectionURL, ConnectionUserName, ConnectionPassword);
		  PreparedStatement preparedStatement = null;
		  
          String strQuery="INSERT INTO CreditCard VALUES (?, ?, ?, ?)";

          preparedStatement = conn.prepareStatement(strQuery);
          preparedStatement.setObject(1,  _Card.getName_on_Card());
          preparedStatement.setObject(2,  _Card.getNumber());
          preparedStatement.setObject(3,  _Card.getCVV());
          preparedStatement.setObject(4,  _Card.getExpiration_Date());
       
          
          preparedStatement.executeQuery();
	    }
	    catch (Exception e)
	    {
	      System.err.println("D'oh! Got an exception!"); 
	      System.err.println(e.getMessage()); 
	    } 
	}
	
}


