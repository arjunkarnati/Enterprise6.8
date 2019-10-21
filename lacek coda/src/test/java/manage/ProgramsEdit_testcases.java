package manage;

import Utility.TestBase;
import org.testng.annotations.Test;

public class ProgramsEdit_testcases extends TestBase{

	//EDIT PROGRAM
    @Test(priority=0)
	public void update_program_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPrograms()
		.editProgram("edit_program_test_01")
		.updateProgramNameTo("edit_program_test_010")
		.clickSubmit()
		.validateUpdates("edit_program_test_010","name","edit_program_test_010")
		.getTitle()
		.logout();
	}
	@Test(priority=1)
	public void update_program_name_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPrograms()
		.editProgram("edit_program_test_010")
		.updateProgramNameTo("edit_program_test_01")
		.clickSubmit()
		.validateUpdates("edit_program_test_01","name","edit_program_test_01")
		.getTitle()
		.logout();
	}
	@Test(priority=2)
	public void update_program_brands()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPrograms()
		.editProgram("edit_program_test_01")
		.deleteEntryInBrandField()
		.updateBrandTo("Cunard")
		.updateBrandTo("Costa Cruises")
		.updateBrandTo("Princess Cruises")
		.updateBrandTo("Fathom")
		.clickSubmit()
		.validateUpdates("edit_program_test_01","brand","4")
		.getTitle()
		.logout();
	}
	@Test(priority=3)
	public void update_program_brands_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPrograms()
		.editProgram("edit_program_test_01")
		.deleteEntryInBrandField()
		.updateBrandTo("Costa Cruises")
		.updateBrandTo("Princess Cruises")
		.clickSubmit()
		.validateUpdates("edit_program_test_01","brand","2")
		.getTitle()
		.logout();
	}
	@Test(priority=4)
	public void update_program_url()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPrograms()
		.editProgram("edit_program_test_01")
		.updateUrlTo("http://www.seleniumhq.org/")
		.clickSubmit()
		.validateUpdates("edit_program_test_01","url","http://www.seleniumhq.org/")
		.getTitle()
		.logout();
	}
	@Test(priority=5)
	public void update_program_url_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPrograms()
		.editProgram("edit_program_test_01")
		.updateUrlTo("http://www.lacek.com/")
		.clickSubmit()
		.validateUpdates("edit_program_test_01","url","http://www.lacek.com/")
		.getTitle()
		.logout();
	}
	@Test(priority=6)
	public void update_program_description()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPrograms()
		.editProgram("edit_program_test_01")
		.updateDescription("still using selenium for automation")
		.clickSubmit()
		.getTitle()
		.logout();
	}
	@Test(priority=7)
	public void select_cancel_button_in_program_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPrograms()
		.editProgram("edit_program_test_01")
		.clickCancel()
		.getTitle()
		.logout();
	}
	//*need some updates
	@Test(priority=8)
	public void update_program_clientname()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPrograms()
		.editProgram("edit_program_test_01")
		//		.updateClientNameTo("DuPont")
		//		.clickSubmit()
		//		.validateUpdates("edit_program_test_01","client","DuPont")
		.getTitle()
		.logout();
	}
	//*need some updates
	@Test(priority=9)
	public void update_program_clientname_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPrograms()
		.editProgram("edit_program_test_01")
		//	.updateClientNameTo("Carnival Corporation & PLC")
		//		.clickSubmit()
		//		.validateUpdates("edit_program_test_01","client","Carnival Corporation & PLC")
		.getTitle()
		.logout();
	}
	@Test(priority=10)
	public void inactivate_program()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPrograms()
		.editProgram("edit_program_test_01")
		.inactivateProgram()
		.clickSubmit()
		.validateUpdates("edit_program_test_01","status","INACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=11)
	public void activate_program()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPrograms()
		.editProgram("edit_program_test_01")
		.activateProgram()
		.clickSubmit()
		.validateUpdates("edit_program_test_01","status","ACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=12)
	public void empty_name_field_in_programs_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPrograms()
		.editProgram("edit_program_test_01")
		.deleteName()
		.failToUpdate()
		.getTitle()
		.logout();
	}
	@Test(priority=13)
	public void archive_program()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPrograms()
		.archiveProgram("edit_program_test_01")
		.getTitle();
	}
	@Test(priority=14)
	public void restore_program()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPrograms()
		.restoreProgram("edit_program_test_01")
		.getTitle();
	}
}