package manage;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BrandsEditPage extends PageBase {

	public BrandsEditPage(WebDriver driver) 
	{
		super(driver);
	}
	//update clientname
	public BrandsEditPage updateClientNameTo(String newclientname)
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("brand_edit_client"))).click();
		driver.findElement(By.id(manage.getProperty("brand_edit_client_search_field"))).sendKeys(newclientname);
		driver.findElement(By.id(manage.getProperty("brand_edit_client_search_field"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertEquals(driver.findElement(By.id(manage.getProperty("brand_edit_client"))).getText(),newclientname);
		Assert.assertEquals(driver.getTitle(),manage.getProperty("brand_edit_page_title"));
		return new BrandsEditPage(driver);
	}
	//update  Brand name
	public BrandsEditPage updateNameTo(String newbrandname)
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("brand_edit_name"))).clear();
		driver.findElement(By.id(manage.getProperty("brand_edit_name"))).sendKeys(newbrandname);
		Assert.assertEquals(driver.getTitle(),manage.getProperty("brand_edit_page_title"));
		return new BrandsEditPage(driver);
	}
	//delete Brand name
	public BrandsEditPage deleteName()
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("brand_edit_name"))).clear();
		Assert.assertEquals(driver.getTitle(),manage.getProperty("brand_edit_page_title"));
		return new BrandsEditPage(driver);
	}
	//update  color 
	public BrandsEditPage updateColorTo(String newcolorvalue)
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("brand_edit_color"))).clear();
		driver.findElement(By.id(manage.getProperty("brand_edit_color"))).sendKeys(newcolorvalue);
		Assert.assertEquals(driver.getTitle(),manage.getProperty("brand_edit_page_title"));
		return new BrandsEditPage(driver);
	}
	//delete color
	public BrandsEditPage deleteColor()
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("brand_edit_color"))).clear();
		Assert.assertEquals(driver.getTitle(),manage.getProperty("brand_edit_page_title"));
		return new BrandsEditPage(driver);
	}
	//update  url 
	public BrandsEditPage updateUrlTo(String newurl)
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("brand_edit_url"))).clear();
		driver.findElement(By.id(manage.getProperty("brand_edit_url"))).sendKeys(newurl);
		Assert.assertEquals(driver.getTitle(),manage.getProperty("brand_edit_page_title"));
		return new BrandsEditPage(driver);
	}
	//delete color
	public BrandsEditPage deleteUrl()
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("brand_edit_url"))).clear();
		Assert.assertEquals(driver.getTitle(),manage.getProperty("brand_edit_page_title"));
		return new BrandsEditPage(driver);
	}
	//inactivate brand
	public BrandsEditPage activateBrand()
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("brand_edit_activate"))).click();
		Assert.assertEquals(driver.getTitle(),manage.getProperty("brand_edit_page_title"));
		return new BrandsEditPage(driver);
	}
	//inactivate brand
	public BrandsEditPage inactivateBrand()
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("brand_edit_inactivate"))).click();
		Assert.assertEquals(driver.getTitle(),manage.getProperty("brand_edit_page_title"));
		return new BrandsEditPage(driver);
	}
	//click cancel
	public BrandsEditPage clickCancel()
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("brand_edit_cancel"))).click();
		//driver.switchTo().alert().accept();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),manage.getProperty("brand_page_title"));
		return new BrandsEditPage(driver);
	}
	//click submit
	public BrandsPage clickSubmit()
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("brand_edit_submit"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//assert and verify
		Assert.assertEquals(driver.getTitle(),manage.getProperty("brand_page_title"));
		return new BrandsPage(driver);
	}
	//click save for failed
	public BrandsAddPage failToUpdate()
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("brand_edit_submit"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),manage.getProperty("brand_edit_page_title"));
		return new BrandsAddPage(driver);
	}
}