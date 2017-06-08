package library;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Utility.PageBase;

public class MessagesPage extends PageBase{

	WebDriverWait wait = new WebDriverWait(driver, 15);
	static String bname;
	public MessagesPage(WebDriver driver) 
	{
		super(driver);
	}
	//open messages add page
	public MessagesAddPage clickAddMessageButton()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("mes_add_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_add_page_title"));
		//return series add page//return messages add page
		return new MessagesAddPage(driver);
	}	
	//reload messages page
	public MessagesPage reloadMessagesPage()
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("mes_reload_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("mess_page_title"));
		//return series page
		return new MessagesPage(driver);
	}
	//Error message
	public MessagesPage validateerrormessage(){
		readconfig();
		driver.findElement(By.xpath("//h4[contains(text(),'Form Processing Error(s)')]"));
		return new MessagesPage(driver);
	}
	//Click on view button
	public MessagesPage viewMessage(String message){
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(message);
		try{
			driver.findElement(By.xpath("//i[@class='fa fa-eye']")).click();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new MessagesPage(driver);
	}
	//verify the locale
	public MessagesEditPage previewlocales(String localename){
		readconfig();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String localetext = driver.findElement(By.xpath(".//*[@id='message-form']/div[1]/div[10]/div/div/div[2]/div[1]/ul/li/a")).getText();
		try{
				driver.findElement(By.xpath(library.getProperty("mes_edit_preview"))).click();
				Assert.assertEquals(localetext.toLowerCase(),driver.findElement(By.xpath("//div[@id='s2id_locale']/a/span[1]")).getText().toLowerCase());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return new MessagesEditPage(driver);
	}
	//preview a message
	public MessagesPage previewMessage(String message){
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(message);
		try{
			driver.findElement(By.xpath("//a[@data-original-title='Preview']")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			bname = driver.findElement(By.xpath("//label[contains(text(),'Name')]/following-sibling::div")).getText();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new MessagesPage(driver);
	}
	//Navigate to communications page
	public MessagesPage navigateCommunications(){
		readconfig();
		try{
			driver.findElement(By.xpath("//i[@class='fa fa-book']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'Communications')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return new MessagesPage(driver);
	}
	//view message in communication page
	public MessagesPage viewCommunicationMessage(String message){
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(message);
		try{
			driver.findElement(By.xpath("//a[@data-original-title='Preview']")).click();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return new MessagesPage(driver);
	}
	//Verify the banner exists in the region drop down
	public MessagesPage verifybannerexists(){
		readconfig();
		try{
			int regionvalues = driver.findElements(By.xpath("//select[@id='RegionSelect_1']/option")).size();
			System.out.println("Region have currently "+regionvalues);
			for(int i=1;i<=regionvalues;i++){
				String regionname = driver.findElement(By.xpath("//select[@id='RegionSelect_1']/option["+i+"]")).getText();
				System.out.println("Banners "+regionname);
				if(regionname.contains(bname)){
					System.out.println("Banner name exists in communications page");
					break;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return new MessagesPage(driver);
	}
	//edit a message
	public MessagesEditPage editMessage(String messagename)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(messagename);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch(messagename)
		{
		case "1715":
		{
			driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[18]/div/div/a[6]/i")).click();
			try{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if(driver.findElement(By.xpath(".//*[@id='manage-workflow-form']/div/div[2]/div[1]/div[2]/div[2]/table/tbody/tr/td[8]/span")).getText().toLowerCase().equals("draft")){
				//	driver.findElement(By.xpath(".//*[@id='Message_1715_NewWorkflowID']")).click();
					Select se = new Select(driver.findElement(By.id("Message_1715_NewWorkflowID")));
					se.selectByVisibleText("Internal Testing");
					driver.findElement(By.xpath(".//*[@id='manage-workflow-form']/div/div[2]/button")).click();
					
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			break;
		}
		case "edit_message_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_message_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),library.getProperty("mess_edit_page_title"));
			break;
		}
		case "edit_message_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_message_test_010"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),library.getProperty("mess_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("message "+messagename +" cannot be edited, ref automation doc series page.");
		}
		}
		return new MessagesEditPage(driver);
	}
	//publish a message
	public MessagesPublishPage publishMessage(String messagename)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(messagename);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		switch(messagename)
		{
		case "publish_message_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("publish_message_test_01"))).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),library.getProperty("mess_publish_page_title"));
			break;
		}
		case "opt-publish_message_test_02":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("publish_message_test_01"))).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),library.getProperty("mess_publish_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("message "+messagename +" cannot be published, ref automation doc series page.");
		}
		}
		return new MessagesPublishPage(driver);
	}
	//restore a message
	public MessagesPage restoreMessage(String messagename)
	{
		readconfig();
		driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(messagename);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		sleep();
		driver.findElement(By.xpath("html/body/div[7]/div/div/div[3]/button[1]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("reload")).click();
		sleep();		
		//assert ad verify	
		Assert.assertEquals(driver.getTitle(), library.getProperty("mess_archive_page_title"));
		return new MessagesPage(driver);
	}
	
	
	
	//this method will be updated,(to permanent archive method)
	public MessagesPage archiveMessage(String messagename)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(messagename);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
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
	 	WebElement ele = driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[19]/div/div/a[8]"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[19]/div/div/a[8]")).click();                             
		//switch to active element 
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "yes" 
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new MessagesPage(driver);			
	}
	
	
	//test validation
	public MessagesPage validateUpdates(String messagename,String column,String expectedresult)
	{
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
		case"client":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("mes_client"))).getText(),expectedresult);
			break;
		}
		case"brand":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(library.getProperty("mes_brand"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(library.getProperty("mes_brand")));
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
		case"program":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(library.getProperty("mes_program"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(library.getProperty("mes_program")));
			java.util.Iterator<WebElement> name = iname.iterator();
			while(name.hasNext()) 
			{
				WebElement row = name.next();
				System.out.println("**program: "+row.getText());
			} 
			//assert and verify
			Assert.assertEquals(expectedresult,String.valueOf(iCount));
			break;
		}
		case"name":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("mes_name"))).getText(),expectedresult);
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(library.getProperty("mes_name")));
			java.util.Iterator<WebElement> name = iname.iterator();
			while(name.hasNext()) 
			{
				WebElement row = name.next();
				System.out.println("**program: "+row.getText());
			}
			break;
		}
		case"code":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("mes_code"))).getText(),expectedresult);
			break;
		}
		case"template":
		{
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(library.getProperty("mes_template"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(library.getProperty("mes_template")));
			java.util.Iterator<WebElement> name = iname.iterator();
			while(name.hasNext()) 
			{
				WebElement row = name.next();
				System.out.println("**template :"+row.getText());
			} 
			//assert and verify
			Assert.assertEquals(expectedresult,String.valueOf(iCount));
			break;
		}
		case"status":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("mes_status"))).getText(),expectedresult);
			break;
		}
		case"workflow":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("mes_workflow"))).getText(),expectedresult);
			break;
		}
		default :
		{
			throw new InvalidParameterException(column +" is not a column for locales page.");
		}
		}
		return new MessagesPage(driver);
	}
	public MessagesPage copyMessage(String messagename) {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(messagename);
		try{
			driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr[1]/td[18]/div/div/a[7]/i")).click();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new MessagesPage(driver);
	}
	public MessagesPage editcopymessagename(String newname) {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath("//h4[contains(text(),'Save copy as...')]"));
		driver.findElement(By.xpath("//input[@id='saveAsName']")).clear();
		driver.findElement(By.xpath("//input[@id='saveAsName']")).sendKeys(newname);
		try{
			driver.findElement(By.xpath("//button[contains(text(),'Save Copy')]")).click();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return new MessagesPage(driver);
	}
	public void validatecopymessage(){
		
	}
	public MessagesPage validatecopiedmessages(String copiedname) {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(copiedname);
		try{
			String verify = driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[6]")).getText();
			System.out.println(verify);
		//	Assert.assertEquals(verify, copiedname);
			Assert.assertTrue(verify.contains(copiedname));
		}catch(Exception e){
			e.printStackTrace();
		}
		return new MessagesPage(driver);
	}
	public MessagesPage clickquicklook() {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys("edit_message_test_01");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(library.getProperty("message_quicklook"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(library.getProperty("quicklook_close"))).click();
		
	
	return new MessagesPage(driver);

		
		
}
	public MessagesPage clickMassadvanceworkflow() {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys("edit_ehi_message_01");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(library.getProperty("message_massadvance"))).click();
		System.out.println("test.mass");
		driver.findElement(By.xpath(library.getProperty("message_mass_checkbox"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("test.checkbox");
		Select newworkflow=new Select (driver.findElement(By.xpath(library.getProperty("message_newworkflow"))));
		newworkflow.selectByVisibleText("Approved - Keep current state");
		System.out.println("test.approved");
				
		
		return new MessagesPage(driver);
	}
	}












