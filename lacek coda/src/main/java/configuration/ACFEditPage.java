package configuration;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.security.InvalidParameterException;

public class ACFEditPage extends PageBase {

	public ACFEditPage(WebDriver driver) 
	{
		super(driver);
	}
	//update client name
	public ACFEditPage updateClientNameTo(String newclientname)
	{
		readconfig();
		Assert.assertEquals(driver.findElement(By.id(configuration.getProperty("acf_edit_client"))).getText(),"Carnival Corporation & PLC");
		//return series edit page
		return new ACFEditPage(driver);
	}
	//update the brand
	public ACFEditPage updateBrandTo(String newbrandname)
	{		
		readconfig();
		driver.findElement(By.id(configuration.getProperty("acf_edit_brand"))).sendKeys(newbrandname);
		driver.findElement(By.id(configuration.getProperty("acf_edit_brand"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.id(configuration.getProperty("acf_edit_brand"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_edit_page_title"));
		//return series edit page
		return new ACFEditPage(driver);
	}
	//update the program
	public ACFEditPage updateProgramTo(String program)
	{		
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("acf_edit_program"))).sendKeys(program);
		driver.findElement(By.xpath(configuration.getProperty("acf_edit_program"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(configuration.getProperty("acf_edit_program"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_edit_page_title"));
		//return series edit page
		return new ACFEditPage(driver);
	}
	//update name
	public ACFEditPage updateGroupNameTo(String groupname)
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("acf_edit_group_name"))).clear();
		driver.findElement(By.id(configuration.getProperty("acf_edit_group_name"))).sendKeys(groupname);
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_edit_page_title"));
		//return series edit page
		return new ACFEditPage(driver);
	}
	//update name
	public ACFEditPage emptyGroupName()
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("acf_edit_group_name"))).clear();
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_edit_page_title"));
		//return series edit page
		return new ACFEditPage(driver);
	}
	//delete entry in screen field
	public ACFEditPage emptyScreenField()
	{
		readconfig();
		//counting the number of entry in the field
		int iCount = driver.findElements(By.id(configuration.getProperty("acf_edit_location_number"))).size();
		System.out.println("**screen: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(configuration.getProperty("acf_edit_location"))).sendKeys(Keys.BACK_SPACE);
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_edit_page_title"));
		return new ACFEditPage(driver);
	}
	//delete entry in brand field
	public ACFEditPage emptyBrandField()
	{
		readconfig();
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(configuration.getProperty("acf_edit_brand_number"))).size();
		System.out.println("**brand: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.id(configuration.getProperty("acf_edit_brand"))).sendKeys(Keys.BACK_SPACE);
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_edit_page_title"));
		return new ACFEditPage(driver);
	}
	//remove entries in program field
	public ACFEditPage deleteEntryInProgramField()
	{
		readconfig();
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(configuration.getProperty("acf_edit_program_number"))).size();
		System.out.println("**program: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(configuration.getProperty("acf_edit_program"))).sendKeys(Keys.BACK_SPACE);
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_edit_page_title"));
		return new ACFEditPage(driver);
	}
	//add action
	public ACFEditPage updateAction(String actionname)
	{
		readconfig();
		Select action = new Select(driver.findElement(By.id(configuration.getProperty("acf_edit_action"))));
		action.selectByVisibleText(actionname);
		return new ACFEditPage(driver);
	}
	//select a location
	public ACFEditPage updateScreen(String location)
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("acf_edit_location"))).sendKeys(location);
		driver.findElement(By.id(configuration.getProperty("acf_edit_location"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_edit_page_title"));
		Assert.assertTrue(driver.findElement(By.id(configuration.getProperty("acf_edit_location"))).isEnabled());
		//return acf add page
		return new ACFEditPage(driver);
	}
	//empty field label
	public ACFEditPage emptyFieldLabel()
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("acf_edit_editfield"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(configuration.getProperty("acf_edit_field_label"))).clear();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_edit_page_title"));
		//return acf add page
		return new ACFEditPage(driver);
	}
	//empty field name
	public ACFEditPage emptyFieldName()
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("acf_edit_editfield"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id(configuration.getProperty("acf_edit_field_name"))).clear();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_edit_page_title"));
		//return acf add page
		return new ACFEditPage(driver);
	}
	//empty field name
	public ACFEditPage emptyFieldInstructions()
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("acf_edit_editfield"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id(configuration.getProperty("acf_edit_field_instructions"))).clear();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_edit_page_title"));
		//return acf add page
		return new ACFEditPage(driver);
	}
	//add field label
	public ACFEditPage addFieldLabel (String fieldlabel)
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("acf_edit_field_label"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(configuration.getProperty("acf_edit_field_label"))).clear();
		driver.findElement(By.xpath(configuration.getProperty("acf_edit_field_label"))).sendKeys(fieldlabel);
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_edit_page_title"));
		//return acf add page
		return new ACFEditPage(driver);
	}
	//add field name
	public ACFEditPage addFieldName (String fieldname)
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("acf_edit_field_label"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id(configuration.getProperty("acf_edit_field_name"))).clear();
		driver.findElement(By.id(configuration.getProperty("acf_edit_field_name"))).sendKeys(fieldname);
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_edit_page_title"));
		//return acf add page
		return new ACFEditPage(driver);
	}
	//add field name
	public ACFEditPage addDataType(String datatype)
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("acf_edit_field_label"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Select action = new Select(driver.findElement(By.id(configuration.getProperty("acf_edit_data_type"))));
		action.selectByVisibleText(datatype);
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_edit_page_title"));
		//return acf add page
		return new ACFEditPage(driver);
	}
	//add field name
	public ACFEditPage addFieldType(String fieldtype)
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("acf_edit_field_label"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Select action = new Select(driver.findElement(By.id(configuration.getProperty("acf_edit_field_type"))));
		action.selectByVisibleText(fieldtype);
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_edit_page_title"));
		//return acf add page
		return new ACFEditPage(driver);
	}
	//add field name
	public ACFEditPage addFieldInstructions(String instructions)
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("acf_edit_field_label"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(configuration.getProperty("acf_edit_field_instructions"))).clear();
		driver.findElement(By.xpath(configuration.getProperty("acf_edit_field_instructions"))).sendKeys(instructions);
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_edit_page_title"));
		//return acf add page
		return new ACFEditPage(driver);
	}
	//acf is required or not required
	public ACFEditPage isRequired(boolean answer)
	{  
		readconfig();
		//no
		if(answer==false)
		{
			driver.findElement(By.xpath(configuration.getProperty("acf_edit_is_not_required"))).click();
			Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_edit_page_title"));
		}	
		//yes
		else if(answer==true)
		{
			driver.findElement(By.xpath(configuration.getProperty("acf_edit_is_required"))).click();
			Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_edit_page_title"));
		}
		else
		{
			throw new InvalidParameterException("answer "+answer +" is not supported, ref automation doc page.");
		}
		return new ACFEditPage(driver);
	}
	//add field name
	public ACFEditPage addCharacterLimit(int limit)
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("acf_edit_field_label"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(configuration.getProperty("acf_edit_character_limit"))).clear();
		driver.findElement(By.xpath(configuration.getProperty("acf_edit_character_limit"))).sendKeys(String.valueOf(limit));
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_edit_page_title"));
		//return acf add page
		return new ACFEditPage(driver);
	}
	//add field name
	public ACFEditPage closeAddField()
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("acf_edit_close"))).click();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_edit_page_title"));
		//return acf add page
		return new ACFEditPage(driver);
	}
	//click submit button in acf add page
	public ACFPage clickSubmitButton()
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("acf_edit_submit"))).click();
		try {
			Thread.sleep(16000);
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
		driver.findElement(By.xpath(configuration.getProperty("acf_edit_cancel"))).click();
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
	public ACFAddPage failToUpdate()
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("acf_edit_submit"))).click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("acf_edit_page_title"));
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
}