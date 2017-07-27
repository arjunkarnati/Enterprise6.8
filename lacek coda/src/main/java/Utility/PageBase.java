package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import DataBase.DataBaseHelper;
import library.CampaignPage;
import login.LoginPage;

public class PageBase {

	protected WebDriver driver;
	protected LoginPage loginas;
	protected Alert alert;
	protected LoginPage logout;
	protected static Properties testconfig;
	protected static Properties dashboard;
	protected static Properties elementslocator;
	protected static Properties test_data_reader;
	protected static Properties urls;
	protected static Properties library;
	protected static Properties assets;
	protected static Properties layout;
	protected static Properties manage;
	protected static Properties configuration;
	protected WebDriverWait wait;
	protected boolean acceptNextAlert = true;
	protected CampaignPage clickArchiveButton;	
	protected DataBaseHelper dbhelp;
	// Declare the JDBC objects.  
	protected static Connection con = null;  
	protected static Statement stmt = null;  
	protected static ResultSet rs = null;  
	/// Create a variable for the db connection string.  
	protected static String connectionUrl ="jdbc:sqlserver://10.16.1.171 ;" 
			+"databaseName= tlg_cmp_b5;"  
			+"user= tlg;"
			+"password= tlg%HerndonVA";  
	static String SystemPath = System.getProperty("user.dir");

	public PageBase(WebDriver driver) 
	{
		this.driver=driver;
		//this initElements method will create all webelements
		PageFactory.initElements(driver, this);
	}
	//wait for ajax call
	public static void waitForAjax(WebDriver driver) {
		new WebDriverWait(driver, 180).until(new ExpectedCondition<Boolean>(){
			public Boolean apply(WebDriver driver) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				return (Boolean) js.executeScript("return jQuery.active == 0");
			}
		});
	}
	//elementLocators properties file
	public static void elementLocators() 
	{	
		test_data_reader();
		testconfig(); 
		sleep();
		elementslocator=new Properties();
		try {
			elementslocator.load(new FileInputStream(SystemPath+File.separator+"mms webelements"+File.separator+"elementslocator.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//testconfig properties file
	public static void testconfig() 
	{	
		testconfig=new Properties();
		try {
			testconfig.load(new FileInputStream("testConfig.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//read test data file
	public static void test_data_reader() 
	{	
		test_data_reader=new Properties();
		try {
			test_data_reader.load(new FileInputStream(SystemPath+File.separator+"mms webelements"+File.separator+"test_data_reader.properties"));	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//logout from mms
	public void logout()
	{
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//read test data file
	public static void urls() 
	{	
		urls=new Properties();
		try {
			urls.load(new FileInputStream(SystemPath+File.separator+"mms webelements"+File.separator+"urls.properties"));	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//get page title
	public PageBase getTitle()
	{
		String title =driver.getTitle();
		System.out.println("************Page's Tilte is: "+title);
		return new PageBase(driver);
	}
	//wait
	public static void sleep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//read library web elements
	public static void library() 
	{	
		library=new Properties();
		try {
			library.load(new FileInputStream(SystemPath+File.separator+"mms webelements"+File.separator+"library.properties"));	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//read library web elements
	public static void assets() 
	{	
		assets=new Properties();
		try {
			assets.load(new FileInputStream(SystemPath+File.separator+"mms webelements"+File.separator+"assets.properties"));	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void layout() 
	{	
		layout=new Properties();
		try {
			layout.load(new FileInputStream(SystemPath+File.separator+"mms webelements"+File.separator+"layout.properties"));	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void manage() 
	{	
		manage=new Properties();
		try {
			manage.load(new FileInputStream(SystemPath+File.separator+"mms webelements"+File.separator+"manage.properties"));	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void configuration() 
	{	
		configuration=new Properties();
		try {
			configuration.load(new FileInputStream(SystemPath+File.separator+"mms webelements"+File.separator+"configuration.properties"));	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void dashboard() 
	{	
		dashboard=new Properties();
		try {
			dashboard.load(new FileInputStream(SystemPath+File.separator+"mms webelements"+File.separator+"dashboard.properties"));	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//read config files
	public static void readconfig() 
	{
		elementLocators();
		test_data_reader();
		testconfig(); 
		urls(); 
		library();
		assets();
		layout();
		manage();
		configuration();
		dashboard(); 
	}
	
	
	
}