package settings;

import java.security.InvalidParameterException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import Utility.PageBase;

public class WorkflowManagerAddPage extends PageBase {

	public WorkflowManagerAddPage(WebDriver driver) 
	{
		super(driver);
	}
	//add client
	public WorkflowManagerAddPage addClient(String client)
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_client"))).click();
		driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_client_search_field"))).sendKeys(client);
		driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_client_search_field"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_client"))).getText(),client);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
		return new WorkflowManagerAddPage(driver);
	}
	//add brand
	public WorkflowManagerAddPage addBrand(String brand)
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_brand"))).sendKeys(brand);
		driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_brand"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
		return new WorkflowManagerAddPage(driver);
	}
	//add program
	public WorkflowManagerAddPage addProgram(String program)
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_program"))).sendKeys(program);
		driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_program"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
		return new WorkflowManagerAddPage(driver);
	}
	//add name
	public WorkflowManagerAddPage addWorkflowMgrName(String name)
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_name"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_name"))).sendKeys(name);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
		return new WorkflowManagerAddPage(driver);
	}
	//add location
	public WorkflowManagerAddPage addLocation(String location)
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_location"))).sendKeys(location);
		driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_location"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
		return new WorkflowManagerAddPage(driver);
	}
	//add workflow state
	public WorkflowManagerAddPage addWorkflowState(int actionnumber, String workflowstate)
	{	
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("wf_manager_add_workflow_state_button"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch(actionnumber)
		{
		case 1:
		{
			Select wfstate = new Select(driver.findElement(By.name(elementslocator.getProperty("wf_manager_add_workflow_state_1"))));
			wfstate.selectByVisibleText(workflowstate);
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			break;
		}
		case 2:
		{
			Select wfstate = new Select(driver.findElement(By.name(elementslocator.getProperty("wf_manager_add_workflow_state_2"))));
			wfstate.selectByVisibleText(workflowstate);
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			break;
		}
		case 3:
		{
			Select wfstate = new Select(driver.findElement(By.name(elementslocator.getProperty("wf_manager_add_workflow_state_3"))));
			wfstate.selectByVisibleText(workflowstate);
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			break;
		}
		case 4:
		{
			Select wfstate = new Select(driver.findElement(By.name(elementslocator.getProperty("wf_manager_add_workflow_state_4"))));
			wfstate.selectByVisibleText(workflowstate);
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			break;
		}
		default :
		{
			throw new InvalidParameterException("action number is not correct, select from 1 to 4");
		}
		}
		return new WorkflowManagerAddPage(driver);
	}
	//add workflow state action
	public WorkflowManagerAddPage addWorkflowStateAction(int actionnumber, String wfaction)
	{	
		readconfig();
		switch(actionnumber)
		{
		case 1:
		{
			Select action= new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_workflow_action_1"))));
			action.selectByVisibleText(wfaction);
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			break;
		}
		case 2:
		{
			Select action= new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_workflow_action_2"))));
			action.selectByVisibleText(wfaction);
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			break;
		}
		case 3:
		{
			Select action= new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_workflow_action_3"))));
			action.selectByVisibleText(wfaction);
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			break;
		}
		case 4:
		{
			Select action= new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_workflow_action_4"))));
			action.selectByVisibleText(wfaction);
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			break;
		}
		default :
		{
			throw new InvalidParameterException("action number is not correct, select from 1 to 4");
		}
		}
		return new WorkflowManagerAddPage(driver);
	}
	/*action is transition*/
	//add workflow state to state 
	public WorkflowManagerAddPage toState(int actionnumber, String wfstate)
	{	
		readconfig();
		switch(actionnumber)
		{
		case 1:
		{
			Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_workflow_to_state_1"))));
			state.selectByVisibleText(wfstate);
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			break;
		}
		case 2:
		{
			Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_workflow_to_state_2"))));
			state.selectByVisibleText(wfstate);
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			break;
		}
		case 3:
		{
			Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_workflow_to_state_3"))));
			state.selectByVisibleText(wfstate);
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			break;
		}
		case 4:
		{
			Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_workflow_to_state_4"))));
			state.selectByVisibleText(wfstate);
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			break;
		}
		default :
		{
			throw new InvalidParameterException("action number is not correct, select from 1 to 4");
		}
		}
		return new WorkflowManagerAddPage(driver);
	}
	/*action is transition*/
	//add workflow state name
	public WorkflowManagerAddPage addName(int actionnumber, String name)
	{	
		readconfig();
		switch(actionnumber)
		{
		case 1:
		{
			driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_workflow_name_1"))).clear();
			driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_workflow_name_1"))).sendKeys(name);
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			break;
		}
		case 2:
		{
			driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_workflow_name_2"))).clear();
			driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_workflow_name_2"))).sendKeys(name);
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			break;
		}
		case 3:
		{
			driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_workflow_name_3"))).clear();
			driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_workflow_name_3"))).sendKeys(name);
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			break;
		}
		case 4:
		{
			driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_workflow_name_4"))).clear();
			driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_workflow_name_4"))).sendKeys(name);
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			break;
		}
		default :
		{
			throw new InvalidParameterException("action number is not correct, select from 1 to 4");
		}
		}
		return new WorkflowManagerAddPage(driver);
	}
	/*action is transition*/
	//add workflow state description 
	public WorkflowManagerAddPage addDescription(int actionnumber, String description)
	{	
		readconfig();
		switch(actionnumber)
		{
		case 1:
		{
			driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_workflow_description_1"))).clear();
			driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_workflow_description_1"))).sendKeys(description);
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			break;
		}
		case 2:
		{
			driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_workflow_description_2"))).clear();
			driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_workflow_description_2"))).sendKeys(description);
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			break;
		}
		case 3:
		{
			driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_workflow_description_3"))).clear();
			driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_workflow_description_3"))).sendKeys(description);
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			break;
		}
		case 4:
		{
			driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_workflow_description_4"))).clear();
			driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_workflow_description_4"))).sendKeys(description);
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			break;
		}
		default :
		{
			throw new InvalidParameterException("action number is not correct, select from 1 to 4");
		}
		}
		return new WorkflowManagerAddPage(driver);
	}
	/*action is transition*/
	//add workflow state transition roles 
	public WorkflowManagerAddPage addTransitionRole(int actionnumber, String role )
	{	
		readconfig();
		switch(actionnumber)
		{
		case 1:
		{
			driver.findElement(By.xpath(elementslocator.getProperty("wf_manager_add_workflow_transition_roles_1"))).sendKeys(role);
			driver.findElement(By.xpath(elementslocator.getProperty("wf_manager_add_workflow_transition_roles_1"))).sendKeys(Keys.ENTER);
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			break;
		}
		case 2:
		{
			driver.findElement(By.xpath(elementslocator.getProperty("wf_manager_add_workflow_transition_roles_2"))).sendKeys(role);
			driver.findElement(By.xpath(elementslocator.getProperty("wf_manager_add_workflow_transition_roles_2"))).sendKeys(Keys.ENTER);
			break;
		}
		case 3:
		{
			driver.findElement(By.xpath(elementslocator.getProperty("wf_manager_add_workflow_transition_roles_3"))).sendKeys(role);
			driver.findElement(By.xpath(elementslocator.getProperty("wf_manager_add_workflow_transition_roles_3"))).sendKeys(Keys.ENTER);
			break;
		}
		case 4:
		{
			driver.findElement(By.xpath(elementslocator.getProperty("wf_manager_add_workflow_transition_roles_4"))).sendKeys(role);
			driver.findElement(By.xpath(elementslocator.getProperty("wf_manager_add_workflow_transition_roles_4"))).sendKeys(Keys.ENTER);
			break;
		}
		default :
		{
			throw new InvalidParameterException("action number is not correct, select from 1 to 4");
		}
		}
		return new WorkflowManagerAddPage(driver);
	}
	/*action is transition on edit*/
	//add workflow state transition roles 
	public WorkflowManagerAddPage isOptional(int actionnumber, boolean answer )
	{	
		readconfig();
		switch(actionnumber)
		{
		case 1:
		{
			if(answer==true){
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_to_state_optional_1"))));
				state.selectByVisibleText("Yes; user may optionally keep the state the same.");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			}
			else if(answer=false)
			{
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_to_state_optional_1"))));
				state.selectByVisibleText("No; the item is forced into the new workflow state.");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));	
			}
			else
			{
				throw new InvalidParameterException("answer should be true or false");
			}
			break;
		}
		case 2:
		{
			if(answer==true){
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_to_state_optional_2"))));
				state.selectByVisibleText("Yes; user may optionally keep the state the same.");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			}
			else if(answer=false)
			{
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_to_state_optional_2"))));
				state.selectByVisibleText("No; the item is forced into the new workflow state.");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));	
			}
			else
			{
				throw new InvalidParameterException("answer should be true or false");
			}
			break;
		}
		case 3:
		{
			if(answer==true){
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_to_state_optional_3"))));
				state.selectByVisibleText("Yes; user may optionally keep the state the same.");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			}
			else if(answer=false)
			{
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_to_state_optional_3"))));
				state.selectByVisibleText("No; the item is forced into the new workflow state.");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));	
			}
			else
			{
				throw new InvalidParameterException("answer should be true or false");
			}
			break;
		}
		case 4:
		{
			if(answer==true){
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_to_state_optional_4"))));
				state.selectByVisibleText("Yes; user may optionally keep the state the same.");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			}
			else if(answer=false)
			{
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_to_state_optional_4"))));
				state.selectByVisibleText("No; the item is forced into the new workflow state.");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));	
			}
			else
			{
				throw new InvalidParameterException("answer should be true or false");
			}
			break;
		}
		default :
		{
			throw new InvalidParameterException("action number is not correct, select from 1 to 4");
		}
		}
		return new WorkflowManagerAddPage(driver);
	}
	/*action is approval*/
	//add workflow state requirement  
	public WorkflowManagerAddPage isRequired(int actionnumber, boolean answer )
	{	
		readconfig();
		switch(actionnumber)
		{
		case 1:
		{
			if(answer==true){
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_requirement_1"))));
				state.selectByVisibleText("Required; items cannot advance without this approval.");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			}
			else if(answer=false)
			{
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_requirement_1"))));
				state.selectByVisibleText("Optional; items can be advanced without this approval.");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));	
			}
			else
			{
				throw new InvalidParameterException("answer should be true or false");
			}
			break;
		}
		case 2:
		{
			if(answer==true){
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_requirement_2"))));
				state.selectByVisibleText("Required; items cannot advance without this approval.");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			}
			else if(answer=false)
			{
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_requirement_2"))));
				state.selectByVisibleText("Optional; items can be advanced without this approval.");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));	
			}
			else
			{
				throw new InvalidParameterException("answer should be true or false");
			}
			break;
		}
		case 3:
		{
			if(answer==true){
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_requirement_3"))));
				state.selectByVisibleText("Required; items cannot advance without this approval.");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			}
			else if(answer=false)
			{
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_requirement_3"))));
				state.selectByVisibleText("Optional; items can be advanced without this approval.");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));	
			}
			else
			{
				throw new InvalidParameterException("answer should be true or false");
			}
			break;
		}
		case 4:
		{
			if(answer==true){
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_requirement_4"))));
				state.selectByVisibleText("Required; items cannot advance without this approval.");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			}
			else if(answer=false)
			{
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_requirement_4"))));
				state.selectByVisibleText("Optional; items can be advanced without this approval.");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));	
			}
			else
			{
				throw new InvalidParameterException("answer should be true or false");
			}
			break;
		}
		default :
		{
			throw new InvalidParameterException("action number is not correct, select from 1 to 4");
		}
		}
		return new WorkflowManagerAddPage(driver);
	}
	/*action is publish*/
	//add workflow state requirement  
	public WorkflowManagerAddPage publishingIs(int actionnumber, String answer )
	{	
		readconfig();
		switch(actionnumber)
		{
		case 1:
		{
			if(answer.equalsIgnoreCase("Allowed")){
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_requirement_1"))));
				state.selectByVisibleText("Allowed");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			}
			else if(answer.equalsIgnoreCase("Required"))	{
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_requirement_1"))));
				state.selectByVisibleText("Required");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));	
			}
			else
			{
				throw new InvalidParameterException("answer is not correct");
			}
			break;
		}
		case 2:
		{
			if(answer.equalsIgnoreCase("Allowed")){
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_requirement_2"))));
				state.selectByVisibleText("Allowed");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			}
			else if(answer.equalsIgnoreCase("Required"))	{
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_requirement_2"))));
				state.selectByVisibleText("Required");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));	
			}
			else
			{
				throw new InvalidParameterException("answer is not correct");
			}
			break;
		}
		case 3:
		{
			if(answer.equalsIgnoreCase("Allowed")){
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_requirement_3"))));
				state.selectByVisibleText("Allowed");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			}
			else if(answer.equalsIgnoreCase("Required"))	{
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_requirement_3"))));
				state.selectByVisibleText("Required");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));	
			}
			else
			{
				throw new InvalidParameterException("answer is not correct");
			}
			break;
		}
		case 4:
		{
			if(answer.equalsIgnoreCase("Allowed")){
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_requirement_4"))));
				state.selectByVisibleText("Allowed");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			}
			else if(answer.equalsIgnoreCase("Required"))	{
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_requirement_4"))));
				state.selectByVisibleText("Required");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));	
			}
			else
			{
				throw new InvalidParameterException("answer is not correct");
			}
			break;
		}
		default :
		{
			throw new InvalidParameterException("action number is not correct, select from 1 to 4");
		}
		}
		return new WorkflowManagerAddPage(driver);
	}
	/*action is child check*/
	//add workflow state requirement  
	public WorkflowManagerAddPage lowerStates(int actionnumber, String answer)
	{	
		readconfig();
		switch(actionnumber)
		{
		case 1:
		{
			if(answer.equalsIgnoreCase("warn")){
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_requirement_1"))));
				state.selectByVisibleText("Warn; allow lower state children, but issue a warning about it.");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			}
			else if(answer.equalsIgnoreCase("prevent"))	{
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_requirement_1"))));
				state.selectByVisibleText("Prevent; do not allow items to have children in a lower state.");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));	
			}
			else
			{
				throw new InvalidParameterException("answer is not correct");
			}
			break;
		}
		case 2:
		{
			if(answer.equalsIgnoreCase("warn")){
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_requirement_2"))));
				state.selectByVisibleText("Warn; allow lower state children, but issue a warning about it.");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			}
			else if(answer.equalsIgnoreCase("prevent"))	{
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_requirement_2"))));
				state.selectByVisibleText("Prevent; do not allow items to have children in a lower state.");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));	
			}
			else
			{
				throw new InvalidParameterException("answer is not correct");
			}
			break;
		}
		case 3:
		{
			if(answer.equalsIgnoreCase("warn")){
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_requirement_3"))));
				state.selectByVisibleText("Warn; allow lower state children, but issue a warning about it.");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			}
			else if(answer.equalsIgnoreCase("prevent"))	{
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_requirement_3"))));
				state.selectByVisibleText("Prevent; do not allow items to have children in a lower state.");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));	
			}
			else
			{
				throw new InvalidParameterException("answer is not correct");
			}
			break;
		}
		case 4:
		{
			if(answer.equalsIgnoreCase("warn")){
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_requirement_4"))));
				state.selectByVisibleText("Warn; allow lower state children, but issue a warning about it.");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			}
			else if(answer.equalsIgnoreCase("prevent"))	{
				Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_requirement_4"))));
				state.selectByVisibleText("Prevent; do not allow items to have children in a lower state.");
				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));	
			}
			else
			{
				throw new InvalidParameterException("answer is not correct");
			}
			break;
		}
		default :
		{
			throw new InvalidParameterException("action number is not correct, select from 1 to 4");
		}
		}
		return new WorkflowManagerAddPage(driver);
	}
	//close workflowstate in workflow manager
	public WorkflowManagerAddPage closeState(int actionnumber)
	{	
		readconfig();
		switch(actionnumber)
		{
		case 1:
		{
			driver.findElement(By.linkText(elementslocator.getProperty("close"))).click();
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			break;
		}
		case 2:
		{
			driver.findElement(By.xpath(elementslocator.getProperty("wf_manager_add_workflow_state_close_2"))).click();
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			break;
		}
		case 3:
		{
			driver.findElement(By.xpath(elementslocator.getProperty("wf_manager_add_workflow_state_close_3"))).click();
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			break;
		}
		case 4:
		{
			driver.findElement(By.xpath(elementslocator.getProperty("wf_manager_add_workflow_state_close_4"))).click();
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
			break;
		}
		default :
		{
			throw new InvalidParameterException("action number is not correct, select from 1 to 4");
		}
		}
		return new WorkflowManagerAddPage(driver);
	}
	//return to index page
	public WorkflowManagerPage returnToMainPage()
	{	
		readconfig();
		driver.findElement(By.linkText(elementslocator.getProperty("wf_manager_main_page"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_page_title"));
		return new WorkflowManagerPage(driver);
	}
	//click save
	public WorkflowManagerPage clickSave()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_submit"))).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_page_title"));	
		return new WorkflowManagerPage(driver);
	}
	//click cancel
	public WorkflowManagerPage clickCancel()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("wf_manager_add_cancel"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_page_title"));
		return new WorkflowManagerPage(driver);
	}
	//click save for failed
	public WorkflowManagerAddPage failToCreate()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_submit"))).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
		return new WorkflowManagerAddPage(driver);
	}
}