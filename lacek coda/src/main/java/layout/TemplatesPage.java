package layout;

import java.security.InvalidParameterException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Utility.PageBase;

public class TemplatesPage extends PageBase{

	public TemplatesPage(WebDriver driver) 
	{
		super(driver);
	}
	//open templates add page
	public TemplatesAddPage clickAddTemplateButton()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("template_add_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("template_add_page_title"));
		//return templates add page
		return new TemplatesAddPage(driver);
	}	
	//open templates archive page
	public TemplatesArchivePage clickArchiveButton()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("template_archive_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("template_archive_page_title"));
		//return templates archive page
		return new TemplatesArchivePage(driver);
	}
	//edit a template
	public TemplatesEditPage editTemplate(String templatename)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(templatename);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch(templatename)
		{
		case "edit_template_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_template_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("template_edit_page_title"));
			break;
		}
		case "edit_template_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_template_test_010"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("template_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("template "+templatename +" cannot be edited, ref automation doc template page.");
		}
		}
		return new TemplatesEditPage(driver);
	}
	//restore a template	
	public TemplatesPage restoreTemplate(String templatename)
	{
		readconfig();
		driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(templatename);
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		sleep();
		driver.findElement(By.xpath("html/body/div[7]/div/div/div[3]/button[1]")).click();
		sleep();
		driver.findElement(By.id("reload")).click();
		sleep();		
		//assert ad verify	
		Assert.assertEquals(driver.getTitle(), elementslocator.getProperty("template_archive_page_title"));
		return new TemplatesPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public TemplatesPage archiveTemplate(String templatename)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(templatename);
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
		driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[13]/div/div/a[4]/i")).click();
		//switch to active element 
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "yes" 
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		return new TemplatesPage(driver);			
	}
	//test validation
	public TemplatesPage validateUpdates(String seriesname,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(seriesname);
		switch(column)
		{
		case"client":
		{
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("template_client"))).getText(),expectedresult);
			break;
		}
		case"brand":
		{
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(elementslocator.getProperty("template_brand"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(elementslocator.getProperty("template_brand")));
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
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("template_name"))).getText(),expectedresult);
			break;
		}
		case"code":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("template_code"))).getText(),expectedresult);
			break;
		}
		case"type":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("template_type"))).getText(),expectedresult);
			break;
		}
		case"channel":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("template_channel"))).getText(),expectedresult);
			break;
		}
		case"status":
		{try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("template_status"))).getText(),expectedresult);
			break;
		}
		case"workflow":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("template_workflow"))).getText(),expectedresult);
			break;
		}
		default :
		{
			throw new InvalidParameterException(column +" is not a column for locales page.");
		}
		}
		return new TemplatesPage(driver);			
	}
}