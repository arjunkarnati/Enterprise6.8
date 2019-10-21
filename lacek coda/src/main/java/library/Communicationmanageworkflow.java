

package library;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.security.InvalidParameterException;



public class Communicationmanageworkflow extends PageBase {

	public Communicationmanageworkflow(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public Communicationmanageworkflow manageWorkflowehiqa(String workflowname, String communicationID)
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

		return new Communicationmanageworkflow(driver);
	
		
	}
	/*public Communicationmanageworkflow slectManageworkflowbyehi_qa(String slectworkflowbyehi_qaname) {
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
	}*/
	public CommunicationsPage saveManageworkflow()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("save_manageworkflow"))).click();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("comm_page_title")));
		return new CommunicationsPage(driver);
		
		}

}
