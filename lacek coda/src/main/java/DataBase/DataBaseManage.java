package DataBase;

import java.sql.DriverManager;
import org.openqa.selenium.WebDriver;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import Utility.PageBase;

public class DataBaseManage extends PageBase {

	public DataBaseManage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//sql delete client
	public static void deleteClient()
	{
		readconfig();
		System.out.println("**CONNECTING TO SQL SERVER DATABASE");
		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  

			// Create and execute SQL statement 
			ps = con.prepareStatement("DELETE FROM ClientLocale WHERE ClientID IN(SELECT CLIENTID FROM CLIENT WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tClientLocale");
			e.printStackTrace();  
		}  	
		finally {  
			if (rs != null) try { rs.close(); } catch(Exception e) {}  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
			if (con != null) try { con.close(); } catch(Exception e) {} 
			if (ps != null) try {ps.close(); } catch(Exception e) {}
		}
		
		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  

			// Create and execute SQL statement 
			ps = con.prepareStatement("DELETE FROM Client WHERE RowInsertBy="+testconfig.getProperty("db_user_id"));
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tClient");
			e.printStackTrace();  
		}  	
		finally {  
			if (rs != null) try { rs.close(); } catch(Exception e) {}  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
			if (con != null) try { con.close(); } catch(Exception e) {} 
			if (ps != null) try {ps.close(); } catch(Exception e) {}
		}	
	}
	//sql delete brand
	public static void deleteBrand()
	{
		readconfig();
		System.out.println("**CONNECTING TO SQL SERVER DATABASE");
		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  

			// Create and execute an SQL statement 
			String SQLquery = "DELETE FROM dbo.brand WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			System.out.println("********** record deleted");  
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
	//sql delete program
	public static void deleteProgram()
	{
		readconfig();
		System.out.println("**CONNECTING TO SQL SERVER DATABASE");
		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  

			// Create and execute an SQL statement 
			String SQLquery = "DELETE FROM dbo.programbrand WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			System.out.println("********** record deleted");  
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
		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  

			// Create and execute an SQL statement 
			String SQLquery = "DELETE FROM dbo.program WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			System.out.println("********** record deleted");  
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
		{
			DataBaseManage.deleteClient();
			DataBaseManage.deleteBrand();
			DataBaseManage.deleteProgram();
		}
	}
}