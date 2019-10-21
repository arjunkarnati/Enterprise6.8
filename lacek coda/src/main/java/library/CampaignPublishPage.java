package library;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CampaignPublishPage extends PageBase{

	/*explicit wait object*/
	WebDriverWait wait = new WebDriverWait(driver, 15); 

	//constructor
	public CampaignPublishPage(WebDriver driver) 
	{
		super(driver);
	}
	//select every checkboxes
	public CampaignPublishPage checkAll()
	{
		readconfig();
		java.util.List<WebElement> els = driver.findElements(By.xpath(library.getProperty("camp_publish_checkboxes")));
		for ( WebElement el : els ) 
		{
			if ( !el.isSelected()) 
			{
				el.click();
			}
			//Assert.assertTrue(el.isSelected());	
		}
		//return campaign publish page
		return new CampaignPublishPage(driver);
	}
	//select publish button in campaign publish page
	public CampaignPublishPage clickPublishButton()
	{
		readconfig();
		//select submit button to publish a campaign
		driver.findElement(By.id(library.getProperty("camp_publish_button"))).click();	
		try {
			Thread.sleep(13000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//select submit button in pop up
		driver.findElement(By.xpath(library.getProperty("camp_publish_submit_buton"))).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//assert that the campaign is publish
		//Assert.assertTrue(driver.getTitle().equalsIgnoreCase(elementslocator.getProperty("campaign_page_title")));
		//return campaign publish page
		return new CampaignPublishPage(driver);
	}
	//select cancel button in campaign publish page
	public CampaignPage clickCancelButton()
	{
		readconfig();
		driver.findElement(By.cssSelector(library.getProperty("camp_publish_cancel_button"))).click();
		//return campaign page
		return new CampaignPage(driver);
	}
}