package settings;

import org.testng.annotations.Test;
import DataBase.DataBaseSettings;
import Utility.TestBase;

public class WorkflowManager_testcases extends TestBase {

	@Test(priority=8,enabled=true)
	public void create_a_workflow_manager()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickWorkflowManager()
		.clickAddWfMgrButton()
		;
	}
	@Test(priority=900,enabled=true)
	public void delete_workflow_manager_from_database()
	{
		DataBaseSettings.deleteWorkflowManager();
	}
}
