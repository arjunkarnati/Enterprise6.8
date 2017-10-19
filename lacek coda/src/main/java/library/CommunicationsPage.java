package library;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
		case"edit_ehi_comm_test_01":
		{
			driver.findElement(By.xpath(library.getProperty("edit_ehi_comm_data"))).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),library.getProperty("comm_edit_page_title"));
			break;
		}
		case"cloned_comm_ehi_ae":
		{
			driver.findElement(By.xpath(library.getProperty("edit_ehi_comm_data"))).click();
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
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(library.getProperty("archive-comm"))).click();
		driver.findElement(By.xpath(library.getProperty("archive-select_yes"))).click();
		
		/*//select all check boxes
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
		}*/
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
		case"Description":
		{
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("comm_get_description"))).getText(),expectedresult);
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
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
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
	public CommunicationsPage clickpreviewbutton() {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(".//*[@id='button_preview']/i")).click();
		driver.findElement(By.xpath(".//*[@id='button_preview']/i")).click();
		driver.findElement(By.xpath(".//*[@id='button_preview']")).click();
		driver.findElement(By.xpath(".//*[@id='communication-form']/div[2]/div/div/a[1]")).click();
		
		return new CommunicationsPage(driver);
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
		Assert.assertEquals(driver.getTitle(),library.getProperty("comm_mass_title"));
		//return series page
		return new CommunicationsPage(driver);
	}
	public Communicationmanageworkflow slectManageworkflowbyehi_qa(String slectworkflowbyehi_qaname) {
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
	
	return new Communicationmanageworkflow(driver);
	}
	/*public CommunicationsPage manageWorkflowehiqa(String workflowname, String communicationID)
	{
		readconfig();
		switch(workflowname)
		{
		case "DRAFT":
		{
			driver.findElement(By.xpath(".//*[@id='Communication_WorkflowID']")).sendKeys("D");
			break;
		}
		case "APPROVED":
		{
			driver.findElement(By.xpath(".//*[@id='Communication_WorkflowID']")).sendKeys("A");
			
			break;
		}
		default: 
		{
			throw new InvalidParameterException("Please verify the workflow name");
		}
		}

		return new CommunicationsPage(driver);
	
		
	}*/
	/*public void changeAssignWorkflow() throws Exception{
		// TODO Auto-generated method stub
		readconfig();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='manage-workflow-form']/div/div[2]/div[1]/div[2]/div[2]/table/thead/tr/th[1]/div/span/input")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//select[@id='Communication_Workflow']")).click();
		Thread.sleep(2000);
		
	}*/
	
	
	public CommunicationsPage changeAssignWorkflow(String workflowname, String communicationname) throws InterruptedException {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(".//*[@id='manage-workflow-form']/div/div[2]/div[1]/div[2]/div[2]/table/thead/tr/th[1]/div/span/input")).click();
		switch(workflowname)
		{
		case "DRAFT":
		{
			driver.findElement(By.xpath(library.getProperty("comm_mass_workflow"))).sendKeys("D");
			break;
		}
		case "APPROVED":
		{
			driver.findElement(By.xpath(library.getProperty("comm_mass_workflow"))).sendKeys("A");
			Thread.sleep(3000);
			break;
		}
		case "Internal Testing":
		{
			driver.findElement(By.xpath(library.getProperty("comm_mass_workflow"))).sendKeys("I");
			break;
		}
		case "Client Testing":
		{
			driver.findElement(By.xpath(library.getProperty("comm_mass_workflow"))).sendKeys("C");
			break;
		}
		default: 
		{
			throw new InvalidParameterException("Please verify the workflow name");
		}
		}

		return new CommunicationsPage(driver);
	}
	
	
	
	public CommunicationsPage searchCommunications(String name) {
		
		{
			readconfig();
			driver.findElement(By.xpath(library.getProperty("filter"))).click();
			driver.findElement(By.xpath(library.getProperty("filter"))).clear();
			driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(name);
			}
		return new CommunicationsPage(driver);
	}
	public CommunicationsPage saveMassadvanceworkflow()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("save_massadvanceworkflow"))).click();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("comm_page_title")));
		return new CommunicationsPage(driver);
		
		}
	public CommunicationsPage commMessageWorkflow(String msgworkflowname, String communicationname) throws InterruptedException {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(library.getProperty("com_mes_click"))).click();
		switch(msgworkflowname)
		{
		case "DRAFT":
		{
			driver.findElement(By.xpath(library.getProperty("comm_mass_msg_workflow"))).sendKeys("D");
			break;
		}
		case "APPROVED":
		{
			driver.findElement(By.xpath(library.getProperty("comm_mass_msg_workflow"))).sendKeys("A");
			Thread.sleep(3000);
			break;
		}
		case "Internal Testing":
		{
			driver.findElement(By.xpath(library.getProperty("comm_mass_msg_workflow"))).sendKeys("I");
			break;
		}
		case "Client Testing":
		{
			driver.findElement(By.xpath(library.getProperty("comm_mass_msg_workflow"))).sendKeys("C");
			break;
		}
		default: 
		{
			throw new InvalidParameterException("Please verify the Comm_msg_workflow name");
		}
		}

		return new CommunicationsPage(driver);

	}
	/*public CommunicationsPage commMessageWorkflow(String string,String  msgworkflowname ) throws InterruptedException {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(library.getProperty("comm_mess_workflow"))).click();
		readconfig();
		driver.findElement(By.xpath(library.getProperty("com_mes_click"))).click();
		switch(msgworkflowname)
		{
		case "DRAFT":
		{
			driver.findElement(By.xpath("//select[@id='Communication_Workflow']")).sendKeys("D");
			break;
		}
		case "APPROVED":
		{
			driver.findElement(By.xpath("//select[@id='Communication_Workflow']")).sendKeys("A");
			Thread.sleep(3000);
			break;
		}
		case "Qatest1":
		{
			driver.findElement(By.id(library.getProperty("comm_edit_msg_workflow"))).sendKeys("Q");
			break;
		}
		default: 
		{
			throw new InvalidParameterException("Please verify the workflow name");
		}
		}

	
		return new CommunicationsPage(driver);
	}*/
	public CommunicationsPage clonecommunication(String name) {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(name);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(library.getProperty("comm_clone"))).click();
		
		return new CommunicationsPage(driver);
	}
	public CommunicationsPage editNameinsaveas(String updatecommname) {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(library.getProperty("saveas_name"))).clear();
		driver.findElement(By.xpath(library.getProperty("saveas_name"))).sendKeys(updatecommname);
		driver.findElement(By.xpath(library.getProperty("select_saveas"))).click();
		
		return new CommunicationsPage(driver);
	}
	public CommunicationsPage clickDownloadpreview() {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath(library.getProperty("download_preview"))).click();
		
		return new CommunicationsPage(driver);
	}
	
	
}













