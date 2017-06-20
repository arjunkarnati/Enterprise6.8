package access;

import org.testng.annotations.Test;
import Utility.TestBase;

public class PermissionActionsEdit_TestCases extends TestBase{

	@Test(priority=0,enabled=true)
	public void update_permission_action_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionActions()
		.editPermissionActions("edit_permission_action_test_01")
		.updateName("edit_permission_action_test_010")
		.clickSave()
		.validateUpdates("edit_permission_action_test_010","action name","edit_permission_action_test_010")
		.getTitle()
		.logout();
	}
	@Test(priority=1,enabled=true)
	public void update_permission_action_name_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionActions()
		.editPermissionActions("edit_permission_action_test_010")
		.updateName("edit_permission_action_test_01")
		.clickSave()
		.validateUpdates("edit_permission_action_test_01","action name","edit_permission_action_test_01")
		.getTitle()
		.logout();
	}
	@Test(priority=2,enabled=true)
	public void update_permission_action_controller_action_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionActions()
		.editPermissionActions("edit_permission_action_test_01")
		.updateControllerAction("test_selenium")
		.clickSave()
		.validateUpdates("edit_permission_action_test_01","controller action","test_selenium")
		.getTitle()
		.logout();
	}
	@Test(priority=3,enabled=true)
	public void update_permission_action_controller_action_name_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionActions()
		.editPermissionActions("edit_permission_action_test_01")
		.updateControllerAction("still_testing")
		.clickSave()
		.validateUpdates("edit_permission_action_test_01","controller action","still_testing")
		.getTitle()
		.logout();
	}
	@Test(priority=4,enabled=true)
	public void update_permission_action_permission()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionActions()
		.editPermissionActions("edit_permission_action_test_01")
		.updatePermission("Brands Add")
		.clickSave()
		.getTitle()
		.logout();
	}
	@Test(priority=5,enabled=true)
	public void update_permission_action_permission_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionActions()
		.editPermissionActions("edit_permission_action_test_01")
		.updatePermission("Clients Add")
		.clickSave()
		.getTitle()
		.logout();
	}
	@Test(priority=6,enabled=true)
	public void empty_name_field_in_permission_actions_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionActions()
		.editPermissionActions("edit_permission_action_test_01")
		.deleteName()
		.failToUpdate()
		.getTitle()
		.logout();
	}
	@Test(priority=7,enabled=true)
	public void empty_controller_action_field_in_permission_actions_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionActions()
		.editPermissionActions("edit_permission_action_test_01")
		.deleteControllerAction()
		.failToUpdate()
		.getTitle()
		.logout();
	}
	@Test(priority=8,enabled=true)
	public void empty_permission_field_in_permission_actions_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionActions()
		.editPermissionActions("edit_permission_action_test_01")
		.emptyPermissionsField()
		.failToUpdate()
		.getTitle()
		.logout();
	}
	@Test(priority=9,enabled=true)
	public void click_cancel_in_permission_action_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionActions()
		.editPermissionActions("edit_permission_action_test_01")
		.clickCancel()
		.getTitle()
		.logout();
	}
	@Test(priority=10,enabled=true)
	public void return_to_permission_actions_main_page_from_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionActions()
		.editPermissionActions("edit_permission_action_test_01")
		.returToPermissionGroupsPage()
		.getTitle()
		.logout();
	}
	@Test(priority=11,enabled=true)
	public void inactivate_permission_actions()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionActions()
		.editPermissionActions("edit_permission_action_test_01")
		.isActive(false)
		.clickSave()
		.validateUpdates("edit_permission_action_test_01","status","INACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=12,enabled=true)
	public void activate_permission_actions()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionActions()
		.editPermissionActions("edit_permission_action_test_01")
		.isActive(true)
		.clickSave()
		.validateUpdates("edit_permission_action_test_01","status","ACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=13,enabled=true)
	public void archive_permission_action()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionActions()
		.editPermissionActions("edit_permission_action_test_01")
		.archivePermissionActions()
		.clickSave()
		.getTitle()
		.logout();
	}
	@Test(priority=14,enabled=true)
	public void restore_permission_action()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionActions()
		.clickArchiveButton()
		.editPermissionActions("edit_permission_action_test_01")
		.restorePermissionActions()
		.clickSave()
		.getTitle()
		.logout();
	}
}