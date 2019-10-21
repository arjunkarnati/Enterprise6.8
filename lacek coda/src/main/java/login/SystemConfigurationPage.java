package login;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.security.InvalidParameterException;

public class SystemConfigurationPage extends PageBase {

	public SystemConfigurationPage(WebDriver driver) 
	{
		super(driver);
	}
	/*disabled live publishing*/	
	public SystemConfigurationPage enableLivePublishing(boolean answer) 
	{
		readconfig(); 
		if(answer==true)
		{
			driver.findElement(By.xpath(dashboard.getProperty("sys_config_live_publishing_on"))).click();
			Assert.assertEquals(driver.getTitle(),dashboard.getProperty("sys_configuration_page_title"));
			//Assert.assertTrue(driver.findElement(By.xpath(dashboard.getProperty("alert_live_publishing_off"))).isDisplayed(),"live publishing is not disabled");
		}
		else if(answer==false)
		{
			driver.findElement(By.xpath(dashboard.getProperty("sys_config_live_publishing_off"))).click();
			Assert.assertEquals(driver.getTitle(),dashboard.getProperty("sys_configuration_page_title"));
		}
		else
		{
			throw new InvalidParameterException("answer must be true or false");
		}
		//assert and verify
		Assert.assertEquals(driver.getTitle(),dashboard.getProperty("sys_configuration_page_title"));
		return new SystemConfigurationPage(driver);
	}
	/*disabled automatic publishing*/	
	public SystemConfigurationPage enableAutomaticPublishing(boolean answer) 
	{
		readconfig(); 
		if(answer==true)
		{
			driver.findElement(By.xpath(dashboard.getProperty("sys_config_automatic_publishing_on"))).click();
			Assert.assertEquals(driver.getTitle(),dashboard.getProperty("sys_configuration_page_title"));	
		}
		else if(answer==false)
		{
			driver.findElement(By.xpath(dashboard.getProperty("sys_config_automatic_publishing_off"))).click();
			Assert.assertEquals(driver.getTitle(),dashboard.getProperty("sys_configuration_page_title"));
		}
		else
		{
			throw new InvalidParameterException("answer must be true or false");
		}
		//assert and verify
		Assert.assertEquals(driver.getTitle(),dashboard.getProperty("sys_configuration_page_title"));
		return new SystemConfigurationPage(driver);
	}
	/*click save*/	
	public DashboardPage clickSave() 
	{
		readconfig(); 
		driver.findElement(By.xpath(dashboard.getProperty("sys_config_automatic_submit"))).click();
		waitForAjax(driver);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("dashboard_page_title"));
		return new DashboardPage(driver);
	}
	/*click cancel*/	
	public DashboardPage clickCancel() 
	{
		readconfig(); 
		driver.findElement(By.xpath(dashboard.getProperty("sys_config_automatic_cancel"))).click();
		waitForAjax(driver);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("dashboard_page_title"));
		return new DashboardPage(driver);
	}
}