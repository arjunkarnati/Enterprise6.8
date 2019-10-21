package access;

import DataBase.DataBaseAccess;
import Utility.TestBase;
import org.testng.annotations.Test;

public class Permissions_TestCases extends TestBase {

	@Test(priority=0,enabled=true)
	public void create_a_new_permissions()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissions()
		.clickAddpermissionsButton()
		.addName("selenium_permission02")
		.addPermissionCategory("Campaigns")
		.addBusinessRule("selenium_bizz2")
		.clickSave()
		.validateUpdates("selenium_permission02","permission","selenium_permission02")
		.validateUpdates("selenium_permission02","category","Campaigns")
		.validateUpdates("selenium_permission02","status","ACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=1,enabled=true)
	public void create_a_new_permissions_without_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissions()
		.clickAddpermissionsButton()
		.addPermissionCategory("Campaigns")
		.addBusinessRule("selenium_bizz_01")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=2,enabled=true)
	public void create_a_new_permissions_without_permission_category()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissions()
		.clickAddpermissionsButton()
		.addName("test_01")
		.addBusinessRule("selenium_bizz_01")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=3,enabled=true)
	public void click_cancel_in_permissions_add_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissions()
		.clickAddpermissionsButton()
		.clickCancel()
		.getTitle()
		.logout();
	}
	@Test(priority=4,enabled=true)
	public void return_to_permissions_main_page_from_add()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissions()
		.clickAddpermissionsButton()
		.clickPermissionsLink()
		.getTitle()
		.logout();
	}
	@Test(priority=5,enabled=true)
	public void delete_permissions_from_database()
	{
		DataBaseAccess.deletePermission();
	}
	/*@Test(priority=11,enabled=true)
	public void create_testdata_permissions()
	{
		login.loginAs("test.data","Monday#223")
		.isSuccessfulLogin("test data")
		.clickPermissions()
		.clickAddpermissionsButton()
		.addName("edit_permission_test_01")
		.addPermissionCategory("Campaigns")
		.addBusinessRule("selenium_bizz2")
		.clickSave()
		.validateUpdates("edit_permission_test_01","permission","edit_permission_test_01")
		.validateUpdates("edit_permission_test_01","category","Campaigns")
		.validateUpdates("edit_permission_test_01","status","ACTIVE")
		.getTitle()
		.logout();
	}*/
	
}