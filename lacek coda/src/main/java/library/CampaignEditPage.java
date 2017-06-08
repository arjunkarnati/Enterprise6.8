package library;

import java.security.InvalidParameterException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utility.PageBase;

public class CampaignEditPage extends PageBase{

	public CampaignEditPage(WebDriver driver) 
	{
		super(driver);		
	}
	//activate and inactivate campaign
	public CampaignEditPage isActive(boolean answer)
	{  
		readconfig();
		//no
		if(answer==false)
		{
			driver.findElement(By.xpath(library.getProperty("camp_status_inactive"))).click();
		}	
		//yes
		else if(answer==true)
		{
			driver.findElement(By.xpath(library.getProperty("camp_status_active"))).click();
		}
		else
		{
			throw new InvalidParameterException
			("answer "+answer +" is not supported, ref automation doc workflow page.");
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("camp_edit_page_title"));
		return new CampaignEditPage(driver);
	}
	//update client field
	public CampaignEditPage updateClientNameTo(String newclientname) 
	{
		readconfig();
		if(driver.findElement(By.id(library.getProperty("camp_edit_client"))).getText().equals(newclientname))
		{
			driver.findElement(By.xpath(library.getProperty("camp_edit_submit"))).click();
		}
		else
		{
			driver.findElement(By.id(library.getProperty("camp_edit_client"))).click();
			driver.findElement(By.id(library.getProperty("camp_edit_client_search_field"))).sendKeys(newclientname);
			driver.findElement(By.id(library.getProperty("camp_edit_client_search_field"))).sendKeys(Keys.ENTER);
			//Assert and verify
			String i= driver.findElement(By.id(library.getProperty("camp_edit_client"))).getText();
			Assert.assertEquals(i, newclientname);
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("camp_edit_page_title"));
		//return campaign edit page
		return new CampaignEditPage(driver);
	}	
	//update brand field
	public CampaignEditPage updateBrand(String brandname)
	{	
		readconfig();
		driver.findElement(By.xpath(library.getProperty("canp_edit_brand"))).sendKeys(brandname);		
		driver.findElement(By.xpath(library.getProperty("canp_edit_brand"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("canp_edit_brand"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("camp_edit_page_title"));
		return new CampaignEditPage(driver);		
	}
	//update program
	public CampaignEditPage updateProgram(String newprogramname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("camp_edit_program"))).sendKeys(newprogramname);
		driver.findElement(By.xpath(library.getProperty("camp_edit_program"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("camp_edit_program"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("camp_edit_page_title"));
		//return camapign add page
		return new CampaignEditPage(driver);
	}
	//update series
	public CampaignEditPage updateSeries(String newseriesname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("camp_edit_series"))).sendKeys(newseriesname);
		driver.findElement(By.xpath(library.getProperty("camp_edit_series"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("camp_edit_series"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("camp_edit_page_title"));
		//return camapign add page
		return new CampaignEditPage(driver);
	}
	//update name
	public CampaignEditPage updateCampaignName(String newcampaignname)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("camp_edit_name"))).clear();
		driver.findElement(By.id(library.getProperty("camp_edit_name"))).sendKeys(newcampaignname);
		Assert.assertEquals(driver.getTitle(),library.getProperty("camp_edit_page_title"));
		//return camapign add page
		return new CampaignEditPage(driver);
	}
	//update code
	public CampaignEditPage updateCampaignCode(String code)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("camp_edit_code"))).clear();
		driver.findElement(By.id(library.getProperty("camp_edit_code"))).sendKeys(code);
		//assert and verify
		String i= driver.findElement(By.id("Campaign_Code")).getText();
		Assert.assertEquals(i, code);
		Assert.assertEquals(driver.getTitle(),library.getProperty("camp_edit_page_title"));
		return new CampaignEditPage(driver);
	}
	//set workflow to
	public CampaignPage setWorkFlowTo(String workflowname, String campaignname)
	{
		readconfig();
		switch(workflowname)
		{
		case "DRAFT":
		{
			driver.findElement(By.id(library.getProperty("camp_workflow"))).sendKeys("D");
			driver.findElement(By.id(library.getProperty("camp_edit_submit"))).click();
			Assert.assertEquals(driver.getTitle(),library.getProperty("campaign_page_title"));
			break;
		}
		case "APPROVED":
		{
			driver.findElement(By.id(library.getProperty("camp_workflow"))).sendKeys("A");
			driver.findElement(By.id(library.getProperty("camp_edit_submit"))).click();
			Assert.assertEquals(driver.getTitle(),library.getProperty("campaign_page_title"));
			break;
		}
		case "Qatest1":
		{
			driver.findElement(By.id(library.getProperty("camp_workflow"))).sendKeys("Q");
			driver.findElement(By.id(library.getProperty("camp_edit_submit"))).click();
			Assert.assertEquals(driver.getTitle(),library.getProperty("campaign_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("Please verify the workflow name");
		}
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("campaign_page_title"));
		return new CampaignPage(driver);
	}
	//submit
	public CampaignPage clickSubmit()
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("camp_edit_submit"))).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//assert and verify
		Assert.assertEquals(driver.getTitle(),library.getProperty("campaign_page_title"));
		//return campaign page
		return new CampaignPage(driver);
	}
	//cancel
	public CampaignPage clickCancel()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("campaign_page"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//assert and verify
		Assert.assertEquals(driver.getTitle(),library.getProperty("campaign_page_title"));
		//return campaign edit page
		return new CampaignPage(driver);
	}
	//click save for failed
	public CampaignAddPage failToUpdate()
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("camp_edit_submit"))).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("camp_edit_page_title"));
		return new CampaignAddPage(driver);
	}
	//delete entry in brand field
	public CampaignEditPage deleteEntryInBrandField()
	{
		readconfig();	
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(library.getProperty("camp_edit_brand_number"))).size();
		System.out.println("**brand: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(library.getProperty("canp_edit_brand"))).sendKeys(Keys.BACK_SPACE);
		}
		return new CampaignEditPage(driver);
	}
	//delete entry in program field
	public CampaignEditPage deleteEntryInProgramField()
	{
		readconfig();	
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(library.getProperty("camp_edit_program_number"))).size();
		System.out.println("**program: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(library.getProperty("camp_edit_program"))).sendKeys(Keys.BACK_SPACE);
		}
		return new CampaignEditPage(driver);
	}
	//delete entry in series field
	public CampaignEditPage deleteEntryInSeriesField()
	{
		readconfig();
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(library.getProperty("camp_edit_series_number"))).size();
		System.out.println("**series: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(library.getProperty("camp_edit_series"))).sendKeys(Keys.BACK_SPACE);
		}
		return new CampaignEditPage(driver);
	}
}