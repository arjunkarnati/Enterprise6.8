package settings;

import DataBase.DataBaseSettings;
import Utility.TestBase;
import org.testng.annotations.Test;

public class WorkflowState_TestCases extends TestBase{

	@Test(priority=0,enabled=true)
	public void create_a_new_wf_state()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickWorkflowState()
		.clickAddWfStateButton()
		.addName("selenium_coda_01")
		.addColor("#1b98e0")
		.addDescription("description is here")
		.clickSave()
		.validateUpdates("selenium_coda_01","name","selenium_coda_01")
		.validateUpdates("selenium_coda_01","description","description is here")
		.validateUpdates("selenium_coda_01","status","ACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=1,enabled=true)
	public void create_a_new_wf_state_without_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickWorkflowState()
		.clickAddWfStateButton()
		.addColor("#1b98e0")
		.addDescription("description is here")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=2,enabled=true)
	public void create_a_new_wf_state_without_color()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickWorkflowState()
		.clickAddWfStateButton()
		.addName("selenium_coda_01")
		.addDescription("description is here")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=3,enabled=true)
	public void click_cancel_in_wf_state_add_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickWorkflowState()
		.clickAddWfStateButton()
		.clickCancel()
		.getTitle()
		.logout();
	}
	@Test(priority=4,enabled=true)
	public void return_to_wf_state_main_page_from_add()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickWorkflowState()
		.clickAddWfStateButton()
		.returnToMainPage()
		.getTitle()
		.logout();
	}
	@Test(priority=5,enabled=true)
	public void delete_workflow_state_from_database()
	{
		DataBaseSettings.deleteWorkflowState();
	}
	/*@Test(priority=30,enabled=true)
	public void create_test_wf_state()
	{
		login.loginAs("test.data","Monday#223")
		.isSuccessfulLogin("test data")
		.clickWorkflowState()
		.clickAddWfStateButton()
		.addName("edit_wfstate_test_01")
		.addColor("#423a57")
		.addDescription("description is here")
		.clickSave()
		.validateUpdates("edit_wfstate_test_01","name","edit_wfstate_test_01")
		.validateUpdates("edit_wfstate_test_01","description","description is here")
		.validateUpdates("edit_wfstate_test_01","status","ACTIVE")
		.getTitle()
		.logout();
	}*/
}