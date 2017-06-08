package access;

import org.testng.annotations.Test;
import DataBase.DataBaseAccess;
import Utility.TestBase;

public class PermissionGroups_TestCases extends TestBase{

	@Test(priority=0,enabled=true)
	public void create_a_new_permission_groups()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickPermissionGroups()
		.clickAddpermissionGroupsButton()
		.addName("selenium033")
		.addBusinessRule("bizzrule selenium")
		.addPermission("restore record")
		.addPermission("Archive Page View")
		.addPermission("edit")
		.clickSave()
		.validateUpdates("selenium033","name","selenium033")
		.validateUpdates("selenium033","permissions","3")
		.getTitle()
		.logout();
	}
	@Test(priority=1,enabled=true)
	public void create_a_new_permission_groups_without_name()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickPermissionGroups()
		.clickAddpermissionGroupsButton()
		.addName("")
		.addBusinessRule("bizzrule selenium")
		.addParentPermissionGroup("Variables View")
		.addPermission("restore record")
		.addPermission("Archive Page View")
		.addPermission("edit")
		.failToCreate()
		.getTitle();
	}
	@Test(priority=2,enabled=true)
	public void click_cancel_in_permission_groups_add_page()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickPermissionGroups()
		.clickAddpermissionGroupsButton()
		.clickCancel()
		.getTitle();
	}
	@Test(priority=3,enabled=true)
	public void returm_to_permission_groups_main_page()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickPermissionGroups()
		.clickAddpermissionGroupsButton()
		.clickPermissionGroupsLink()
		.getTitle();
	}
	@Test(priority=4,enabled=true)
	public void delete_permission_groups_in_database()
	{
		DataBaseAccess.deletePermissionGroup();
	}
	/*@Test(priority=10,enabled=true)
	public void create_test_permission_groups()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickPermissionGroups()
		.clickAddpermissionGroupsButton()
		.addName("edit_permission_group_test_01")
		.addBusinessRule("edit_permission_group_test_01")
		.addPermission("restore record")
		.addPermission("Archive Page View")
		.addPermission("edit")
		.clickSave()
		.validateUpdates("edit_permission_group_test_01","name","edit_permission_group_test_01")
		.validateUpdates("selenium033","permissions","3")
		.getTitle()
		.logout();
	}*/
	
}