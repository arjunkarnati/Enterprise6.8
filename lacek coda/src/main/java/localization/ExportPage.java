package localization;

import java.security.InvalidParameterException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import Utility.PageBase;

public class ExportPage extends PageBase {

	public ExportPage(WebDriver driver)
	{
		super(driver);
	}
	//add client
	public ExportPage addClient(String clientname)
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("export_client"))).click();
		driver.findElement(By.id(elementslocator.getProperty("export_client_search_field"))).sendKeys(clientname);
		driver.findElement(By.id(elementslocator.getProperty("export_client_search_field"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(	driver.findElement(By.id(elementslocator.getProperty("export_client"))).getText(),clientname);
		return new ExportPage(driver);
	}
	//add campaign
	public ExportPage addCampaign(String campaignname)
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("export_campaign"))).sendKeys(campaignname);
		driver.findElement(By.id(elementslocator.getProperty("export_campaign"))).sendKeys(Keys.ENTER);
		//Assert.assertTrue(driver.findElement(By.id(elementslocator.getProperty("export_campaign_number"))).isDisplayed());
		return new ExportPage(driver);
	}
	//add series
	public ExportPage addSeries(String seriesname)
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("export_series"))).sendKeys(seriesname);
		driver.findElement(By.id(elementslocator.getProperty("export_series"))).sendKeys(Keys.ENTER);
		//Assert.assertTrue(driver.findElement(By.id(elementslocator.getProperty("export_series_number"))).isDisplayed());
		return new ExportPage(driver);
	}
	//add track
	public ExportPage addTrack(String trackname)
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("export_track"))).sendKeys(trackname);
		driver.findElement(By.id(elementslocator.getProperty("export_track"))).sendKeys(Keys.ENTER);
		//Assert.assertTrue(driver.findElement(By.id(elementslocator.getProperty("export_track_number"))).isDisplayed());
		return new ExportPage(driver);
	}
	//add communication
	public ExportPage addCommunication(String communicationname)
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("export_communication"))).sendKeys(communicationname);
		driver.findElement(By.id(elementslocator.getProperty("export_communication"))).sendKeys(Keys.ENTER);
		//Assert.assertTrue(driver.findElement(By.id(elementslocator.getProperty("export_communication_number"))).isDisplayed());
		return new ExportPage(driver);
	}
	//add message
	public ExportPage addMessage(String messagename)
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("export_message"))).sendKeys(messagename);
		driver.findElement(By.id(elementslocator.getProperty("export_message"))).sendKeys(Keys.ENTER);
		//Assert.assertTrue(driver.findElement(By.id(elementslocator.getProperty("export_message_number"))).isDisplayed());
		return new ExportPage(driver);
	}
	//add media gallery
	public ExportPage addMediaGallery(String medgalleryname)
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("export_media_gallery"))).sendKeys(medgalleryname);
		driver.findElement(By.id(elementslocator.getProperty("export_media_gallery"))).sendKeys(Keys.ENTER);
		//Assert.assertTrue(driver.findElement(By.id(elementslocator.getProperty("export_media_gallery_number"))).isDisplayed());
		return new ExportPage(driver);
	}
	//select format
	public ExportPage selectFormat(String formatname)
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("export_export_format"))).click();
		driver.findElement(By.id(elementslocator.getProperty("export_export_format_search_field"))).sendKeys(formatname);
		driver.findElement(By.id(elementslocator.getProperty("export_export_format_search_field"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.findElement(By.id(elementslocator.getProperty("export_export_format"))).getText(),formatname);
		return new ExportPage(driver);
	}
	//click export button
	public ExportPage clickExport()
	{	
		readconfig();
		WebElement ele = driver.findElement(By.xpath(elementslocator.getProperty("export_export_button")));
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ExportPage(driver);
	}
	//fail to export
	public ExportPage failToExport()
	{	
		readconfig();
		WebElement ele = driver.findElement(By.xpath(elementslocator.getProperty("export_export_button")));
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("localization_export_page_title"));
		return new ExportPage(driver);
	}
	//field is disable when no client is selected
	public ExportPage isDisabled(String fieldname)
	{	
		readconfig();
		switch(fieldname)
		{
		case"campaign":
		{
			Assert.assertFalse(driver.findElement(By.id(elementslocator.getProperty("export_campaign"))).isEnabled(),"field is disabled");
			break;
		}
		case"series":
		{
			Assert.assertFalse(driver.findElement(By.id(elementslocator.getProperty("export_series"))).isEnabled(),"field is disabled");
			break;
		}
		case"track":
		{
			Assert.assertFalse(driver.findElement(By.id(elementslocator.getProperty("export_track"))).isEnabled(),"field is disabled");
			break;
		}
		case"communication":
		{
			Assert.assertFalse(driver.findElement(By.id(elementslocator.getProperty("export_communication"))).isEnabled(),"field is disabled");
			break;
		}
		case"message":
		{
			Assert.assertFalse(driver.findElement(By.id(elementslocator.getProperty("export_message"))).isEnabled(),"field is disabled");
			break;
		}
		case"media gallery":
		{
			Assert.assertFalse(driver.findElement(By.id(elementslocator.getProperty("export_media_gallery"))).isEnabled(),"field is disabled");
			break;
		}
		default :
		{
			throw new InvalidParameterException(fieldname +" is not a valid field to export. ref automation doc localization export page");
		}
		}
		return new ExportPage(driver);
	}
}