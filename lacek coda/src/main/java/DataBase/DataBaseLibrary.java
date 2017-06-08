package DataBase;

import java.sql.DriverManager;
import org.openqa.selenium.WebDriver;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import Utility.PageBase;

public class DataBaseLibrary extends PageBase {
	static int carinivalcount = 0;
	public DataBaseLibrary(WebDriver driver) 
	{
		super(driver);
	}
	//sql delete campaign
	public static void deleteCampaign()  
	{
		readconfig();
		System.out.println("**CONNECTING TO SQL SERVER DATABASE");
		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  

			// Create and execute an SQL statement 
			String SQLquery = "DELETE FROM campaignprogram WHERE CampaignID >= "+testconfig.getProperty("campaignID");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM CampaignBrand WHERE CampaignID >= "+testconfig.getProperty("campaignID");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
//		// Handle any errors that may have occurred.  
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
			String SQLquery = "DELETE FROM CampaignSeries WHERE CampaignID >= "+testconfig.getProperty("campaignID");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM campaign WHERE CampaignID >= "+testconfig.getProperty("campaignID");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
	//sql delete communication
	public static void deleteCommunication()  
	{
		readconfig();
		System.out.println("**CONNECTING TO SQL SERVER DATABASE");  
		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  

			// Create and execute an SQL statement 
			String SQLquery = "DELETE FROM PublishCommunicationDetail WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM PublishCommunication WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM communicationTemplateRegion WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM CommunicationHistorySegmentGroup WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM communicationSegmentGroup WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM communicationRegionMessage WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM communicationPublishHistory WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM communicationHistoryMessageType WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM communicationHistoryMessageTargetingCriteria WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM communicationHistoryMessageSegment WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM communicationHistoryMessagePriority WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM communicationHistoryConnector WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM communicationHistoryChannelWebDetails WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM communicationHistoryChannelEmailDetails WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM communicationHistoryBrand WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM campaignbrand WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM communicationConnector WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM communicationChannelWebDetails WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM communicationChannelEmailDetails WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM communicationApproval WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM CommunicationHistoryRegionMessage WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM CommunicationHistoryTemplateRegion WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM CommunicationHistoryProgram WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM CommunicationHistory WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM communicationWorkflowDetails WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM communicationprogram WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM communicationbrand WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM TrackCommunication WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM communication WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
	//sql delete messages
	public static void deleteMessage()  
	{
		readconfig();
		System.out.println("**CONNECTING TO SQL SERVER DATABASE");  
		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  

			// Create and execute an SQL statement 
			String SQLquery = "DELETE FROM MessageHistoryVariable WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageHistoryTemplate WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageHistoryContentImage WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageHistoryContentHyperlinkLocale WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageHistoryContentHyperlink WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageHistoryContentHtmlLocale WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageHistoryContentHtml WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageHistoryConnector WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageHistoryBrand WHERE WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageHistoryProgram WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessagePublishHistory WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageVersionHistoryVariable WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageVersionHistoryTemplate WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageVersionHistoryProgram WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageVersionHistoryContentImage WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageVersionHistoryContentHyperlink WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageVersionHistoryContentHtml WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageVersionHistoryConnector WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageVersionHistoryBrand WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageVersionHistory WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageHistory WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageVersionContentImage WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageVersionContentHyperlink WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageVersionContentHtml WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageVersionConnector WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageVersionBrand WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageVersionProgram WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageVersionPublishHistory WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageVersionTemplate WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageVersionVariable WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageVersion WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageWorkflowDetails WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageContentHtml WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageContentHtmlLocale WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageContentHyperlink WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageContentHyperlinkLocale WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageContentImage WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageTypeBrand WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageType WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageVariable WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageTemp WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageTemplate WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageBrand WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageProgram WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageConnector WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageApproval WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageHistoryBrand WHERE WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM MessageHistory WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
			String SQLquery = "DELETE FROM [message] WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
			//update
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLquery);  
		}  
		// Handle sql server exception
//		catch (SQLServerException e) {  
//			System.out.println("********** record deleted");  
//		}
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
	//sql delete series
	public static void deleteSeries()  
	{
		readconfig();
		System.out.println("**CONNECTING TO SQL SERVER DATABASE");
		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  

			// Create and execute an SQL statement 
			String SQLquery = "DELETE FROM seriesApproval WHERE SeriesID >="+testconfig.getProperty("seriesID");
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
			String SQLquery = "DELETE FROM seriesBrand WHERE WHERE SeriesID >="+testconfig.getProperty("seriesID");
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
			String SQLquery = "DELETE FROM seriesProgram WHERE SeriesID >="+testconfig.getProperty("seriesID");
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
			String SQLquery = "DELETE FROM seriesTrack WHERE SeriesID >="+testconfig.getProperty("seriesID");
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
			String SQLquery = "DELETE FROM seriesWorkflowDetails WHERE SeriesID >="+testconfig.getProperty("seriesID");
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
			String SQLquery = "";
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
			String SQLquery = "DELETE FROM seriesPublishHistory WHERE SeriesID >="+testconfig.getProperty("seriesID");
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
			String SQLquery = "DELETE FROM PublishSeriesDetail WHERE SeriesID >="+testconfig.getProperty("seriesID");
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
			String SQLquery = "DELETE FROM PublishSeries WHERE SeriesID >="+testconfig.getProperty("seriesID");
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
			String SQLquery = "DELETE FROM CampaignSeries WHERE SeriesID >="+testconfig.getProperty("seriesID");
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
			String SQLquery = "DELETE FROM SeriesBrand WHERE SeriesID >="+testconfig.getProperty("seriesID");
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
			String SQLquery = "DELETE FROM series WHERE SeriesID >="+testconfig.getProperty("seriesID");
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
	//sql delete tracks
	public static void deleteTracks()  
	{
		readconfig();
		System.out.println("**CONNECTING TO SQL SERVER DATABASE");
		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  

			// Create and execute an SQL statement 
			String SQLquery = "DELETE FROM trackApproval WHERE TrackID >="+testconfig.getProperty("trackID");
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
			String SQLquery = "DELETE FROM trackBrand WHERE TrackID >="+testconfig.getProperty("trackID");
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
			String SQLquery = "DELETE FROM trackCommunication WHERE TrackID >="+testconfig.getProperty("trackID");
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
			String SQLquery = "DELETE FROM trackProgram WHERE TrackID >="+testconfig.getProperty("trackID");
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
			String SQLquery = "DELETE FROM trackPublishHistory WHERE TrackID >="+testconfig.getProperty("trackID");
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
			String SQLquery = "DELETE FROM trackWorkflowDetails WHERE TrackID >="+testconfig.getProperty("trackID");
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
			String SQLquery = "DELETE FROM PublishTrackDetail WHERE TrackID >="+testconfig.getProperty("trackID");
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
			String SQLquery = "DELETE FROM PublishTrack WHERE TrackID >="+testconfig.getProperty("trackID");
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
			String SQLquery = "DELETE FROM SeriesTrack WHERE TrackID >="+testconfig.getProperty("trackID");
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
			String SQLquery = "DELETE FROM track WHERE TrackID >="+testconfig.getProperty("trackID");
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
	//sql delete variable
	public static void deleteVariable ()
	{
		readconfig();
		System.out.println("**CONNECTING TO SQL SERVER DATABASE");
		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  

			// Create and execute an SQL statement 
			String SQLquery = "DELETE FROM dbo.variablebrand WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
			String SQLquery = "DELETE FROM dbo.variable WHERE RowInsertBy="+testconfig.getProperty("db_user_id");
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
	
	//delete connector name
	public static void connector(){
		readconfig();
		System.out.println("**CONNECTING TO SQL SERVER DATABASE");
		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  

			// Create and execute an SQL statement 
			String SQLquery = "DELETE FROM dbo.Connector WHERE ConnectorID="+testconfig.getProperty("connectorID");
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
	public static void main(String[] args) {
		DataBaseLibrary.deleteCampaign();
		DataBaseLibrary.deleteCommunication();
		DataBaseLibrary.deleteMessage();
		DataBaseLibrary.deleteSeries();
		DataBaseLibrary.deleteTracks();
		DataBaseLibrary.deleteVariable();
	}
}