package library;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.InvalidParameterException;
import java.util.List;

public class SeriesPage extends PageBase{

	WebDriverWait wait = new WebDriverWait(driver, 15); 

	//constructor
	public SeriesPage(WebDriver driver) 
	{
		super(driver);
	}
	//open series add page
	public SeriesAddPage clickAddSeriesButton()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("series_add_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("series_add_page_title"));
		//return series add page
		return new SeriesAddPage(driver);
	}	
	//reload series page
	public SeriesPage reloadSeriesPage()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("series_reload_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("series_page_title"));
		//return series page
		return new SeriesPage(driver);
	}
	//open series archive page
	public SeriesArchivePage clickArchiveButton(String seriesname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(seriesname);
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
		driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[14]/div/div/div/a[4]")).click();
		//switch to active element 
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "yes" 
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//return series archive page
		return new SeriesArchivePage(driver);
	}
	//edit a series
	public SeriesEditPage editSeries(String seriesname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(seriesname);
		switch(seriesname)
		{
		case "edit_series_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_series_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),library.getProperty("series_edit_page_title"));
			break;
		}
		case "edit_series_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_series_test_010"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),library.getProperty("series_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("series "+seriesname +" cannot be edited, ref automation doc series page.");
		}
		}
		return new SeriesEditPage(driver);
	}
	//publish series
	public SeriesPublishPage publishSeries(String seriesname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(seriesname);
		switch(seriesname)
		{
		case "publish_series_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("publish_series_test_01"))).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),library.getProperty("series_publish_page_title"));
			break;
		}
		case "opt-out":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("publish_series_test_01"))).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),library.getProperty("series_publish_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("Series "+seriesname +" cannot be published, ref automation doc series page.");
		}
		}
		return new SeriesPublishPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public SeriesPage archiveSeries(String seriesname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(seriesname);
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
		driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[14]/div/div/div/a[4] | //i[contains(@class,'fa fa-trash-o')]")).click();
		//switch to active element 
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "yes" 
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new SeriesPage(driver);			
	}
	//retore series
	public SeriesPage retoreSeries(String seriesname)
	{
		readconfig();
		driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(seriesname);
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		sleep();
		driver.findElement(By.xpath("html/body/div[6]/div/div/div[3]/button[1] | //button[@class='btn btn-success' and contains(text(),'Yes')]")).click();
		sleep();
		driver.findElement(By.id("reload")).click();
		sleep();		
		//assert ad verify	
		Assert.assertEquals(driver.getTitle(), library.getProperty("series_archive_page_title"));
		return new SeriesPage(driver);
	}
	//test validation
	public SeriesPage validateUpdates(String seriesname,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(seriesname);
		switch(column)
		{
		case"client":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("series_client"))).getText(),expectedresult);
			break;
		}
		case"brand":
		{
		/*	//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(library.getProperty("series_brand"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(library.getProperty("series_brand")));
			java.util.Iterator<WebElement> name = iname.iterator();
			while(name.hasNext()) 
			{
				WebElement row = name.next();
				System.out.println("**Brand: "+row.getText());
			} 
			//assert and verify
			Assert.assertEquals(expectedresult,String.valueOf(iCount));*/
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("series_brand"))).getText().toLowerCase(),expectedresult.toLowerCase());

			break;
		}
		case"program":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("series_program"))).getText().toLowerCase(),expectedresult.toLowerCase());
			/*//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(library.getProperty("series_program"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(library.getProperty("series_program")));
			java.util.Iterator<WebElement> name = iname.iterator();
			while(name.hasNext()) 
			{
				WebElement row = name.next();
				System.out.println("**program: "+row.getText());
			} 
			//assert and verify
			Assert.assertEquals(expectedresult,String.valueOf(iCount));*/
			break;
		}
		case"name":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("series_name"))).getText(),expectedresult);
			break;
		}
		case"code":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("series_code"))).getText(),expectedresult);
			break;
		}
		case"campaign":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("series_campaign"))).getText(),expectedresult);
			break;
		}
		case"status":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("series_status"))).getText(),expectedresult);
			break;
		}
		case"workflow":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("series_workflow"))).getText(),expectedresult);
			break;
		}
		case"track":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("series_track"))).getText(),expectedresult);
			break;
		}
		default :
		{
			throw new InvalidParameterException(column +" is not a column for locales page.");
		}
		}
		return new SeriesPage(driver);			
	}
}