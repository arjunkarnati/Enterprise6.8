package layout;

import org.testng.annotations.Test;

import Utility.TestBase;

public class TemplatesEdit_testcases extends TestBase{

	//EDIT TEMPLATE 
	@Test(priority=0)
	public void update_template_brand()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.editTemplate("edit_template_test_01")
		.deleteEntryInBrandField()
		.updateBrandTo("cunard")	
		.updateBrandTo("Carnival Cruise Line")	
		.clickSubmitButton()
		.validateUpdates("edit_template_test_01","brand","1")
		.getTitle()
		.logout();
	}
	@Test(priority=1)
	public void update_template_brand_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.editTemplate("edit_template_test_01")
		.deleteEntryInBrandField()
		.updateBrandTo("cunard")	
		.clickSubmitButton()
		.validateUpdates("edit_template_test_01","brand","1")
		.getTitle()
		.logout();
	}
	@Test(priority=2)
	public void update_template_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.editTemplate("edit_template_test_01")
		.updateTemplateName("edit_template_test_010")
		.clickSubmitButton()
		.validateUpdates("edit_template_test_010","name","edit_template_test_010")
		.getTitle()
		.logout();
	}
	@Test(priority=3)
	public void update_template_name_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.editTemplate("edit_template_test_010")
		.updateTemplateName("edit_template_test_01")
		.clickSubmitButton()
		.validateUpdates("edit_template_test_01","name","edit_template_test_01")
		.getTitle()
		.logout();
	}
	@Test(priority=4)
	public void update_template_channel()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.editTemplate("edit_template_test_01")
		.updateChannel("web")
		.clickSubmitButton()
		.validateUpdates("edit_template_test_01","channel","Web")
		.getTitle()
		.logout();
	}
	@Test(priority=5)
	public void update_template_channel_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.editTemplate("edit_template_test_01")
		.updateChannel("email")
		.clickSubmitButton()
		.validateUpdates("edit_template_test_01","channel","Email")
		.getTitle()
		.logout();
	}
	@Test(priority=6,enabled=false)
	public void update_template_type()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.editTemplate("edit_template_test_01")
		.updateType("Message")
		.clickSubmitButton()
		.validateUpdates("edit_template_test_01","type","Message")
		.getTitle()
		.logout();
	}
	@Test(priority=7,enabled=false)
	public void update_template_type_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.editTemplate("edit_template_test_01")
		.updateType("Communication")
		.clickSubmitButton()
		.validateUpdates("edit_template_test_01","type","Communication")
		.getTitle()
		.logout();
	}
	@Test(priority=8)
	public void update_template_clientname()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.editTemplate("edit_template_test_01")
		.updateClientNameTo("DuPont")
		.clickSubmitButton()
		.validateUpdates("edit_template_test_01","client","DuPont")
		.getTitle()
		.logout();
	}
	@Test(priority=9)
	public void update_template_clientname_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.editTemplate("edit_template_test_01")
		.updateClientNameTo("Carnival Corporation & PLC")
		.deleteEntryInBrandField()
		.clickSubmitButton()
		.validateUpdates("edit_template_test_01","client","Carnival Corporation & PLC")
		.getTitle()
		.logout();
	}
	@Test(priority=10)
	public void select_button_save_in_template_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.editTemplate("edit_template_test_01")
		.clickSaveButton()
		.getTitle()
		.logout();
	}
	@Test(priority=11)
	public void select_button_cancel_in_template_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.editTemplate("edit_template_test_01")
		.clickCancelButton()
		.getTitle()
		.logout();
	}
	@Test(priority=12)
	public void inactivate_template()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.editTemplate("edit_template_test_01")
		.isActive(false)
		.clickSubmitButton()
		.validateUpdates("edit_template_test_01","status","INACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=13)
	public void activate_template()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.editTemplate("edit_template_test_01")
		.isActive(true)
		.clickSubmitButton()
		.validateUpdates("edit_template_test_01","status","ACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=14)
	public void set_template_workflow_to_draft()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.editTemplate("edit_template_test_01")
		.setWorkFlowTo("DRAFT","edit_template_test_01")
		.validateUpdates("edit_template_test_01","workflow","DRAFT")
		.getTitle()
		.logout();
	}
	@Test(priority=15)
	public void set_template_workflow_to_approved()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.editTemplate("edit_template_test_01")
		.setWorkFlowTo("APPROVED","edit_template_test_01")
		.validateUpdates("edit_template_test_01","workflow","APPROVED")
		.getTitle()
		.logout();
	}
	@Test(priority=16)
	public void archive_template()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.archiveTemplate("edit_template_test_01")
		.getTitle()
		.logout();
	}
	@Test(priority=17)
	public void restore_template()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.restoreTemplate("edit_template_test_01")
		.getTitle()
		.logout();
	}
}