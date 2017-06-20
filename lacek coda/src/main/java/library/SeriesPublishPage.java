package library;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utility.PageBase;

public class SeriesPublishPage extends PageBase{

	public SeriesPublishPage(WebDriver driver) 
	{
		super(driver);
	}
	//select every checkboxes
	public SeriesPublishPage checkAll()
	{
		readconfig();
		java.util.List<WebElement> els = driver.findElements(By.xpath(library.getProperty("series_publish_checkboxes")));
		for ( WebElement el : els ) 
		{
			if ( !el.isSelected()) 
			{
				el.click();
			}
			//Assert.assertTrue(el.isSelected());	
		}
		return new SeriesPublishPage(driver);
	}
	//publish series
	public SeriesPage clickPublishButton()
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("series_publish_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Switch to active element model dialogue box.
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "submit" 
		driver.findElement(By.xpath(library.getProperty("series_publish_submit_buton"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//assert and verify
		//Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("dashboard_page_title")));
		return new SeriesPage(driver);
	}
	//click cancel button in publishseries page.
	public SeriesPage clickCancelButton()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("series_edit_cancel"))).click();
		//assert and verify
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("series_page_title")));
		//return series paeg
		return new SeriesPage(driver);
	}
	public PageBase deletelocales() {
		// TODO Auto-generated method stub
		
		readconfig();
		driver.findElement(By.xpath(library.getProperty("series_locale_delete"))).sendKeys(Keys.BACK_SPACE);
		//driver.findElement(By.xpath(library.getProperty("series_edit_tracks"))).sendKeys(newlocalename);
		//driver.findElement(By.xpath(library.getProperty("series_locale_delete"))).sendKeys(Keys.ENTER);
		return new SeriesPage(driver);
	}
	public SeriesPage addlocaleTo(String newlocale)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("series_locale_delete"))).sendKeys(newlocale);
		driver.findElement(By.xpath(library.getProperty("series_locale_delete"))).sendKeys(Keys.ENTER);
		return new SeriesPage(driver);
	}
}