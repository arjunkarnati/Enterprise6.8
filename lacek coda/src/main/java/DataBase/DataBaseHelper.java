package DataBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Utility.PageBase;

public class DataBaseHelper extends PageBase {

	public DataBaseHelper(WebDriver driver) 
	{
		super(driver);
	}
	public void validateCampaignCount(String client)
	{
		String uicount=driver.findElement(By.xpath(".//*[@id='nav-item-campaigns']/a/span[2]")).getText();
		int dbcount=CountObjects.campaignCount("carnival");
		Assert.assertEquals(uicount,dbcount);
	}

}