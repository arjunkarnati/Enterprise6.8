package library;

import java.security.InvalidParameterException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Utility.PageBase;

public class VariablesAddPage extends PageBase{

	public VariablesAddPage(WebDriver driver) 
	{
		super(driver);		
	}
	//enter client name in client field
	public VariablesAddPage addClientName(String clientname)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("var_add_client"))).click();
		driver.findElement(By.id(library.getProperty("var_add_client_search_field"))).sendKeys(clientname);
		driver.findElement(By.id(library.getProperty("var_add_client_search_field"))).sendKeys(Keys.ENTER);
		sleep();
		//assert and verify
		Assert.assertTrue(driver.findElement(By.id(library.getProperty("var_add_client"))).getText().equalsIgnoreCase(clientname));
		//return variables add page
		return new VariablesAddPage(driver);
	}
	//select a brand
	public VariablesAddPage addBrand(String brandname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("var_add_brand"))).sendKeys(brandname);
		driver.findElement(By.xpath(library.getProperty("var_add_brand"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("var_add_brand"))).isEnabled());
		//return variables add page
		return new VariablesAddPage(driver);
	}
	//enter tracks name in name field
	public VariablesAddPage addVariableName(String variablename)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("var_add_name"))).clear();
		driver.findElement(By.id(library.getProperty("var_add_name"))).sendKeys(variablename);
		//return variables add page
		return new VariablesAddPage(driver);
	}	
	//enter description in description field
	public VariablesAddPage addDescription(String description)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("var_add_description"))).clear();
		driver.findElement(By.id(library.getProperty("var_add_description"))).sendKeys(description);
		//return variables add page
		return new VariablesAddPage(driver);				
	}
	//enter description in dafault field
	public VariablesAddPage addDefault(String defaultvalue)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("var_add_default"))).clear();
		driver.findElement(By.id(library.getProperty("var_add_default"))).sendKeys(defaultvalue);
		//return variables add page
		return new VariablesAddPage(driver);				
	}
	//global/locale variable	
	public VariablesAddPage isGlobal(boolean answer)
	{  
		readconfig();
		//no
		if(answer==true)
		{
			driver.findElement(By.xpath(library.getProperty("var_add_is_global"))).click();
		}	
		//yes
		else if(answer==false)
		{
			sleep();
		}
		else
		{
			throw new InvalidParameterException("answer "+answer +" is not supported, ref automation doc variable page.");
		}
		return new VariablesAddPage(driver);
	}
	//click button cancel
	public VariablesPage clickCancel()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("var_add_cancel"))).click();
		//assert and verify
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("var_page_title")));
		return new VariablesPage(driver);
	}
	//click button submit
	public VariablesPage clickSubmit()
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("var_add_submit"))).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//assert and verify
		return new VariablesPage(driver);
	}
	//click save for failed
	public VariablesAddPage failToCreate()
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("var_add_submit"))).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("var_add_page_title"));
		return new VariablesAddPage(driver);
	}
	public VariablesAddPage addacfvalue(String string) {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath(".//*[@id='text_105']/div/div[1]/input")).sendKeys("0");
		return new VariablesAddPage(driver);
	}
}