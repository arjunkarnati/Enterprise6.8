package access;

import org.testng.annotations.Test;
import DataBase.DataBaseAccess;
import Utility.TestBase;

public class PermissionCategories_TestCases extends TestBase {

	@Test(priority=0,enabled=true)
	public void create_a_new_permission_categories()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionCategories()
		.clickAddpermissionCategoriesButton()
		.addName("selenium_test2")
		.addControllerName("selenium_controller2")
		.clickSave()
		.validateUpdates("selenium_test2","name","selenium_test2")
		.validateUpdates("selenium_test2","controller","selenium_controller2")
		.validateUpdates("selenium_test2","status","ACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=1,enabled=true)
	public void create_a_new_permission_categories_without_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionCategories()
		.clickAddpermissionCategoriesButton()
		.addControllerName("selenium_controller1")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=2,enabled=true)
	public void create_a_new_permission_categories_without_controller_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionCategories()
		.clickAddpermissionCategoriesButton()
		.addName("selenium_test2")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=3,enabled=true)
	public void click_cancel_in_permission_categories_add_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionCategories()
		.clickAddpermissionCategoriesButton()
		.clickCancel()
		.getTitle()
		.logout();
	}
	@Test(priority=4,enabled=true)
	public void return_to_permission_categories_main_page_from_add()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionCategories()
		.clickAddpermissionCategoriesButton()
		.clickPermissionsLink()
		.getTitle()
		.logout();
	}
	@Test(priority=5,enabled=true)
	public void delete_permission_category_from_database()
	{
		DataBaseAccess.deletePermissionCategory();
	}
	//No need to run
	/* @Test(priority=10,enabled=true)
	public void create_test_permission_categories()
	{
		login.loginAs("test.data","Monday#223")
		.isSuccessfulLogin("test data")
		.clickPermissionCategories()
		.clickAddpermissionCategoriesButton()
		.addName("edit_permission_category_test_01")
		.addControllerName("controller_test_1")
		.clickSave()
		.validateUpdates("edit_permission_category_test_01","name","edit_permission_category_test_01")
		.validateUpdates("edit_permission_category_test_01","controller","controller_test_1")
		.validateUpdates("edit_permission_category_test_01","status","ACTIVE")
		.getTitle()
		.logout();
	}*/
}