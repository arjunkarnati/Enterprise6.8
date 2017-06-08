package access;

import java.security.InvalidParameterException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Utility.PageBase;

public class RolesPage extends PageBase{

	public RolesPage(WebDriver driver) 
	{
		super(driver);	
	}
	//open roles add page
	public RolesAddPage clickAddRoleButton()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("role_add_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_add_page_title"));
		//return users add page
		return new RolesAddPage(driver);
	}	
	//open roles archive page
	public RolesArchivePage clickArchiveButton()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("role_archive_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_archive_page_title"));
		//return roles page
		return new RolesArchivePage(driver);
	}
	//edit a role
	public RolesEditPage editRole(String rolename)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(rolename);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch(rolename)
		{
		case "edit_role_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_role_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_edit_page_title"));
			break;
		}
		case "edit_role_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_role_test_010"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("role "+rolename +" cannot be published, ref automation doc roles page.");
		}
		}
		return new RolesEditPage(driver);
	}
	//restore role
	public RolesPage  restoreRole(String rolename)
	{
		readconfig();
		driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(rolename);
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		sleep();
		driver.findElement(By.xpath("html/body/div[6]/div/div/div[3]/button[1]")).click();
		sleep();
		driver.findElement(By.id("reload")).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_archive_page_title"));
		return new RolesPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public RolesPage archiveRole(String rolename)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(rolename);
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
		driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[8]/div/div/div/a[2]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//switch to active element 
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "yes" 
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();

		return new RolesPage(driver);			
	}
	//test validation
	public RolesPage validateUpdates(String rolename,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(rolename);
		switch(column)
		{
		case"name":
		{
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("role_name"))).getText(),expectedresult);
			break;
		}		
		case"parent role":
		{
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("role_parent_name"))).getText(),expectedresult);
			break;
		}
		case"permission groups":
		{
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath("//td[contains(text(),'selenium_role')]/following-sibling::td[3]/span")).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath("//td[contains(text(),'selenium_role')]/following-sibling::td[3]/span"));
			java.util.Iterator<WebElement> name = iname.iterator();
			while(name.hasNext()) 
			{
				WebElement row = name.next();
				System.out.println("**permissions: "+row.getText());
			} 
			//assert and verify
			Assert.assertEquals(expectedresult,String.valueOf(iCount));

			break;
		}
		case"client":
		{
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(elementslocator.getProperty("role_client"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(elementslocator.getProperty("role_client")));
			java.util.Iterator<WebElement> name = iname.iterator();
			while(name.hasNext()) 
			{
				WebElement row = name.next();
				System.out.println("**clients: "+row.getText());
			} 
			//assert and verify
			Assert.assertEquals(String.valueOf(iCount), expectedresult);
			break;
		}
		case"status":
		{
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("role_status"))).getText(),expectedresult);
			break;
		}
		default :
		{
			throw new InvalidParameterException(column +" is not a column for roles page.");
		}
		}
		return new RolesPage(driver);			
	}
}