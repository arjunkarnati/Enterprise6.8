package configuration;

import org.testng.annotations.Test;
import DataBase.DataBaseConfiguration;
import Utility.TestBase;

public class TargetingCriteria_TestCases extends TestBase{

	/*create targeting criteria test cases */

	@Test(priority=0)
	//@Test(enabled=false)
	public void create_a_new_targeting_criteria()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTargetingCriteria()
		.clickAddTargetingcriteriaButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addBrand("Costa Cruises")
		.addTargetingCriteriaName("selenium_targetingcriteria_007")	
		.addDescription("creating a new targeting criteria using selenium WD")
		.clickSubmitButton()	
		.validateUpdates("selenium_targetingcriteria_007","client","Carnival Corporation & PLC")
		.validateUpdates("selenium_targetingcriteria_007","brand","2")
		.validateUpdates("selenium_targetingcriteria_007","name","selenium_targetingcriteria_007")
		.validateUpdates("selenium_targetingcriteria_007","status","ACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=1)
	//@Test(enabled=false)
	public void create_a_new_targeting_criteria_without_a_clientname()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTargetingCriteria()
		.clickAddTargetingcriteriaButton()
		.addTargetingCriteriaName("test_selenium_targetingcriteria_02")	
		.addDescription("creating a new targeting criteria using selenium WD")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=2)
	//@Test(enabled=false)
	public void create_a_new_targeting_criteria_without_a_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTargetingCriteria()
		.clickAddTargetingcriteriaButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addDescription("creating a new targeting criteria using selenium WD")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=3)
	//@Test(enabled=false)
	public void select_button_cancel_in_targeting_criteria_add_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTargetingCriteria()
		.clickAddTargetingcriteriaButton()
		.clickCancelButton()
		.getTitle()
		.logout();
	}
	@Test(priority=30) 
	public void database_delete_targeting_criteria()
	{	
		DataBaseConfiguration.deleteTargetingCriteria();
	}
	/*@Test(priority=31)
	//@Test(enabled=false)
	public void create_test_targeting_criteria()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTargetingCriteria()
		.clickAddTargetingcriteriaButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addBrand("Costa Cruises")
		.addTargetingCriteriaName("edit_tar_criteria_test_01")	
		.addDescription("automation testing")
		.clickSubmitButton()	
		.validateUpdates("edit_tar_criteria_test_01","client","Carnival Corporation & PLC")
		.validateUpdates("edit_tar_criteria_test_01","brand","2")
		.validateUpdates("edit_tar_criteria_test_01","name","edit_tar_criteria_test_01")
		.validateUpdates("edit_tar_criteria_test_01","status","ACTIVE")
		.getTitle()
		.logout();
	}*/
}