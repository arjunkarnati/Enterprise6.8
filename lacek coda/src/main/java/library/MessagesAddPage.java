package library;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utility.PageBase;

public class MessagesAddPage extends PageBase {

	public MessagesAddPage(WebDriver driver) 
	{
		super(driver);
	}
	//enter client name in client field
	public MessagesAddPage addClientName(String clientname)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("mes_add_client"))).click();
		driver.findElement(By.id(library.getProperty("mes_add_client_search_field"))).sendKeys(clientname);
		driver.findElement(By.id(library.getProperty("mes_add_client_search_field"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertEquals(driver.findElement(By.id(library.getProperty("mes_add_client"))).getText(),clientname);
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_add_page_title"));	
		//return messages add page
		return new MessagesAddPage(driver);
	}
	//select a brand
	public MessagesAddPage addBrand(String brandname) 
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("mes_add_brand"))).sendKeys(brandname);
		driver.findElement(By.xpath(library.getProperty("mes_add_brand"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("mes_add_brand"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_add_page_title"));
		//return messages add page
		return new MessagesAddPage(driver);
	}
	//select a program
	public MessagesAddPage addProgram(String programname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("mes_add_program"))).sendKeys(programname);
		driver.findElement(By.xpath(library.getProperty("mes_add_program"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("mes_add_program"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_add_page_title"));
		//return messages add page
		return new MessagesAddPage(driver);
	}
	//enter message name in name field
	public MessagesAddPage addMessageName(String messagename)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("mes_add_name"))).clear();
		driver.findElement(By.id(library.getProperty("mes_add_name"))).sendKeys(messagename);
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_add_page_title"));
		//return messages add page
		return new MessagesAddPage(driver);
	}	
	//enter description in description field
	public MessagesAddPage addDescription(String description)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("mes_add_description"))).clear();
		driver.findElement(By.id(library.getProperty("mes_add_description"))).sendKeys(description);
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_add_page_title"));
		//return messages add page
		return new MessagesAddPage(driver);				
	}
	//add variables
	public MessagesAddPage addVariables(String variablename)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("mes_add_variable"))).sendKeys(variablename);
		driver.findElement(By.xpath(library.getProperty("mes_add_variable"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("mes_add_variable"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_add_page_title"));
		//return messages add page
		return new MessagesAddPage(driver);
	}
	//add template
	public MessagesAddPage addtemplates(String templatename)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("mes_add_template"))).sendKeys(templatename);
		driver.findElement(By.xpath(library.getProperty("mes_add_template"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("mes_add_template"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_add_page_title"));
		//return messages add page
		return new MessagesAddPage(driver);
	}
	//add connectors
	public MessagesAddPage addConnector(String connectorname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("mes_add_connector"))).sendKeys(connectorname);
		driver.findElement(By.xpath(library.getProperty("mes_add_connector"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("mes_add_connector"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_add_page_title"));
		//return messages add page
		return new MessagesAddPage(driver);
	}	
	//click submit button in messges add page
	public MessagesPage clickSubmitButton()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("mes_add_submit"))).click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Assert.assertEquals(driver.getTitle(),library.getProperty("mess_edit_page_title"));
		//return messages page
		return new MessagesPage(driver);
	}
	//click cancel button in messages add page
	public MessagesPage clickCancelButton()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("mes_add_cancel"))).click();
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_page_title"));
		//driver.switchTo().alert().accept();
		//return messages  page
		return new MessagesPage(driver);
	}
	//click save for failed
	public MessagesAddPage failToCreate()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("mes_add_submit"))).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_add_page_title"));
		return new MessagesAddPage(driver);
	}
	
	
	public MessagesAddPage addcclBrand(String brandname) {
		readconfig();
		driver.findElement(By.xpath(library.getProperty("mes_addccl_brand"))).sendKeys(brandname);
		driver.findElement(By.xpath(library.getProperty("mes_addccl_brand"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("mes_addccl_brand"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_add_page_title"));
	
		// TODO Auto-generated method stub
		return new MessagesAddPage(driver);
	}
}