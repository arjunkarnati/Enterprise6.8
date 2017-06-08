package layout;

import java.security.InvalidParameterException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Utility.PageBase;

public class RegionsEditPage extends PageBase {

	public RegionsEditPage(WebDriver driver) 
	{
		super(driver);		
	}
	//update region name in name field
	public RegionsEditPage updateRegionName(String newregionname)
	{
		elementLocators();
		driver.findElement(By.id(layout.getProperty("region_edit_name"))).clear();
		driver.findElement(By.id(layout.getProperty("region_edit_name"))).sendKeys(newregionname);
		Assert.assertEquals(driver.getTitle(),layout.getProperty("region_edit_page_title"));
		//return regions edit page
		return new RegionsEditPage(driver);
	}	
	//update description in description field
	public RegionsEditPage updateDescription(String description)
	{
		elementLocators();
		driver.findElement(By.id(layout.getProperty("region_edit_description"))).clear();
		driver.findElement(By.id(layout.getProperty("region_edit_description"))).sendKeys(description);
		Assert.assertEquals(driver.getTitle(),layout.getProperty("region_edit_page_title"));
		//return regions edit page
		return new RegionsEditPage(driver);				
	}
	//activate and inactivate campaign
	public RegionsEditPage isActive(boolean answer)
	{  
		elementLocators();
		//no
		if(answer==false)
		{
			driver.findElement(By.xpath(layout.getProperty("region_edit_status_inactive"))).click();
			Assert.assertEquals(driver.getTitle(),layout.getProperty("region_edit_page_title"));
		}	
		//yes
		else if(answer==true)
		{
			driver.findElement(By.xpath(layout.getProperty("region_edit_status_active"))).click();
			Assert.assertEquals(driver.getTitle(),layout.getProperty("region_edit_page_title"));
		}
		else
		{
			throw new InvalidParameterException("answer "+answer+ " is not supported, ref automation doc workflow page.");
		}
		return new RegionsEditPage(driver);
	}
	//click submit button
	public RegionsPage clickSubmitButton()
	{
		elementLocators();
		driver.findElement(By.id(layout.getProperty("region_edit_submit"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),layout.getProperty("region_page_title"));
		//return regions edit page
		return new RegionsPage(driver);	
	}
	//click cancel button
	public RegionsEditPage clickCancelButton()
	{
		elementLocators();
		driver.findElement(By.xpath(layout.getProperty("region_edit_cancel"))).click();
		Assert.assertEquals(driver.getTitle(),layout.getProperty("region_page_title"));
		//return regions edit page
		return new RegionsEditPage(driver);	
	}
	//click save for failed
	public RegionsEditPage failToUpdate()
	{
		readconfig();
		driver.findElement(By.id(layout.getProperty("region_edit_submit"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),layout.getProperty("region_edit_page_title"));
		return new RegionsEditPage(driver);
	}
}