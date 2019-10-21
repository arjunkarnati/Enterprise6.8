package access;

import Utility.TestBase;
import org.testng.annotations.Test;

public class PermissionCategoriesEdit_TestCases extends TestBase{

	@Test(priority=0,enabled=true)
	public void update_permission_categories_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionCategories()
		.editPermissionCategories("edit_permission_category_test_01")
		.updateName("edit_permission_category_test_010")
		.clickSave()
		.validateUpdates("edit_permission_category_test_010","name","edit_permission_category_test_010")
		.getTitle()
		.logout();
	}
	@Test(priority=1,enabled=true)
	public void update_permission_categories_name_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionCategories()
		.editPermissionCategories("edit_permission_category_test_010")
		.updateName("edit_permission_category_test_01")
		.clickSave()
		.validateUpdates("edit_permission_category_test_01","name","edit_permission_category_test_01")
		.getTitle()
		.logout();
	}
	@Test(priority=2,enabled=true)
	public void update_permission_categories_conttroller_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionCategories()
		.editPermissionCategories("edit_permission_category_test_01")
		.updateControllerNmae("controller1")
		.clickSave()
		.validateUpdates("edit_permission_category_test_01","controller","controller1")
		.getTitle()
		.logout();
	}
	@Test(priority=3,enabled=true)
	public void update_permission_categories_conttroller_name_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionCategories()
		.editPermissionCategories("edit_permission_category_test_01")
		.updateControllerNmae("controller_test_1")
		.clickSave()
		.validateUpdates("edit_permission_category_test_01","controller","controller_test_1")
		.getTitle()
		.logout();
	}
	@Test(priority=4,enabled=false)
	public void empty_name_field_in_permission_categories_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionCategories()
		.editPermissionCategories("edit_permission_category_test_01")
		.deleteName()
		.failToUpdate()
		.getTitle()
		.logout();
	}
	@Test(priority=5,enabled=false)
	public void empty_controller_name_field_in_permission_categories_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionCategories()
		.editPermissionCategories("edit_permission_category_test_01")
		.deleteControllerName()
		.failToUpdate()
		.getTitle()
		.logout();
	}
	@Test(priority=6,enabled=true)
	public void click_cancel_in_permission_categories_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionCategories()
		.editPermissionCategories("edit_permission_category_test_01")
		.clickCancel()
		.getTitle()
		.logout();
	}
	@Test(priority=7,enabled=true)
	public void return_to_main_page_from_permission_categories_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionCategories()
		.editPermissionCategories("edit_permission_category_test_01")
		.returnToMainPage()
		.getTitle()
		.logout();
	}
	@Test(priority=8,enabled=true)
	public void inactivate_permission_categories()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionCategories()
		.editPermissionCategories("edit_permission_category_test_01")
		.isActive(false)
		.clickSave()
		.validateUpdates("edit_permission_category_test_01","status","INACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=9,enabled=true)
	public void activate_permission_categories()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionCategories()
		.editPermissionCategories("edit_permission_category_test_01")
		.isActive(true)
		.clickSave()
		.validateUpdates("edit_permission_category_test_01","status","ACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=10,enabled=true)
	public void archive_permission_categories()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionCategories()
		.editPermissionCategories("edit_permission_category_test_01")
		.archivePermissionCategories()
		.clickSave()
		.getTitle()
		.logout();
	}
	@Test(priority=11,enabled=true)
	public void restore_permission_categories()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionCategories()
		.clickArchiveButton()
		.editPermissionCategories("edit_permission_category_test_01")
		.restorePermissionCategories()
		.clickSave()
		.getTitle()
		.logout();
	}
}