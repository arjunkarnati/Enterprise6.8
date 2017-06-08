package library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
}
