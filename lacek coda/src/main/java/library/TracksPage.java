package library;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.security.InvalidParameterException;
import java.util.List;

public class TracksPage extends PageBase

{
	public TracksPage(WebDriver driver) {
		super(driver);
	}

	//open tracks add page
	public TracksAddPage clickAddTrackButton()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("tracks_add_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("tracks_add_page_title"));
		//return series add page
		return new TracksAddPage(driver);
	}
	//reload tracks page
	public TracksPage reloadTracksPage()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("tracks_reload_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("tracks_page_title"));
		//return series page
		return new TracksPage(driver);
	}
	//open tracks edit page
	public TracksEditPage editTracks(String trackname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(trackname);
		switch(trackname)
		{
		case "edit_tracks_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_tracks_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),library.getProperty("tracks_edit_page_title"));
			break;
		}
		case "edit_tracks_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_tracks_test_010"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),library.getProperty("tracks_edit_page_title"));
			break;
		}
		case "edit_ehi_track_01":
		{
			driver.findElement(By.xpath(library.getProperty("edit_ehi_track_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),library.getProperty("tracks_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("track "+trackname +" cannot be edited, ref automation doc series page.");
		}
		}
		return new TracksEditPage(driver);
	}
	//publish a track
	public TracksPublishPage publishTracks(String trackname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(trackname);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch(trackname)
		{
		case "publish_tracks_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("publish_tracks_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),library.getProperty("tracks_publish_page_title"));
			break;
		}
		case "test":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("publish_tracks_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),library.getProperty("tracks_publish_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("track "+trackname +" cannot be published, ref automation doc series page.");
		}
		}
		return new TracksPublishPage(driver);
	}
	//restore traks
	public TracksPage restoreTracks(String trackname)
	{
		readconfig();
		driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(trackname);
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		sleep();
		driver.findElement(By.xpath("html/body/div[7]/div/div/div[3]/button[1]")).click();
		sleep();
		driver.findElement(By.id("reload")).click();
		sleep();		
		//assert ad verify	
		Assert.assertEquals(driver.getTitle(), library.getProperty("tracks_archive_page_title"));
		return new TracksPage(driver);
	}	//this method will be updated,(to permanent archive method)
	public TracksPage archiveTracks(String tracksname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(tracksname);
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
		driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[14]/div/div/a[5]/i")).click();
		//switch to active element 
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "yes" 
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		//return series archive page
		return new TracksPage(driver);			
	}
	//test validation
	public TracksPage validateUpdates(String trackname,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(trackname);
		switch(column)
		{
		case"client":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("tracks_client"))).getText(),expectedresult);
			break;
		}
		case"brand":
		{
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(library.getProperty("tracks_brand"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(library.getProperty("tracks_brand")));
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
		case"program":
		{
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(library.getProperty("tracks_program"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(library.getProperty("tracks_program")));
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
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("tracks_name"))).getText(),expectedresult);
			break;
		}
		case"code":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("tracks_code"))).getText(),expectedresult);
			break;
		}
		case"series":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("tracks_series"))).getText(),expectedresult);
			break;
		}
		case"status":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("tracks_status"))).getText(),expectedresult);
			break;
		}
		case"workflow":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("tracks_workflow"))).getText(),expectedresult);
			break;
		}
		case"communication":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("tracks_communications"))).getText(),expectedresult);
			break;
		}
		default :
		{
			throw new InvalidParameterException(column +" is not a column for coda.");
		}
		}
		return new TracksPage(driver);			
	}
}