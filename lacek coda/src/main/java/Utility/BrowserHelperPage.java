package Utility;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.concurrent.TimeUnit;

public class BrowserHelperPage extends PageBase {

	public BrowserHelperPage(WebDriver driver) 
	{
		super(driver);
	}
	public static WebDriver createDriver(String os_browser, String runnig_environment)throws MalformedURLException
	{
		WebDriver driver=null;
		DesiredCapabilities caps = new DesiredCapabilities();
		final String USERNAME = "prince84";
		final String AUTOMATE_KEY = "xC4aY1DPEn7zLmfrqQKe";
		final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

		switch (runnig_environment){
		case "local":
			if (os_browser.equalsIgnoreCase("firefox"))
			{
				//FirefoxOptions options = new FirefoxOptions();
				//options.setBinary("C:\\Users\\arjun.karnati\\Downloads\\geckodriver-v0.14.0-win32\\geckodriver.exe"); 
				caps=DesiredCapabilities.firefox();
				//caps.setCapability("marionette", true);
				//caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				//driver = new FirefoxDriver(caps);
				driver = new FirefoxDriver();
				
			}
			else if (os_browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty        
				("webdriver.chrome.driver","C:\\Users\\arjun.karnati\\Downloads\\chromedriver_win32(2)\\chromedriver.exe"); 
				caps = new DesiredCapabilities();
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		  
				driver = new ChromeDriver(caps);
				
			}
			else if (os_browser.equalsIgnoreCase("ie"))
			{
				System.setProperty
				("webdriver.ie.driver","H:\\Drivers\\IEdriver\\IEDriverServer.exe"); 
				caps = new DesiredCapabilities();
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
				caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				//caps.setCapability("requireWindowFocus", true);
				driver = new InternetExplorerDriver(caps);
			}
			else if (os_browser.equalsIgnoreCase("safari"))
			{	
				System.setProperty
				("webdriver.safiri.driver","C:\\Program Files (x86)\\Safari\\safari.exe");
				driver = new SafariDriver();			
			}	
			else if (os_browser.equalsIgnoreCase("edge"))
			{
				/*System.setProperty
					/Desktop\\Drivers\\IE\\IEDriverServer_x64_2.53.0\\IEDriverServer.exe");*/ 
				driver = new EdgeDriver();	
			}
			else
			{
				throw new InvalidParameterException(os_browser +" - is not a valid web browser for web driver.");
			}	
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

			break;

			/*browserstack*/
		case "browserstack":
		{
			switch (os_browser){
			case "OS X EL CAPITAIN firefox 45" :  
			{
				caps.setCapability("browser", "Firefox");
				caps.setCapability("browser_version", "45.0");
				caps.setCapability("os", "OS X");
				caps.setCapability("os_version", "El Capitan");
				caps.setCapability("resolution", "1024x768");
				caps.setCapability("project", "LACEK MMS");
				caps.setCapability("build", "1.0");
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);//accepting certificate
				//caps.setCapability("browserstack.localIdentifier", "lacektest01");
				caps.setCapability("browserstack.local" , true);
				caps.setCapability("browserstack.javascriptEnabled", true);
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

				driver = new RemoteWebDriver(new URL(URL), caps);

				break;
			}
			case "OS X EL CAPITAIN chrome 49" :  
			{
				caps.setCapability("browser", "Chrome");
				caps.setCapability("browser_version", "49.0");
				caps.setCapability("os", "OS X");
				caps.setCapability("os_version", "El Capitan");
				caps.setCapability("resolution", "1024x768");
				caps.setCapability("project", "LACEK MMS");
				caps.setCapability("build", "1.0");
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);//accepting certificate
				//caps.setCapability("browserstack.localIdentifier", "lacektest01");
				caps.setCapability("browserstack.local" , true);
				caps.setCapability("browserstack.javascriptEnabled", true);
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

				driver = new RemoteWebDriver(new URL(URL), caps);

				break;
			}
			case "OS X EL CAPITAIN safari 9" :  

				caps.setCapability("browser", "Safari");
				caps.setCapability("browser_version", "9.1");
				caps.setCapability("os", "OS X");
				caps.setCapability("os_version", "El Capitan");
				caps.setCapability("resolution", "1024x768");
				caps.setCapability("project", "LACEK MMS STAGING");
				caps.setCapability("build", "1.0");
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);//accepting certificate
				//caps.setCapability("browserstack.localIdentifier", "lacektest01");
				caps.setCapability("browserstack.local" , true);
				caps.setCapability("browserstack.javascriptEnabled", true);
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

				driver = new RemoteWebDriver(new URL(URL), caps);

				break;
			case "OS X YOSEMITE firefox 45" :  
			{
				caps.setCapability("browser", "Firefox");
				caps.setCapability("browser_version", "45.0");
				caps.setCapability("os", "OS X");
				caps.setCapability("os_version", "Yosemite");
				caps.setCapability("resolution", "1024x768");
				caps.setCapability("project", "LACEK MMS");
				caps.setCapability("build", "1.0");
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);//accepting certificate
				//caps.setCapability("browserstack.localIdentifier", "lacektest01");
				caps.setCapability("browserstack.local" , true);
				caps.setCapability("browserstack.javascriptEnabled", true);
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

				driver = new RemoteWebDriver(new URL(URL), caps);

				break;
			}
			case "OS X YOSEMITE chrome 49" :  
			{
				caps.setCapability("browser", "Chrome");
				caps.setCapability("browser_version", "49.0");
				caps.setCapability("os", "OS X");
				caps.setCapability("os_version", "Yosemite");
				caps.setCapability("resolution", "1024x768");
				caps.setCapability("project", "LACEK MMS");
				caps.setCapability("build", "1.0");
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);//accepting certificate
				//caps.setCapability("browserstack.localIdentifier", "lacektest01");
				caps.setCapability("browserstack.local" , true);
				caps.setCapability("browserstack.javascriptEnabled", true);
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

				driver = new RemoteWebDriver(new URL(URL), caps);

				break;
			}
			case "OS X YOSEMITE safari 8" :  
			{
				caps.setCapability("browser", "Safari");
				caps.setCapability("browser_version", "8.0");
				caps.setCapability("os", "OS X");
				caps.setCapability("os_version", "Yosemite");
				caps.setCapability("resolution", "1024x768");
				caps.setCapability("project", "LACEK MMS");
				caps.setCapability("build", "1.0");
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);//accepting certificate
				//caps.setCapability("browserstack.localIdentifier", "lacektest01");
				caps.setCapability("browserstack.local" , true);
				caps.setCapability("browserstack.javascriptEnabled", true);
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

				driver = new RemoteWebDriver(new URL(URL), caps);

				break;
			}
			case "OS X EL MAVERICKS safari 7.1" :  
			{
				caps.setCapability("browser", "Safari");
				caps.setCapability("browser_version", "7.1");
				caps.setCapability("os", "OS X");
				caps.setCapability("os_version", "Mavericks");
				caps.setCapability("resolution", "1024x768");
				caps.setCapability("project", "LACEK MMS");
				caps.setCapability("build", "1.0");
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);//accepting certificate
				//caps.setCapability("browserstack.localIdentifier", "lacektest01");
				caps.setCapability("browserstack.local" , true);
				caps.setCapability("browserstack.javascriptEnabled", true);
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

				driver = new RemoteWebDriver(new URL(URL), caps);

				break;
			}
			case "OS X EL MAVERICKS chrome 49" :  
			{
				caps.setCapability("browser", "Chrome");
				caps.setCapability("browser_version", "49.0");
				caps.setCapability("os", "OS X");
				caps.setCapability("os_version", "Mavericks");
				caps.setCapability("resolution", "1024x768");
				caps.setCapability("project", "LACEK MMS");
				caps.setCapability("build", "1.0");
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);//accepting certificate
				//caps.setCapability("browserstack.localIdentifier", "lacektest01");
				caps.setCapability("browserstack.local" , true);
				caps.setCapability("browserstack.javascriptEnabled", true);
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

				driver = new RemoteWebDriver(new URL(URL), caps);

				break;
			}
			case "OS X EL MAVERICKS firefox 45" :  
			{
				caps.setCapability("browser", "Firefox");
				caps.setCapability("browser_version", "45.0");
				caps.setCapability("os", "OS X");
				caps.setCapability("os_version", "Mavericks");
				caps.setCapability("resolution", "1024x768");
				caps.setCapability("project", "LACEK MMS");
				caps.setCapability("build", "1.0");
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);//accepting certificate
				//caps.setCapability("browserstack.localIdentifier", "lacektest01");
				caps.setCapability("browserstack.local" , true);
				caps.setCapability("browserstack.javascriptEnabled", true);
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

				driver = new RemoteWebDriver(new URL(URL), caps);

				break;
			}
			case "Windows 10 firefox 45" :  
			{
				caps.setCapability("browser", "Firefox");
				caps.setCapability("browser_version", "45.0");
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setCapability("resolution", "1024x768");
				caps.setCapability("project", "LACEK MMS");
				caps.setCapability("build", "1.0");
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);//accepting certificate
				//caps.setCapability("browserstack.localIdentifier", "lacektest01");
				caps.setCapability("browserstack.local" , true);
				caps.setCapability("browserstack.javascriptEnabled", true);
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

				driver = new RemoteWebDriver(new URL(URL), caps);

				break;
			}
			case "Windows 10 chrome 49" :  
			{
				caps.setCapability("browser", "Chrome");
				caps.setCapability("browser_version", "49.0");
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setCapability("resolution", "1024x768");
				caps.setCapability("project", "CODA LACEK");
				caps.setCapability("build", "1.0");
			
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);//accepting certificate
				//caps.setCapability("browserstack.localIdentifier", "lacektest01");
				caps.setCapability("browserstack.local" , true);
				caps.setCapability("browserstack.javascriptEnabled", true);
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

				driver = new RemoteWebDriver(new URL(URL), caps);

				break;
			}
			case "Windows 10 ie 11" :  
			{
				caps.setCapability("browser", "IE");
				caps.setCapability("browser_version", "11.0");
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setCapability("resolution", "1024x768");
				caps.setCapability("project", "LACEK MMS");
				caps.setCapability("build", "1.0");
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);//accepting certificate
				//caps.setCapability("browserstack.localIdentifier", "lacektest01");
				caps.setCapability("browserstack.local" , true);
				caps.setCapability("browserstack.javascriptEnabled", true);
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

				driver = new RemoteWebDriver(new URL(URL), caps);

				break;
			}
			case "Windows 10 edge 13" :  
			{
				caps.setCapability("browser", "Edge");
				caps.setCapability("browser_version", "13.0");
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setCapability("resolution", "1024x768");
				caps.setCapability("project", "LACEK MMS");
				caps.setCapability("build", "1.0");
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);//accepting certificate
				//caps.setCapability("browserstack.localIdentifier", "lacektest01");
				caps.setCapability("browserstack.local" , true);
				caps.setCapability("browserstack.javascriptEnabled", true);
				caps.setCapability("browserstack.debug", true);
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

				driver = new RemoteWebDriver(new URL(URL), caps);

				break;
			}
			case "Windows 8 ie 11" :  
			{
				caps.setCapability("browser", "IE");
				caps.setCapability("browser_version", "11.0");
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "8");
				caps.setCapability("resolution", "1024x768");
				caps.setCapability("project", "LACEK MMS");
				caps.setCapability("build", "1.0");
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);//accepting certificate
				//caps.setCapability("browserstack.localIdentifier", "lacektest01");
				caps.setCapability("browserstack.local" , true);
				caps.setCapability("browserstack.javascriptEnabled", true);
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

				driver = new RemoteWebDriver(new URL(URL), caps);

				break;
			}
			case "Windows 8 firefox 45" :  
			{
				caps.setCapability("browser", "Firefox");
				caps.setCapability("browser_version", "45.0");
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "8");
				caps.setCapability("resolution", "1024x768");
				caps.setCapability("project", "LACEK MMS");
				caps.setCapability("build", "1.0");
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);//accepting certificate
				//caps.setCapability("browserstack.localIdentifier", "lacektest01");
				caps.setCapability("browserstack.local" , true);
				caps.setCapability("browserstack.javascriptEnabled", true);
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

				driver = new RemoteWebDriver(new URL(URL), caps);

				break;
			}
			case "Windows 8 chrome 49" :  
			{
				caps.setCapability("browser", "Chrome");
				caps.setCapability("browser_version", "49.0");
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "8");
				caps.setCapability("resolution", "1024x768");
				caps.setCapability("project", "LACEK MMS");
				caps.setCapability("build", "1.0");
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);//accepting certificate
				//caps.setCapability("browserstack.localIdentifier", "lacektest01");
				caps.setCapability("browserstack.javascriptEnabled", true);
				caps.setCapability("browserstack.local" , "true");
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

				driver = new RemoteWebDriver(new URL(URL), caps);

				break;
			}
			case "Windows 8 chrome 52" :  
			{
				caps.setCapability("browser", "Chrome");
				caps.setCapability("browser_version", "52.0");
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "8");
				caps.setCapability("resolution", "1024x768");
				caps.setCapability("project", "LACEK MMS");
				caps.setCapability("build", "1.0");
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);//accepting certificate
				//caps.setCapability("browserstack.localIdentifier", "lacektest01");
				caps.setCapability("browserstack.javascriptEnabled", true);
				caps.setCapability("browserstack.local" , "true");
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

				driver = new RemoteWebDriver(new URL(URL), caps);

				break;
			}
			case "Windows 8 ie 10" :  
			{
				caps.setCapability("browser", "IE");
				caps.setCapability("browser_version", "10.0");
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "8");
				caps.setCapability("resolution", "1024x768");
				caps.setCapability("project", "LACEK MMS");
				caps.setCapability("build", "1.0");
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);//accepting certificate
				//caps.setCapability("browserstack.localIdentifier", "lacektest01");
				caps.setCapability("browserstack.local" , true);
				caps.setCapability("browserstack.javascriptEnabled", true);
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

				driver = new RemoteWebDriver(new URL(URL), caps);

				break;
			}
			case "Windows 7 firefox 45" :  
			{
				caps.setCapability("browser", "Firefox");
				caps.setCapability("browser_version", "45.0");
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "7");
				caps.setCapability("resolution", "1024x768");
				caps.setCapability("project", "LACEK MMS");
				caps.setCapability("build", "1.0");
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);//accepting certificate
				//caps.setCapability("browserstack.localIdentifier", "lacektest01");
				caps.setCapability("browserstack.local" , true);
				caps.setCapability("browserstack.javascriptEnabled", true);
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);


				driver = new RemoteWebDriver(new URL(URL), caps);

				break;
			}
			case "Windows 7 chrome 49" :  
			{
				caps.setCapability("browser", "Chrome");
				caps.setCapability("browser_version", "49.0");
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "7");
				caps.setCapability("resolution", "1024x768");
				caps.setCapability("project", "LACEK CODA");
				caps.setCapability("build", "SYSTEM SETTINGS SPRINT RUN 2");
				//caps.setCapability("name", true);
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);//accepting certificate
				//caps.setCapability("browserstack.localIdentifier", "lacektest01");
				caps.setCapability("browserstack.local" , true);
				caps.setCapability("browserstack.javascriptEnabled", true);
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-popup-blocking");
				caps.setCapability(ChromeOptions.CAPABILITY, options);
				caps.setCapability("browserstack.video",true);
				driver = new RemoteWebDriver(new URL(URL), caps);

				break;
			}
			case "Windows 7 ie 9" :  
			{
				caps.setCapability("browser", "IE");
				caps.setCapability("browser_version", "9.0");
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "7");
				caps.setCapability("resolution", "1024x768");
				caps.setCapability("project", "LACEK MMS");
				caps.setCapability("build", "1.0");
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);//accepting certificate
				//caps.setCapability("browserstack.localIdentifier", "lacektest01");
				caps.setCapability("browserstack.local" , true);
				caps.setCapability("browserstack.javascriptEnabled", true);
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

				driver = new RemoteWebDriver(new URL(URL), caps);

				break;
			}
			case "iOS iPad Air 2" :
			{
				caps.setCapability("Tablet","iPad Air 2");
				caps.setCapability("project", "LACEK MMS");
				caps.setCapability("build", "1.0");
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);//accepting certificate
				//caps.setCapability("browserstack.localIdentifier", "lacektest01");
				caps.setCapability("browserstack.local" , true);
				caps.setCapability("browserstack.javascriptEnabled", true);
				caps.setCapability("browserstack.debug", "true");
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

				driver = new RemoteWebDriver(new URL(URL), caps);

				break;
			
			}	
		
			default :
			{
				throw new InvalidParameterException(os_browser +" is not a valid web browser or operating system for web driver. ref automation doc os_browsers page");
			}
			}	
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		return driver;
	}
	//closing browser
	public static void quitDriver(WebDriver driver) 
	{
		driver.quit();
	}


}


