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

			// Create and execute SQL statement 
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

			// Create and execute SQL statement 
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

			// Create and execute SQL statement 
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

			// Create and execute SQL statement 
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

			// Create and execute SQL statement 
			ps = con.prepareStatement("DELETE FROM PublishCommunicationDetail WHERE PublishCommunicationID IN(SELECT PublishCommunicationID FROM PublishCommunication WHERE COMMUNICATIONID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+"))");
			ps.executeUpdate();
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {
			System.out.println("Could not delete:\tPublishCommunicationDetail");
			e.printStackTrace();  
		}
		finally {  
			if (rs != null) try { rs.close(); } catch(Exception e) {}  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
			if (con != null) try { con.close(); } catch(Exception e) {}
			if (ps != null) try { ps.close(); } catch(Exception e) {}
		}  
		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  

			// Create and execute SQL statement 
			ps = con.prepareStatement("DELETE FROM PublishCommunication WHERE COMMUNICATIONID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate(); 
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {
			System.out.println("Could not delete:\tPublishCommunication");
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
			ps = con.prepareStatement("DELETE FROM CommunicationTemplateRegion WHERE COMMUNICATIONID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();;  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {  
			System.out.println("Could not delete:\tCommunicationTemplateRegion");
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
			ps = con.prepareStatement("DELETE FROM CommunicationHistorySegmentGroup WHERE CommunicationHistoryID IN(SELECT CommunicationHistoryID FROM CommunicationHistory WHERE CommunicationID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+"))");
			ps.executeUpdate(); 
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tCommunicationHistorySegmentGroup");
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
			ps = con.prepareStatement("DELETE FROM CommunicationSegmentGroup WHERE COMMUNICATIONID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {  
			System.out.println("Could not delete:\tCommunicationSegmentGroup");
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
			ps = con.prepareStatement("DELETE FROM CommunicationPreviewSave WHERE COMMUNICATIONID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate(); 
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {
			System.out.println("Could not delete:\tCommunicationPreviewSave");
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
			ps = con.prepareStatement("DELETE FROM CommunicationPreviewRegion WHERE CommunicationPreviewID IN(SELECT CommunicationPreviewID FROM CommunicationPreview WHERE COMMUNICATIONID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+"))");
			ps.executeUpdate();
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {
			System.out.println("Could not delete:\tCommunicationPreviewRegion");
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
			ps = con.prepareStatement("DELETE FROM CommunicationPreview WHERE COMMUNICATIONID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate(); 
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tCommunicationPreview");
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
			ps = con.prepareStatement("DELETE FROM CommunicationRegionMessageLocale WHERE COMMUNICATIONID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tCommunicationRegionMessageLocale");
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
			ps = con.prepareStatement("DELETE FROM CommunicationRegionMessage WHERE COMMUNICATIONID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {
			System.out.println("Could not delete:\tCommunicationRegionMessage");
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
			ps = con.prepareStatement("DELETE FROM CommunicationPublishHistory WHERE COMMUNICATIONID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tCommunicationPublishHistory");
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
			ps = con.prepareStatement("DELETE FROM CommunicationHistoryMessageTargetingCriteria WHERE CommunicationHistoryID IN(SELECT CommunicationHistoryID FROM CommunicationHistory WHERE CommunicationID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+"))");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {
			System.out.println("Could not delete:\tCommunicationHistoryMessageTargetingCriteria");
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
			ps = con.prepareStatement("DELETE FROM communicationHistoryMessageSegment WHERE CommunicationHistoryID IN(SELECT CommunicationHistoryID FROM CommunicationHistory WHERE CommunicationID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+"))");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {
			System.out.println("Could not delete:\tcommunicationHistoryMessageSegment");
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
			ps = con.prepareStatement("DELETE FROM CommunicationHistoryConnector WHERE CommunicationHistoryID IN(SELECT CommunicationHistoryID FROM CommunicationHistory WHERE CommunicationID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+"))");
			ps.executeUpdate();
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {
			System.out.println("Could not delete:\tCommunicationHistoryConnector");
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

			// Create and execute SQL statement 
			ps = con.prepareStatement("DELETE FROM CommunicationHistoryChannelWebDetails WHERE CommunicationHistoryID IN(SELECT CommunicationHistoryID FROM CommunicationHistory WHERE CommunicationID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+"))");
			ps.executeUpdate();
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {
			System.out.println("Could not delete:\tCommunicationHistoryChannelWebDetails"); 
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
			ps = con.prepareStatement("DELETE FROM CommunicationHistoryChannelEmailDetails WHERE CommunicationHistoryID IN(SELECT CommunicationHistoryID FROM CommunicationHistory WHERE CommunicationID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+"))");
			ps.executeUpdate();
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {
			System.out.println("Could not delete:\tCommunicationHistoryChannelEmailDetails");
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
			ps = con.prepareStatement("DELETE FROM CommunicationHistoryBrand WHERE CommunicationHistoryID IN(SELECT CommunicationHistoryID FROM CommunicationHistory WHERE CommunicationID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+"))");
			ps.executeUpdate();
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {
			System.out.println("Could not delete:\tCommunicationHistoryBrand");
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
			ps = con.prepareStatement("DELETE FROM CommunicationConnector WHERE COMMUNICATIONID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tCommunicationConnector");
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
			ps = con.prepareStatement("DELETE FROM CommunicationChannelWebDetails WHERE COMMUNICATIONID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {
			System.out.println("Could not delete:\tCommunicationChannelWebDetails");
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
			ps = con.prepareStatement("DELETE FROM CommunicationChannelEmailDetails WHERE COMMUNICATIONID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {
			System.out.println("Could not delete:\tCommunicationChannelEmailDetails");
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
			ps = con.prepareStatement("DELETE FROM CommunicationApproval WHERE COMMUNICATIONID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {
			System.out.println("Could not delete:\tCommunicationApproval");
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
			ps = con.prepareStatement("DELETE FROM CommunicationHistoryRegionMessage WHERE CommunicationHistoryID IN(SELECT CommunicationHistoryID FROM CommunicationHistory WHERE CommunicationID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+"))");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {
			System.out.println("Could not delete:\tCommunicationHistoryRegionMessage");
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
			ps = con.prepareStatement("DELETE FROM CommunicationHistoryTemplateRegion WHERE CommunicationHistoryID IN(SELECT CommunicationHistoryID FROM CommunicationHistory WHERE CommunicationID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+"))");
			ps.executeUpdate(); 
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {
			System.out.println("Could not delete:\tCommunicationHistoryTemplateRegion");
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
			ps = con.prepareStatement("DELETE FROM CommunicationHistoryProgram WHERE CommunicationHistoryID IN(SELECT CommunicationHistoryID FROM CommunicationHistory WHERE CommunicationID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+"))");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {
			System.out.println("Could not delete:\tCommunicationHistoryProgram");
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
			ps = con.prepareStatement("DELETE FROM CommunicationHistory WHERE COMMUNICATIONID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {
			System.out.println("Could not delete:\tCommunicationHistory");
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
			ps = con.prepareStatement("DELETE FROM CommunicationWorkflowDetails WHERE COMMUNICATIONID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {
			System.out.println("Could not delete:\tCommunicationWorkflowDetails");
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
			ps = con.prepareStatement("DELETE FROM CommunicationProgram WHERE COMMUNICATIONID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {
			System.out.println("Could not delete:\tCommunicationProgram");
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
			ps = con.prepareStatement("DELETE FROM TrackCommunication WHERE COMMUNICATIONID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tTrackCommunication");
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
			ps = con.prepareStatement("DELETE FROM CommunicationBrand WHERE COMMUNICATIONID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace();  
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {
			System.out.println("Could not delete:\tCommunicationBrand");
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
			ps = con.prepareStatement("DELETE FROM CommunicationMessageSegment WHERE COMMUNICATIONID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tCommunicationMessageSegment");
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
			ps = con.prepareStatement("DELETE FROM CommunicationMessageTargetingCriteria WHERE COMMUNICATIONID IN(SELECT COMMUNICATIONID FROM COMMUNICATION WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {
			System.out.println("Could not delete:\tCommunicationMessageTargetingCriteria");
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
			ps = con.prepareStatement("DELETE FROM communication WHERE RowInsertBy="+testconfig.getProperty("db_user_id"));
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tcommunication");
			e.printStackTrace();  
		}  	
		finally {  
			if (rs != null) try { rs.close(); } catch(Exception e) {}  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
			if (con != null) try { con.close(); } catch(Exception e) {} 
			if (ps != null) try {ps.close(); } catch(Exception e) {}
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

			// Create and execute SQL statement 
			ps = con.prepareStatement("DELETE FROM MessageContentImage WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageContentImage");
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
			ps = con.prepareStatement("DELETE FROM MessageContentHyperlinkLocale WHERE MessageContentHyperlinkID IN(SELECT MessageContentHyperlinkID FROM MessageContentHyperlink WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+"))");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageContentHyperlinkLocale");
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
			ps = con.prepareStatement("DELETE FROM MessageContentHyperlink WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageContentHyperlink");
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
			ps = con.prepareStatement("DELETE FROM MessageContentHtmlLocale WHERE MessageContentHtmlID IN(SELECT MessageContentHtmlID FROM MessageContentHtml WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+"))");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageContentHtmlLocale");
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
			ps = con.prepareStatement("DELETE FROM MessageContentHtml WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageContentHtml");
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
			ps = con.prepareStatement("DELETE FROM MessageConnector WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageConnector");
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
			ps = con.prepareStatement("DELETE FROM MessageBrand WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageBrand");
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
			ps = con.prepareStatement("DELETE FROM MessageApprovalLocale WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageApprovalLocale");
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
			ps = con.prepareStatement("DELETE FROM MessageApproval WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageApproval");
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
			ps = con.prepareStatement("DELETE FROM MessageProgram WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageProgram");
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
			ps = con.prepareStatement("DELETE FROM MessagePublishHistory WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessagePublishHistory");
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
			ps = con.prepareStatement("DELETE FROM MessageTemp WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageTemp");
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
			ps = con.prepareStatement("DELETE FROM MessageTemplate WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageTemplate");
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
			ps = con.prepareStatement("DELETE FROM PublishMessageMediaGallery WHERE PublishMessageID IN(SELECT PublishMessageID FROM PublishMessage WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+"))");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tPublishMessageMediaGallery");
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
			ps = con.prepareStatement("DELETE FROM PublishMessageDetail WHERE PublishMessageID IN(SELECT PublishMessageID FROM PublishMessage WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+"))");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tPublishMessageDetail");
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
			ps = con.prepareStatement("DELETE FROM PublishMessage WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tPublishMessage");
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
			ps = con.prepareStatement("DELETE FROM MessageWorkflowDetails WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageWorkflowDetails");
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
			ps = con.prepareStatement("DELETE FROM MessageVariable WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageVariable");
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
			ps = con.prepareStatement("DELETE FROM MessageHistoryVariable WHERE MessageHistoryID IN(SELECT MessageHistoryID FROM MessageHistory WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+"))");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageHistoryVariable");
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
			ps = con.prepareStatement("DELETE FROM MessageHistoryTemplate WHERE MessageHistoryID IN(SELECT MessageHistoryID FROM MessageHistory WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+"))");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageHistoryTemplate");
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
			ps = con.prepareStatement("DELETE FROM MessageHistoryProgram WHERE MessageHistoryID IN(SELECT MessageHistoryID FROM MessageHistory WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+"))");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageHistoryProgram");
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
			ps = con.prepareStatement("DELETE FROM MessageHistoryContentImage WHERE MessageHistoryID IN(SELECT MessageHistoryID FROM MessageHistory WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+"))");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageHistoryContentImage");
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
			ps = con.prepareStatement("DELETE FROM MessageHistoryContentHyperlinkLocale WHERE MessageHistoryContentHyperlinkID IN(SELECT MessageHistoryContentHyperlinkID FROM MessageHistoryContentHyperlink WHERE MessageHistoryID IN(SELECT MessageHistoryID FROM MessageHistory WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")))");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageHistoryContentHyperlinkLocale");
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
			ps = con.prepareStatement("DELETE FROM MessageHistoryContentHyperlink WHERE MessageHistoryID IN(SELECT MessageHistoryID FROM MessageHistory WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+"))");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageHistoryContentHyperlink");
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
			ps = con.prepareStatement("DELETE FROM MessageHistoryContentHtmlLocale WHERE MessageHistoryContentHtmlID IN(SELECT MessageHistoryContentHtmlID FROM MessageHistoryContentHtml WHERE MessageHistoryID IN(SELECT MessageHistoryID FROM MessageHistory WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")))");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageHistoryContentHtmlLocale");
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
			ps = con.prepareStatement("DELETE FROM MessageHistoryContentHtml WHERE MessageHistoryID IN(SELECT MessageHistoryID FROM MessageHistory WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+"))");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageHistoryContentHtml");
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
			ps = con.prepareStatement("DELETE FROM MessageHistoryConnector WHERE MessageHistoryID IN(SELECT MessageHistoryID FROM MessageHistory WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+"))");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageHistoryConnector");
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
			ps = con.prepareStatement("DELETE FROM MessageHistoryBrand WHERE MessageHistoryID IN(SELECT MessageHistoryID FROM MessageHistory WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+"))");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageHistoryBrand");
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
			ps = con.prepareStatement("DELETE FROM MessageHistoryLocale WHERE MessageHistoryID IN(SELECT MessageHistoryID FROM MessageHistory WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+"))");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageHistoryLocale");
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
			ps = con.prepareStatement("DELETE FROM MessageHistory WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageHistory");
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
			ps = con.prepareStatement("DELETE FROM MessageLocale WHERE MessageID IN(SELECT MessageID FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageLocale");
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
			ps = con.prepareStatement("DELETE FROM MessageTypeBrand WHERE MessageTypeID IN(SELECT MessageTypeID FROM MessageType WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageTypeBrand");
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
			ps = con.prepareStatement("DELETE FROM MessageType WHERE RowInsertBy="+testconfig.getProperty("db_user_id"));
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessageType");
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
			ps = con.prepareStatement("DELETE FROM Message WHERE RowInsertBy="+testconfig.getProperty("db_user_id"));
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tMessage");
			e.printStackTrace();  
		}  	
		finally {  
			if (rs != null) try { rs.close(); } catch(Exception e) {}  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
			if (con != null) try { con.close(); } catch(Exception e) {} 
			if (ps != null) try {ps.close(); } catch(Exception e) {}
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

			// Create and execute SQL statement 
			ps = con.prepareStatement("DELETE FROM WorkflowNote WHERE SeriesID IN(SELECT SeriesID FROM Series WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tWorkflowNote");
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
			ps = con.prepareStatement("DELETE FROM SeriesWorkflowDetails WHERE SeriesID IN(SELECT SeriesID FROM Series WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tSeriesWorkflowDetails");
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
			ps = con.prepareStatement("DELETE FROM SeriesTrack WHERE SeriesID IN(SELECT SeriesID FROM Series WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tSeriesTrack");
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
			ps = con.prepareStatement("DELETE FROM SeriesPublishHistory WHERE SeriesID IN(SELECT SeriesID FROM Series WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tSeriesPublishHistory");
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
			ps = con.prepareStatement("DELETE FROM SeriesProgram WHERE SeriesID IN(SELECT SeriesID FROM Series WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tSeriesProgram");
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
			ps = con.prepareStatement("DELETE FROM SeriesBrand WHERE SeriesID IN(SELECT SeriesID FROM Series WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tSeriesBrand");
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
			ps = con.prepareStatement("DELETE FROM SeriesApproval WHERE SeriesID IN(SELECT SeriesID FROM Series WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tSeriesApproval");
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
			ps = con.prepareStatement("DELETE FROM PublishSeries WHERE SeriesID IN(SELECT SeriesID FROM Series WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tPublishSeries");
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
			ps = con.prepareStatement("DELETE FROM CampaignSeries WHERE SeriesID IN(SELECT SeriesID FROM Series WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tCampaignSeries");
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
			ps = con.prepareStatement("DELETE FROM Series WHERE RowInsertBy="+testconfig.getProperty("db_user_id"));
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tSeries");
			e.printStackTrace();  
		}  	
		finally {  
			if (rs != null) try { rs.close(); } catch(Exception e) {}  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
			if (con != null) try { con.close(); } catch(Exception e) {} 
			if (ps != null) try {ps.close(); } catch(Exception e) {}
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

			// Create and execute SQL statement 
			ps = con.prepareStatement("DELETE FROM WorkflowNote WHERE TrackID IN(SELECT TrackID FROM Track WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tWorkflowNote");
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
			ps = con.prepareStatement("DELETE FROM TrackWorkflowDetails WHERE TrackID IN(SELECT TrackID FROM Track WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tTrackWorkflowDetails");
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
			ps = con.prepareStatement("DELETE FROM TrackPublishHistory WHERE TrackID IN(SELECT TrackID FROM Track WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tTrackPublishHistory");
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
			ps = con.prepareStatement("DELETE FROM TrackProgram WHERE TrackID IN(SELECT TrackID FROM Track WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tTrackProgram");
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
			ps = con.prepareStatement("DELETE FROM TrackCommunication WHERE TrackID IN(SELECT TrackID FROM Track WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tTrackCommunication");
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
			ps = con.prepareStatement("DELETE FROM TrackBrand WHERE TrackID IN(SELECT TrackID FROM Track WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tTrackBrand");
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
			ps = con.prepareStatement("DELETE FROM TrackApproval WHERE TrackID IN(SELECT TrackID FROM Track WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tTrackApproval");
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
			ps = con.prepareStatement("DELETE FROM SeriesTrack WHERE TrackID IN(SELECT TrackID FROM Track WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tSeriesTrack");
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
			ps = con.prepareStatement("DELETE FROM PublishTrack WHERE TrackID IN(SELECT TrackID FROM Track WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tPublishTrack");
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
			ps = con.prepareStatement("DELETE FROM Track WHERE RowInsertBy="+testconfig.getProperty("db_user_id"));
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tTrack");
			e.printStackTrace();  
		}  	
		finally {  
			if (rs != null) try { rs.close(); } catch(Exception e) {}  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
			if (con != null) try { con.close(); } catch(Exception e) {} 
			if (ps != null) try {ps.close(); } catch(Exception e) {}
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

			// Create and execute SQL statement 
			ps = con.prepareStatement("DELETE FROM VariableBrand WHERE VariableID IN(SELECT VariableID FROM Variable WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tVariableBrand");
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
			ps = con.prepareStatement("DELETE FROM Variable WHERE RowInsertBy="+testconfig.getProperty("db_user_id"));
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tVariable");
			e.printStackTrace();  
		}  	
		finally {  
			if (rs != null) try { rs.close(); } catch(Exception e) {}  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
			if (con != null) try { con.close(); } catch(Exception e) {} 
			if (ps != null) try {ps.close(); } catch(Exception e) {}
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

			// Create and execute SQL statement 
			ps = con.prepareStatement("DELETE FROM ConnectorProgram WHERE ConnectorID IN(SELECT ConnectorID FROM Connector WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tConnectorProgram");
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
			ps = con.prepareStatement("DELETE FROM ConnectorDetail WHERE ConnectorID IN(SELECT ConnectorID FROM Connector WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tConnectorDetail");
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
			ps = con.prepareStatement("DELETE FROM ConnectorBrand WHERE ConnectorID IN(SELECT ConnectorID FROM Connector WHERE RowInsertBy="+testconfig.getProperty("db_user_id")+")");
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tConnectorBrand");
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
			ps = con.prepareStatement("SELECT * FROM Connector WHERE RowInsertBy="+testconfig.getProperty("db_user_id"));
			ps.executeUpdate();  
		}  
		// Handle sql server exception
		catch (SQLServerException e) {  
			e.printStackTrace(); 
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) { 
			System.out.println("Could not delete:\tConnector");
			e.printStackTrace();  
		}  	
		finally {  
			if (rs != null) try { rs.close(); } catch(Exception e) {}  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
			if (con != null) try { con.close(); } catch(Exception e) {} 
			if (ps != null) try {ps.close(); } catch(Exception e) {}
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