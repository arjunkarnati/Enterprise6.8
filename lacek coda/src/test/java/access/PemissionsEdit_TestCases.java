package access;

import org.testng.annotations.Test;

import Utility.TestBase;

public class PemissionsEdit_TestCases extends TestBase {

	@Test(priority=0,enabled=true)
	public void update_permissions_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissions()
		.editPermissions("edit_permission_test_01")
		.updateName("edit_permission_test_010")
		.clickSave()
		.validateUpdates("edit_permission_test_010","permission","edit_permission_test_010")
		.getTitle()
		.logout();
	}
	@Test(priority=1,enabled=true)
	public void update_permissions_name_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissions()
		.editPermissions("edit_permission_test_010")
		.updateName("edit_permission_test_01")
		.clickSave()
		.validateUpdates("edit_permission_test_01","permission","edit_permission_test_01")
		.getTitle()
		.logout();
	}
	@Test(priority=2,enabled=true)
	public void update_permissions_permission_category()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissions()
		.editPermissions("edit_permission_test_01")
		.updatePermissionCategory("Channels")
		.clickSave()
		.validateUpdates("edit_permission_test_01","category","Channels")
		.getTitle()
		.logout();
	}
	@Test(priority=3,enabled=true)
	public void update_permissions_permission_category_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissions()
		.editPermissions("edit_permission_test_01")
		.updatePermissionCategory("Clients")
		.clickSave()
		.validateUpdates("edit_permission_test_01","category","Clients")
		.getTitle()
		.logout();
	}
	@Test(priority=4,enabled=true)
	public void update_permissions_business_rule()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissions()
		.editPermissions("edit_permission_test_01")
		.updateBusinessRule("still testing")
		.clickSave()
		.getTitle()
		.logout();
	}
	@Test(priority=5,enabled=true)
	public void update_permissions_business_rule_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissions()
		.editPermissions("edit_permission_test_01")
		.updateBusinessRule("testing 001")
		.clickSave()
		.getTitle()
		.logout();
	}
	@Test(priority=6,enabled=false)
	public void empty_name_field_in_permissions_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissions()
		.editPermissions("edit_permission_test_01")
		.deleteName()
		.failToUpdate()
		.getTitle()
		.logout();
	}
	@Test(priority=7,enabled=false)
	public void empty_permission_category_field_in_permissions_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissions()
		.editPermissions("edit_permission_test_01")
		.emptyPermissionCategoryField()
		.failToUpdate()
		.getTitle()
		.logout();
	}
	@Test(priority=8,enabled=true)
	public void click_cancel_in_permissions_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissions()
		.editPermissions("edit_permission_test_01")
		.clickCancel()
		.getTitle()
		.logout();
	}
	@Test(priority=9,enabled=true)
	public void returm_to_permissions_main_page_from_edit()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissions()
		.editPermissions("edit_permission_test_01")
		.clickPermissionsLink()
		.getTitle()
		.logout();
	}
	@Test(priority=10,enabled=true)
	public void inactivate_permissions()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissions()
		.editPermissions("edit_permission_test_01")
		.isActive(false)
		.clickSave()
		.validateUpdates("edit_permission_test_01","status","INACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=11,enabled=true)
	public void activate_permissions()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissions()
		.editPermissions("edit_permission_test_01")
		.isActive(true)
		.clickSave()
		.validateUpdates("edit_permission_test_01","status","ACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=12,enabled=true)
	public void archive_permissions()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissions()
		.editPermissions("edit_permission_test_01")
		.archivePermissions()
		.clickSave()
		.getTitle()
		.logout();
	}
	@Test(priority=13,enabled=true)
	public void restore_permissions()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissions()
		.clickArchiveButton()
		.editPermissions("edit_permission_test_01")
		.restorePermissions()
		.clickSave()
		.getTitle()
		.logout();
	}
}