package configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utility.PageBase;

public class SegmentsAddPage extends PageBase {

	public SegmentsAddPage(WebDriver driver) 
	{
		super(driver);
	}
	//enter client name in client field
	public SegmentsAddPage addClientName(String clientname) 
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("segments_add_client"))).click();
		driver.findElement(By.id(configuration.getProperty("segments_add_client_search_field"))).sendKeys(clientname);
		driver.findElement(By.id(configuration.getProperty("segments_add_client_search_field"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertEquals(driver.findElement(By.id(configuration.getProperty("segments_add_client"))).getText(), clientname);
		Assert.assertEquals(driver.getTitle(), configuration.getProperty("segment_add_page_title"));
		//return segments  add page
		return new SegmentsAddPage(driver);
	}
	//add segmentgroups
	public SegmentsAddPage addSegmentGroups(String segmentgroupsname) 
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("segments_add_segementgroups"))).click();
		driver.findElement(By.id(configuration.getProperty("segments_add_segementgroups_search_field"))).sendKeys(segmentgroupsname);
		driver.findElement(By.id(configuration.getProperty("segments_add_segementgroups_search_field"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertEquals(driver.findElement(By.id(configuration.getProperty("segments_add_segementgroups"))).getText(),segmentgroupsname);
		Assert.assertEquals(driver.getTitle(), configuration.getProperty("segment_add_page_title"));
		//return segment  add page
		return new SegmentsAddPage(driver);
	}
	//add segement  name
	public SegmentsAddPage addSegementName(String segementname)
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("segments_add_name"))).clear();
		driver.findElement(By.id(configuration.getProperty("segments_add_name"))).sendKeys(segementname);
		Assert.assertEquals(driver.getTitle(), configuration.getProperty("segment_add_page_title"));
		//return segment  add page
		return new SegmentsAddPage(driver);
	}
	//add description
	public SegmentsAddPage addDescription(String description)
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("segments_add_description"))).clear();
		driver.findElement(By.id(configuration.getProperty("segments_add_description"))).sendKeys(description);
		Assert.assertEquals(driver.getTitle(), configuration.getProperty("segment_add_page_title"));
		//return segment  add page
		return new SegmentsAddPage(driver);
	}
	//add code
	public SegmentsAddPage addCode(String intcode)
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("segments_add_code"))).clear();
		driver.findElement(By.id(configuration.getProperty("segments_add_code"))).sendKeys(intcode);
		Assert.assertEquals(driver.getTitle(), configuration.getProperty("segment_add_page_title"));
		//return segment  add page
		return new SegmentsAddPage(driver);
	}
	//click submit button 
	public SegmentsPage clickSubmitButton()
	{
		readconfig();
		driver.findElement(By.name(configuration.getProperty("segments_add_submit"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(), configuration.getProperty("segment_page_title"));
		//return segment 
		return new SegmentsPage(driver);
	}
	//click cancel button
	public SegmentsPage clickCancelButton()
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("segments_add_cancel"))).click();
		Assert.assertEquals(driver.getTitle(), configuration.getProperty("segment_page_title"));
		//driver.switchTo().alert().accept();
		//return
		return new SegmentsPage(driver);
	}
	//click save for failed
	public SegmentsAddPage failToCreate()
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("segments_add_submit"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("segment_add_page_title"));
		return new SegmentsAddPage(driver);
	}
}