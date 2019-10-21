package access;

import Utility.TestBase;
import org.testng.annotations.Test;

public class PermissionGroupsEdit_testcases extends TestBase{

	//EDIT ROLE
	@Test(priority=0,enabled=true)
	public void update_permission_groups_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionGroups()
		.editPermissionGroups("edit_permission_group_test_01")
		.updateName("edit_permission_group_test_010")
		.clickSave()
		.validateUpdates("edit_permission_group_test_010","name","edit_permission_group_test_010")
		.getTitle()
		.logout();
	}
	@Test(priority=1,enabled=true)
	public void update_permission_groups_name_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionGroups()
		.editPermissionGroups("edit_permission_group_test_010")
		.updateName("edit_permission_group_test_01")
		.clickSave()
		.validateUpdates("edit_permission_group_test_01","name","edit_permission_group_test_01")
		.getTitle()
		.logout();
	}
	@Test(priority=2,enabled=true)
	public void update_permission_groups_business_groups()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionGroups()
		.editPermissionGroups("edit_permission_group_test_01")
		.updateBusinessRule("test001")
		.clickSave()
		.getTitle()
		.logout();
	}
	@Test(priority=3,enabled=true)
	public void update_permission_groups_business_rule_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionGroups()
		.editPermissionGroups("edit_permission_group_test_01")
		.updateBusinessRule("test")
		.clickSave()
		.getTitle()
		.logout();
	}
	@Test(priority=4,enabled=true)
	public void update_permission_groups_parent_permission()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionGroups()
		.editPermissionGroups("edit_permission_group_test_01")
		.updateParentPermissionGroup("Brands View")
		.clickSave()
		.getTitle()
		.logout();
	}
	@Test(priority=5,enabled=true)
	public void update_permission_groups_parent_permission_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionGroups()
		.editPermissionGroups("edit_permission_group_test_01")
		.updateParentPermissionGroup("Select a Parent Permission Group if applicable.")
		.clickSave()
		.getTitle()
		.logout();
	}
	@Test(priority=6,enabled=true)
	public void update_permission_groups_permissions()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionGroups()
		.editPermissionGroups("edit_permission_group_test_01")
		.emptyPermissionField()
		.addPermission("Page view")
		.addPermission("add")
		.addPermission("Archive Page view")
		.clickSave()
		.validateUpdates("edit_permission_group_test_01","permissions","3")
		.getTitle()
		.logout();
	}
	@Test(priority=7,enabled=true)
	public void update_permission_groups_permissions_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionGroups()
		.editPermissionGroups("edit_permission_group_test_01")
		.emptyPermissionField()
		.addPermission("Page view")
		.addPermission("add")
		.clickSave()
		.validateUpdates("edit_permission_group_test_01","permissions","2")
		.getTitle()
		.logout();
	}
	@Test(priority=8,enabled=true)
	public void empty_a_required_field_and_click_save_in_permission_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionGroups()
		.editPermissionGroups("edit_permission_group_test_01")
		.deleteName()
		.failToUpdate()
		.getTitle();
	}
	@Test(priority=9,enabled=true)
	public void click_cancel_in_permission_groups_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionGroups()
		.editPermissionGroups("edit_permission_group_test_01")
		.clickCancel()
		.getTitle();
	}
	@Test(priority=10,enabled=true)
	public void return_to_permission_groups_main_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionGroups()
		.editPermissionGroups("edit_permission_group_test_01")
		.returToPermissionGroupsPage()
		.getTitle();
	}
	@Test(priority=11,enabled=true)
	public void inactivate_permission_groups()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionGroups()
		.editPermissionGroups("edit_permission_group_test_01")
		.isActive(false)
		.clickSave()
		.validateUpdates("edit_permission_group_test_01","status","INACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=12,enabled=true)
	public void activate_permission_groups()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionGroups()
		.editPermissionGroups("edit_permission_group_test_01")
		.isActive(true)
		.clickSave()
		.validateUpdates("edit_permission_group_test_01","status","ACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=13,enabled=true)
	public void archive_permission_groups()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionGroups()
		.editPermissionGroups("edit_permission_group_test_01")
		.archivePermissionGroups()
		.clickSave()
		.getTitle();
	}
	@Test(priority=14,enabled=true)
	public void restore_permission_groups()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionGroups()
		.clickArchiveButton()
		.editPermissionGroups("edit_permission_group_test_01")
		.restorePermissionGroups()
		.clickSave()
		.getTitle();
	}
}