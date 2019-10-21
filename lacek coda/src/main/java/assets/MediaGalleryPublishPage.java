package assets;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MediaGalleryPublishPage extends PageBase {

	public MediaGalleryPublishPage(WebDriver driver) 
	{
		super(driver);
	}
	//select every checkboxes
	public MediaGalleryPublishPage checkAll()
	{
		readconfig();
		java.util.List<WebElement> els = driver.findElements(By.xpath(assets.getProperty("med_gallery_publish_checkboxes")));
		for ( WebElement el : els ) 
		{
			if ( !el.isSelected()) 
			{
				el.click();
			}
			//Assert.assertTrue(el.isSelected());	
		}
		return new MediaGalleryPublishPage(driver);
	}
	//click publish
	public MediaGalleryPage  clickPublisButton()
	{
		readconfig();
		driver.findElement(By.id(assets.getProperty("med_gallery_publish_button"))).click();
		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Switch to active element model dialogue box.
		driver.switchTo().activeElement();
		// find the button which contains text "submit" 
		driver.findElement(By.xpath(assets.getProperty("med_gallery_publish_submit_buton"))).click();
		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//assert and verify
		//Assert.assertTrue(driver.getTitle().equalsIgnoreCase(assets.getProperty("med_gallery_publish_page_title")));
		return new MediaGalleryPage(driver);
	}
	//click cancel
	public MediaGalleryPage clickCancelButton()
	{
		readconfig();
		driver.findElement(By.xpath(assets.getProperty("med_gallery_publish_cancel_button"))).click();
		//assert and verify
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(assets.getProperty("med_gallery_page_title")));
		return new MediaGalleryPage(driver);
	}
}