package library;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utility.PageBase;




public class ContentcodeAddpage extends PageBase{
	
	
	public ContentcodeAddpage(WebDriver driver) 
	{
		super(driver);
	}

	public ContentcodeAddpage clickAddcontentbutton() {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(library.getProperty("content_add"))).click();
		try{
			Thread.sleep(1500);
			
		}catch (InterruptedException e){
		e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("contentcode_page_add_title"));
		
		return new ContentcodeAddpage(driver);
		
	}

	public ContentcodeAddpage selectClient(String clientname) {
		
		readconfig();
		driver.findElement(By.xpath(library.getProperty("content_client"))).click();
		driver.findElement(By.xpath(library.getProperty("content_search_client"))).sendKeys(clientname);
		driver.findElement(By.xpath(library.getProperty("content_search_client"))).sendKeys(Keys.ENTER);		
		
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("content_client"))).getText().equalsIgnoreCase(clientname));
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("contentcode_page_add_title"));
		return new ContentcodeAddpage(driver);
		// TODO Auto-generated method stub
		
	}

	public ContentcodeAddpage selectType(String typename) {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(library.getProperty("content_type"))).click();
		driver.findElement(By.xpath(library.getProperty("content_type_search"))).sendKeys(typename);
		driver.findElement(By.xpath(library.getProperty("content_type_search"))).sendKeys(Keys.ENTER);
		
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("content_type"))).getText().equalsIgnoreCase(typename));
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("contentcode_page_add_title"));
		
		return new ContentcodeAddpage(driver);
		
	}

	public ContentcodeAddpage  addCode(String codename) {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(library.getProperty("content_code"))).click();
		driver.findElement(By.xpath(library.getProperty("content_code"))).sendKeys(codename);
		
		return new ContentcodeAddpage(driver);
	}

	public ContentcodeAddpage addDescription(String description) {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(library.getProperty("content_description"))).click();
		driver.findElement(By.xpath(library.getProperty("content_description"))).sendKeys(description);
		
		return new ContentcodeAddpage(driver);
	}



	public ContentcodeAddpage clicksubmitbuttom() {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.id(library.getProperty("content_submit"))).click();
		try{
			Thread.sleep(1500);
		}catch (InterruptedException e) {

			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(), elementslocator.getProperty("contentcode_page_title"));
		
	   driver.findElement(By.id(library.getProperty("content_reload_button"))).click();
	   return new ContentcodeAddpage(driver);
	}
	
	
	
	
	
	
	}
	
	
	
	

