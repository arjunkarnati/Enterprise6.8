package layout;

import Utility.TestBase;
import org.testng.annotations.Test;

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
	@Test(priority=15)
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
	@Test(priority=18)
	public void rollback_template_updates()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.editTemplate("edit_template_test_01")
		.updateChannel("web")
		.setWorkFlowTo("APPROVED","edit_template_test_01")
		.validateUpdates("edit_template_test_01","channel","Web")
		.validateUpdates("edit_template_test_01","workflow","APPROVED")
		.editTemplate("edit_template_test_01")
		.selectTemplatehistory()
		.latestTemplatehistory()
		.rollbackTemplate()
		.clickSubmitButton()
		.validateUpdates("edit_template_test_01","channel","Email")
		.validateUpdates("edit_template_test_01","workflow","DRAFT")
		.getTitle()
		.logout();
		}
	@Test(priority=18)
	public void rollback_template_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.editTemplate("edit_template_test_01")
		.updateChannel("web")
		.setWorkFlowTo("APPROVED","edit_template_test_01")
		.validateUpdates("edit_template_test_01","channel","Web")
		.validateUpdates("edit_template_test_01","workflow","APPROVED")
		.editTemplate("edit_template_test_01")
		.selectTemplatehistory()
		.latestTemplatehistory()
		.rollbackTemplate()
		.clickSubmitButton()
		.validateUpdates("edit_template_test_01","channel","Email")
		.validateUpdates("edit_template_test_01","workflow","DRAFT")
		.getTitle()
		.logout();
		}
	@Test(priority=1)
	public void compare_template_updates()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.editTemplate("edit_template_test_01")
		.updateBrandTo("Carnival Cruise Line")
		.clickSubmitButton()
		.editTemplate("edit_template_test_01")
		.selectTemplatehistory()
		.latestTemplatehistory()
		.compareTemplate()
		.validateTemp_count();
	}
	@Test(priority=19)
	public void add_media_to_template()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.editTemplate("edit_template_test_01")
		.selectTemp_media_add()
		.add_media_to_temp("2223")
		.clickSubmitButton()
		.getTitle()
		.logout();
	}
	@Test(priority=20)
	public void delete_media_to_template()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.editTemplate("edit_template_test_01")
		.deleteTemp_media()
		.clickSubmitButton()
		.getTitle()
		.logout();
	}
	@Test(priority=21)
	public void add_markup_to_template()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.editTemplate("edit_ehi_temp-01")
		.selectTemp_region_header()
		.addmarkup_to_Template("template")
		.getTitle()
		.logout();
        
		
	}
	@Test(priority=22)
	public void add_comm_to_template()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.editTemplate("ACMSGTMP")
		//.click_comm_temp()
		.logout();
	
	
	}
	@Test(priority=23)
	public void enable_column_search()
	{
		login.loginAs("ehi.ae","09ht1a0480@123")
		.isSuccessfulLogin("ehi ae")
		.edit_own_profile()
		.logout();
			
	}
	
	@Test(priority=24)
	public void temp_column_search()
	{
		login.loginAs("ehi.ae","09ht1a0480@123")
		.isSuccessfulLogin("ehi ae")
		.clickTemplates()
		.searchtempby_ID("10000002")
		.edit_temp_ehi_ae()
		.setWorkFlow_ehi_aeTo("APPROVED","edit_ehi_template_01")
		.validateUpdates("edit_ehi_template_01","workflow","APPROVED")
		.getTitle()
		.logout();
	}
	@Test(priority=25)
	public void temp_column_search_update()
	{
		login.loginAs("ehi.ae","09ht1a0480@123")
		.isSuccessfulLogin("ehi ae")
		.clickTemplates()
		.searchtempby_ID("10000002")
		.edit_temp_ehi_ae()
		.setWorkFlow_ehi_aeTo("DRAFT","edit_ehi_template_01")
		.validateUpdates("edit_ehi_template_01","workflow","DRAFT")
		.getTitle()
		.logout();
	}
	@Test(priority=23)
	public void disable_column_search()
	{
		login.loginAs("ehi.ae","09ht1a0480@123")
		.isSuccessfulLogin("ehi ae")
		.edit_own_profile()
		.logout();
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
}