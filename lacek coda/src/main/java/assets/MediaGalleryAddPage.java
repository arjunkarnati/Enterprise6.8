package assets;

import java.security.InvalidParameterException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utility.PageBase;

public class MediaGalleryAddPage extends PageBase {

	public MediaGalleryAddPage(WebDriver driver) 
	{
		super(driver);		
	}
	//enter client name in client field
	public MediaGalleryAddPage addClientName(String clientname) 
	{
		readconfig();
		driver.findElement(By.id(assets.getProperty("med_gallery_add_client"))).click();
		driver.findElement(By.id(assets.getProperty("med_gallery_add_client_search_field"))).sendKeys(clientname);
		driver.findElement(By.id(assets.getProperty("med_gallery_add_client_search_field"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.id(assets.getProperty("med_gallery_add_client"))).getText().equalsIgnoreCase(clientname));
		Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_add_page_title"));
		//return media galerry add page
		return new MediaGalleryAddPage(driver);
	}
	//select a brand
	public MediaGalleryAddPage addBrand(String brandname)
	{
		readconfig();
		driver.findElement(By.xpath(assets.getProperty("med_gallery_add_brand"))).sendKeys(brandname);
		driver.findElement(By.xpath(assets.getProperty("med_gallery_add_brand"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(assets.getProperty("med_gallery_add_brand"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_add_page_title"));
		//return media gallery add page
		return new MediaGalleryAddPage(driver);
	}
	//select a program
	public MediaGalleryAddPage addProgram(String programname)
	{
		readconfig();
		driver.findElement(By.xpath(assets.getProperty("med_gallery_add_program"))).sendKeys(programname);
		driver.findElement(By.xpath(assets.getProperty("med_gallery_add_program"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(assets.getProperty("med_gallery_add_program"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_add_page_title"));
		//return media gallery add page
		return new MediaGalleryAddPage(driver);
	}
	//add connectors
	public MediaGalleryAddPage addConnector(String connectorname)
	{
		readconfig();
		driver.findElement(By.xpath(assets.getProperty("med_gallery_add_connector"))).sendKeys(connectorname);
		driver.findElement(By.xpath(assets.getProperty("med_gallery_add_connector"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(assets.getProperty("med_gallery_add_connector"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_add_page_title"));
		//return media gallery add page
		return new MediaGalleryAddPage(driver);
	}
	//click submit button in media gallery add page
	public MediaGalleryPage clickSubmitButton()
	{
		readconfig();
		driver.findElement(By.name(assets.getProperty("med_gallery_add_submit"))).click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_page_title"));
		//return media gallery page
		return new MediaGalleryPage(driver);
	}
	//click cancel button in media gallery add page
	public MediaGalleryPage clickCancelButton()
	{
		readconfig();
		driver.findElement(By.xpath(assets.getProperty("med_gallery_add_cancel"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_page_title"));
		//return media gallery  page
		return new MediaGalleryPage(driver);
	}
	//upload image
	public MediaGalleryAddPage addImage(String imagename) 
	{	
		readconfig();
		switch(imagename)
		{
		case "selenium01":
		{
			driver.findElement(By.id(assets.getProperty("med_gallery_add_file")))
			.sendKeys("C:\\Users\\arjun.karnati\\Pictures\\selenium01.png");
			//assert and verify
			Assert.assertTrue(driver.findElement(By.id(assets.getProperty("med_add_image_added"))).isDisplayed());
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_add_page_title"));
			break;
		}
		case "selenium02":
		{
			driver.findElement(By.id(assets.getProperty("med_gallery_add_file")))
			.sendKeys("C:\\Users\\arjun.karnati\\Pictures\\selenium02.png");
			//assert and verify
			//Assert.assertTrue(driver.findElement(By.id(assets.getProperty("med_add_image_added"))).isDisplayed());
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_add_page_title"));
			break;
		}
		case "selenium03":
		{
			driver.findElement(By.id(assets.getProperty("med_gallery_add_file")))
			.sendKeys("C:\\Users\\prince.kabuika\\Desktop\\Test\\Test Data\\images\\selenium03.jpg");
			//assert and verify
			Assert.assertTrue(driver.findElement(By.id(assets.getProperty("med_add_image_added"))).isDisplayed());
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_add_page_title"));
			break;
		}
		case "selenium04":
		{
			driver.findElement(By.id(assets.getProperty("med_gallery_add_file")))
			.sendKeys("C:\\Users\\prince.kabuika\\Desktop\\Test\\Test Data\\images\\selenium04.png");
			//assert and verify
			Assert.assertTrue(driver.findElement(By.id(assets.getProperty("med_add_image_added"))).isDisplayed());
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_add_page_title"));
			break;
		}
		case "selenium05":
		{
			driver.findElement(By.id(assets.getProperty("med_gallery_add_file")))
			.sendKeys("C:\\Users\\prince.kabuika\\Desktop\\Test\\Test Data\\images\\selenium05.png");
			//assert and verify
			Assert.assertTrue(driver.findElement(By.id(assets.getProperty("med_add_image_added"))).isDisplayed());
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_add_page_title"));
			break;
		}
		case "selenium06":
		{
			driver.findElement(By.id(assets.getProperty("med_gallery_add_file")))
			.sendKeys("C:\\Users\\prince.kabuika\\Desktop\\Test\\Test Data\\images\\selenium06.jpg");
			//assert and verify
			Assert.assertTrue(driver.findElement(By.id(assets.getProperty("med_add_image_added"))).isDisplayed());
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_add_page_title"));
			break;
		}
		case "selenium07":
		{
			driver.findElement(By.id(assets.getProperty("med_gallery_add_file")))
			.sendKeys("C:\\Users\\prince.kabuika\\Desktop\\Test\\Test Data\\images\\selenium07.jpg");
			//assert and verify
			Assert.assertTrue(driver.findElement(By.id(assets.getProperty("med_add_image_added"))).isDisplayed());
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_add_page_title"));
			break;
		}
		case "selenium08":
		{
			driver.findElement(By.id(assets.getProperty("med_gallery_add_file")))
			.sendKeys("C:\\Users\\prince.kabuika\\Desktop\\Test\\Test Data\\images\\selenium08.png");
			//assert and verify
			Assert.assertTrue(driver.findElement(By.id(assets.getProperty("med_add_image_added"))).isDisplayed());
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_add_page_title"));
			break;
		}
		case "selenium09":
		{
			driver.findElement(By.id(assets.getProperty("med_gallery_add_file")))
			.sendKeys("C:\\Users\\prince.kabuika\\Desktop\\Test\\Test Data\\images\\selenium09.jpg");
			//assert and verify
			Assert.assertTrue(driver.findElement(By.id(assets.getProperty("med_add_image_added"))).isDisplayed());
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_add_page_title"));
			break;
		}
		case "selenium10":
		{
			driver.findElement(By.id(assets.getProperty("med_gallery_add_file")))
			.sendKeys("C:\\Users\\prince.kabuika\\Desktop\\Test\\Test Data\\images\\selenium10.jpg");
			//assert and verify
			Assert.assertTrue(driver.findElement(By.id(assets.getProperty("med_add_image_added"))).isDisplayed());
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_add_page_title"));
			break;
		}
		case "selenium11":
		{
			driver.findElement(By.id(assets.getProperty("med_gallery_add_file")))
			.sendKeys("C:\\Users\\prince.kabuika\\Desktop\\Test\\Test Data\\images\\selenium11.jpg");
			//assert and verify
			Assert.assertTrue(driver.findElement(By.id(assets.getProperty("med_add_image_added"))).isDisplayed());
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_add_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("imagename "+imagename +" not found, please verify that the image exists in the path.");
		}
		}
		//assert and verify
		Assert.assertTrue(driver.findElement(By.id(assets.getProperty("med_add_image_added"))).isDisplayed());
		return new MediaGalleryAddPage(driver);
	}
	//click save for failed
	public MediaGalleryAddPage failToCreate()
	{
		readconfig();
		driver.findElement(By.id(assets.getProperty("med_gallery_add_submit"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_add_page_title"));
		return new MediaGalleryAddPage(driver);
	}
}