package library;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class CommunicationsAddPage extends PageBase {

	public CommunicationsAddPage(WebDriver driver) 
	{
		super(driver);
	}
	//enter client name in client field
	public CommunicationsAddPage addClientName(String clientname)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("comm_add_client"))).click();
		driver.findElement(By.id(library.getProperty("comm_add_client_search_field"))).sendKeys(clientname);
		driver.findElement(By.id(library.getProperty("comm_add_client_search_field"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.id(library.getProperty("comm_add_client"))).getText().equalsIgnoreCase(clientname));
		Assert.assertEquals(driver.getTitle(),library.getProperty("comm_add_page_title"));
		//return communications add page
		return new CommunicationsAddPage(driver);
	}
	//select a brand
	public CommunicationsAddPage addBrand(String brandname) 
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("comm_add_brand"))).sendKeys(brandname);
		driver.findElement(By.xpath(library.getProperty("comm_add_brand"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("comm_add_brand"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("comm_add_page_title"));
		//return communication add page
		return new CommunicationsAddPage(driver);
	}
	//select a program
	public CommunicationsAddPage addProgram(String programname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("comm_add_program"))).sendKeys(programname);
		driver.findElement(By.xpath(library.getProperty("comm_add_program"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("comm_add_program"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("comm_add_page_title"));
		//return communications add page
		return new CommunicationsAddPage(driver);
	}
	//select a track
	public CommunicationsAddPage addTrack(String trackname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("comm_add_track"))).sendKeys(trackname);
		driver.findElement(By.xpath(library.getProperty("comm_add_track"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("comm_add_track"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),library.getProperty("comm_add_page_title"));
		//return communications add page
		return new CommunicationsAddPage(driver);
	}
	//enter communication name in name field
	public CommunicationsAddPage addCommunicationName(String communicationname)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("comm_add_name"))).clear();
		driver.findElement(By.id(library.getProperty("comm_add_name"))).sendKeys(communicationname);
		Assert.assertEquals(driver.getTitle(),library.getProperty("comm_add_page_title"));
		//return communications add page
		return new CommunicationsAddPage(driver);
	}	
	//enter description in description field
	public CommunicationsAddPage addDescription(String description)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("comm_add_description"))).clear();
		driver.findElement(By.id(library.getProperty("comm_add_description"))).sendKeys(description);
		Assert.assertEquals(driver.getTitle(),library.getProperty("comm_add_page_title"));
		//return communications add page
		return new CommunicationsAddPage(driver);				
	}
	//add segments groups
	public CommunicationsAddPage addSegmentGroups(String segmentgroupsname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("comm_add_segment_group"))).sendKeys(segmentgroupsname);
		driver.findElement(By.xpath(library.getProperty("comm_add_segment_group"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("comm_add_segment_group"))).isEnabled());
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("comm_add_page_title")));	
		//return communications add page
		return new CommunicationsAddPage(driver);
	}
	//add template
	public CommunicationsAddPage addTemplate(String templatename)
	{
		readconfig();
		WebElement menu = driver.findElement(By.xpath(library.getProperty("comm_add_template")));
	    Actions build = new Actions(driver); 
	    build.moveToElement(menu).build().perform(); 
	    WebElement m2m= driver.findElement(By.xpath(library.getProperty("comm_add_template")));
	    m2m.click();
		driver.findElement(By.xpath(library.getProperty("comm_add_template_search_field"))).sendKeys(templatename);
		driver.findElement(By.xpath(library.getProperty("comm_add_template_search_field"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("comm_add_template"))).isEnabled());
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("comm_add_page_title")));	
		//return communications add page
		return new CommunicationsAddPage(driver);
	}
	//add connectors
	public CommunicationsAddPage addConnector(String connectorname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("comm_add_connector"))).sendKeys(connectorname);
		driver.findElement(By.xpath(library.getProperty("comm_add_connector"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("comm_add_connector"))).isEnabled());
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("comm_add_page_title")));	
		//return communications add page
		return new CommunicationsAddPage(driver);
	}	
	//click submit button in communications add page
	public CommunicationsPage clickSubmit()
	{
		readconfig();
		driver.findElement(By.name(library.getProperty("comm_add_submit"))).click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//assert and verify
		Assert.assertEquals(driver.getTitle(), library.getProperty("comm_page_title"));
		//return communications page
		driver.findElement(By.id(library.getProperty("comm_reload_button"))).click();
		return new CommunicationsPage(driver);
	}
	//click cancel button in communications add page
	public CommunicationsPage clickCancelButton()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("comm_add_cancel"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		//assert and verify
		Assert.assertEquals(driver.getTitle(), library.getProperty("comm_page_title"));
		//return communications  page
		return new CommunicationsPage(driver);
	}
	//click cancel button in communications add page
	public CommunicationsPage clickSaveAndContinueButton()
	{
		readconfig();
		driver.findElement(By.name(library.getProperty("comm_add_save_and_continue"))).click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		//assert and verify
		Assert.assertEquals(driver.getTitle(), library.getProperty("comm_add_page_title"));	
		//return communications  page
		return new CommunicationsPage(driver);
	}
	//communication is not created when required fields are not filled
	public CommunicationsAddPage failToCreate()
	{		
		readconfig();
		driver.findElement(By.name(library.getProperty("comm_add_submit"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(), library.getProperty("comm_add_page_title"));	
		return new CommunicationsAddPage(driver);
	}
	public CommunicationsAddPage openPublish(String URL, String username, String password) {
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
	return new CommunicationsAddPage(driver);	
	}
	public CommunicationsAddPage RunPublish() {
		
			// TODO Auto-generated method stub
			driver.findElement(By.xpath("//button[contains(text(),'Run Publish Command')]")).click();
			try{
			Thread.sleep(3000);}
			catch(Exception e){
				e.printStackTrace();
			}
			return new CommunicationsAddPage (driver);
		}
	public CommunicationsAddPage validateUpdates(String comunnicationname,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(comunnicationname);
		
		switch(column)
		{
		case"workflow":
		{
			Assert.assertEquals(driver.findElement(By.xpath("")).getText(),expectedresult);
			break;
		}
		}
		return new CommunicationsAddPage(driver);
	}	
}