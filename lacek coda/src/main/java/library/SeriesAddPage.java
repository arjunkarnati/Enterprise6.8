package library;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utility.PageBase;

public class SeriesAddPage extends PageBase {

	//constructor
	public SeriesAddPage(WebDriver driver)
	{
		super(driver);		
	}
	//add client
	public SeriesAddPage addClientName(String clientname) 
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("series_add_client"))).click();
		driver.findElement(By.id(library.getProperty("series_add_client_search_field"))).sendKeys(clientname);
		driver.findElement(By.id(library.getProperty("series_add_client_search_field"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.findElement(By.id(library.getProperty("series_add_client"))).getText(),clientname);
		Assert.assertEquals(driver.getTitle(),library.getProperty("series_add_page_title"));
		//return series add page
		return new SeriesAddPage(driver);
	}
	//add name
	public SeriesAddPage addSeriesName(String seriesname)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("series_add_name"))).clear();
		driver.findElement(By.id(library.getProperty("series_add_name"))).sendKeys(seriesname);	
		Assert.assertEquals(driver.getTitle(),library.getProperty("series_add_page_title"));
		//return series add page
		return new SeriesAddPage(driver);
	}	
	//add description
	public SeriesAddPage addDescription(String description)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("series_add_description"))).clear();
		driver.findElement(By.id(library.getProperty("series_add_description"))).sendKeys(description);
		Assert.assertEquals(driver.getTitle(),library.getProperty("series_add_page_title"));
		//return series add page
		return new SeriesAddPage(driver);				
	}
	//select a brand
	public SeriesAddPage addBrand(String brandname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("series_add_brand"))).click();
		driver.findElement(By.xpath(library.getProperty("series_add_brand"))).sendKeys(brandname);
		driver.findElement(By.xpath(library.getProperty("series_add_brand"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertEquals(driver.getTitle(),library.getProperty("series_add_page_title"));
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("series_add_brand"))).isEnabled());
		//return series add page
		return new SeriesAddPage(driver);
	}
	//select a program
	public SeriesAddPage addProgram(String programname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("series_add_program"))).clear();
		driver.findElement(By.xpath(library.getProperty("series_add_program"))).sendKeys(programname);
		driver.findElement(By.xpath(library.getProperty("series_add_program"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertEquals(driver.getTitle(),library.getProperty("series_add_page_title"));
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("series_add_program"))).isEnabled());
		//return series add page
		return new SeriesAddPage(driver);
	}
	//select tracks
	public SeriesAddPage addTracks(String tracksname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("series_add_tracks"))).clear();
		driver.findElement(By.xpath(library.getProperty("series_add_tracks"))).sendKeys(tracksname);
		driver.findElement(By.xpath(library.getProperty("series_add_tracks"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertEquals(driver.getTitle(),library.getProperty("series_add_page_title"));
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("series_add_tracks"))).isEnabled());
		//return series add page
		return new SeriesAddPage(driver);
	}	
	//select a campaign	
	public SeriesAddPage addCampaign(String campaignname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("series_add_campaign"))).clear();
		driver.findElement(By.xpath(library.getProperty("series_add_campaign"))).sendKeys(campaignname);
		driver.findElement(By.xpath(library.getProperty("series_add_campaign"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertEquals(driver.getTitle(),library.getProperty("series_add_page_title"));
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("series_add_campaign"))).isEnabled());
		//return series add page
		return new SeriesAddPage(driver);
	}
	//click submit button in series add page
	public SeriesPage clickSubmitButton()
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("series_add_submit"))).click();
		Assert.assertEquals(driver.getTitle(),library.getProperty("series_page_title"));
		//return series page
		return new SeriesPage(driver);
	}
	//click cancel button in series add page
	public SeriesPage clickCancelButton()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("series_add_cancel"))).click();
		Assert.assertEquals(driver.getTitle(),library.getProperty("series_page_title"));
		//driver.switchTo().alert().accept();
		return new SeriesPage(driver);
	}
	//click save for failed
	public SeriesAddPage failToCreate()
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("series_add_submit"))).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("series_add_page_title"));
		return new SeriesAddPage(driver);
	}
}