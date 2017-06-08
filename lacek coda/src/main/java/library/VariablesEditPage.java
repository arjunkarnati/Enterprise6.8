package library;

import java.security.InvalidParameterException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utility.PageBase;

public class VariablesEditPage extends PageBase{

	public VariablesEditPage(WebDriver driver) 
	{
		super(driver);
	}
	//update client name
	public VariablesEditPage updateClientNameTo(String newclientname)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("var_edit_client"))).click();
		driver.findElement(By.id(library.getProperty("var_edit_client_search_field"))).sendKeys(newclientname);
		driver.findElement(By.id(library.getProperty("var_edit_client_search_field"))).sendKeys(Keys.ENTER);
		//the below line insert by ME
		//driver.findElement(By.xpath(".//*[@id='text_105']/div/div[1]/input")).sendKeys("0");
		//assert and verify
		Assert.assertTrue(driver.findElement(By.id(library.getProperty("var_edit_client"))).getText().equalsIgnoreCase(newclientname));
		//return series edit page
		return new VariablesEditPage(driver);
	}
	//public VariablesAddPage addacfvalue(String string) {
		// TODO Auto-generated method stub
	//	driver.findElement(By.xpath(".//*[@id='text_105']/div/div[1]/input")).sendKeys("0");
	//	return new VariablesAddPage(driver);
	//}
	//update the brand
	public VariablesEditPage updateBrandTo(String newbrandname)
	{		
		readconfig();
		driver.findElement(By.xpath(library.getProperty("var_edit_brand"))).sendKeys(newbrandname);
		driver.findElement(By.xpath(library.getProperty("var_edit_brand"))).sendKeys(Keys.ENTER);	
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("var_edit_brand"))).isEnabled());
		//return variables edit page
		return new VariablesEditPage(driver);
	}
	//update Variable name
	public VariablesEditPage updateVariableNameTo(String newvariablename)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("var_edit_name"))).clear();
		driver.findElement(By.id(library.getProperty("var_edit_name"))).sendKeys(newvariablename);
		//driver.findElement(By.xpath(".//*[@id='text_105']/div/div[1]/input")).sendKeys("0");

		return new VariablesEditPage(driver);
	}
	//update description field
	public VariablesEditPage updateDescription(String newdescription)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("var_edit_description"))).clear();
		driver.findElement(By.id(library.getProperty("var_edit_description"))).sendKeys(newdescription);
		//return variables edit page
		return new VariablesEditPage(driver);	
	}
	//activate and inactivate campaign
	public VariablesEditPage isActive(boolean answer)
	{  
		readconfig();
		//no
		if(answer==false)
		{
			driver.findElement(By.xpath(library.getProperty("var_status_inactive"))).click();
		}	
		//yes
		else if(answer==true)
		{
			driver.findElement(By.xpath(library.getProperty("var_status_active"))).click();
		}
		else
		{
			throw new InvalidParameterException
			("answer "+answer +" is not supported, ref automation doc workflow page.");
		}
		return new VariablesEditPage(driver);
	}
	//select submit button in variables edit page
	public VariablesPage clickSubmitButon()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("var_edit_submit"))).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//assert and verify
		Assert.assertEquals(driver.getTitle(),library.getProperty("var_page_title") );
		//return variables page
		return new VariablesPage(driver);
	}
	//select cancel button in variables edit page
	public VariablesPage clickCancelButoon()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("var_edit_cancel"))).click();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),library.getProperty("var_page_title") );
		//return variables page
		return new VariablesPage(driver);
	}
	//remove entries in brand field
	public VariablesEditPage deleteEntryInBrandField()
	{
		readconfig();
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(library.getProperty("var_edit_brand_number"))).size();
		System.out.println("**brands: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(library.getProperty("var_edit_brand"))).sendKeys(Keys.BACK_SPACE);
		}
		//return variables edit page
		return new VariablesEditPage(driver);
	}
	
	//EHI-AE
	//remove entries in brand field
		public VariablesEditPage deleteEntryInBrandField_ehi_ae()
		{
			readconfig();
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(library.getProperty("var_edit_brand_number_ehi_ae"))).size();
			System.out.println("**brands: "+iCount);
			for (int i=0; i<iCount;i++)
			{
				driver.findElement(By.xpath(library.getProperty("var_edit_brand_ehi_ae"))).sendKeys(Keys.BACK_SPACE);
				driver.findElement(By.xpath(library.getProperty("var_edit_brand_ehi_ae"))).sendKeys(Keys.BACK_SPACE);
			}
			//return variables edit page
			return new VariablesEditPage(driver);
		}
		//update the brand
		public VariablesEditPage ehi_ae_updateBrandTo(String newbrandname)
		{		
			readconfig();
			driver.findElement(By.xpath(library.getProperty("var_edit_brand_ehi_ae"))).sendKeys(newbrandname);
			driver.findElement(By.xpath(library.getProperty("var_edit_brand_ehi_ae"))).sendKeys(Keys.ENTER);	
			//assert and verify
			Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("var_edit_brand_ehi_ae"))).isEnabled());
			//return variables edit page
			return new VariablesEditPage(driver);
		}
}