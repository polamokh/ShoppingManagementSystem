package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Avalible implements Status
{
	private String ConnectionURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String ConnectionUserName = "hr";
	private String ConnectionPassword = "hr";
	
	
	public Avalible()
	{
		
	}
	
	public String ToString()
	{
		return "Avalible";
	}
	
	public void updateStatus(String _boyName)
	{
		new Controls().updateStatus(_boyName, "A");
	}
}
