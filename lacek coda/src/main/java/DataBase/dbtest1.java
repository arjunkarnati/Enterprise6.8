package DataBase;

import java.sql.DriverManager;
import org.openqa.selenium.WebDriver;

import Utility.PageBase;


public class dbtest1 extends PageBase {

	public dbtest1(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//validate that campaign is created
	public static void dbValidateCampaign()
	{
		readconfig();
		System.out.println("**connecting to database...");
		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  
			// Create and execute an SQL statement 
			String SQLquery = "select top 1 name from campaign";
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
			
			// Move cursor from default position to first row of result set.
			rs.next();

			// Fetch value of "email_address" from "result" object.
			String campname = rs.getString("name");
			System.out.println(campname);

									
		}  
		// Handle any errors that may have occurred.  
		catch (Exception e) {  
			e.printStackTrace();  
		}
		finally {  
			if (rs != null) 
				try { rs.close(); } catch(Exception e) {}  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
			if (con != null) try { con.close(); } catch(Exception e) {}  
		} 
		
	}

	public static void main(String[] args) {
		dbtest1.dbValidateCampaign();
	}
}
