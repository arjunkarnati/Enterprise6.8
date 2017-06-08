package assets;

import java.security.InvalidParameterException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import Utility.PageBase;
import library.MessagesEditPage;
import library.MessagesPage;

public class MediaGalleryPage extends PageBase{

	public MediaGalleryPage(WebDriver driver) 
	{
		super(driver);		
	}
	//open media gallery add page
	public MediaGalleryAddPage clickAddMediaGalleryButton()
	{
		readconfig();
		driver.findElement(By.xpath(assets.getProperty("med_gallery_add_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_add_page_title"));
		//return media gallery add page
		return new MediaGalleryAddPage(driver);
	}	
	//open media gallery archive page
	public MediaGalleryArchivePage clickArchiveButton()
	{
		readconfig();
		driver.findElement(By.xpath(assets.getProperty("med_gallery_archive_button"))).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("med_gallery_archive_page_title"));
		//return media gallery archive page
		return new MediaGalleryArchivePage(driver);
	}
	//edit a media gallery
	public MediaGalleryEditPage editMediaGallery(String imagename)
	{
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		readconfig();
		driver.findElement(By.xpath(assets.getProperty("filter"))).clear();
		driver.findElement(By.xpath(assets.getProperty("filter"))).sendKeys(imagename);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch(imagename)
		{
		case "Primary - CTA FPO":
		{
			driver.findElement(By.xpath("//i[@class='fa fa-pencil-square-o']")).click();
			break;
		}
		case "ERAC PRM SHU 307717151 FRFR R2.jpg":
		{
			driver.findElement(By.xpath("//i[@class='fa fa-pencil-square-o']")).click();
			break;
		}
		case "edit_image_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_image_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_edit_page_title"));
			break;
		}
		case "edit_image_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_image_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_edit_page_title"));
			break;
		}
		case "edit_ehi_test_01":
		{
			driver.findElement(By.xpath(assets.getProperty("edit_ehi_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("media gallery  "+imagename +" cannot be edited, ref automation doc series page.");
		}
		}
		return new MediaGalleryEditPage(driver);
	}
	//publish media gallery
	public MediaGalleryPublishPage publishMediaGallery(String imagename)
	{
		readconfig();
		driver.findElement(By.xpath(assets.getProperty("filter"))).clear();
		driver.findElement(By.xpath(assets.getProperty("filter"))).sendKeys(imagename);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch(imagename)
		{
		case "publish_image_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("publish_image_test_01"))).click();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_publish_page_title"));
			break;
		}
		case "opt-out":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("publish_image_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_publish_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("media gallery "+imagename +" cannot be published, ref automation doc series page.");
		}
		}
		return new MediaGalleryPublishPage(driver);
	}

	//restore media gallery
	public MediaGalleryPage restoreMediaGallery(String imagename)
	{
		readconfig();
		driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(imagename);
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		sleep();
		driver.findElement(By.xpath("html/body/div[7]/div/div/div[3]/button[1]")).click();
		sleep();
		driver.findElement(By.id("reload")).click();
		sleep();		
		//assert ad verify	
		Assert.assertEquals(driver.getTitle(), assets.getProperty("med_gallery_archive_page_title"));
		return new MediaGalleryPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public MediaGalleryPage archiveMediagallery(String mediagalleryname)
	{
		readconfig();
		driver.findElement(By.xpath(assets.getProperty("filter"))).clear();
		driver.findElement(By.xpath(assets.getProperty("filter"))).sendKeys(mediagalleryname);
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
		WebElement ele = driver.findElement(By.xpath("//i[@class='fa fa-trash-o']"));	
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();
		//switch to active element 
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "yes" 
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(), assets.getProperty("med_gallery_page_title"));
		return new MediaGalleryPage(driver);			
	}
	//test validation
	public MediaGalleryPage validateUpdates(String medgalleryname,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(assets.getProperty("filter"))).clear();
		driver.findElement(By.xpath(assets.getProperty("filter"))).sendKeys(medgalleryname);
		switch(column)
		{
		case"client":
		{
			Assert.assertEquals(driver.findElement(By.xpath(assets.getProperty("med_gallery_client"))).getText(),expectedresult);
			break;
		}
		case"brand":
		{
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(assets.getProperty("med_gallery_brand"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(assets.getProperty("med_gallery_brand")));
			java.util.Iterator<WebElement> name = iname.iterator();
			while(name.hasNext()) 
			{
				WebElement row = name.next();
				System.out.println("**Brand: "+row.getText());
			} 
			//assert and verify
			Assert.assertEquals(expectedresult,String.valueOf(iCount));
			break;
		}
		case"program":
		{
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(assets.getProperty("med_gallery_program"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(assets.getProperty("med_gallery_program")));
			java.util.Iterator<WebElement> name = iname.iterator();
			while(name.hasNext()) 
			{
				WebElement row = name.next();
				System.out.println("**program: "+row.getText());
			} 
			//assert and verify
			Assert.assertEquals(expectedresult,String.valueOf(iCount));
			break;
		}
		case"name":
		{
			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Assert.assertEquals(driver.findElement(By.xpath(assets.getProperty("med_gallery_name"))).getText(),expectedresult);
			break;
		}
		case"alt-tag":
		{
			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Assert.assertEquals(driver.findElement(By.xpath(assets.getProperty("med_gallery_alt_tag"))).getText(),expectedresult);
			break;
		}
		case"status":
		{
			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Assert.assertEquals(driver.findElement(By.xpath(assets.getProperty("med_gallery_status"))).getText(),expectedresult);
			break;
		}
		case"workflow":
		{
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(assets.getProperty("med_gallery_workflow"))).getText(),expectedresult);
			break;
		}
		case"manage":
		{
			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Assert.assertEquals(driver.findElement(By.xpath(assets.getProperty("med_gallery_workflow"))).getText(),expectedresult);
			break;
		}
		
		default :
		{
			throw new InvalidParameterException(column +" is not a column for locales page.");
		}
		}
		return new MediaGalleryPage(driver);			
	}
	public MediaGalleryPage clickMessagesLink() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("library"))).click();
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("messages"))));
		driver.findElement(By.xpath(elementslocator.getProperty("messages"))).click();
		waitForAjax(driver);
		//assert that system naviagtes in messages page
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("mess_page_title"));
		return new MediaGalleryPage(driver);
	}
	public MediaGalleryPage editMessage(String messagename)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(messagename);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch(messagename)
		{
		case "edit_message_test_01":
		{
		//	driver.findElement(By.xpath("//i[@class='fa fa-cloud-upload']")).click();
			WebElement ele =	driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[18]/div/a/i"));

			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ele);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		//	Assert.assertEquals(driver.getTitle(),library.getProperty("mess_edit_page_title"));
			break;
		}
		}	
		return new MediaGalleryPage(driver);
	}
	public MediaGalleryPage checkmissingconnector() {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath(".//*[@id='message-datatable']/tbody/tr[1]/td[10]"));
		return new MediaGalleryPage(driver);
	}
	
	public MediaGalleryPage manageworkflow(String workflowname, String mediagalleryname) 
	{
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(assets.getProperty("filter"))).clear();
		driver.findElement(By.xpath(assets.getProperty("filter"))).sendKeys(mediagalleryname);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch(mediagalleryname)
		{
		case "edit_image_test_01":
		{
			driver.findElement(By.xpath(assets.getProperty("med_gallery_manage_workflow"))).click();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.findElement(By.xpath(assets.getProperty("med_gallery_workflow_edit_manage_workflow"))).sendKeys("D");
			driver.findElement(By.id(assets.getProperty("med_gallery_edit_submit"))).click();
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_page_title"));
			break;
		}
		case "APPROVED":
		{
			driver.findElement(By.id(assets.getProperty("med_gallery_edit_workflow"))).sendKeys("A");
			driver.findElement(By.id(assets.getProperty("med_gallery_edit_submit"))).click();
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_page_title"));
			break;
		}
	default: 
	{
		throw new InvalidParameterException("Please verify the workflow name");
	}
	}
	return new MediaGalleryPage(driver);
	}
		
	
	
	
	
	
	
	
	
}