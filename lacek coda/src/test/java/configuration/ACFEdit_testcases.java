package configuration;

import Utility.TestBase;
import org.testng.annotations.Test;

public class ACFEdit_testcases extends TestBase {

	/*need some updates*/
	@Test(priority=0,enabled=true)
	public void update_acf_client()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickAcf()
		.editAcf("edit_acf_test_01")
		//.updateClientNameTo("DuPont")
		.clickSubmitButton()
		.getTitle()
		.logout();
	}
	/*need some updates*/
	@Test(priority=1,enabled=true)
	public void update_acf_brand()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickAcf()
		.editAcf("edit_acf_test_01")
		.emptyBrandField()
		.updateBrandTo("Cunard")
		.updateBrandTo("Carnival Cruise Line")
		.updateBrandTo("Fathom")
		.clickSubmitButton()
		.validateUpdates("edit_acf_test_01","brand","3")
		.getTitle()
		.logout();
	}
	@Test(priority=2,enabled=true)
	public void update_acf_brand_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickAcf()
		.editAcf("edit_acf_test_01")
		.emptyBrandField()
		.updateBrandTo("Cunard")
		.updateBrandTo("Carnival Cruise Line")
		.updateBrandTo("Fathom")
		.updateBrandTo("AIDA Cruises")
		.updateBrandTo("Princess Cruises")
		.clickSubmitButton()
		.validateUpdates("edit_acf_test_01","brand","5")
		.getTitle()
		.logout();
	}
	@Test(priority=3,enabled=true)
	public void update_acf_program()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickAcf()
		.editAcf("edit_acf_test_01")
		.deleteEntryInProgramField()
		.updateProgramTo("VIFP")
		.clickSubmitButton()
		.validateUpdates("edit_acf_test_01","program","1")
		.getTitle()
		.logout();
	}
	@Test(priority=4,enabled=true)
	public void update_acf_program_to_prvious()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickAcf()
		.editAcf("edit_acf_test_01")
		.deleteEntryInProgramField()
		.updateProgramTo("VIFP")
		.updateProgramTo("smm1")
		.clickSubmitButton()
		.validateUpdates("edit_acf_test_01","program","2")
		.getTitle()
		.logout();
	}
	@Test(priority=5,enabled=true)
	public void update_acf_group_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickAcf()
		.editAcf("edit_acf_test_01")
		.updateGroupNameTo("edit_acf_test_010")
		.clickSubmitButton()
		.validateUpdates("edit_acf_test_010","name","edit_acf_test_010")
		.getTitle()
		.logout();
	}
	@Test(priority=6,enabled=true)
	public void update_acf_group_name_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickAcf()
		.editAcf("edit_acf_test_010")
		.updateGroupNameTo("edit_acf_test_01")
		.clickSubmitButton()
		.validateUpdates("edit_acf_test_01","name","edit_acf_test_01")
		.getTitle()
		.logout();
	}
	@Test(priority=7,enabled=true)
	public void empty_group_name_in_acf_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickAcf()
		.editAcf("edit_acf_test_01")
		.emptyFieldName()
		.failToUpdate()
		.getTitle()
		.logout();
	}
	@Test(priority=8,enabled=true)
	public void empty_field_label_in_acf_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickAcf()
		.editAcf("edit_acf_test_01")
		.emptyFieldLabel()
		.failToUpdate()
		.getTitle()
		.logout();
	}
	@Test(priority=9,enabled=true)
	public void empty_field_name_in_acf_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickAcf()
		.editAcf("edit_acf_test_01")
		.emptyFieldName()
		.failToUpdate()
		.getTitle()
		.logout();
	}
}