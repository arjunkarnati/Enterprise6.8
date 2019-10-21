package configuration;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.security.InvalidParameterException;
import java.util.List;

public class SegmentsPage extends PageBase{

	public SegmentsPage(WebDriver driver) 
	{
		super(driver);
	}
	//open users add page
	public SegmentsAddPage clickAddSegmentButton()
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("segment_add_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("segment_add_page_title"));
		//return segments add page
		return new SegmentsAddPage(driver);
	}	
	//open segments archive page
	public SegmentsArchivePage clickArchiveButton()
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("segment_archive_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("segment_archive_page_title"));
		//return segments archive page
		return new SegmentsArchivePage(driver);
	}
	//edit a segment
	public SegmentsEditPage editSegment(String segmentname)
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("filter"))).clear();
		driver.findElement(By.xpath(configuration.getProperty("filter"))).sendKeys(segmentname);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch(segmentname)
		{
		case "edit_segments_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_segments_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),configuration.getProperty("segment_edit_page_title"));
			break;
		}
		case "edit_segments_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_segments_test_010"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),configuration.getProperty("segment_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("segments "+segmentname +" cannot be edited, ref automation doc segments page.");
		}
		}
		return new SegmentsEditPage(driver);
	}
	//restore segment	
	public SegmentsPage restoreSegment(String segmentname)
	{
		readconfig();
		driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(segmentname);
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		sleep();
		driver.findElement(By.xpath("html/body/div[7]/div/div/div[3]/button[1]")).click();
		sleep();
		driver.findElement(By.id("reload")).click();
		sleep();		
		//assert ad verify	
		Assert.assertEquals(driver.getTitle(), configuration.getProperty("segment_archive_page_title"));
		return new  SegmentsPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public SegmentsPage archiveSegements(String segmentsname)
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("filter"))).clear();
		driver.findElement(By.xpath(configuration.getProperty("filter"))).sendKeys(segmentsname);
		//select all check boxes
		java.util.List<WebElement> els = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for ( WebElement el : els ) 
		{
			if ( !el.isSelected()) 
			{
				el.click();
			}
			Assert.assertTrue(el.isSelected());
		}
		driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();
		//switch to active element 
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "yes" 
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		return new SegmentsPage(driver);			
	}
	//test validation
	public SegmentsPage validateUpdates(String segmentname,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("filter"))).clear();
		driver.findElement(By.xpath(configuration.getProperty("filter"))).sendKeys(segmentname);
		switch(column)
		{
		case"client":
		{
			Assert.assertEquals(driver.findElement(By.xpath(configuration.getProperty("segments_client"))).getText(),expectedresult);
			break;
		}
		case"brand":
		{
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(configuration.getProperty("segments_brand"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(configuration.getProperty("segments_brand")));
			java.util.Iterator<WebElement> name = iname.iterator();
			while(name.hasNext()) 
			{
				WebElement row = name.next();
				System.out.println("**Brand: "+row.getText());
			} 
			//assert and verify
			Assert.assertEquals(expectedresult,String.valueOf(iCount));

			break;
		}
		case"name":
		{
			Assert.assertEquals(driver.findElement(By.xpath(configuration.getProperty("segments_name"))).getText(),expectedresult);
			break;
		}
		case"group":
		{
			Assert.assertEquals(driver.findElement(By.xpath(configuration.getProperty("segments_group"))).getText(),expectedresult);
			break;
		}
		case"code":
		{
			Assert.assertEquals(driver.findElement(By.xpath(configuration.getProperty("segments_code"))).getText(),expectedresult);
			break;
		}
		case"status":
		{
			Assert.assertEquals(driver.findElement(By.xpath(configuration.getProperty("segments_status"))).getText(),expectedresult);
			break;
		}
		default :
		{
			throw new InvalidParameterException(column +" is not a column for locales page.");
		}
		}
		return new SegmentsPage(driver);			
	}
}