package access;

import org.testng.annotations.Test;
import DataBase.DataBaseAccess;
import Utility.TestBase;

public class Roles_TestCases extends TestBase{

	/*create role test cases */
	@Test(priority=0,enabled=true)
	public void create_a_new_role()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickRoles()
		.clickAddRoleButton()
		.addRoleName("selenium_role_3.27")
		.addBusinessRule("selenium testing_1")
		.addAccessLevel(0)
		.addPermissionGroup("Brands Modify")
		.addPermissionGroup("Brands View")
		.addClient("Carnival Corporation & PLC")
		.Submit()
		.validateUpdates("selenium_role_3.27","name","selenium_role_3.27")
		.validateUpdates("selenium_role_3.27","permission groups","2")
		.getTitle()
		.logout();
	}
	@Test(priority=1)
	//@Test(enabled=false)
	public void create_a_new_role_without_a_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickRoles()
		.clickAddRoleButton()
		.addRoleName("")
		.addBusinessRule("selenium testing")
		.addAccessLevel(0)
		.addParentRole("BI Analyst")
		.addClient("Carnival Corporation & PLC")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=2)
	//@Test(enabled=false)
	public void select_cancel_button_in_roles_add_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickRoles()
		.clickAddRoleButton()
		.Cancel()
		.getTitle()
		.logout();
	}	
	@Test(priority=3)
	//@Test(enabled=false)
	public void fail_to_create_role_when_require_field_is_not_populated()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickRoles()
		.clickAddRoleButton()
		.addRoleName("")
		.addBusinessRule("selenium testing")
		.addAccessLevel(0)
		.failToCreate()
		.getTitle()
		.logout();
	}	
	@Test(priority=4)
	//@Test(enabled=false)
	public void create_a_duplicate_role()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickRoles()
		.clickAddRoleButton()
		.addRoleName("Account Administrator")
		.addBusinessRule("selenium testing")
		.addAccessLevel(0)
		.addClient("Carnival Corporation & PLC")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=5)
	//@Test(enabled=false)
	public void acces_level_field_is_empty_in_role_add_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickRoles()
		.clickAddRoleButton()
		.addRoleName("2Account 2Administrator")
		.addBusinessRule("selenium testing")
		.addAccessLevel(0)
		.emptyAccessLevel()
		.addClient("Carnival Corporation & PLC")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=6)
	//@Test(enabled=false)
	public void delete_role_from_database()
	{
		DataBaseAccess.deleteRole();
	}
	/*@Test(priority=10,enabled=true)
	public void create_test_role()
	{
		login.loginAs("test.data","Monday#223")
		.isSuccessfulLogin("test data")
		.clickRoles()
		.clickAddRoleButton()
		.addRoleName("edit_role_test_01")
		.addBusinessRule("test again")
		.addAccessLevel(0)
		.addPermissionGroup("Brands Modify")
		.addPermissionGroup("Brands View")
		.addClient("Carnival Corporation & PLC")
		.Submit()
		.validateUpdates("edit_role_test_01","name","edit_role_test_01")
		.getTitle()
		.logout();
	}*/
}