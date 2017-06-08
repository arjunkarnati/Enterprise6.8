package library;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utility.PageBase;

/*this class inherit pagebase class*/
public class CampaignAddPage extends PageBase{

	/*constructor*/
	public CampaignAddPage(WebDriver driver) 
	{
		super(driver);
	}
	/*select a brand*/
	public CampaignAddPage addBrand(String brandname)
	{	
		readconfig();
		
		driver.findElement(By.id(library.getProperty("canp_add_brand"))).click();
		driver.findElement(By.id(library.getProperty("canp_add_brand"))).sendKeys(brandname);
		System.out.println("Clicking on the brand field");
	//	

		waitForAjax(driver);
		driver.findElement(By.id(library.getProperty("canp_add_brand"))).sendKeys(Keys.ENTER);
		//assert that the brand is added 
		boolean i= driver.findElement(By.id(library.getProperty("canp_add_brand"))).isDisplayed();	
		Assert.assertTrue(i);
		//return camapign add page
		return new CampaignAddPage(driver);
	}
	/*select a program*/
	public CampaignAddPage addProgram(String programname) 
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("camp_add_program"))).click();

		driver.findElement(By.id(library.getProperty("camp_add_program"))).sendKeys(programname);
		waitForAjax(driver);
		driver.findElement(By.id(library.getProperty("camp_add_program"))).sendKeys(Keys.ENTER);
		//return camapign add page
		return new CampaignAddPage(driver);
	}	
	/*select a series*/
	public CampaignAddPage addSeries(String seriesname) 
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("camp_add_series"))).click();

		driver.findElement(By.xpath(library.getProperty("camp_add_series"))).sendKeys(seriesname);
		waitForAjax(driver);
		driver.findElement(By.xpath(library.getProperty("camp_add_series"))).sendKeys(Keys.ENTER);
		//return camapign add page
		return new CampaignAddPage(driver);		
	}
	//select a client
	public CampaignAddPage addClient(String clientname)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("camp_add_client"))).click();
		driver.findElement(By.id(library.getProperty("camp_add_client_search_field"))).sendKeys(clientname);
		waitForAjax(driver);
		driver.findElement(By.id(library.getProperty("camp_add_client_search_field"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.findElement(By.id(library.getProperty("camp_add_client"))).getText(),clientname);
		//assert and verify
		return new CampaignAddPage(driver);	
	}	
	//campaign name textbox
	public CampaignAddPage addCampaignName(String campaignname)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("camp_add_name"))).clear();
		driver.findElement(By.id(library.getProperty("camp_add_name"))).sendKeys(campaignname);
		return new CampaignAddPage(driver);	
	}
	//descritption textbox
	public CampaignAddPage addDescription(String description)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("camp_add_description"))).clear();
		driver.findElement(By.id(library.getProperty("camp_add_description"))).sendKeys(description);
		return new CampaignAddPage(driver);	
	}
	/*click cancel button in campaign add page*/
	public CampaignAddPage clickCancelCampaign()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("camp_add_cancel"))).click();
		//driver.switchTo().alert().accept();
		//assert and verify
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("campaign_page_title")));
		//return campaign add page
		return new CampaignAddPage(driver);
	}
	/*click submit button in campaign add page*/
	public CampaignPage clickSubmitCampaign()
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("camp_add_submit"))).click();
		waitForAjax(driver);
		Assert.assertEquals(driver.getTitle(),library.getProperty("campaign_page_title"));
		return new CampaignPage(driver);
	}
	//click save for failed
	public CampaignAddPage failToCreate()
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("camp_add_submit"))).click();
		waitForAjax(driver);
		Assert.assertEquals(driver.getTitle(),library.getProperty("camp_add_page_title"));
		return new CampaignAddPage(driver);
	}
}