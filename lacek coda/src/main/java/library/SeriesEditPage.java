package library;

import java.security.InvalidParameterException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utility.PageBase;

//this class inherit page base class
public class SeriesEditPage extends PageBase{

	//constructor
	public SeriesEditPage(WebDriver driver) 
	{
		super(driver);
	}	
	//update client name
	public SeriesEditPage updateClientNameTo(String newclientname)
	{
		readconfig();
		if(driver.findElement(By.id(library.getProperty("series_edit_client"))).getText().equals(newclientname))
		{
			driver.findElement(By.xpath(library.getProperty("series_edit_submit"))).click();
		}
		else
		{
			driver.findElement(By.id(library.getProperty("series_edit_client"))).click();
			driver.findElement(By.id(library.getProperty("series_edit_client_search_field"))).sendKeys(newclientname);
			driver.findElement(By.id(library.getProperty("series_edit_client_search_field"))).sendKeys(Keys.ENTER);
			//assert and verify
			Assert.assertTrue(driver.findElement(By.id(library.getProperty("series_edit_client"))).getText().equalsIgnoreCase(newclientname));
			Assert.assertEquals(driver.getTitle(),library.getProperty("series_edit_page_title"));
		}
		//return series edit page
		return new SeriesEditPage(driver);
	}
	//update the brand
	public SeriesEditPage updateBrandTo(String newbrandname)
	{		
		readconfig();
		driver.findElement(By.xpath(library.getProperty("series_edit_brand"))).sendKeys(newbrandname);
		driver.findElement(By.xpath(library.getProperty("series_edit_brand"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("series_edit_brand"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("series_edit_page_title"));
		//return series edit page
		return new SeriesEditPage(driver);
	}
	//update program
	public SeriesEditPage updateProgramTo(String newprogramname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("series_edit_program"))).sendKeys(newprogramname);
		driver.findElement(By.xpath(library.getProperty("series_edit_program"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("series_edit_program"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("series_edit_page_title"));
		//return series edit page
		return new SeriesEditPage(driver);
	}
	//update campaign
	public SeriesEditPage updateCampaignTo(String newcampaignname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("series_edit_campaign"))).clear();
		driver.findElement(By.xpath(library.getProperty("series_edit_campaign"))).sendKeys(newcampaignname);
		driver.findElement(By.xpath(library.getProperty("series_edit_campaign"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("series_edit_campaign"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("series_edit_page_title"));
		//return series edit page
		return new SeriesEditPage(driver);
	}
	//update series name
	public SeriesEditPage updateSeriesNameTo(String newseriesname)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("series_edit_name"))).clear();
		driver.findElement(By.id(library.getProperty("series_edit_name"))).sendKeys(newseriesname);
		Assert.assertEquals(driver.getTitle(),library.getProperty("series_edit_page_title"));
		//return series edit page
		return new SeriesEditPage(driver);
	}
	//update description field
	public SeriesEditPage updateDescription(String newdescription)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("series_edit_description"))).clear();
		driver.findElement(By.id(library.getProperty("series_edit_description"))).sendKeys(newdescription);
		Assert.assertEquals(driver.getTitle(),library.getProperty("series_edit_page_title"));
		//return series edit page
		return new SeriesEditPage(driver);	
	}
	//update tracks
	public SeriesEditPage updateTrackTo(String newtracksname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("series_edit_tracks"))).sendKeys(newtracksname);
		driver.findElement(By.xpath(library.getProperty("series_edit_tracks"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("series_edit_tracks"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("series_edit_page_title"));
		//return series edit page
		return new SeriesEditPage(driver);
	}
	//set workflow to
	public SeriesPage setWorkFlowTo(String workflowname, String seriesname)
	{
		readconfig();
		switch(workflowname)
		{
		case "DRAFT":
		{
			driver.findElement(By.id(library.getProperty("series_edit_workflow"))).sendKeys("D");
			driver.findElement(By.id(library.getProperty("series_edit_submit"))).click();
			Assert.assertEquals(driver.getTitle(),library.getProperty("series_page_title"));
			break;
		}
		case "APPROVED":
		{
			driver.findElement(By.id(library.getProperty("series_edit_workflow"))).sendKeys("A");
			driver.findElement(By.id(library.getProperty("series_edit_submit"))).click();
			Assert.assertEquals(driver.getTitle(),library.getProperty("series_page_title"));
			break;
		}
		case "Qatest1":
		{
			driver.findElement(By.id(library.getProperty("series_edit_workflow"))).sendKeys("Q");
			driver.findElement(By.id(library.getProperty("series_edit_submit"))).click();
			Assert.assertEquals(driver.getTitle(),library.getProperty("series_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("Please verify the workflow name");
		}
		}
		return new SeriesPage(driver);
	}
	//activate and inactivate series
	public SeriesEditPage isActive(boolean answer)
	{  
		readconfig();
		//no
		if(answer==false)
		{
			driver.findElement(By.xpath(".//*[@id='series-form']/div[1]/div[12]/div/div/div/span[2]")).click();
			Assert.assertEquals(driver.getTitle(),library.getProperty("series_edit_page_title"));
		}	
		//yes
		else if(answer==true)
		{
			driver.findElement(By.xpath(".//*[@id='series-form']/div[1]/div[12]/div/div/div/span[2]")).click();
			Assert.assertEquals(driver.getTitle(),library.getProperty("series_edit_page_title"));
		}
		else
		{
			throw new InvalidParameterException
			("answer "+answer +" is not supported, ref automation doc page.");
		}
		return new SeriesEditPage(driver);
	}
	//select submit button in series edit page
	public SeriesPage clickSubmitButton()
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("series_edit_submit"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("series_page_title"));
		//return series page
		return new SeriesPage(driver);
	}
	//select cancel button in series edit page
	public SeriesPage clickCancelButoon()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("series_edit_cancel"))).click();
		//assert and verify
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("series_page_title")));
		//return series page
		return new SeriesPage(driver);
	}
	//delete entry in brand field
	public SeriesEditPage deleteEntryInBrandField()
	{
		readconfig();
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(library.getProperty("series_edit_brand_number"))).size();
		System.out.println("**brand: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(library.getProperty("series_edit_brand"))).sendKeys(Keys.BACK_SPACE);
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("series_edit_page_title"));
		return new SeriesEditPage(driver);
	}
	//remove entries in program field
	public SeriesEditPage deleteEntryInProgramField()
	{
		readconfig();
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(library.getProperty("series_edit_program_number"))).size();
		System.out.println("**program: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(library.getProperty("series_edit_program"))).sendKeys(Keys.BACK_SPACE);
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("series_edit_page_title"));
		return new SeriesEditPage(driver);
	}
	//remove entries in campaign field
	public SeriesEditPage deleteEntryInCampaignField()
	{
		readconfig();	
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(library.getProperty("series_edit_campaign_number"))).size();
		System.out.println("**campaign: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(library.getProperty("series_edit_campaign"))).sendKeys(Keys.BACK_SPACE);
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("series_edit_page_title"));
		return new SeriesEditPage(driver);
	}
	//remove entries in tracks field
	public SeriesEditPage deleteEntryInTrackField()
	{
		readconfig();	
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(library.getProperty("series_edit_tracks_number"))).size();
		System.out.println("**tracks: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(library.getProperty("series_edit_tracks"))).sendKeys(Keys.BACK_SPACE);
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("series_edit_page_title"));
		return new SeriesEditPage(driver);
	}
	//click save for failed
	public SeriesEditPage failToUpdate()
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("series_edit_submit"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("series_edit_page_title"));
		return new SeriesEditPage(driver);
	}
}