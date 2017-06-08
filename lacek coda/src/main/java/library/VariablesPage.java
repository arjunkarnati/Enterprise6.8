package library;

import java.security.InvalidParameterException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Utility.PageBase;

public class VariablesPage extends PageBase{

	public VariablesPage(WebDriver driver) 
	{
		super(driver);
	}
	//click add variable button
	public VariablesAddPage clickAddVariableButton()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("var_add_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("var_add_page_title"));
		return new VariablesAddPage(driver);
	}
	//reload series page
	public VariablesPage reloadVariablePage()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("series_reload_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("var_page_title"));
		//return variable page
		return new VariablesPage(driver);
	}
	//open variables archive page
	public variablesArchivePage clickArchiveButton()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("var_archive_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("var_archive_page_title"));
		//return variables archive page
		return new variablesArchivePage(driver);
	}
	//edit variables
	public VariablesEditPage editVariables(String variablename)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(variablename);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch(variablename)
		{
		case "edit_variable_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_variable_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),library.getProperty("var_edit_page_title"));
			break;
		}
		case "edit_variable_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_variable_test_010"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),library.getProperty("var_edit_page_title"));
			break;
		}
		case "edit_ehi_variable":
		{
			driver.findElement(By.xpath(elementslocator.getProperty("var_edit_ehi_ae"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),library.getProperty("var_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("variable "+variablename +" cannot be edited, ref automation doc variable page.");
		}
		}
		return new VariablesEditPage(driver);
	}
	//restore variable
	public VariablesPage restoreVariable(String variablename)
	{
		readconfig();
		driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(variablename);
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		sleep();
		driver.findElement(By.xpath("html/body/div[6]/div/div/div[3]/button[1] | //button[@class='btn btn-success' and contains(text(),'Yes')]")).click();
		sleep();
		driver.findElement(By.id("reload")).click();
		sleep();		
		//assert ad verify	
		Assert.assertEquals(driver.getTitle(), library.getProperty("var_archive_page_title"));
		return new VariablesPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public VariablesPage archiveVariable(String variablename)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(variablename);
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
		driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[10]/div/div/a[2]")).click();
		//switch to active element 
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "yes" 
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();

		return new VariablesPage(driver);			
	}
	//test validation
	public VariablesPage validateUpdates(String variablename,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(variablename);
		switch(column)
		{
		case"client":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("var_client"))).getText(),expectedresult);
			break;
		}
		case"brands":
		{
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(library.getProperty("var_brand"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(library.getProperty("var_brand")));
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
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("var_name"))).getText(),expectedresult);
			break;
		}
		case"code":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("var_code"))).getText(),expectedresult);
			break;
		}
		case"is global":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("var_is_Global"))).getText(),expectedresult);
			break;
		}
		case"status":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("var_status"))).getText(),expectedresult);
			break;
		}
		case"default":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("var_default"))).getText(),expectedresult);
			break;
		}
		default :
		{
			throw new InvalidParameterException(column +" is not a column for coda page.");
		}
		}
		return new VariablesPage(driver);			
	}
	public VariablesPage verifyIdcolumn() {
		// TODO Auto-generated method stub
		WebElement id=driver.findElement(By.xpath(".//*[@id='datatable']/thead/tr/th[1]"));
		return new VariablesPage(driver);	
	}
	public PageBase ehi_ae_archiveVariable(String variablename) {
	
		{
			readconfig();
			driver.findElement(By.xpath(library.getProperty("filter"))).clear();
			driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(variablename);
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
			driver.findElement(By.xpath(library.getProperty("var_archive_button"))).click();
			//switch to active element 
			driver.switchTo().activeElement();
			sleep();
			// find the button which contains text "yes" 
			driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();

			return new VariablesPage(driver);			
		}
	}
	//restore variable
		public VariablesPage ehi_ae_restoreVariable(String variablename)
		{
			readconfig();
			driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
			sleep();
			driver.findElement(By.xpath("//input[@type='search']")).clear();
			sleep();
			driver.findElement(By.xpath("//input[@type='search']")).sendKeys(variablename);
			sleep();
			driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
			sleep();
			driver.findElement(By.xpath("html/body/div[6]/div/div/div[3]/button[1] | //button[@class='btn btn-success' and contains(text(),'Yes')]")).click();
			sleep();
			driver.findElement(By.id("reload")).click();
			sleep();		
			//assert ad verify	
			Assert.assertEquals(driver.getTitle(), library.getProperty("var_archive_page_title"));
			return new VariablesPage(driver);
		}
	
}