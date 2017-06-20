package library;

import org.testng.annotations.Test;

import Utility.TestBase;

public class VariableEdit_Testcases extends TestBase{

	//EDIT VARIABLE 
	@Test(priority=0)
	public void update_variable_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickVariablesLink()
		.editVariables("edit_variable_test_01")
		.updateVariableNameTo("edit_variable_test_010")
		.clickSubmitButon()
		.validateUpdates("edit_variable_test_010","name","edit_variable_test_010")
		.getTitle()
		.logout();	
	}
	@Test(priority=1)
	public void update_variable_name_to_previous_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickVariablesLink()
		.editVariables("edit_variable_test_010")
		.updateVariableNameTo("edit_variable_test_01")
		.clickSubmitButon()
		.validateUpdates("edit_variable_test_01","name","edit_variable_test_01")
		.getTitle()
		.logout();	
	}
	@Test(priority=2)
	public void update_variable_brands()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickVariablesLink()
		.editVariables("edit_variable_test_01")
		.deleteEntryInBrandField()
		.updateBrandTo("Costa Cruises")
		.updateBrandTo("cunard")
		.clickSubmitButon()
		.validateUpdates("edit_variable_test_01","brands","2")
		.getTitle()
		.logout();	
	}
	@Test(priority=3)
	public void update_variable_brands_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickVariablesLink()
		.editVariables("edit_variable_test_01")
		.deleteEntryInBrandField()
		.updateBrandTo("Costa Cruises")
		.clickSubmitButon()
		.validateUpdates("edit_variable_test_01","brands","1")
		.getTitle()
		.logout();	
	}
	@Test(priority=4)
	public void update_Variable_client()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickVariablesLink()
		.editVariables("edit_variable_test_01")
		.updateClientNameTo("DuPont")
		.clickSubmitButon()
		.validateUpdates("edit_variable_test_01","client","DuPont")
		.getTitle()
		.logout();	
	}
	@Test(priority=5)
	public void update_variable_clientname_to_previous_client()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickVariablesLink()
		.editVariables("edit_variable_test_01")
		.updateClientNameTo("Carnival Corporation & PLC")
		//.addacfvalue("0")
		.clickSubmitButon()
		.validateUpdates("edit_variable_test_01","client","Carnival Corporation & PLC")
		.getTitle()
		.logout();	
	}
	@Test(priority=6)
	public void inactivate_variable()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickVariablesLink()
		.editVariables("edit_variable_test_01")
		.isActive(false)
		.clickSubmitButon()
		.validateUpdates("edit_variable_test_01","status","INACTIVE")
		.getTitle()
		.logout();	
	}
	@Test(priority=7)
	public void activate_variable()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickVariablesLink()
		.editVariables("edit_variable_test_01")
		.isActive(true)
		.clickSubmitButon()
		.validateUpdates("edit_variable_test_01","status","ACTIVE")
		.getTitle()
		.logout();	
	}
	@Test(priority=8)
	public void archive_variable()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickVariablesLink()
		.archiveVariable("edit_variable_test_01")
		.getTitle()
		.logout();	
	}
	@Test(priority=9)
	public void restore_variable()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickVariablesLink()
		.restoreVariable("edit_variable_test_01")
		.getTitle()
		.logout();	
	}
	@Test(priority=10)
	public void check_idcolumn()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickVariablesLink()
		.verifyIdcolumn();
	}
	@Test(priority=11)
	public void update_variable_brands_by_EHI_AE()
	{
		login.loginAs("ehi.ae","09ht1a0480123")
		.isSuccessfulLogin("ehi ae")
		.clickVariablesLink()
		.editVariables("edit_ehi_variable")
		.deleteEntryInBrandField_ehi_ae()
		.ehi_ae_updateBrandTo("carsales")
		//.ehi_ae_updateBrandTo("Alamo")
		.ehi_ae_updateBrandTo("Enterprise")
		.clickSubmitButon()
		.validateUpdates("edit_ehi_variable","brands","2")
		.getTitle()
		.logout();	
	}
	@Test(priority=12)
	public void update_variable_brands_to_previous_by_EHI_AE()
	{
		login.loginAs("ehi.ae","09ht1a0480123")
		.isSuccessfulLogin("ehi ae")
		.clickVariablesLink()
		.editVariables("edit_ehi_variable")
		.deleteEntryInBrandField_ehi_ae()
		.ehi_ae_updateBrandTo("carsales")
		.ehi_ae_updateBrandTo("National")
		.clickSubmitButon()
		.validateUpdates("edit_ehi_variable","brands","2")
		.getTitle()
		.logout();	
	}
	@Test(priority=13)
	public void archive_variable_ehi_ae()
	{
		login.loginAs("ehi.ae","09ht1a0480123")
		.isSuccessfulLogin("ehi ae")
		.clickVariablesLink()
		.ehi_ae_archiveVariable("edit_ehi_variable")
		.getTitle()
		.logout();	
	}
	@Test(priority=14)
	public void restore_variable_ehi_ae()
	{
		login.loginAs("ehi.ae","09ht1a0480123")
		.isSuccessfulLogin("ehi ae")
		.clickVariablesLink()
		.ehi_ae_restoreVariable("edit_ehi_variable")
		.getTitle()
		.logout();	
	}
	
}