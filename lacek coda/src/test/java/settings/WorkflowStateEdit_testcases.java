package settings;

import org.testng.annotations.Test;
import Utility.TestBase;

public class WorkflowStateEdit_testcases extends TestBase{

	@Test(priority=0,enabled=true)
	public void update_workflow_state_name()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickWorkflowState()
		.editWorkflowState("edit_wfstate_test_01")
		.updateName("edit_wfstate_test_010")
		.clickSave()
		.validateUpdates("edit_wfstate_test_010","name","EDIT_WFSTATE_TEST_010")
		.getTitle()
		.logout();
	}
	@Test(priority=1,enabled=true)
	public void update_workflow_state_name_to_previous()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickWorkflowState()
		.editWorkflowState("edit_wfstate_test_010")
		.updateName("edit_wfstate_test_01")
		.clickSave()
		.validateUpdates("edit_wfstate_test_01","name","EDIT_WFSTATE_TEST_01")
		.getTitle()
		.logout();
	}
	@Test(priority=2,enabled=true)
	public void update_workflow_state_color()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickWorkflowState()
		.editWorkflowState("edit_wfstate_test_01")
		.updateColor("#4f6628")
		.clickSave()
		.getTitle()
		.logout();
	}
	@Test(priority=3,enabled=true)
	public void update_workflow_state_color_to_previous()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickWorkflowState()
		.editWorkflowState("edit_wfstate_test_01")
		.updateColor("#423a57")
		.clickSave()
		.getTitle()
		.logout();
	}
	@Test(priority=4,enabled=true)
	public void update_workflow_state_description()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickWorkflowState()
		.editWorkflowState("edit_wfstate_test_01")
		.updateDescription("test description is here")
		.clickSave()
		.validateUpdates("edit_wfstate_test_01","description","test description is here")
		.getTitle()
		.logout();
	}
	@Test(priority=5,enabled=true)
	public void update_workflow_state_description_to_previous()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickWorkflowState()
		.editWorkflowState("edit_wfstate_test_01")
		.updateDescription("description is here")
		.clickSave()
		.validateUpdates("edit_wfstate_test_01","description","description is here")
		.getTitle()
		.logout();
	}
	@Test(priority=6,enabled=true)
	public void empty_name_field_in_wf_state_edit_page()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickWorkflowState()
		.editWorkflowState("edit_wfstate_test_01")
		.deleteName()
		.failToUpdate()
		.getTitle()
		.logout();
	}
	@Test(priority=7,enabled=true)
	public void empty_color_field_in_wf_state_edit_page()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickWorkflowState()
		.editWorkflowState("edit_wfstate_test_01")
		.deleteColor()
		.failToUpdate()
		.getTitle()
		.logout();
	}
	@Test(priority=8,enabled=true)
	public void inactivate_workflow_state()
	{
	
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickWorkflowState()
		.editWorkflowState("edit_wfstate_test_01")
		.isActive(false)
		.clickSave()
		.validateUpdates("edit_wfstate_test_01","status","INACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=9,enabled=true)
	public void activate_workflow_state()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickWorkflowState()
		.editWorkflowState("edit_wfstate_test_01")
		.isActive(true)
		.clickSave()
		.validateUpdates("edit_wfstate_test_01","status","ACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=10,enabled=true)
	public void click_cancel_in_wf_state_edit_page()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickWorkflowState()
		.editWorkflowState("edit_wfstate_test_01")
		.clickCancel()
		.getTitle()
		.logout();
	}
	@Test(priority=11,enabled=true)
	public void return_to_wf_state_main_page_from_edit()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickWorkflowState()
		.editWorkflowState("edit_wfstate_test_01")
		.returnToMainPage()
		.getTitle()
		.logout();
	}
	@Test(priority=12,enabled=true)
	public void archive_wf_state()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickWorkflowState()
		.archiveWorkFlowState("edit_wfstate_test_01")
		.getTitle()
		.logout();
	}
	@Test(priority=13,enabled=true)
	public void restore_wf_state()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickWorkflowState()
		.restoreWorkflowState("edit_wfstate_test_01")
		.getTitle()
		.logout();
	}
}