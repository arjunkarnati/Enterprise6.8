package DataBase;

import Utility.PageBase;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import org.openqa.selenium.WebDriver;

import java.sql.DriverManager;

public class DataBaseSettings extends PageBase {

	public DataBaseSettings(WebDriver driver) {
		super(driver);
	}
	//sql delete workflow state
	public static void deleteWorkflowState()  
	{
		readconfig(); 
		System.out.println("**CONNECTING TO SQL SERVER DATABASE");
		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  

			// Create and execute an SQL statement 
			String SQLquery = "DELETE FROM dbo.Workflowrole WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM dbo.Workflow WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
	//sql delete workflow manager
	public static void deleteWorkflowManager()  
	{
		readconfig(); 
		System.out.println("**CONNECTING TO SQL SERVER DATABASE");
		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  

			// Create and execute an SQL statement 
			String SQLquery = "DELETE FROM dbo.workflowmanagerworkflowaction WHERE RowInsertBy="+testconfig.getProperty("db_user_id");;
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
			String SQLquery = "DELETE FROM dbo.workflowmanagerworkflow WHERE RowInsertBy="+testconfig.getProperty("db_user_id");;
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
			String SQLquery = "DELETE FROM dbo.workflowmanagerprogram WHERE RowInsertBy="+testconfig.getProperty("db_user_id");;
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
			String SQLquery = "DELETE FROM dbo.workflowmanagerbrand WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM dbo.workflowmanager WHERE RowInsertBy="+testconfig.getProperty("db_user_id");;
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
	// main method
	public static void main(String[] args) 
	{
		DataBaseSettings.deleteWorkflowState();
		DataBaseSettings.deleteWorkflowManager();
	}
}