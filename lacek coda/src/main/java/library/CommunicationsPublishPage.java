package library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utility.PageBase;

public class CommunicationsPublishPage extends PageBase {

	public CommunicationsPublishPage(WebDriver driver) 
	{
		super(driver);	
	}
	//select every checkboxes
	public CommunicationsPublishPage checkAll()
	{
		readconfig();
		java.util.List<WebElement> els = driver.findElements(By.xpath(library.getProperty("comm_publish_checkboxes")));
		for ( WebElement el : els ) 
		{
			if ( !el.isSelected()) 
			{
				el.click();
			}
			//Assert.assertTrue(el.isSelected());	
		}
		//return campaign publish page
		return new CommunicationsPublishPage(driver);
	}
	//select publish button in campaign publish page
	public CommunicationsPublishPage clickPublishButton()
	{
		readconfig();
		//select submit button to publish a campaign
		driver.findElement(By.id(library.getProperty("comm_publish_button"))).click();
		//Switch to active element model dialogue box.
		driver.switchTo().activeElement();
		sleep();
		//select submit button in pop up
		driver.findElement(By.xpath(library.getProperty("comm_publish_submit_buton"))).click();
		//return campaign publish page
		return new CommunicationsPublishPage(driver);
	}
	//select cancel button in campaign publish page
	public CommunicationsPage clickCancelButton()
	{
		readconfig();
		driver.findElement(By.cssSelector(library.getProperty("camp_publish_cancel_button"))).click();
		//return campaign page
		return new CommunicationsPage(driver);
	}
	public CommunicationsPublishPage uncheckMessages() {
		// TODO Auto-generated method stub
	//Communications uncheck
		if(driver.findElements(By.xpath(".//*[@id='communication-datatable']/thead/tr/th[1]/input")).size()!=0){
		driver.findElement(By.xpath(".//*[@id='communication-datatable']/thead/tr/th[1]/input")).click();
		}
		//Meesages uncheck
		if(driver.findElements(By.xpath(".//*[@id='message-datatable']/thead/tr/th[1]/input")).size()!=0){
			driver.findElement(By.xpath(".//*[@id='message-datatable']/thead/tr/th[1]/input")).click();
		}
		//Media uncheck
		if(driver.findElements(By.xpath(".//*[@id='mediagallery-datatable']/thead/tr/th[1]/input")).size()!=0){
			driver.findElement(By.xpath(".//*[@id='mediagallery-datatable']/thead/tr/th[1]/input")).click();
		}
		return new CommunicationsPublishPage(driver);
	}
	public CommunicationsPublishPage publishwarningmessgae() {
		// TODO Auto-generated method stub
		try{
			driver.findElement(By.xpath("//a[@id='publish-button']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if(driver.findElements(By.xpath("//div[contains(text(),'You must check at least one box to publish something.')]")).size()!=0){
				System.out.println("Publish warning message displayed as to check atleast on check");
			}else{
				throw new Exception("Warning not displayed");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return new CommunicationsPublishPage(driver);
	}
	public CommunicationsPublishPage deletelocales() {
		readconfig();
		//counting the number of entry in the field
		//int iCount = driver.findElements(By.xpath(library.getProperty("comm_delete_locales"))).size();
		//System.out.println("**locales: "+iCount);
		//for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(library.getProperty("comm_delete_locales"))).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(library.getProperty("comm_delete_locales"))).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(library.getProperty("comm_delete_locales"))).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(library.getProperty("comm_delete_locales"))).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(library.getProperty("comm_delete_locales"))).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(library.getProperty("comm_delete_locales"))).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(library.getProperty("comm_delete_locales"))).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(library.getProperty("comm_delete_locales"))).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(library.getProperty("comm_delete_locales"))).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(library.getProperty("comm_delete_locales"))).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(library.getProperty("comm_delete_locales"))).sendKeys(Keys.BACK_SPACE);
			
			
			
			
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return new CommunicationsPublishPage(driver);
	}
	public CommunicationsPublishPage addlocales(String newlocale) 
	{
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(library.getProperty("comm_add_locale"))).sendKeys(newlocale);
		driver.findElement(By.xpath(library.getProperty("comm_add_locale"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("comm_add_locale"))).isDisplayed());
		//return communication edit page
		return new CommunicationsPublishPage(driver);
	}
	public CommunicationsPublishPage clickPublishButton1() {
		// TODO Auto-generated method stub
		elementLocators();
		driver.findElement(By.xpath(library.getProperty("click_publish_button"))).click();
		return new CommunicationsPublishPage(driver);
	}
}
