package layout;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.security.InvalidParameterException;

public class RegionsPage extends PageBase{

	public RegionsPage(WebDriver driver)

	{
		super(driver);		
	}
	//open regions add page
	public RegionsAddPage clickAddRegionButton()
	{
		readconfig();
		driver.findElement(By.xpath(layout.getProperty("region_add_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),layout.getProperty("region_add_page_title"));
		//return region add page
		return new RegionsAddPage(driver);
	}
	//open regions archive page
	public RegionsArchivePage clickArchiveButton()
	{
		readconfig();
		driver.findElement(By.xpath(layout.getProperty("region_archive_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),layout.getProperty("region_archive_page_title"));
		//return regions archive page
		return new RegionsArchivePage(driver);
	}
	//edit a region
	public RegionsEditPage editRegion(String regionname)
	{
		readconfig();
		driver.findElement(By.xpath(layout.getProperty("filter"))).clear();
		driver.findElement(By.xpath(layout.getProperty("filter"))).sendKeys(regionname);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch(regionname)
		{
		case "edit_region_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_region_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),layout.getProperty("region_edit_page_title"));
			break;
		}
		case "edit_region_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_region_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),layout.getProperty("region_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("region "+regionname +" cannot be edited, ref automation doc region page.");
		}
		}
		return new RegionsEditPage(driver);
	}
	//restore region
	public RegionsPage  restoreRegion(String regionname)
	{
		readconfig();
		driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(regionname);
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		sleep();
		driver.findElement(By.xpath("html/body/div[7]/div/div/div[3]/button[1]")).click();
		sleep();
		driver.findElement(By.id("reload")).click();
		sleep();		
		//assert ad verify	
		Assert.assertEquals(driver.getTitle(), layout.getProperty("region_archive_page_title"));
		return new RegionsPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public RegionsPage archiveRegion(String regionname)
	{
		readconfig();
		driver.findElement(By.xpath(layout.getProperty("filter"))).clear();
		driver.findElement(By.xpath(layout.getProperty("filter"))).sendKeys(regionname);
		//select all check boxes
		java.util.List<WebElement> els = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for ( WebElement el : els ) 
		{
			if ( !el.isSelected()) 
			{
				el.click();
			}
			Assert.assertTrue(el.isSelected());
		}
		driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//switch to active element 
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "yes" 
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		return new RegionsPage(driver);			
	}
	//test validation
	public RegionsPage validateUpdates(String regionname,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(layout.getProperty("filter"))).clear();
		driver.findElement(By.xpath(layout.getProperty("filter"))).sendKeys(regionname);
		switch(column)
		{
		case"name":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(layout.getProperty("region_name"))).getText(),expectedresult);
			break;
		}		
		case"status":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(layout.getProperty("region_status"))).getText(),expectedresult);
			break;
		}
		default :
		{
			throw new InvalidParameterException(column +" is not a column for locales page.");
		}
		}
		return new RegionsPage(driver);			
	}
}