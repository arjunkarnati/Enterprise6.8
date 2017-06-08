package configuration;

import java.security.InvalidParameterException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import Utility.PageBase;

public class ACFAddPage extends PageBase {

	public ACFAddPage(WebDriver driver) 
	{
		super(driver);
	}
	//add client
	public ACFAddPage addClientName(String clientname) 
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("acf_add_client"))).click();
		driver.findElement(By.id(configuration.getProperty("acf_add_client_search_field"))).sendKeys(clientname);
		driver.findElement(By.id(configuration.getProperty("acf_add_client_search_field"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.findElement(By.id(configuration.getProperty("acf_add_client"))).getText(),clientname);
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_add_page_title"));
		//return acf add page
		return new ACFAddPage(driver);
	}
	//select a brand
	public ACFAddPage addBrand(String brandname)
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("acf_add_brand"))).click();
		driver.findElement(By.id(configuration.getProperty("acf_add_brand"))).sendKeys(brandname);
		driver.findElement(By.id(configuration.getProperty("acf_add_brand"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_add_page_title"));
		Assert.assertTrue(driver.findElement(By.id(configuration.getProperty("acf_add_brand"))).isEnabled());
		//return acf add page
		return new ACFAddPage(driver);
	}	
	//return to acf index page
	public ACFPage returnToMainPage()
	{
		readconfig();
		driver.findElement(By.linkText(configuration.getProperty("acf_main_page"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_page_title"));
		//return acf add page
		return new ACFPage(driver);
	}
	//select a program
	public ACFAddPage addProgram(String programname)
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("acf_add_program"))).clear();
		driver.findElement(By.id(configuration.getProperty("acf_add_program"))).sendKeys(programname);
		driver.findElement(By.id(configuration.getProperty("acf_add_program"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_add_page_title"));
		Assert.assertTrue(driver.findElement(By.id(configuration.getProperty("acf_add_program"))).isEnabled());
		//return acf add page
		return new ACFAddPage(driver);
	}
	//add name
	public ACFAddPage addGroupName(String groupname)
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("acf_add_group_name"))).clear();
		driver.findElement(By.id(configuration.getProperty("acf_add_group_name"))).sendKeys(groupname);	
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_add_page_title"));
		//return acf add page
		return new ACFAddPage(driver);
	}	
	//add action
	public ACFAddPage addAction(String actionname)
	{
		readconfig();
		Select action = new Select(driver.findElement(By.id(configuration.getProperty("acf_add_action"))));
		action.selectByVisibleText(actionname);
		return new ACFAddPage(driver);
	}
	//select a location
	public ACFAddPage addScreen(String location)
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("acf_add_location"))).clear();
		driver.findElement(By.id(configuration.getProperty("acf_add_location"))).sendKeys(location);
		driver.findElement(By.id(configuration.getProperty("acf_add_location"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_add_page_title"));
		Assert.assertTrue(driver.findElement(By.id(configuration.getProperty("acf_add_location"))).isEnabled());
		//return acf add page
		return new ACFAddPage(driver);
	}
	//empty field label
	public ACFAddPage emptyFieldLabel()
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("acf_add_addfield"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(configuration.getProperty("acf_add_field_label"))).clear();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_add_page_title"));
		//return acf add page
		return new ACFAddPage(driver);
	}
	//empty field name
	public ACFAddPage emptyFieldName()
	{
		readconfig();
		//driver.findElement(By.xpath(configuration.getProperty("acf_add_addfield"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id(configuration.getProperty("acf_add_field_name"))).clear();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_add_page_title"));
		//return acf add page
		return new ACFAddPage(driver);
	}
	//add field label
	public ACFAddPage addFieldLabel (String fieldlabel)
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("acf_add_addfield"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(configuration.getProperty("acf_add_field_label"))).clear();
		driver.findElement(By.xpath(configuration.getProperty("acf_add_field_label"))).sendKeys(fieldlabel);
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_add_page_title"));
		//return acf add page
		return new ACFAddPage(driver);
	}
	//add field name
	public ACFAddPage addFieldName (String fieldname)
	{
		readconfig();
		//driver.findElement(By.xpath(elementslocator.getProperty("acf_add_addfield"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id(configuration.getProperty("acf_add_field_name"))).clear();
		driver.findElement(By.id(configuration.getProperty("acf_add_field_name"))).sendKeys(fieldname);
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_add_page_title"));
		//return acf add page
		return new ACFAddPage(driver);
	}
	//add field name
	public ACFAddPage addDataType(String datatype)
	{
		readconfig();
		//driver.findElement(By.xpath(configuration.getProperty("acf_add_addfield"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Select action = new Select(driver.findElement(By.id(configuration.getProperty("acf_add_data_type"))));
		action.selectByVisibleText(datatype);
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_add_page_title"));
		//return acf add page
		return new ACFAddPage(driver);
	}
	//add field name
	public ACFAddPage addFieldType(String fieldtype)
	{
		readconfig();
		//driver.findElement(By.xpath(configuration.getProperty("acf_add_addfield"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Select action = new Select(driver.findElement(By.id(configuration.getProperty("acf_add_field_type"))));
		action.selectByVisibleText(fieldtype);
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_add_page_title"));
		//return acf add page
		return new ACFAddPage(driver);
	}
	//add field name
	public ACFAddPage addFieldInstructions(String instructions)
	{
		readconfig();
		//driver.findElement(By.xpath(elementslocator.getProperty("acf_add_addfield"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(configuration.getProperty("acf_add_field_instructions"))).clear();
		driver.findElement(By.xpath(configuration.getProperty("acf_add_field_instructions"))).sendKeys(instructions);
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_add_page_title"));
		//return acf add page
		return new ACFAddPage(driver);
	}
	//acf is required or not required
	public ACFAddPage isRequired(boolean answer)
	{  
		readconfig();
		//no
		if(answer==false)
		{
			driver.findElement(By.xpath(configuration.getProperty("acf_add_is_not_required"))).click();
			Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_add_page_title"));
		}	
		//yes
		else if(answer==true)
		{
			driver.findElement(By.xpath(configuration.getProperty("acf_add_is_required"))).click();
			Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_add_page_title"));
		}
		else
		{
			throw new InvalidParameterException("answer "+answer +" is not supported, ref automation doc page.");
		}
		return new ACFAddPage(driver);
	}
	//field type select additionnal fields
	public ACFAddPage addTextForfieldTypeSelect(String text)
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("acf_add_decimal_select_text"))).clear();
		driver.findElement(By.xpath(configuration.getProperty("acf_add_decimal_select_text"))).sendKeys(text);
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_add_page_title"));
		//return acf add page
		return new ACFAddPage(driver);
	}
	//field type select additionnal fields
	public ACFAddPage addValueForfieldTypeSelect(String value)
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("acf_add_decimal_select_value"))).clear();
		driver.findElement(By.xpath(configuration.getProperty("acf_add_decimal_select_value"))).sendKeys(value);
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_add_page_title"));
		//return acf add page
		return new ACFAddPage(driver);
	}
	//add field name
	public ACFAddPage addCharacterLimit(int limit)
	{
		readconfig();
		//driver.findElement(By.xpath(configuration.getProperty("acf_add_addfield"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(configuration.getProperty("acf_add_character_limit"))).clear();
		driver.findElement(By.xpath(configuration.getProperty("acf_add_character_limit"))).sendKeys(String.valueOf(limit));
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_add_page_title"));
		//return acf add page
		return new ACFAddPage(driver);
	}
	//add field name
	public ACFAddPage closeAddField()
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("acf_add_close"))).click();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_add_page_title"));
		//return acf add page
		return new ACFAddPage(driver);
	}
	//click submit button in acf add page
	public ACFPage clickSubmitButton()
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("acf_add_submit"))).click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_page_title"));
		//return acf page
		return new ACFPage(driver);
	}
	//click cancel button in acf add page
	public ACFPage clickCancelButton()
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("acf_add_cancel"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_page_title"));
		//driver.switchTo().alert().accept();
		return new ACFPage(driver);
	}
	//click save for failed
	public ACFAddPage failToCreate()
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("acf_add_submit"))).click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_add_page_title"));
		return new ACFAddPage(driver);
	}
}