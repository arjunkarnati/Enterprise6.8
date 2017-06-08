package library;

import java.security.InvalidParameterException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import Utility.PageBase;
import login.DashboardPage;

public class MessagesEditPage extends PageBase{

	public MessagesEditPage(WebDriver driver) 
	{
		super(driver);	
	}
	//update client name in client field
	public MessagesEditPage updateClientNameTo(String newclientname)
	{
		readconfig();
		if(driver.findElement(By.id(library.getProperty("mes_edit_client"))).getText().equals(newclientname))
		{
			driver.findElement(By.id(library.getProperty("mes_edit_submit"))).click(); 
		}
		else
		{
			driver.findElement(By.id(library.getProperty("mes_edit_client"))).click();
			driver.findElement(By.id(library.getProperty("mes_edit_client_search_field"))).sendKeys(newclientname);
			driver.findElement(By.id(library.getProperty("mes_edit_client_search_field"))).sendKeys(Keys.ENTER);
			//assert and verify
			Assert.assertTrue(driver.findElement(By.id(library.getProperty("mes_edit_client"))).getText().equalsIgnoreCase(newclientname));
			Assert.assertEquals(driver.getTitle(),library.getProperty("mess_edit_page_title"));
		}
		//return messages add page
		return new MessagesEditPage(driver);
	}
	//verify the locale text
	public MessagesEditPage previewlocales(String localename){
		readconfig();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String localetext = driver.findElement(By.xpath(".//*[@id='lang-tabs']/li[1]/a")).getText();
		try{
				driver.findElement(By.xpath(library.getProperty("mes_edit_preview"))).click();
				Assert.assertEquals(localetext.toLowerCase(),driver.findElement(By.xpath("//div[@id='s2id_locale']/a/span[1]")).getText().toLowerCase());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return new MessagesEditPage(driver);
	}
	//update the brand
	public MessagesEditPage UpdateBrandTo(String newbrandname) 
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("mes_edit_brand"))).sendKeys(newbrandname);
		driver.findElement(By.xpath(library.getProperty("mes_edit_brand"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("mes_edit_brand"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_edit_page_title"));
		//return messages edit page
		return new MessagesEditPage(driver);
	}
	//update the CCL brand
		public MessagesEditPage updatecclbrand(String newbrandname) 
		{
			readconfig();
			driver.findElement(By.xpath(library.getProperty("mes_addccl_brand"))).sendKeys(newbrandname);
			driver.findElement(By.xpath(library.getProperty("mes_addccl_brand"))).sendKeys(Keys.ENTER);
			//assert and verify
			Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("mes_addccl_brand"))).isEnabled());
			Assert.assertEquals(driver.getTitle(),library.getProperty("mess_edit_page_title"));
			//return messages edit page
			return new MessagesEditPage(driver);
		}
	//update a program
	public MessagesEditPage updateProgramTo(String newprogramname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("mes_edit_program"))).sendKeys(newprogramname);
		driver.findElement(By.xpath(library.getProperty("mes_edit_program"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("mes_edit_program"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_edit_page_title"));
		//return messages edit page
		return new MessagesEditPage(driver);
	}
	//update message name 
	public MessagesEditPage updateMessageNameTo(String newmessagename)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("mes_edit_name"))).clear();
		driver.findElement(By.id(library.getProperty("mes_edit_name"))).sendKeys(newmessagename);
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_edit_page_title"));
		//return messages edit page
		return new MessagesEditPage(driver);
	}	
	//update description in description field
	public MessagesEditPage updateDescription(String newdescription)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("mes_edit_description"))).clear();
		driver.findElement(By.id(library.getProperty("mes_edit_description"))).sendKeys(newdescription);
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_edit_page_title"));
		//return messages edit page
		return new MessagesEditPage(driver);				
	}
	//activate and inactivate
	public MessagesEditPage isActive(boolean answer)
	{
		readconfig();
		if(answer==false)
		{
			driver.findElement(By.xpath(library.getProperty("mes_status_inactive"))).click();
			Assert.assertEquals(driver.getTitle(),library.getProperty("mess_edit_page_title"));
		}			
		else if(answer==true)
		{
			driver.findElement(By.xpath(library.getProperty("mes_status_active"))).click();
			Assert.assertEquals(driver.getTitle(),library.getProperty("mess_edit_page_title"));
		}
		else
		{
			throw new InvalidParameterException
			("answer "+answer +" is not supported, ref automation doc track page.");
		}
		return new MessagesEditPage(driver);
	}
	//set workflow to
	public MessagesPage setWorkFlowTo(String workflowname, String messagename)
	{
		readconfig();
		switch(workflowname)
		{
		case "DRAFT":
		{
			driver.findElement(By.id(library.getProperty("mes_edit_workflow"))).sendKeys("D");
			driver.findElement(By.xpath(library.getProperty("mes_edit_submit"))).click();
			Assert.assertEquals(driver.getTitle(),library.getProperty("mess_page_title"));
			break;
		}
		case "APPROVED":
		{
			driver.findElement(By.id(library.getProperty("mes_edit_workflow"))).sendKeys("A");
			driver.findElement(By.xpath(library.getProperty("mes_edit_submit"))).click();
			Assert.assertEquals(driver.getTitle(),library.getProperty("mess_page_title"));
			break;
		}
		case "Qatest1":
		{
			driver.findElement(By.id(library.getProperty("mes_edit_workflow"))).sendKeys("Q");
			driver.findElement(By.id(library.getProperty("mes_edit_submit"))).click();
			Assert.assertEquals(driver.getTitle(),library.getProperty("mess_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("Please verify the workflow name");
		}
		}
		return new MessagesPage(driver);
	}
	//update variables
	public MessagesEditPage updateVariablesTo(String newvariablename)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("mes_edit_variable"))).sendKeys(newvariablename);
		driver.findElement(By.xpath(library.getProperty("mes_edit_variable"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("mes_edit_variable"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_edit_page_title"));
		//return messages edit page
		return new MessagesEditPage(driver);
	}
	//update template
	public MessagesEditPage updatetemplatesTo(String newtemplatename)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("mes_edit_template"))).sendKeys(newtemplatename);
		driver.findElement(By.xpath(library.getProperty("mes_edit_template"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("mes_edit_template"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_edit_page_title"));
		//return messages edit page
		return new MessagesEditPage(driver);
	}
	//update template
		public MessagesEditPage updatetemplatesbyCarnival(String newtemplatename)
		{
			readconfig();
			driver.findElement(By.xpath(library.getProperty("mes_edit_templatebyCCL_AE"))).sendKeys(newtemplatename);
			driver.findElement(By.xpath(library.getProperty("mes_edit_templatebyCCL_AE"))).sendKeys(Keys.ENTER);
			//assert and verify
			Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("mes_edit_templatebyCCL_AE"))).isEnabled());
			Assert.assertEquals(driver.getTitle(),library.getProperty("mess_edit_page_title"));
			//return messages edit page
			return new MessagesEditPage(driver);
		}
	//update connectors
	public MessagesEditPage updateConnectorTo(String newconnectorname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("mes_edit_connector"))).sendKeys(newconnectorname);
		driver.findElement(By.xpath(library.getProperty("mes_edit_connector"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("mes_edit_connector"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_edit_page_title"));
		//return messages edit page
		return new MessagesEditPage(driver);
	}
	//click cancel button
	public MessagesPage clickCancelButton()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("mes_edit_cancel"))).click();
		//assert and verify
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("mess_page_title")));
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_page_title"));
		return new MessagesPage(driver);
	}
	//click save button
	public MessagesEditPage clickSaveButton()
	{
		readconfig();
		driver.findElement(By.name(library.getProperty("mes_edit_save"))).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//assert and verify
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("mess_edit_page_title")));
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_edit_page_title"));
		return new MessagesEditPage(driver);
	}
	//click save and clone button
	public void clickSaveAndCloneButton()
	{
		readconfig();
		driver.findElement(By.name(library.getProperty("mes_edit_save_and_clone"))).click();
		driver.findElement(By.xpath("html/body/div[7]/div/div/div[3]/button[1]")).click();
		//assert and verify
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("mess_edit_page_title")));
	}
	//click preview button
	public MessagesPreviewPage clickPreviewButton()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("mes_edit_preview"))).click();
		//assert and verify
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("mess_preview_page_title")));
		return new MessagesPreviewPage(driver);
	}
	//click submit button
	public MessagesPage clickSubmitButton()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("mes_edit_submit"))).click();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//assert and verify
		//Assert.assertEquals(driver.getTitle(),library.getProperty("mess_page_title"));
		return new MessagesPage(driver);
	}
	
	
	//delete entry in brand field
	public MessagesEditPage deleteEntryInBrandfield() 
	{
		readconfig();	
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(library.getProperty("mes_edit_brand_number"))).size();
		System.out.println("**brands: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(library.getProperty("mes_edit_brand"))).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(library.getProperty("mes_edit_brand"))).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(library.getProperty("mes_edit_brand"))).sendKeys(Keys.BACK_SPACE);
		}
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("mes_edit_brand"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_edit_page_title"));
		//return messages edit page
		return new MessagesEditPage(driver);
	}
	//delete entry in brand field
		public MessagesEditPage deleteEntryInCCLBrandfield() 
		{
			readconfig();	
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(library.getProperty("mes_edit_CCLbrand_number"))).size();
			System.out.println("**brands: "+iCount);
			for (int i=0; i<iCount;i++)
			{
				driver.findElement(By.xpath(library.getProperty("mes_edit_CCLbrand"))).sendKeys(Keys.BACK_SPACE);
			}
			//assert and verify
			Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("mes_edit_CCLbrand"))).isEnabled());
			Assert.assertEquals(driver.getTitle(),library.getProperty("mess_edit_page_title"));
			//return messages edit page
			return new MessagesEditPage(driver);
		}
	//delete entry in program field
	public MessagesEditPage deleteEntryInProgramField()
	{
		readconfig();
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(library.getProperty("mes_edit_program_number"))).size();
		System.out.println("**programs: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(library.getProperty("mes_edit_program"))).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(library.getProperty("mes_edit_program"))).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(library.getProperty("mes_edit_program"))).sendKeys(Keys.BACK_SPACE);
		}
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("mes_edit_program"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_edit_page_title"));
		//return messages edit page
		return new MessagesEditPage(driver);
	}
	//delete entry in variable field
	public MessagesEditPage deleteEntryInVariablesField()
	{
		readconfig();
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(library.getProperty("mes_edit_variable_number"))).size();
		System.out.println("**variables: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(library.getProperty("mes_edit_variable"))).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(library.getProperty("mes_edit_variable"))).sendKeys(Keys.BACK_SPACE);
		}
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("mes_edit_variable"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_edit_page_title"));
		//return messages edit page
		return new MessagesEditPage(driver);
	}
	//delete entry in templates field
	public MessagesEditPage deleteEntryIntemplatesField()
	{
		readconfig();
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(library.getProperty("mes_edit_template_number"))).size();
		System.out.println("**templates: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(library.getProperty("mes_edit_template"))).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(library.getProperty("mes_edit_template"))).sendKeys(Keys.BACK_SPACE);
		}
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("mes_edit_template"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_edit_page_title"));
		//return messages edit page
		return new MessagesEditPage(driver);
	}
	//delete entry in templates field by CCL
		public MessagesEditPage deleteEntryIntemplatesFieldbyCarnival()
		{
			readconfig();
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(library.getProperty("mes_edit_template_number"))).size();
			System.out.println("**templates: "+iCount);
			for (int i=0; i<iCount;i++)
			{
				driver.findElement(By.xpath(library.getProperty("mes_edit_templatebyCCL_AE"))).sendKeys(Keys.BACK_SPACE);
			}
			//assert and verify
			Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("mes_edit_templatebyCCL_AE"))).isEnabled());
			Assert.assertEquals(driver.getTitle(),library.getProperty("mess_edit_page_title"));
			//return messages edit page
			return new MessagesEditPage(driver);
		}
	//delete entry in connector field
	public MessagesEditPage deleteEntryInConnectorT()
	{
		readconfig();
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(library.getProperty("mes_edit_connector_number"))).size();
		System.out.println("**templates: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(library.getProperty("mes_edit_connector"))).sendKeys(Keys.BACK_SPACE);
		}
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("mes_edit_connector"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_edit_page_title"));
		//return messages edit page
		return new MessagesEditPage(driver);
	}
	//message is not created when required fields are not filled
	public MessagesEditPage failToUpdate()
	{		
		readconfig();
		driver.findElement(By.id(library.getProperty("mes_edit_submit"))).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_edit_page_title"));
		return new MessagesEditPage(driver);
	}
	public MessagesEditPage publishMessage(String messagename) {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(messagename);
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[18]/div/a/i")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new MessagesEditPage(driver);
	}
	public MessagesEditPage openPublish(String URL, String username, String password) {
		// TODO Auto-generated method stub
		driver.get(URL);
		if(driver.findElements(By.id(elementslocator.getProperty("user_name"))).size()!=0){
		driver.findElement(By.id(elementslocator.getProperty("user_name"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("user_name"))).sendKeys(username);
		waitForAjax(driver);
		driver.findElement(By.id(elementslocator.getProperty("password"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("password"))).sendKeys(password);
		waitForAjax(driver);
		driver.findElement(By.id(elementslocator.getProperty("login_button"))).click();	
		}
	return new MessagesEditPage(driver);	
	}
	public MessagesEditPage RunPublish() {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("//button[contains(text(),'Run Publish Command')]")).click();
		try{
		Thread.sleep(3000);}
		catch(Exception e){
			e.printStackTrace();
		}
		return new MessagesEditPage(driver);
	}
		public MessagesEditPage clickMessagesLink() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("library"))).click();
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("messages"))));
		try{
			Thread.sleep(5000);
		driver.findElement(By.xpath(elementslocator.getProperty("messages"))).click();
		}catch(Exception e){
			e.printStackTrace();
		}
		//	waitForAjax(driver);
		//assert that system naviagtes in messages page
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("mess_page_title"));
		return new MessagesEditPage(driver);
	}
		public MessagesEditPage validateUpdates(String messagename, String column, String expectedresult) {
			// TODO Auto-generated method stub
			readconfig();
			driver.findElement(By.xpath(library.getProperty("filter"))).clear();
			driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(messagename);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			switch(column)
			{
			case "workflow":
			{
				Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("mes_workflow"))).getText(),expectedresult);
				break;
			}
		}
			return new MessagesEditPage(driver);

		}	
		
		public MessagesEditPage addLocales() {
			// TODO Auto-generated method stub
			readconfig();
			//Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("Message_add_locale"))).getClass());
			Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("Message_add_locale"))).isDisplayed());
			//driver.findElement(By.xpath(library.getProperty("Message_locale_french"))).click();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			
			return new MessagesEditPage(driver);
			
		}
	
		public MessagesPage previewmessage() {
			// TODO Auto-generated method stub
			readconfig();
			
			driver.findElement(By.xpath(library.getProperty("message_preview"))).click();
			//driver.findElement(By.xpath(library.getProperty("Message_locale_french"))).click();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			
			return new MessagesPage(driver);
			
		}
}