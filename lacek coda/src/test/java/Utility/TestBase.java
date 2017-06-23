package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Random;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import Utility.DataDrivenHelper;
import DataBase.DataBaseHelper;
import login.DashboardPage;
import login.LoginPage;


//@Listeners(JyperionListener.class)

@SuppressWarnings("unused")
public class TestBase {

	protected WebDriver driver;
	protected LoginPage login;
	protected static Properties testconfig;
	protected DashboardPage dashboard;
	protected DataBaseHelper dbhelp;
	protected static File file;

	//take screenshots
	public static void captureScreenshot(WebDriver driver,ITestResult result)
	{
		// Here will compare if test is failing then only it will enter into if condition
		if(ITestResult.FAILURE==result.getStatus())
		{		
			try 
			{
				// Create refernce of TakesScreenshot
				TakesScreenshot ts=(TakesScreenshot)driver;
				// Call method to capture screenshot
				File source=ts.getScreenshotAs(OutputType.FILE);
				// Copy files to specific location 
				// result.getName() will return name of test case so that screenshot name will be same
				FileUtils.copyFile(source, new File("H:\\arjun.karnati.project\\Failed.tests\\screenshots\\"+result.getName()+".png"));
				//				System.setProperty("org.uncommons.reportng.escape-output", "false");
				//				String absolute = file.getAbsolutePath();
				//				int beginIndex = absolute.indexOf(".");
				//				String relative = absolute.substring(beginIndex).replace(".\\","");
				//				String screenShot = relative.replace('\\','/');
				//				Reporter.log("<a href=\"" + screenShot + "\"><p align=\"left\">Error screenshot at " + new Date()+ "</p>");
				//				Reporter.log("<p><img width=\"1024\" src=\"" + file.getAbsoluteFile()  + "\" alt=\"screenshot at " + new Date()+ "\"/></p></a><br />"); 
				//			
				System.out.println("*********Test result is: FAILED, Screenshot taken");
			} 
			catch (Exception e)
			{
				System.out.println("Exception while taking screenshot "+e.getMessage());
			}
		}
		else if(ITestResult.SUCCESS==result.getStatus()) 
			try
		{
				System.out.println("********* Test result is: PASSED");
		} 
		catch (Exception e)
		{
			System.out.println("Exception while taking screenshot "+e.getMessage());
		}
	}
	//before class
	@BeforeClass(alwaysRun=true)
	public void BeforeSuite() throws FileNotFoundException, IOException
	{
		testconfig=new Properties();
		testconfig.load(new FileInputStream("testConfig.properties"));	
	}
	//before test
	@BeforeMethod(alwaysRun = true)
	public void beforeTest(){
		try {
		driver=BrowserHelperPage.createDriver(testconfig.getProperty("os_browser"),testconfig.getProperty("run_in"));
			//driver = BrowserHelperPage.createDriver("chrome","local");
			//Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Base URl..."+testconfig.getProperty("baseUrl"));
		driver.get(testconfig.getProperty("baseUrl"));
		//driver.get("https://qa-b10.mms.lacek.net");
		if(testconfig.getProperty("os_browser").equalsIgnoreCase("ie")){
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		}
		else{
			driver.navigate().refresh();
		}
		login=new LoginPage(driver);
		dashboard=new DashboardPage(driver);
	}
	// It will execute after every test execution 
	@AfterMethod(alwaysRun = true)
	public void AfterLogin(ITestResult result)
	{
		System.out.println("********* test case name is: "+result.getName());
		captureScreenshot(driver,result);
		//closing the browser
		//driver.quit();    
		driver.close();
		System.out.println("********* Test completed ********");
	}
	//send email after execution
	@AfterSuite(alwaysRun = true)
	//	public void sendHtmlReport()
	//	{
	//		email.main(null);
	//	}
	public void tearDown(){

		sendPDFReportByGMail("autoreporttlg@gmail.com", "Monday#1", "arjun.karnati@lacek.com", "Test Report Notification","");

	}
	private static void sendPDFReportByGMail(String from, String pass, String to, String subject, String body) {

		Properties props = System.getProperties();
		String host = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		String environment=testconfig.getProperty("baseUrl");
		String browser=testconfig.getProperty("os_browser");

		Session session = Session.getDefaultInstance(props);

		MimeMessage message = new MimeMessage(session);

		try {

			//Set from address
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			//message.setRecipient(Message.RecipientType.CC, new InternetAddress("prince.kabuika@lacek.com"));
			//Set subject
			message.setSubject(subject);
			message.setText(body);

			BodyPart objMessageBodyPart = new MimeBodyPart();
			objMessageBodyPart.setText("Please Find The Attached Report File!!! "+"Environment: "+environment+", Browser: "+browser);
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(objMessageBodyPart);
			objMessageBodyPart = new MimeBodyPart();
			//Set path to the pdf report file
			Random rn = new Random();
			String filename = System.getProperty("user.dir")+"\\test-output\\html\\overview.html";
			//Create data source to attach the file in mail
			DataSource source = new FileDataSource(filename);
			objMessageBodyPart.setDataHandler(new DataHandler(source));
			objMessageBodyPart.setFileName(filename);
			multipart.addBodyPart(objMessageBodyPart);
			message.setContent(multipart);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		}
		catch (AddressException ae) {
			ae.printStackTrace();
		}

		catch (MessagingException me) {
			me.printStackTrace();
		}
	}

	@DataProvider
	public Object [][] dataProvider(Method method)
	{
		DataDrivenHelper ddh= new DataDrivenHelper(testconfig.getProperty("testdata"));
		Object[][] testData=ddh.getTestDataSets(testconfig.getProperty("mastertestdata"), method.getName());
		return testData;
	}
	public void reRunFails(){
	}	
	public static void main(String[] args) 
	{
	}
}