package access;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.security.InvalidParameterException;
import java.util.List;

public class UsersPage extends PageBase{

	public UsersPage(WebDriver driver) 
	{
		super(driver);
	}
	//open users add page
	public UsersAddPage clickAddUserButton()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("user_add_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_add_page_title"));
		//return users add page
		return new UsersAddPage(driver);
	}	
	//open users archive page
	public UsersArchivePage clickArchiveButton()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("user_archive_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_archive_page_title"));
		//return users page
		return new UsersArchivePage(driver);
	}
	//edit a user
	public UsersEditPage editUser(String username)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(username);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch(username)
		{
		case "edit_user_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_user_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_edit_page_title"));
			break;
		}
		case "remanth":
		{
			driver.findElement(By.xpath("//i[@class='fa fa-pencil-square-o']")).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_edit_page_title"));
			break;
		}
		case "edit_user_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_user_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_edit_page_title"));
			break;
		}
		case "set":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_set"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("user "+username +" cannot be edited, ref automation doc users page.");
		}
		}
		return new UsersEditPage(driver);
	}
	//restore user
	public UsersPage restoreUser(String username)
	{
		readconfig();
		driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(username);
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		sleep();
		driver.findElement(By.xpath("html/body/div[6]/div/div/div[3]/button[1]")).click();
		sleep();
		driver.findElement(By.id("reload")).click();
		sleep();		
		//assert ad verify	
		Assert.assertEquals(driver.getTitle(), elementslocator.getProperty("user_archive_page_title"));
		return new UsersPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public UsersPage archiveUser(String username)
	{
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(username);
		sleep();
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
		driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[11]/div/div/a[3]/i")).click();
		//switching to class="modal-dialog" 
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "yes" 
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		return new UsersPage(driver);			
	}
	//test validation
	public UsersPage validateUpdates(String username,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(username);
		switch(column)
		{
		case"first name":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("user_first_name"))).getText(),expectedresult);
			break;
		}
		case"role":
		{
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(elementslocator.getProperty("user_role"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(elementslocator.getProperty("user_role")));
			java.util.Iterator<WebElement> name = iname.iterator();
			while(name.hasNext()) 
			{
				WebElement row = name.next();
				System.out.println("**roles: "+row.getText());
			} 
			//assert and verify
			Assert.assertEquals(expectedresult,String.valueOf(iCount));

			break;
		}
		case"client":
		{
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(elementslocator.getProperty("user_client"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(elementslocator.getProperty("user_client")));
			java.util.Iterator<WebElement> name = iname.iterator();
			while(name.hasNext()) 
			{
				WebElement row = name.next();
				System.out.println("**clients: "+row.getText());
			} 
			//assert and verify
			Assert.assertEquals(expectedresult,String.valueOf(iCount));
			break;
		}
		case"last name":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("user_last_name"))).getText(),expectedresult);
			break;
		}
		case"email":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("user_email"))).getText(),expectedresult);
			break;
		}
		case"admin":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("user_admin"))).getText(),expectedresult);
			break;
		}
		case"user name":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("ueser_username"))).getText(),expectedresult);
			break;
		}
		case"status":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("user_status"))).getText(),expectedresult);
			break;
		}
		default :
		{
			throw new InvalidParameterException(column +" is not a column for users page.");
		}
		}
		return new UsersPage(driver);			
	}
}