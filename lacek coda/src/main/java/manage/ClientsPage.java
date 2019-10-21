package manage;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.security.InvalidParameterException;
import java.util.List;

public class ClientsPage extends PageBase{

	public ClientsPage(WebDriver driver) 
	{
		super(driver);
	}
	//open client add page
	public ClientsAddPage clickAddClientButton()
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("client_add_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),manage.getProperty("client_add_page_title"));
		//return client add page
		return new ClientsAddPage(driver);
	}	
	//open clients archive page
	public ClientsArchivePage clickArchiveButton()
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("client_archive_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),manage.getProperty("client_archive_page_title"));
		//return clients archive page
		return new ClientsArchivePage(driver);
	}
	//edit a client
	public ClientsEditPage editClient(String clientname)
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("filter"))).clear();
		driver.findElement(By.xpath(manage.getProperty("filter"))).sendKeys(clientname);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch(clientname)
		{
		case "US Bank":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("us_bank"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),manage.getProperty("client_edit_page_title"));
			break;
		}
		case "US Bank01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("us_bank_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),manage.getProperty("client_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("client "+clientname +" cannot be edited, ref automation doc clients page.");
		}
		}
		return new ClientsEditPage(driver);
	}
	//restore client
	public ClientsPage restoreClient(String clientname)
	{
		readconfig();
		driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(clientname);
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		sleep();
		driver.findElement(By.xpath("html/body/div[7]/div/div/div[3]/button[1]")).click();
		sleep();
		driver.findElement(By.id("reload")).click();
		sleep();		
		//assert ad verify	
		Assert.assertEquals(driver.getTitle(), manage.getProperty("client_archive_page_title"));
		return new ClientsPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public ClientsPage archiveClient(String clientname)
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("filter"))).clear();
		driver.findElement(By.xpath(manage.getProperty("filter"))).sendKeys(clientname);
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
		driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[14]/div/div/a[2]/i")).click();
		//switch to active element 
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "yes" 
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		return new ClientsPage(driver);			
	}
	//test validation
	public ClientsPage validateUpdates(String clientname,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("filter"))).clear();
		driver.findElement(By.xpath(manage.getProperty("filter"))).sendKeys(clientname);
		switch(column)
		{
		case"name":
		{
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(manage.getProperty("client_name"))).getText(),expectedresult);
			break;
		}
		case"locales":
		{
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(manage.getProperty("client_locales"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(manage.getProperty("client_locales")));
			java.util.Iterator<WebElement> name = iname.iterator();
			while(name.hasNext()) 
			{
				WebElement row = name.next();
				System.out.println("**locales: "+row.getText());
			} 
			//assert and verify
			Assert.assertEquals(expectedresult,String.valueOf(iCount));

			break;
		}
		case"url":
		{
			Assert.assertEquals(driver.findElement(By.xpath(manage.getProperty("client_url"))).getText(),expectedresult);
			break;
		}
		case"status":
		{
			Assert.assertEquals(driver.findElement(By.xpath(manage.getProperty("client_status"))).getText(),expectedresult);
			break;
		}
		default :
		{
			throw new InvalidParameterException(column +" is not a column for locales page.");
		}
		}
		return new ClientsPage(driver);			
	}
}