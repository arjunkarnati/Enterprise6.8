package layout;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegionsAddPage extends PageBase {

	public RegionsAddPage(WebDriver driver)
	{
		super(driver);
	}
	//add region name
	public RegionsAddPage addRegionName(String regionname)
	{
		readconfig();
		driver.findElement(By.id(layout.getProperty("region_add_name"))).clear();
		driver.findElement(By.id(layout.getProperty("region_add_name"))).sendKeys(regionname);
		Assert.assertEquals(driver.getTitle(),layout.getProperty("region_add_page_title"));
		return new RegionsAddPage(driver);
	}
	//add description
	public RegionsAddPage addDescription(String description)
	{
		readconfig();
		driver.findElement(By.id(layout.getProperty("region_add_description"))).clear();
		driver.findElement(By.id(layout.getProperty("region_add_description"))).sendKeys(description);
		Assert.assertEquals(driver.getTitle(),layout.getProperty("region_add_page_title"));
		return new RegionsAddPage(driver);
	}
	//click submit button in regions add page
	public RegionsPage clickSubmitButton()
	{
		readconfig();
		driver.findElement(By.id(layout.getProperty("region_add_submit"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),layout.getProperty("region_page_title"));
		//return regions page
		return new RegionsPage(driver);
	}
	//click cancel button in regions add page
	public RegionsPage clickCancelButton()
	{
		readconfig();
		driver.findElement(By.xpath(layout.getProperty("region_add_cancel"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),layout.getProperty("region_page_title"));
		//return regions page
		return new RegionsPage(driver);
	}
	//click save for failed
	public RegionsAddPage failToCreate()
	{
		readconfig();
		driver.findElement(By.id(layout.getProperty("region_add_submit"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),layout.getProperty("region_add_page_title"));
		return new RegionsAddPage(driver);
	}
}