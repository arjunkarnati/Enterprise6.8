package library;

import java.security.InvalidParameterException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Utility.PageBase;

/*this classs inherit pagebase class*/
public class CampaignPage extends PageBase{

	/*constructor*/
	public CampaignPage(WebDriver driver) 
	{
		super(driver);
	}
	/*create a new campaign*/
	public CampaignAddPage clickAddCampaignButton() 
	{	
		readconfig();
		driver.findElement(By.xpath(library.getProperty("campaign_add_button"))).click();
		waitForAjax(driver);
		Assert.assertEquals(driver.getTitle(),library.getProperty("camp_add_page_title"));
		//return campaign add page
		return new CampaignAddPage(driver);
	}
	//Reload the page
	public CampaignPage reloadLocalesPagePage()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("campaign_reload_button"))).click();
		waitForAjax(driver);
		Assert.assertEquals(driver.getTitle(),library.getProperty("campaign_page_title"));
		return new CampaignPage(driver);
	}
	//open archive page
	public CampaignArchivePage clickArchiveButton()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("campaign_archive_button"))).click();
		waitForAjax(driver);
		Assert.assertEquals(driver.getTitle(),library.getProperty("camp_archive_page_title"));
		//return campaign archive page
		return new CampaignArchivePage(driver);
	}
	/*Publish campaign */
	public  CampaignPublishPage publishCampaign(String campaignname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(campaignname);
		switch(campaignname)
		{
		case"publish_campaign_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("publish_campaign_test_01"))).click();
			waitForAjax(driver);
			Assert.assertEquals(driver.getTitle(),library.getProperty("camp_publish_page_title"));
			break;
		}
		case "Booked Guest":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("publish_booked_guest"))).click();
			waitForAjax(driver);
			Assert.assertEquals(driver.getTitle(),library.getProperty("camp_publish_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("campaign "+campaignname +" cannot be published, ref automation doc campaigns page.");
		}
		}
		return new CampaignPublishPage(driver);
	}
	//edit campaign 
	public CampaignEditPage editCampaign(String campaignname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(campaignname);
		switch(campaignname)	
		{
		case "edit_campaign_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_campaign_test_01"))).click();
			waitForAjax(driver);
			//assert and verify
			Assert.assertEquals(driver.getTitle(),library.getProperty("camp_edit_page_title"));
			break;
		}
		case "edit_campaign_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_campaign_test_010"))).click();
			waitForAjax(driver);
			//assert and verify
			Assert.assertEquals(driver.getTitle(),library.getProperty("camp_edit_page_title"));
			break;
		}
		default : 
		{
			throw new InvalidParameterException("campaign "+campaignname +" cannot be edited, ref automation doc campaigns page.");
		}
		}
		return new CampaignEditPage(driver);	
	}
	//restore campaign
	public CampaignEditPage restoreCampaign(String campaignname)
	{
		readconfig();
		driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(campaignname);
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		sleep();
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		sleep();
		driver.findElement(By.id("reload")).click();
		sleep();		
		//assert ad verify	
		Assert.assertEquals(driver.getTitle(), library.getProperty("camp_archive_page_title"));
		return new CampaignEditPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public CampaignPage archiveCampaign(String campaignname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(campaignname);
		//select all check boxes
		/*java.util.List<WebElement> els = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for ( WebElement el : els ) 
		{
			if ( !el.isSelected()) 
			{
				el.click();
			}
			Assert.assertTrue(el.isSelected());
		}*/
		driver.findElement(By.xpath("//*[@id='datatable']/tbody/tr/td[14]/div/div/a[5]")).click();
		//switch to active element 
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "yes" 
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		waitForAjax(driver);
		return new CampaignPage(driver);			
	}
	//test validation
	public CampaignPage validateUpdates(String campaignname,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(campaignname);
		switch(column)
		{
		case"client":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("campaign_client"))).getText(),expectedresult);
			break;
		}
		case"brand":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(library.getProperty("campaign_brands"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(library.getProperty("campaign_brands")));
			java.util.Iterator<WebElement> name = iname.iterator();
			while(name.hasNext()) 
			{
				WebElement row = name.next();
				System.out.println("**brands: "+row.getText());
			} 
			//assert and verify
			Assert.assertEquals(expectedresult,String.valueOf(iCount));

			break;
		}
		case"program":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(library.getProperty("campaign_programs"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(library.getProperty("campaign_programs")));
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
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("campaign_name"))).getText(),expectedresult);
			break;
		}
		case"code":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("campaign_code"))).getText(),expectedresult);
			break;
		}
		case"series":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("campaign_series"))).getText(),expectedresult);
			break;
		}
		case"status":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("campaign_status"))).getText(),expectedresult);
			break;
		}
		case"workflow":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("campaign_workflow"))).getText(),expectedresult);
			break;
		}
		default :
		{
			throw new InvalidParameterException(column +" is not a column for locales page.");
		}
		}
		return new CampaignPage(driver);			
	}
	//export campaign 
	public void clickExportCampaign(String campaignname)
	{

	}
}