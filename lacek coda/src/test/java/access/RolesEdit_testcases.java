package access;

import org.testng.annotations.Test;
import Utility.TestBase;

public class RolesEdit_testcases extends TestBase{

	//EDIT ROLE
	@Test(priority=0)
	public void update_role_name()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRoles()	
		.editRole("edit_role_test_01")
		.updateRoleNameTo("edit_role_test_010")
		.Submit()
		.validateUpdates("edit_role_test_010","name","edit_role_test_010")
		.getTitle()
		.logout();
	}
	@Test(priority=1)
	public void update_role_name_to_previous()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRoles()
		.editRole("edit_role_test_010")
		.updateRoleNameTo("edit_role_test_01")
		.Submit()
		.validateUpdates("edit_role_test_01","name","edit_role_test_01")
		.getTitle()
		.logout();
	}
	@Test(priority=2)
	public void update_role_business_rule()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRoles()	
		.editRole("edit_role_test_01")
		.updateBusinessRule("selenium testing")
		.Submit()
		.getTitle()
		.logout();
	}
	@Test(priority=3)
	public void update_role_business_rule_to_previous()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRoles()	
		.editRole("edit_role_test_01")
		.updateBusinessRule("test again")
		.Submit()
		.getTitle()
		.logout();
	}
	@Test(priority=4)
	public void update_role_parent_role()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRoles()	
		//.editRole("edit_role_test_01")
		//.updateParentRole("selenium_role_1")
		//.Submit()
		.getTitle()
		.logout();
	}
	@Test(priority=5)
	public void update_role_parent_role_to_previous()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRoles()	
		.editRole("edit_role_test_01")
		.updateParentRole("selenium_role_6")
		.Submit()
		.validateUpdates("edit_role_test_01","parent role","selenium_role_6")
		.getTitle()
		.logout();
	}
	@Test(priority=6)
	public void update_role_name_permissions()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRoles()
		.editRole("edit_role_test_01")
		.emptyPermissionGroupField()
		.updatePermissionGroup("Access Complete Access")
		.updatePermissionGroup("Brands Modify")
		.updatePermissionGroup("Account Production Complete Access")
		.updatePermissionGroup("Campaigns Ancillary")
		.updatePermissionGroup("Clients Modify")
		.updatePermissionGroup("Connectors Modify")
		.updatePermissionGroup("Publish Ancillary")
		.updatePermissionGroup("Permission Actions View")
        //.validateUpdates("edit_role_test_01","permission groups","8")
		.getTitle()
		.logout();
	}	
	@Test(priority=7)
	public void update_role_name_permissions_to_previous()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRoles()
		.editRole("edit_role_test_01")
		.emptyPermissionGroupField()
		.updatePermissionGroup("Access Complete Access")
		.updatePermissionGroup("Brands Modify")
		.updatePermissionGroup("Account Production Complete Access")
		.updatePermissionGroup("Campaigns Ancillary")
		//.validateUpdates("edit_role_test_01","permission groups","4")
		.getTitle()
		.logout();
	}	
	@Test(priority=8)
	public void inactivate_role()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRoles()
		.editRole("edit_role_test_01")
		.inactivateRole()
		.Submit()
		.validateUpdates("edit_role_test_01","status","INACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=9)
	public void activate_role()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRoles()
		.editRole("edit_role_test_01")
		.activateRole()
		.Submit()
		.validateUpdates("edit_role_test_01","status","ACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=10)
	public void archive_role()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRoles()
		.editRole("edit_role_test_01")
		.archiveRole()
		.Submit()
		.getTitle();
	}	
	@Test(priority=11)
	public void restore_role()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRoles()
		.clickArchiveButton()
		.editRole("edit_role_test_01")
		.restoreRole()
		.Submit()
		.getTitle()
		.logout();
	}	
	@Test(priority=12)
	//@Test(enabled=false)
	public void fail_to_update_role_when_name_field_is_not_populated()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRoles()
		.editRole("edit_role_test_01")
		.deleteName()
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=13)
	public void edit_archiverole(){
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRoles()
		.clickArchiveButton()
		.editRole("analytics")
		.Submit()
		//.clickArchiveButton()
		//.validateUpdates("analytics","name","analytics_1")
		.logout();
	}
	@Test(priority=14)
	public void edit_archiveroleto_previous(){
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRoles()
		.clickArchiveButton()
		.editRole("analytics_1")
		.Submit()
		//.validateUpdates("analytics_1","name","analytics")
		.logout();
	}
}