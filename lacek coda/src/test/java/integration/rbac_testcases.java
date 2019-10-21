package integration;

import DataBase.DataBaseAccess;
import Utility.TestBase;
import org.testng.annotations.Test;

public class rbac_testcases extends TestBase {

	/*start test user with no permission and no client*/
	@Test(priority=0,enabled=true)
	public void integration_create_a_permission_groups_1()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionGroups()
		.clickAddpermissionGroupsButton()
		.addName("permission_integration_testing")
		.clickSave()
		.getTitle()
		.logout();
	}
//	@Test(priority=1,enabled=true)
//	public void integration_create_a_role_1()
//	{
//		login.loginAs("automation.admin","Monday#223")
//		.isSuccessfulLogin("automation admin")
//		.clickRoles()
//		.clickAddRoleButton()
//		.addRoleName("automationrole1")
//		.addBusinessRule("role bizz")
//		.addAccessLevel(0)
//		.addPermissionGroup("permission_integration_testing")
//		.Submit()
//		.getTitle()
//		.logout();
//	}
//	@Test(priority=2,enabled=true)
//	public void integration_edit_user_remove_permissions_and_roles_1()
//	{
//		login.loginAs("automation.admin","Monday#223")
//		.isSuccessfulLogin("automation admin")
//		.clickUsers()
//		.editUser("set")
//		.deleteField("role")
//		.deleteField("client")
//		.Submit()
//		.getTitle()
//		.logout();
//	}
//	@Test(priority=3,enabled=true)
//	public void integration_validate_user_permission_1()
//	{
//		login.loginAs("automation.set","Monday#223")
//		.isSuccessfulLogin("automation set")
//		.validatePermission("no clients", "no role")
//		.getTitle()
//		.logout();
//	}
//	@Test(priority=4,enabled=true)
//	public void delete_permission_groups_in_database_1()
//	{
//		DataBaseAccess.deletePermissionGroup();
//	}
//	@Test(priority=5,enabled=true)
//	public void delete_role_from_database_1()
//	{
//		DataBaseAccess.deleteRole();
//	}
//	//	/*end test user with no permission and no client*/
//	/*start test user with  permission and client*/
//	@Test(priority=7,enabled=true)
//	public void integration_create_a_role_2()
//	{
//		login.loginAs("automation.admin","Monday#223")
//		.isSuccessfulLogin("automation admin")
//		.clickRoles()
//		.clickAddRoleButton()
//		.addRoleName("testrole1")
//		.addBusinessRule("role bizz")
//		.addAccessLevel(0)
//		.Submit()
//		.getTitle()
//		.logout();
//	}
//	@Test(priority=8,enabled=true)
//	public void integration_edit_user_update_permissions_and_roles_1()
//	{
//		login.loginAs("automation.admin","Monday#223")
//		.isSuccessfulLogin("automation admin")
//		.clickUsers()
//		.editUser("set")
//		.deleteField("client")
//		.deleteField("role")
//		.updateRole("testrole1")
//		.Submit()
//		.getTitle()
//		.logout();
//	}
//	@Test(priority=9,enabled=true)
//	public void integration_validate_user_permission_2()
//	{
//		login.loginAs("automation.set","Monday#223")
//		.isSuccessfulLogin("automation set")
//		.validatePermission("","testrole1")
//		.getTitle()
//		.logout();
//	}
//	@Test(priority=10,enabled=true)
//	public void delete_permission_groups_in_database_2()
//	{
//		DataBaseAccess.deletePermissionGroup();
//	}
	@Test(priority=11,enabled=true)
	public void delete_role_from_database_2()
	{
		DataBaseAccess.deleteRole();
	}
	@Test(priority=11,enabled=true)
	public void validate_user_wit_testrole2()
	{
		login.rbacLoginAs("remanth.test","09ht1a0480")
//		.validatePermission("Carnival Corporation & PLC","testrole2")
		.getTitle()
		.logout();
	}

	
}