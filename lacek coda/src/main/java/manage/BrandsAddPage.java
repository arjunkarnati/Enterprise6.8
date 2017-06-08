package manage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utility.PageBase;

public class BrandsAddPage extends PageBase {

	public BrandsAddPage(WebDriver driver) 
	{
		super(driver);
	}
	//add  clientname
	public BrandsAddPage addClientName(String clientname)
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("brand_add_client"))).click();
		driver.findElement(By.id(manage.getProperty("brand_add_client_search_field"))).sendKeys(clientname);
		driver.findElement(By.id(manage.getProperty("brand_add_client_search_field"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(),manage.getProperty("brand_add_page_title"));
		return new BrandsAddPage(driver);
	}
	//add  brand name 
	public BrandsAddPage addBrandName(String brandname)
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("brand_add_name"))).clear();
		driver.findElement(By.id(manage.getProperty("brand_add_name"))).sendKeys(brandname);
		Assert.assertEquals(driver.getTitle(),manage.getProperty("brand_add_page_title"));
		return new BrandsAddPage(driver);
	}
	//add  brand name 
	public BrandsAddPage addBrandCode(String brandname)
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("brand_add_code"))).clear();
		driver.findElement(By.id(manage.getProperty("brand_add_code"))).sendKeys(brandname);
		Assert.assertEquals(driver.getTitle(),manage.getProperty("brand_add_page_title"));
		return new BrandsAddPage(driver);
	}
	//add  color 
	public BrandsAddPage addColor(String colorvalue)
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("brand_add_color"))).clear();
		driver.findElement(By.id(manage.getProperty("brand_add_color"))).sendKeys(colorvalue);
		Assert.assertEquals(driver.getTitle(),manage.getProperty("brand_add_page_title"));
		return new BrandsAddPage(driver);
	}
	//add  url 
	public BrandsAddPage addUrl(String url)
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("brand_add_url"))).clear();
		driver.findElement(By.id(manage.getProperty("brand_add_url"))).sendKeys(url);
		Assert.assertEquals(driver.getTitle(),manage.getProperty("brand_add_page_title"));
		return new BrandsAddPage(driver);
	}
	//click cancel
	public BrandsAddPage clickCancel()
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("brand_add_cancel"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//assert and verify
		Assert.assertEquals(driver.getTitle(),manage.getProperty("brand_page_title"));
		return new BrandsAddPage(driver);
	}
	//click submit
	public BrandsPage clickSubmit()
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("brand_add_submit"))).click();
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
	public BrandsAddPage failToCreate()
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("brand_add_submit"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),manage.getProperty("brand_add_page_title"));
		return new BrandsAddPage(driver);
	}
}