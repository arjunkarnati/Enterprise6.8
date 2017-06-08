package manage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utility.PageBase;

public class ProgramsEditPage extends PageBase {

	public ProgramsEditPage(WebDriver driver) 
	{
		super(driver);
	}
	//update client name in client field
	public ProgramsEditPage updateClientNameTo(String newclientname) 
	{		
		readconfig();
		if(driver.findElement(By.id(manage.getProperty("program_edit_client"))).getText().equals(newclientname))
		{
			driver.findElement(By.xpath(manage.getProperty("program_edit_client"))).click();
		}
		else
		{
			driver.findElement(By.id(manage.getProperty("program_edit_client"))).click();
			driver.findElement(By.id(manage.getProperty("camp_edit_client_search_field"))).sendKeys(newclientname);
			driver.findElement(By.id(manage.getProperty("camp_edit_client_search_field"))).sendKeys(Keys.ENTER);
		}
		//assert and verify
		Assert.assertEquals(driver.findElement(By.id(manage.getProperty("program_edit_client"))).getText(),newclientname);
		Assert.assertEquals(driver.getTitle(), manage.getProperty("program_edit_page_title"));
		//return programs edit page
		return new ProgramsEditPage(driver);
	}
	//update a brand
	public ProgramsEditPage updateBrandTo(String newbrandname)
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("program_edit_brand"))).sendKeys(newbrandname);
		driver.findElement(By.xpath(manage.getProperty("program_edit_brand"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(manage.getProperty("program_edit_brand"))).isEnabled());
		Assert.assertEquals(driver.getTitle(), manage.getProperty("program_edit_page_title"));
		//return programs edit page
		return new ProgramsEditPage(driver);
	}
	//update program name
	public ProgramsEditPage updateProgramNameTo(String newprogramname)
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("program_edit_name"))).clear();
		driver.findElement(By.id(manage.getProperty("program_edit_name"))).sendKeys(newprogramname);
		Assert.assertEquals(driver.getTitle(), manage.getProperty("program_edit_page_title"));
		//return programs edit page
		return new ProgramsEditPage(driver);
	}
	//delete program name
	public ProgramsEditPage deleteName()
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("program_edit_name"))).clear();
		Assert.assertEquals(driver.getTitle(), manage.getProperty("program_edit_page_title"));
		//return programs edit page
		return new ProgramsEditPage(driver);
	}
	//update  url 
	public ProgramsEditPage updateUrlTo(String newurl)
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("program_edit_url"))).clear();
		driver.findElement(By.id(manage.getProperty("program_edit_url"))).sendKeys(newurl);
		Assert.assertEquals(driver.getTitle(), manage.getProperty("program_edit_page_title"));
		//return programs edit page
		return new ProgramsEditPage(driver);
	}
	//delete program name
	public ProgramsEditPage deleteUrl()
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("program_edit_url"))).clear();
		Assert.assertEquals(driver.getTitle(), manage.getProperty("program_edit_page_title"));
		//return programs edit page
		return new ProgramsEditPage(driver);
	}
	//update  description 
	public ProgramsEditPage updateDescription(String description)
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("program_edit_description"))).clear();
		driver.findElement(By.id(manage.getProperty("program_edit_description"))).sendKeys(description);
		Assert.assertEquals(driver.getTitle(), manage.getProperty("program_edit_page_title"));
		//return programs edit page
		return new ProgramsEditPage(driver);
	}
	//click cancel
	public ProgramsPage clickCancel()
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("program_edit_cancel"))).click();
		//driver.switchTo().alert().accept();
		//assert and verify
		Assert.assertEquals(driver.getTitle(), manage.getProperty("program_page_title"));
		return new ProgramsPage(driver);
	}
	//click submit
	public ProgramsPage clickSubmit()
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("program_edit_submit"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//assert and verify
		Assert.assertEquals(driver.getTitle(), manage.getProperty("program_page_title"));
		//return programs edit page
		return new ProgramsPage(driver);
	}
	//activate program
	public ProgramsEditPage activateProgram()
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("program_edit_activate"))).click();
		Assert.assertEquals(driver.getTitle(), manage.getProperty("program_edit_page_title"));
		//return programs edit page
		return new ProgramsEditPage(driver);
	}
	//inactivate  program
	public ProgramsEditPage inactivateProgram()
	{
		readconfig();
		driver.findElement(By.xpath(manage.getProperty("program_edit_inactivate"))).click();
		Assert.assertEquals(driver.getTitle(), manage.getProperty("program_edit_page_title"));
		//return programs edit page
		return new ProgramsEditPage(driver);
	}
	//remove entries in brand field
	public ProgramsEditPage deleteEntryInBrandField()
	{
		readconfig();	
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(manage.getProperty("program_edit_brand_number"))).size();
		System.out.println("**brand: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(manage.getProperty("program_edit_brand"))).sendKeys(Keys.BACK_SPACE);
		}
		//return programs edit page
		return new ProgramsEditPage(driver);	
	}
	//click save for failed
	public ProgramsEditPage failToUpdate()
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("program_edit_submit"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),manage.getProperty("program_edit_page_title"));
		return new ProgramsEditPage(driver);
	}
}