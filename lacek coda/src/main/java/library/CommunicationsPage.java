package library;

import java.security.InvalidParameterException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import Utility.PageBase;

public class CommunicationsPage extends PageBase{

	public CommunicationsPage(WebDriver driver) 
	{
		super(driver);
	}
	//open communications add page
	public CommunicationsAddPage clickAddCommunicationsButton()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("comm_add_button"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("comm_add_page_title"));
		//return series add page
		return new CommunicationsAddPage(driver);
	}
	//reload communications page
	public CommunicationsPage reloadCommunicationsPage()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("comm_reload_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("comm_page_title"));
		//return series page
		return new CommunicationsPage(driver);
	}
	//open communications archive page
	public CommunicationsArchivePage clickArchiveButton()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("comm_archive_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("comm_archive_page_title"));
		//return series page
		return new CommunicationsArchivePage(driver);
	}
	
	public ComunicationsEditPage edit140(String name){
		readconfig();
		driver.findElement(By.xpath("//i[@class='fa fa-pencil-square-o']")).click();
		
		return new ComunicationsEditPage(driver);
	}
	
	//edit a series
	public ComunicationsEditPage editCommunications(String name)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(name);
		switch(name)
		{
		case "140":
		{
			try{
			Thread.sleep(5000);
			driver.findElement(By.xpath("//a[@data-original-title='Mass Advance Workflow']")).click();
			}catch(Exception e){
				e.printStackTrace();
			}
			break;
		}
		case "edit_comm_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_comm_test_01"))).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
			Assert.assertEquals(driver.getTitle(),library.getProperty("comm_edit_page_title"));
			break;
		}
		case "edit_comm_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_comm_test_01"))).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
			Assert.assertEquals(driver.getTitle(),library.getProperty("comm_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("series "+name +" cannot be edited, ref automation doc series page.");
		}
		}
		return new ComunicationsEditPage(driver);
	}
	//publish communication
	public CommunicationsPublishPage publishCommunications(String communicationnanme)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(communicationnanme);
		switch(communicationnanme)
		{
		case "publish_comm_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("publish_comm_test_01"))).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),library.getProperty("comm_publish_page_title"));
			break;
		}
		case "Comm6.14":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("publish_comm_test_01"))).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),library.getProperty("comm_publish_page_title"));
			break;
		}
		
		case "opt-publish_comm_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("publish_comm_test_01"))).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),library.getProperty("comm_publish_page_title"));
			break;
		}
		case "edit_comm_test_01":
		{
			driver.findElement(By.xpath("//a[contains(@href,'/publish/communication')]")).click();
			break;
			
		}
		default: 
		{
			throw new InvalidParameterException("communication "+communicationnanme +" cannot be published, ref automation doc communication page.");
		}
		}
		return new CommunicationsPublishPage(driver);
	}
	//restore a communication
	public CommunicationsPage retoreCommunication(String communicationname)
	{
		readconfig();
		driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(communicationname);
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		sleep();
		driver.findElement(By.xpath("html/body/div[7]/div/div/div[3]/button[1]")).click();
		sleep();
		driver.findElement(By.id("reload")).click();
		sleep();
		//assert and verify
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("comm_archive_page_title")));
		return new CommunicationsPage(driver);
	}
	//open preview page
	public CommunicationsPreviewPage previewCommunications(String communicationnanme)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(communicationnanme);
		switch (communicationnanme)
		{
		case "edit_ehi_comm_test_01":
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.findElement(By.xpath(library.getProperty("comm_ehi_preview"))).click();
			break;
		}
		case "preview_comm_test_01":
		{
			driver.findElement(By.cssSelector(test_data_reader.getProperty("publish_comm_test_01"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(library.getProperty("comm_preview_edit"))));	
			//assert and verify
			Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("comm_preview_page_title")));

			break;
		}
		case "preview_comm_test_02":
		{
			driver.findElement(By.cssSelector(test_data_reader.getProperty("publish_comm_test_02"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(library.getProperty("comm_preview_edit"))));	
			//assert and verify
			Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("comm_preview_page_title")));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("communication "+communicationnanme +" cannot be previewed, ref automation doc communications page.");
		}
		}
		return new CommunicationsPreviewPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public CommunicationsPage archiveCommunication(String archiveCommunicationname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(archiveCommunicationname);
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
		driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[17]/div/div/a[6]/i")).click();
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "yes" 
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new CommunicationsPage(driver);			
	}
	//test validation
	public CommunicationsPage validateUpdates(String comunnicationname,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(comunnicationname);
		
		switch(column)
		{
		case"client":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("comm_client"))).getText(),expectedresult);
			break;
		}
		case"brand":
		{
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(library.getProperty("comm_brand"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(library.getProperty("comm_brand")));
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
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(library.getProperty("comm_program"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(library.getProperty("comm_program")));
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
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("comm_name"))).getText(),expectedresult);
			break;
		}
		case"code":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("comm_code"))).getText(),expectedresult);
			break;
		}
		case"channel":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("comm_channel"))).getText(),expectedresult);
			break;
		}
		case"template":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("comm_template"))).getText(),expectedresult);
			break;
		}
		case"track":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("comm_track"))).getText(),expectedresult);
			break;
		}
		case"status":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("comm_status"))).getText(),expectedresult);
			break;
		}
		case"workflow":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("comm_workflow"))).getText(),expectedresult);
			break;
		}
		default :
		{
			throw new InvalidParameterException(column +" is not a column for communications page.");
		}
		}
		return new CommunicationsPage(driver);			
	}
	public void clickpreviewbutton() {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(".//*[@id='button_preview']/i")).click();
		driver.findElement(By.xpath(".//*[@id='button_preview']/i")).click();
		driver.findElement(By.xpath(".//*[@id='button_preview']")).click();
		driver.findElement(By.xpath(".//*[@id='communication-form']/div[2]/div/div/a[1]")).click();
	}
	public CommunicationsPage commMassadvanceworkflow() {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(library.getProperty("comm_mass_advance"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("comm_page_title"));
		//return series page
		return new CommunicationsPage(driver);
	}
	public void slectManageworkflowbyehi_qa(String slectworkflowbyehi_qaname) {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(slectworkflowbyehi_qaname);
		
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	driver.findElement(By.xpath(library.getProperty("ehi_qa_workflow"))).click();
	
}
	
	
}