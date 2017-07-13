package manage;

import java.security.InvalidParameterException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Utility.PageBase;

public class BrandsPage extends PageBase{

	public BrandsPage(WebDriver driver) 
	{
		super(driver);		
	}
	//open barands add page
	public BrandsAddPage clickAddBrandButton()
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("brand_add_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),manage.getProperty("brand_add_page_title"));
		//return brands add page
		return new BrandsAddPage(driver);
	}	
	//open brands archive page
	public BrandsArchivePage clickArchiveButton()
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("brand_archive_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),manage.getProperty("brand_archive_page_title"));
		//return brands page
		return new BrandsArchivePage(driver);
	}
	//edit a brand
	public BrandsEditPage editBrand(String brandname)
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("filter"))).clear();
		driver.findElement(By.xpath(manage.getProperty("filter"))).sendKeys(brandname);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch(brandname)
		{
		case "edit_brand_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_brand_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),manage.getProperty("brand_edit_page_title"));
			break;
		}
		case "edit_brand_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_brand_test_010"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),manage.getProperty("brand_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("brand "+brandname +" cannot be edited, ref automation doc brands page.");
		}
		}
		return new BrandsEditPage(driver);
	}
	//restore brand
	public BrandsArchivePage restoreBrand(String brandname)
	{
		readconfig();
		driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(brandname);
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		sleep();
		driver.findElement(By.xpath("html/body/div[6]/div/div/div[3]/button[1]| //button[@class='btn btn-success' and contains(text(),'Yes')]")).click();
		sleep();
		driver.findElement(By.id("reload")).click();
		sleep();		
		//assert ad verify	
		Assert.assertEquals(driver.getTitle(), manage.getProperty("brand_archive_page_title"));
		return new BrandsArchivePage(driver);
	}	
	//this method will be updated,(to permanent archive method)
	public BrandsPage archiveBrand(String brandname)
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("filter"))).clear();
		driver.findElement(By.xpath(manage.getProperty("filter"))).sendKeys(brandname);
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
		//switch to active element 
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "yes" 
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		return new BrandsPage(driver);			
	}
	//test validation
	public BrandsPage validateUpdates(String brandname,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("filter"))).clear();
		driver.findElement(By.xpath(manage.getProperty("filter"))).sendKeys(brandname);
		switch(column)
		{
		case"client":
		{
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(manage.getProperty("brand_client"))).getText(),expectedresult);
			break;
		}
		case"name":
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(manage.getProperty("brand_name"))).getText(),expectedresult);
			break;
		}
		case"code":
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(manage.getProperty("brand_code"))).getText(),expectedresult);
			break;
		}
		case"url":
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(manage.getProperty("brand_url"))).getText(),expectedresult);
			break;
		}
		case"status":
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(manage.getProperty("brand_status"))).getText(),expectedresult);
			break;
		}
		default :
		{
			throw new InvalidParameterException(column +" is not a column for locales page.");
		}
		}
		return new BrandsPage(driver);			
	}
}