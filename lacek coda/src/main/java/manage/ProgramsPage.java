package manage;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.security.InvalidParameterException;
import java.util.List;

public class ProgramsPage extends PageBase{

	public ProgramsPage(WebDriver driver) 
	{
		super(driver);
	}
	//open programs add page
	public ProgramsAddPage clickAddProgramButton()
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("program_add_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),manage.getProperty("program_add_page_title"));
		//return programs add page
		return new ProgramsAddPage(driver);
	}	
	//open programs archive page
	public ProgramsArchivePage clickArchiveButton()
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("program_archive_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),manage.getProperty("program_archive_page_title"));
		//return programs archive page
		return new ProgramsArchivePage(driver);
	}
	//edit a program
	public ProgramsEditPage editProgram(String programname)
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("filter"))).clear();
		driver.findElement(By.xpath(manage.getProperty("filter"))).sendKeys(programname);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch(programname)
		{
		case "edit_program_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_program_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),manage.getProperty("program_edit_page_title"));
			break;
		}
		case "edit_program_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_program_test_010"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),manage.getProperty("program_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("program "+programname +" cannot be edited, ref automation doc program page.");
		}
		}
		return new ProgramsEditPage(driver);
	}
	//restore program
	public ProgramsPage restoreProgram(String programname)
	{
		readconfig();
		driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(programname);
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		sleep();
		driver.findElement(By.xpath("html/body/div[7]/div/div/div[3]/button[1]")).click();
		sleep();
		driver.findElement(By.id("reload")).click();
		sleep();		
		//assert ad verify	
		Assert.assertEquals(driver.getTitle(), manage.getProperty("program_archive_page_title"));
		return new ProgramsPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public ProgramsPage archiveProgram(String programname)
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("filter"))).clear();
		driver.findElement(By.xpath(manage.getProperty("filter"))).sendKeys(programname);
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
		driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();
		//switch to active element 
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "yes" 
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		return new ProgramsPage(driver);			
	}
	//test validation
	public ProgramsPage validateUpdates(String programname,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("filter"))).clear();
		driver.findElement(By.xpath(manage.getProperty("filter"))).sendKeys(programname);
		switch(column)
		{
		case"client":
		{
			Assert.assertEquals(driver.findElement(By.xpath(manage.getProperty("program_client"))).getText(),expectedresult);
			break;
		}
		case"brand":
		{
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(manage.getProperty("program_brand"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(manage.getProperty("program_brand")));
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
			Assert.assertEquals(driver.findElement(By.xpath(manage.getProperty("program_name"))).getText(),expectedresult);
			break;
		}
		case"url":
		{
			Assert.assertEquals(driver.findElement(By.xpath(manage.getProperty("program_url"))).getText(),expectedresult);
			break;
		}
		case"status":
		{
			Assert.assertEquals(driver.findElement(By.xpath(manage.getProperty("program_status"))).getText(),expectedresult);
			break;
		}
		default :
		{
			throw new InvalidParameterException(column +" is not a column for locales page.");
		}
		}
		return new ProgramsPage(driver);			
	}
}