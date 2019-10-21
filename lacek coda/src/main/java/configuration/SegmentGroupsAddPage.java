package configuration;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SegmentGroupsAddPage extends PageBase {

	public SegmentGroupsAddPage(WebDriver driver) 
	{
		super(driver);
	}
	//enter client name in client field
	public SegmentGroupsAddPage addClientName(String clientname) 
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("seg_group_add_client"))).click();
		driver.findElement(By.id(configuration.getProperty("seg_group_add_client_search_field"))).sendKeys(clientname);
		driver.findElement(By.id(configuration.getProperty("seg_group_add_client_search_field"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertEquals(driver.findElement(By.id(configuration.getProperty("seg_group_add_client"))).getText(), clientname);
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("seg_group_add_page_title"));
		//return segment groups add page
		return new SegmentGroupsAddPage(driver);
	}
	//select a brand
	public SegmentGroupsAddPage addBrand(String brandname)
	{
		readconfig();
		//driver.findElement(By.id(elementslocator.getProperty("seg_group_add_client"))).click();
		driver.findElement(By.id(configuration.getProperty("seg_group_add_brand"))).sendKeys(brandname);
		driver.findElement(By.id(configuration.getProperty("seg_group_add_brand"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.id(configuration.getProperty("seg_group_add_brand"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("seg_group_add_page_title"));
		//return segment groups add page
		return new SegmentGroupsAddPage(driver);
	}
	//add segement groups name
	public SegmentGroupsAddPage addSegementGroupName(String segementgroupname)
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("seg_group_add_name"))).clear();
		driver.findElement(By.id(configuration.getProperty("seg_group_add_name"))).sendKeys(segementgroupname);
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("seg_group_add_page_title"));
		//return segment groups add page
		return new SegmentGroupsAddPage(driver);
	}
	//add type
	public SegmentGroupsAddPage addType(String type) 
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("seg_group_add_type"))).click();
		driver.findElement(By.id(configuration.getProperty("seg_group_add_type_search_field"))).sendKeys(type);
		driver.findElement(By.id(configuration.getProperty("seg_group_add_type_search_field"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("seg_group_add_page_title"));
		//return segment groups add page
		return new SegmentGroupsAddPage(driver);
	}
	//add description
	public SegmentGroupsAddPage addDescription(String description)
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("seg_group_add_description"))).clear();
		driver.findElement(By.id(configuration.getProperty("seg_group_add_description"))).sendKeys(description);
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("seg_group_add_page_title"));
		//return segment groups add page
		return new SegmentGroupsAddPage(driver);
	}
	//click submit button 
	public SegmentGroupsPage clickSubmitButton()
	{
		readconfig();
		driver.findElement(By.name(configuration.getProperty("seg_group_add_submit"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("seg_group_page_title"));
		//return segment groups
		return new SegmentGroupsPage(driver);
	}
	//click cancel button
	public SegmentGroupsPage clickCancelButton()
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("seg_group_add_cancel"))).click();
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("seg_group_page_title"));
		//driver.switchTo().alert().accept();
		//return media templates
		return new SegmentGroupsPage(driver);
	}
	//click save for failed
	public SegmentGroupsAddPage failToCreate()
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("seg_group_add_submit"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("seg_group_add_page_title"));
		return new SegmentGroupsAddPage(driver);
	}
}