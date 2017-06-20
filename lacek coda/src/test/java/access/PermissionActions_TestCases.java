package access;

import org.testng.annotations.Test;
import DataBase.DataBaseAccess;
import Utility.TestBase;

public class PermissionActions_TestCases extends TestBase{

	@Test(priority=0,enabled=true)
	public void create_a_new_permission_action()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionActions()
		.clickAddpermissionActionsButton()
		.addName("selenium_action_033")
		.addControllerName("control_selenium213")
		.addPermissions("Brands Add")
		.clickSave()
		//.validateUpdates("selenium_action_033","action name","selenium_action_033")
		//.validateUpdates("Brands Add","permission name","Brands Add")
		//.validateUpdates("selenium_action_033","controller action","control_selenium213")
		.getTitle()
		.logout();
	}
	@Test(priority=1,enabled=true)
	public void create_a_new_permission_action_without_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionActions()
		.clickAddpermissionActionsButton()
		.addName("")
		.addControllerName("control_selenium")
		.addPermissions("Brands Add")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=2,enabled=true)
	public void create_a_new_permission_action_without_controller_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionActions()
		.clickAddpermissionActionsButton()
		.addName("test")
		.addControllerName("")
		.addPermissions("Brands Add")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=3,enabled=true)
	public void create_a_new_permission_action_without_permission()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionActions()
		.clickAddpermissionActionsButton()
		.addName("test")
		.addControllerName("test01")
		.addPermissions("Select the Permission tied to this action.")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=4,enabled=true)
	public void click_cancel_in_permission_action_add_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionActions()
		.clickAddpermissionActionsButton()
		.clickCancel()
		.getTitle()
		.logout();
	}
	@Test(priority=5,enabled=true)
	public void returm_to_permission_actions_main_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionActions()
		.clickAddpermissionActionsButton()
		.clickPermissionActionsLink()
		.getTitle()
		.logout();
	}
	@Test(priority=6,enabled=true)
	public void create_a_duplicate_permission_action()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionActions()
		.clickAddpermissionActionsButton()
		.addName("advancedcustomfield")
		.addControllerName("index")
		.addPermissions("Brands Add")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=8,enabled=true)
	public void delete_permission_action_from_database()
	{
		DataBaseAccess.deletePermissionAction();
	}
	/*@Test(priority=12,enabled=true)
	public void create_test_permission_action()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionActions()
		.clickAddpermissionActionsButton()
		.addName("edit_permission_action_test_01")
		.addControllerName("test_selenium")
		.addPermissions("Brands Add")
		.clickSave()
		//.validateUpdates("edit_permission_action_test_01","action name","edit_permission_action_test_01")
		//.validateUpdates("Brands Add","permission name","Brands Add")
		//.validateUpdates("edit_permission_action_test_01","controller action","test_selenium")
		.getTitle()
		.logout();
	}*/
}