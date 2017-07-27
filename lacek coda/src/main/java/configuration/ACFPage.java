package configuration;

import java.security.InvalidParameterException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Utility.PageBase;

public class ACFPage extends PageBase {

	public ACFPage(WebDriver driver) 
	{
		super(driver);
	}
	//open acf add page
	public ACFAddPage clickAddAcfButton()
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("acf_add_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_add_page_title"));
		//return acf add page
		return new ACFAddPage(driver);
	}
	//reload acf page
	public ACFPage reloadAcfPage()
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("acf_add_reload"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_page_title"));
		//return acf page
		return new ACFPage(driver);
	}
	//open acf archive page
	public ACFArchivePage clickArchiveButton(String acfname)
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("acf_archive_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_archive_page_title"));
		//return acf archive page
		return new ACFArchivePage(driver);
	}
	//edit acf
	public ACFEditPage editAcf(String acfname)
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("filter"))).clear();
		driver.findElement(By.xpath(configuration.getProperty("filter"))).sendKeys(acfname);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch(acfname)
		{
		case "edit_acf_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_acf_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_edit_page_title"));
			break;
		}
		case "edit_acf_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_acf_test_010"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("acf "+acfname +" cannot be edited, ref automation doc acf page.");
		}
		}
		return new ACFEditPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public ACFPage archiveAcf(String acfname)
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("filter"))).clear();
		driver.findElement(By.xpath(configuration.getProperty("filter"))).sendKeys(acfname);
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
		driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[11]/div/div/a[2]")).click();
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
		return new ACFPage(driver);			
	}
	//retore acf
	public ACFPage retoreAcf(String acfname)
	{
		readconfig();
		driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(acfname);
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		sleep();
		driver.findElement(By.xpath("html/body/div[6]/div/div/div[3]/button[1]")).click();
		sleep();
		driver.findElement(By.id("reload")).click();
		sleep();		
		//assert ad verify	
		Assert.assertEquals(driver.getTitle(), configuration.getProperty("acf_archive_page_title"));
		return new ACFPage(driver);
	}
	//test validation
	public ACFPage validateUpdates(String acfname,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("filter"))).clear();
		driver.findElement(By.xpath(configuration.getProperty("filter"))).sendKeys(acfname);
		switch(column)
		{
		case"client":
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(configuration.getProperty("acf_client"))).getText(),expectedresult);
			break;
		}
		case"brand":
		{
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(configuration.getProperty("acf_brand"))).size();
			//getting the entry value
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			List<WebElement> iname = driver.findElements(By.xpath(configuration.getProperty("acf_brand")));
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
			int iCount = driver.findElements(By.xpath(configuration.getProperty("acf_program"))).size();
			//getting the entry value
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			List<WebElement> iname = driver.findElements(By.xpath(configuration.getProperty("acf_program")));
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
		case"object":
		{
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(configuration.getProperty("acf_object"))).size();
			//getting the entry value
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			List<WebElement> iname = driver.findElements(By.xpath(configuration.getProperty("acf_object")));
			java.util.Iterator<WebElement> name = iname.iterator();
			while(name.hasNext()) 
			{
				WebElement row = name.next();
				System.out.println("**object: "+row.getText());
			} 
			//assert and verify
			Assert.assertEquals(expectedresult,String.valueOf(iCount));
			break;
		}
		case"name":
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(configuration.getProperty("acf_name"))).getText(),expectedresult);
			break;
		}
		case"field":
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(configuration.getProperty("acf_field"))).getText(),expectedresult);
			break;
		}
		case"in use":
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(configuration.getProperty("acf_in_use"))).getText(),expectedresult);
			break;
		}
		case"status":
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(configuration.getProperty("acf_status"))).getText(),expectedresult);
			break;
		}
		case"order":
		{
			driver.findElement(By.xpath(configuration.getProperty("acf_id"))).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("acf_order"))).getText(),expectedresult);
			break;
		}
		case"label":
		{
			driver.findElement(By.xpath(configuration.getProperty("acf_id"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(configuration.getProperty("acf_label"))).getText(),expectedresult);
			break;
		}
		case"type":
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(configuration.getProperty("acf_type"))).getText(),expectedresult);
			break;
		}
		case"data type":
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(configuration.getProperty("acf_data_type"))).getText(),expectedresult);
			break;
		}
		case"default value":
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(configuration.getProperty("acf_default_value"))).getText(),expectedresult);
			break;
		}
		case"instructions":
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(configuration.getProperty("acf_instruction"))).getText(),expectedresult);
			break;
		}
		case"required":
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(configuration.getProperty("acf_required"))).getText(),expectedresult);
			break;
		}
		default :
		{
			throw new InvalidParameterException(column +" is not a valid column for acf page.");
		}
		}
		return new ACFPage(driver);			
	}
}