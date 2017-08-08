package DataBase;

import java.sql.DriverManager;
import org.openqa.selenium.WebDriver;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import Utility.PageBase;

public class DataBaseAccess extends PageBase{

	public DataBaseAccess(WebDriver driver) {
		super(driver);
	}
	//sql delete user
	public static void deleteUser()
	{
		readconfig();
		System.out.println("**CONNECTING TO SQL SERVER DATABASE");
		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  

			// Create and execute SQL statement 
			ps = con.prepareStatement("DELETE FROM UserClient WHERE UserID IN(SELECT UserID FROM [TLG_CMP_B5].[dbo].[User] WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tUserClient");
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
			ps = con.prepareStatement("DELETE FROM [TLG_CMP_B5].[dbo].[User] WHERE RowInsertBy="+testconfig.getProperty("db_user_id"));
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tUser");
			e.printStackTrace();  
		}  	
		finally {  
			if (rs != null) try { rs.close(); } catch(Exception e) {}  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
			if (con != null) try { con.close(); } catch(Exception e) {} 
			if (ps != null) try {ps.close(); } catch(Exception e) {}
		}
	}
	//sql delete role
	public static void deleteRole()
	{
		readconfig();
		System.out.println("**CONNECTING TO SQL SERVER DATABASE");
		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  
			// Create and execute an SQL statement 
			String SQLquery = "DELETE FROM dbo.rolepermissiongroup WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM dbo.ClientRole WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
			System.out.println("Record is deleted!");
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
			String SQLquery = "DELETE FROM dbo.role WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
	//sql delete permission groups
	public static void deletePermissionGroup()
	{
		readconfig();
		System.out.println("**CONNECTING TO SQL SERVER DATABASE");
		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  
			// Create and execute an SQL statement 
			String SQLquery = "DELETE FROM dbo.permissiongrouppermission WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery); 
			System.out.println("Record is deleted!");	
		} 
		// Handle sql server exception
		catch (SQLServerException e) {  
			System.out.println("********** record deleted");  
		}
		catch (Exception e) {  
			e.printStackTrace();  
		}
		finally {  
			if (rs != null) 
				try { rs.close(); } catch(Exception e) {}  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
			if (con != null) try { con.close(); } catch(Exception e) {}  
		} 
		// Handle any errors that may have occurred.  
		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  
			// Create and execute an SQL statement 
			String SQLquery = "DELETE FROM dbo.RolePermissionGroup WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM dbo.permissiongroup WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
	//sql delete permission actions
	public static void deletePermissionAction()
	{
		readconfig();
		System.out.println("**CONNECTING TO SQL SERVER DATABASE");
		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  
			// Create and execute an SQL statement 
			String SQLquery = "DELETE FROM dbo.permissionAction WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
	//sql delete permissions
	public static void deletePermission()
	{
		readconfig();
		System.out.println("**CONNECTING TO SQL SERVER DATABASE");
		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  
			// Create and execute an SQL statement 
			String SQLquery = "DELETE FROM dbo.permission WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
	//sql delete permission categories
	public static void deletePermissionCategory()
	{
		readconfig();
		System.out.println("**CONNECTING TO SQL SERVER DATABASE");
		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  
			// Create and execute an SQL statement 
			String SQLquery = "DELETE FROM dbo.permissionCategory WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
	//main method
	public static void main(String[] args) 
	{
		DataBaseAccess.deleteUser();
		DataBaseAccess.deleteRole();
		DataBaseAccess.deletePermissionGroup();
		DataBaseAccess.deletePermissionAction();
		DataBaseAccess.deletePermission();
		DataBaseAccess.deletePermissionCategory();
	}
}