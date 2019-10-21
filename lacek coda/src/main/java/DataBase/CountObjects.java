package DataBase;

import Utility.PageBase;
import org.openqa.selenium.WebDriver;

import java.sql.DriverManager;
import java.sql.SQLException;

public class CountObjects extends PageBase {

	public CountObjects(WebDriver driver) {
		super(driver);
	}
	static int carinivalcount = 0;
	static int ehicount = 0;
	//test data update
	public static int campaignCount(String client)
	{
		switch(client){
		case"carnival":
			System.out.println("**connecting to database...");
			try {  
				// Establish the connection.  
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
				con = DriverManager.getConnection(connectionUrl);  
				System.out.println("Connected database successfully...");
				// Create and execute an SQL statement 
				System.out.println("Creating statement...");
				String SQLquery = "SELECT COUNT(clientID) FROM campaign GROUP BY clientID,isarchived HAVING clientID=5 and isarchived=0; ";
				//update
				stmt = con.createStatement();
				rs = stmt.executeQuery(SQLquery); 
				if(rs.next()) 
					carinivalcount = rs.getInt(1);
				// see the updated records
				while(rs.next()){	
					//Display values
					System.out.println(carinivalcount);
				}
				rs.close();
			}catch(SQLException se){
				//Handle errors for JDBC
				se.printStackTrace();}catch(Exception e){
					//Handle errors for Class.forName
					e.printStackTrace();
				}finally{
					//finally block used to close resources
					try{
						if(stmt!=null)
							con.close();
					}catch(SQLException se){
					}// do nothing
					try{
						if(con!=null)
							con.close();}catch(SQLException se){
								se.printStackTrace();
							}//end finally try
				}//end try
			System.out.println("*********************************************carnival campaign count: "+carinivalcount);	
			break;
		case"EHI":
			System.out.println("**connecting to database...");
			try {  
				// Establish the connection.  
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
				con = DriverManager.getConnection(connectionUrl);  
				System.out.println("Connected database successfully...");
				// Create and execute an SQL statement 
				System.out.println("Creating statement...");
				String SQLquery = "SELECT COUNT(clientID) FROM campaign GROUP BY clientID,isarchived HAVING clientID=10 and isarchived=0; ";
				//update
				stmt = con.createStatement();
				rs = stmt.executeQuery(SQLquery); 
				if(rs.next()) 
					ehicount = rs.getInt(1);
				// see the updated records
				while(rs.next()){	
					//Display values
					System.out.println(ehicount);
				}
				rs.close();
			}catch(SQLException se){
				//Handle errors for JDBC
				se.printStackTrace();}catch(Exception e){
					//Handle errors for Class.forName
					e.printStackTrace();
				}finally{
					//finally block used to close resources
					try{
						if(stmt!=null)
							con.close();
					}catch(SQLException se){
					}// do nothing
					try{
						if(con!=null)
							con.close();}catch(SQLException se){
								se.printStackTrace();
							}//end finally try
				}//end try
			System.out.println("*********************************************EHI campaign count: "+ehicount);
		}
		return carinivalcount;
	}
	//main class
	public static void main(String[] args) 
	{
		CountObjects.campaignCount("carnival");
		CountObjects.campaignCount("EHI");
	}
}