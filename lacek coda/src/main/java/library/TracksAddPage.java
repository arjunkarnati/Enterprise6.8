package library;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.security.InvalidParameterException;

public class TracksAddPage extends PageBase{

	public TracksAddPage(WebDriver driver) 
	{
		super(driver);		
	}
	//enter client name in client field
	public TracksAddPage addClientName(String clientname)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("tracks_add_client"))).click();
		driver.findElement(By.id(library.getProperty("tracks_add_client_search_field"))).sendKeys(clientname);
		driver.findElement(By.id(library.getProperty("tracks_add_client_search_field"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.id(library.getProperty("tracks_add_client"))).getText().equalsIgnoreCase(clientname));
		Assert.assertEquals(driver.getTitle(),library.getProperty("tracks_add_page_title"));
		//return tracks add page
		return new TracksAddPage(driver);
	}
	//select a brand
	public TracksAddPage addBrand(String brandname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("tracks_add_brand"))).sendKeys(brandname);
		driver.findElement(By.xpath(library.getProperty("tracks_add_brand"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("tracks_add_brand"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("tracks_add_page_title"));
		//return tracks add page
		return new TracksAddPage(driver);
	}
	//select a program
	public TracksAddPage addProgram(String programname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("tracks_add_program"))).sendKeys(programname);
		driver.findElement(By.xpath(library.getProperty("tracks_add_program"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("tracks_add_program"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("tracks_add_page_title"));
		//return tracks add page
		return new TracksAddPage(driver);
	}
	//select a series
	public TracksAddPage addSeries(String seriesname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("tracks_add_series"))).sendKeys(seriesname);
		driver.findElement(By.xpath(library.getProperty("tracks_add_series"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("tracks_add_series"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("tracks_add_page_title"));
		//return tracks add page
		return new TracksAddPage(driver);
	}
	//enter tracks name in name field
	public TracksAddPage addTracksName(String tracksname)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("tracks_add_name"))).clear();
		driver.findElement(By.id(library.getProperty("tracks_add_name"))).sendKeys(tracksname);	
		Assert.assertEquals(driver.getTitle(),library.getProperty("tracks_add_page_title"));
		//return tracks add page
		return new TracksAddPage(driver);
	}	
	//enter description in description field
	public TracksAddPage addDescription(String description)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("tracks_add_description"))).clear();
		driver.findElement(By.id(library.getProperty("tracks_add_description"))).sendKeys(description);
		Assert.assertEquals(driver.getTitle(),library.getProperty("tracks_add_page_title"));
		//return tracks add page
		return new TracksAddPage(driver);				
	}
	//click submit button in series add page
	public TracksPage clickSubmitButton()
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("tracks_add_submit"))).click();
		Assert.assertEquals(driver.getTitle(),library.getProperty("tracks_page_title"));
		//return tracks page
		return new TracksPage(driver);
	}
	//click cancel button in series add page
	public TracksPage clickCancelButton()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("tracks_add_cancel"))).click();
		Assert.assertEquals(driver.getTitle(),library.getProperty("tracks_page_title"));
		//driver.switchTo().alert().accept();
		return new TracksPage(driver);
	}
	//click save for failed
	public TracksAddPage failToCreate()
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("tracks_add_submit"))).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("tracks_add_page_title"));
		return new TracksAddPage(driver);
	}
	//add communication
	public TracksAddPage addCommunication(String communicationname)
	{
		readconfig();
		switch(communicationname)
		{
		case"16054CCLLIVESAMHUNT20160815":
			driver.findElement(By.xpath(library.getProperty("filter"))).clear();
			driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(communicationname);
			driver.findElement(By.xpath(test_data_reader.getProperty("tracks_add_comm1"))).click();
			Assert.assertEquals(driver.getTitle(),library.getProperty("tracks_add_page_title"));
			Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("tracks_add_comm_is_empty"))).isDisplayed(),"failed to adde communication to track");
			break;

		case"CCLNON16055BIRTHDAY":
		{
			driver.findElement(By.xpath(library.getProperty("filter"))).clear();
			driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(communicationname);
			driver.findElement(By.xpath(test_data_reader.getProperty("tracks_add_comm2"))).click();
			Assert.assertEquals(driver.getTitle(),library.getProperty("tracks_add_page_title"));
			Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("tracks_add_comm_is_empty"))).isDisplayed(),"failed to adde communication to track");
			break;
		}
		case"CCLCBA16031-May-Core-Casino":
		{
			driver.findElement(By.xpath(library.getProperty("filter"))).clear();
			driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(communicationname);
			driver.findElement(By.xpath(test_data_reader.getProperty("tracks_add_comm3"))).click();
			Assert.assertEquals(driver.getTitle(),library.getProperty("tracks_add_page_title"));
			Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("tracks_add_comm_is_empty"))).isDisplayed(),"failed to adde communication to track");
			break;
		}
		default: 
		{
			throw new InvalidParameterException("communication "+communicationname +" does not exit");
		}
		}
		return new TracksAddPage(driver);
	}
}	