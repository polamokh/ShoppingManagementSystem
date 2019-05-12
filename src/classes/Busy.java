package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Busy implements Status
{
	private String ConnectionURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String ConnectionUserName = "hr";
	private String ConnectionPassword = "hr";
	
	
	public Busy()
	{
		
	}
	public String ToString()
	{
		return "Busy";
	}
	
	public void updateStatus(String _boyName)
	{
		new Controls().updateStatus(_boyName, "B");
	}
}
