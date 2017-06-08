package manage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utility.PageBase;

public class ProgramsAddPage extends PageBase {

	public ProgramsAddPage(WebDriver driver) 
	{
		super(driver);
	}
	//add  clientname
	public ProgramsAddPage addClientName(String clientname)
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("program_add_client"))).click();
		driver.findElement(By.id(manage.getProperty("program_add_client_search_field"))).sendKeys(clientname);
		driver.findElement(By.id(manage.getProperty("program_add_client_search_field"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertEquals(driver.findElement(By.id(manage.getProperty("program_add_client"))).getText(),clientname);
		Assert.assertEquals(driver.getTitle(), manage.getProperty("program_add_page_title"));
		return new ProgramsAddPage(driver);
	}
	//add  brand
	public ProgramsAddPage addBrand(String brandname)
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("program_add_brand"))).click();
		driver.findElement(By.xpath(manage.getProperty("program_add_brand"))).sendKeys(brandname);
		driver.findElement(By.xpath(manage.getProperty("program_add_brand"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertEquals(driver.getTitle(), manage.getProperty("program_add_page_title"));
		return new ProgramsAddPage(driver);
	}
	//add  program name
	public ProgramsAddPage addProgramName(String programname)
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("program_add_name"))).clear();
		driver.findElement(By.id(manage.getProperty("program_add_name"))).sendKeys(programname);
		Assert.assertEquals(driver.getTitle(), manage.getProperty("program_add_page_title"));
		return new ProgramsAddPage(driver);
	}
	//add  url 
	public ProgramsAddPage addUrl(String url)
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("program_add_url"))).clear();
		driver.findElement(By.id(manage.getProperty("program_add_url"))).sendKeys(url);
		Assert.assertEquals(driver.getTitle(), manage.getProperty("program_add_page_title"));
		return new ProgramsAddPage(driver);
	}
	//add  description 
	public ProgramsAddPage addDescription(String description)
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("program_add_description"))).clear();
		driver.findElement(By.id(manage.getProperty("program_add_description"))).sendKeys(description);
		Assert.assertEquals(driver.getTitle(), manage.getProperty("program_add_page_title"));
		return new ProgramsAddPage(driver);
	}
	//click cancel
	public ProgramsPage clickCancel()
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("program_add_cancel"))).click();
		//driver.switchTo().alert().accept();
		//assert and verify
		Assert.assertEquals(driver.getTitle(), manage.getProperty("program_page_title"));
		return new ProgramsPage(driver);
	}
	//click submit
	public ProgramsPage clickSubmit()
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("program_add_submit"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//assert and verify
		Assert.assertEquals(driver.getTitle(), manage.getProperty("program_page_title"));
		return new ProgramsPage(driver);
	}
	//click save for failed
	public ProgramsAddPage failToCreate()
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("program_add_submit"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),manage.getProperty("program_add_page_title"));
		return new ProgramsAddPage(driver);
	}
}