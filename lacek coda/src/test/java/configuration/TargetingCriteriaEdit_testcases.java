package configuration;

import org.testng.annotations.Test;

import Utility.TestBase;

public class TargetingCriteriaEdit_testcases extends TestBase{

	//EDIT TARGETING CRITERIA
	@Test(priority=0)
	public void update_targeting_criteria_client()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTargetingCriteria()
		.editTargetingCriteria("edit_tar_criteria_test_01")
		.updateClientNameTo("DuPont")
		.clickSubmitButton()
		.validateUpdates("edit_tar_criteria_test_01","client","DuPont")
		.getTitle()
		.logout();
	}
	@Test(priority=1)
	public void update_targeting_criteria_client_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTargetingCriteria()
		.editTargetingCriteria("edit_tar_criteria_test_01")
		.updateClientNameTo("Carnival Corporation & PLC")
		.clickSubmitButton()
		.validateUpdates("edit_tar_criteria_test_01","client","Carnival Corporation & PLC")
		.getTitle()
		.logout();
	}
	@Test(priority=2)
	public void update_targeting_criteria_brand()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTargetingCriteria()
		.editTargetingCriteria("edit_tar_criteria_test_01")
		.deleteEntryInBrandField()
		.updateBrandTo("Cunard")
		.clickSubmitButton()
		.validateUpdates("edit_tar_criteria_test_01","brand","1")
		.getTitle()
		.logout();
	}
	@Test(priority=3)
	public void update_targeting_criteria_brand_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTargetingCriteria()
		.editTargetingCriteria("edit_tar_criteria_test_01")
		.deleteEntryInBrandField()
		.updateBrandTo("Costa Cruises")
		.updateBrandTo("Cunard")
		.clickSubmitButton()
		.validateUpdates("edit_tar_criteria_test_01","brand","2")
		.getTitle()
		.logout();
	}
	@Test(priority=4)
	public void update_targeting_criteria_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTargetingCriteria()
		.editTargetingCriteria("edit_tar_criteria_test_01")
		.updateTargetingCriteriaName("edit_tar_criteria_test_010")
		.clickSubmitButton()
		.validateUpdates("edit_tar_criteria_test_010","name","edit_tar_criteria_test_010")
		.getTitle()
		.logout();
	}
	@Test(priority=5)
	public void update_targeting_criteria_name_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTargetingCriteria()
		.editTargetingCriteria("edit_tar_criteria_test_010")
		.updateTargetingCriteriaName("edit_tar_criteria_test_01")
		.clickSubmitButton()
		.validateUpdates("edit_tar_criteria_test_01","name","edit_tar_criteria_test_01")
		.getTitle()
		.logout();
	}
	@Test(priority=6)
	public void update_targeting_criteria_description()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTargetingCriteria()
		.editTargetingCriteria("edit_tar_criteria_test_01")
		.updateDescription("automation testing")
		.clickSubmitButton()
		.getTitle()
		.logout();
	}
	@Test(priority=7)
	public void inactivate_tageting_criteria()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTargetingCriteria()
		.editTargetingCriteria("edit_tar_criteria_test_01")
		.inactivateTargetingCriteria()
		.clickSubmitButton()
		.validateUpdates("edit_tar_criteria_test_01","status","INACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=8)
	public void activate_tageting_criteria()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTargetingCriteria()
		.editTargetingCriteria("edit_tar_criteria_test_01")
		.activateTargetingCriteria()
		.clickSubmitButton()
		.validateUpdates("edit_tar_criteria_test_01","status","ACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=9)
	public void empty_name_field_in_tagerting_criteria_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTargetingCriteria()
		.editTargetingCriteria("edit_tar_criteria_test_01")
		.deleteName()
		.failToUpdate()
		.getTitle()
		.logout();
	}
	@Test(priority=10)
	public void empty_code_field_in_tagerting_criteria_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTargetingCriteria()
		.editTargetingCriteria("edit_tar_criteria_test_01")
		.deleteCode()
		.failToUpdate()
		.getTitle()
		.logout();
	}
	@Test(priority=11)
	public void select_cancel_button_in_targeting_criteria_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTargetingCriteria()
		.editTargetingCriteria("edit_tar_criteria_test_01")
		.clickCancelButton()
		.getTitle()
		.logout();
	}
	@Test(priority=12)
	public void archive_tageting_criteria()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTargetingCriteria()
		.archiveTargetingcriteria("edit_tar_criteria_test_01")
		.getTitle();
	}
	@Test(priority=13)
	public void restore_tageting_criteria()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTargetingCriteria()
		.restoreTargetingCriteria("edit_tar_criteria_test_01")
		.getTitle();
	}
}