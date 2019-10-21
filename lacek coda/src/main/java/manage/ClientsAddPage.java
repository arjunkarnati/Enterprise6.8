package manage;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ClientsAddPage extends PageBase {

	public ClientsAddPage(WebDriver driver) 
	{
		super(driver);	
	}
	//add  client name
	public ClientsAddPage addName(String name)
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("client_add_name"))).clear();
		driver.findElement(By.id(manage.getProperty("client_add_name"))).sendKeys(name);
		Assert.assertEquals(driver.getTitle(),manage.getProperty("client_add_page_title"));
		return new ClientsAddPage(driver);
	}
	//add  client code
	public ClientsAddPage addCode(String code)
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("client_add_code"))).clear();
		driver.findElement(By.id(manage.getProperty("client_add_code"))).sendKeys(code);
		Assert.assertEquals(driver.getTitle(),manage.getProperty("client_add_page_title"));
		return new ClientsAddPage(driver);
	}
	//add  color 
	public ClientsAddPage addColor(String colorvalue)
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("client_add_color"))).clear();
		driver.findElement(By.id(manage.getProperty("client_add_color"))).sendKeys(colorvalue);
		Assert.assertEquals(driver.getTitle(),manage.getProperty("client_add_page_title"));
		return new ClientsAddPage(driver);
	}
	//add  url 
	public ClientsAddPage addUrl(String url)
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("client_add_url"))).clear();
		driver.findElement(By.id(manage.getProperty("client_add_url"))).sendKeys(url);
		Assert.assertEquals(driver.getTitle(),manage.getProperty("client_add_page_title"));
		return new ClientsAddPage(driver);
	}
	//add locales 
	public ClientsAddPage addLocales(String locales)
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("client_add_locales"))).clear();
		driver.findElement(By.id(manage.getProperty("client_add_locales"))).sendKeys(locales);
		driver.findElement(By.id(manage.getProperty("client_add_locales"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(),manage.getProperty("client_add_page_title"));
		return new ClientsAddPage(driver);
	}	
	//add default locales 
	/*important to remember when creating testscript, index number will chnage based on how the test data is created in coda clients add page*/
	public ClientsAddPage addDefaultLocales(int indexnumber)
	{
		readconfig();
		Select defaultlocales = new Select(driver.findElement(By.id(manage.getProperty("client_add_default_locales"))));
		defaultlocales.selectByIndex(indexnumber);
		return new ClientsAddPage(driver);
	}
	//click cancel
	public ClientsPage clickCancel()
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("client_add_cancel"))).click();
		//driver.switchTo().alert().accept();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),manage.getProperty("client_page_title"));
		return new ClientsPage(driver);
	}
	//click submit
	public ClientsPage clickSubmit()
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("client_add_submit"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//assert and verify
		Assert.assertEquals(driver.getTitle(),manage.getProperty("client_page_title"));
		return new ClientsPage(driver);
	}
	//click save for failed
	public ClientsAddPage failToCreate()
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("client_add_submit"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),manage.getProperty("client_add_page_title"));
		return new ClientsAddPage(driver);
	}
}