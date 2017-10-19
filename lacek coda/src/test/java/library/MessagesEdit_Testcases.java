package library;

import org.testng.annotations.Test;
import Utility.TestBase;



public class MessagesEdit_Testcases extends TestBase{

	@Test(priority=0)
	//@Test(enabled=false)
	public void update_message_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.editMessage("edit_message_test_01")
		.updateMessageNameTo("edit_message_test_010")
		.clickSubmitButton()
		.validateUpdates("edit_message_test_010","name","edit_message_test_010")
		.getTitle()
		.logout();	
	}
	@Test(priority=1)
	//@Test(enabled=false)
	public void update_message_name_to_previous_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.editMessage("edit_message_test_010")
		.updateMessageNameTo("edit_message_test_01")
		.clickSubmitButton()
		.validateUpdates("edit_message_test_01","name","edit_message_test_01")
		.getTitle()
		.logout();	
	}
	@Test(priority=2,enabled=false)
	public void update_message_client_field()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.editMessage("edit_message_test_01")
		.updateClientNameTo("DuPont")
		.clickSubmitButton()
		.validateUpdates("edit_message_test_01","client","DuPont")
		.getTitle()
		.logout();	
	}
	@Test(priority=3,enabled=false)
	public void update_message_clientname_to_previous_client()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.editMessage("edit_message_test_01")
		.updateClientNameTo("Carnival Corporation & PLC")
		.clickSubmitButton()
		//.validateUpdates("edit_message_test_01","client","Carnival Corporation & PLC")
		.getTitle()
		.logout();	
	}
	@Test(priority=4)
	//@Test(enabled=false)
	public void update_message_brands()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.editMessage("edit_message_test_01")
		.deleteEntryInBrandfield()
		.UpdateBrandTo("Costa Cruises")
		.clickSubmitButton()
		.validateUpdates("edit_message_test_01","brand","1")
		.getTitle()
		.logout();	
	}
	@Test(priority=5)
	//@Test(enabled=false)
	public void update_message_brands_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.editMessage("edit_message_test_01")
		.deleteEntryInBrandfield()
		.UpdateBrandTo("Costa Cruises")
		.UpdateBrandTo("cunard")
		.clickSubmitButton()
		//.validateUpdates("edit_message_test_01","brand","2")
		.getTitle()
		.logout();	
	}
	@Test(priority=6)
	//@Test(enabled=false)
	public void update_message_programs()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.editMessage("edit_message_test_01")
		.deleteEntryInProgramField()
		.updateProgramTo("VIFP")
		.updateProgramTo("edit_program_test_01")
		.clickSubmitButton()
		.validateUpdates("edit_message_test_01","program","2")
		.getTitle()
		.logout();	
	}
	@Test(priority=7)
	//@Test(enabled=false)
	public void update_message_programs_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.editMessage("edit_message_test_01")
		.deleteEntryInProgramField()
		.updateProgramTo("VIFP")
		.clickSubmitButton()
		.validateUpdates("edit_message_test_01","program","1")
		.getTitle()
		.logout();	
	}
	@Test(priority=8)
	//@Test(enabled=false)
	public void update_message_workflow_to_approved()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.editMessage("edit_message_test_01")
		.setWorkFlowTo("APPROVED","edit_message_test_01")
		.validateUpdates("edit_message_test_01","workflow","APPROVED")
		.getTitle()
		.logout();	
	}
	@Test(priority=9)
	//@Test(enabled=false)
	public void update_message_variable()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.editMessage("edit_message_test_01")
		.deleteEntryInVariablesField()
		.updateVariablesTo("First_Name")
		.clickSubmitButton()
		.getTitle()
		.logout();	
	}
	@Test(priority=10)
	//@Test(enabled=false)
	public void update_message_template()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.editMessage("edit_message_test_01")
		.deleteEntryIntemplatesField()
		.updatetemplatesTo("CPC16003-Header")
		.updatetemplatesTo("CPC16003-Hero")
		.updatetemplatesTo("CPC16003-CTA")
		.clickSubmitButton()
		.validateUpdates("edit_message_test_01","template","3")
		.getTitle()
		.logout();	
	}
	@Test(priority=11)
	//@Test(enabled=false)
	public void update_message_template_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.editMessage("edit_message_test_01")
		.deleteEntryIntemplatesField()
		.updatetemplatesTo("Booked Guest - Primary")
		.clickSubmitButton()
		.validateUpdates("edit_message_test_01","template","1")
		.getTitle()
		.logout();	
	}
	@Test(priority=12)
	//@Test(enabled=false)
	public void update_message_workflow_to_draft()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.editMessage("edit_message_test_01")
		.setWorkFlowTo("DRAFT","edit_message_test_01")
		.validateUpdates("edit_message_test_01","workflow","DRAFT")
		.getTitle()
		.logout();	
	}
	@Test(priority=13)
	//@Test(enabled=false)
	public void inactivate_message()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.editMessage("10000003")
		.isActive(false)
		.clickSubmitButton()
		.validateUpdates("10000003","status","INACTIVE")
		.getTitle()
		.logout();	
	}
	@Test(priority=14)
	//@Test(enabled=false)
	public void activate_message()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.editMessage("10000003")
		.isActive(true)
		.clickSubmitButton()
		.validateUpdates("10000003","status","ACTIVE")
		.getTitle()
		.logout();	
	}
	@Test(priority=15)
	//@Test(enabled=false)
	public void archive_message()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.archiveMessage("10000003")
		.getTitle()
		.logout();	
	}
	@Test(priority=16,enabled=true)
	public void restore_message()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.restoreMessage("3346ZZ003")
		//.validateUpdates("3346ZZ003","status","ACTIVE")
		.getTitle()
		.logout();	
	}
	@Test(priority=17,enabled=true)
	public void preview_locale()
	{
	login.loginAs("automation.admin","Monday#223")
	.isSuccessfulLogin("automation admin")
	.clickMessagesLink()
	.editMessage("edit_message_test_01")
	.previewlocales("English")
	.getTitle()
	.logout();
	}
	@Test(priority=18,enabled=true)
	public void view_locale()
	{
	login.loginAs("automation.admin","Monday#223")
	.isSuccessfulLogin("automation admin")
	.clickMessagesLink()
	.viewMessage("edit_message_test_01")
	.previewlocales("English")
	.getTitle()
	.logout();
	}
	@Test(priority=19,enabled=true)
	public void VerifyBanner(){
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.previewMessage("1718")
		.navigateCommunications()
		.viewCommunicationMessage("141")
		.verifybannerexists()
		.logout();
	}
	@Test(priority=20,enabled=true)
	public void verifyadding_twosame_Templates(){
		 login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.editMessage("edit_message_test_01")	
		.deleteEntryIntemplatesField()
		.updatetemplatesTo("CPC16003-CTA")
		.updatetemplatesTo("CPC16003-CTA")
		.clickSubmitButton()
		//.validateerrormessage()
		.logout();
	}
	@Test(priority=21,enabled=true)
	public void CCL_AE_updatebrand()
	{
		login.loginAs("carnival.account","09ht1a0480")
		.isSuccessfulLogin("carnival account")
		.clickMessagesLink()
		.editMessage("edit_message_test_01")
		.deleteEntryInCCLBrandfield()
		.updatecclbrand("CUNARD")
		.clickSubmitButton()
		.validateUpdates("edit_message_test_01","brand","1")
		.getTitle()
		.logout();
	}
	@Test(priority=22,enabled=true)
	public void CCL_AE_updatebrandtoprevious()
	{
		login.loginAs("carnival.account","09ht1a0480")
		.isSuccessfulLogin("carnival account")
		.clickMessagesLink()
		.editMessage("edit_message_test_01")
		.deleteEntryInCCLBrandfield()
		.updatecclbrand("CUNARD")
		.updatecclbrand("COSTA CRUISES")
		.clickSubmitButton()
		.validateUpdates("edit_message_test_01","brand","2")
		.getTitle()
		.logout();
	}
	
	@Test(priority=23,enabled=true)
	public void VerifyAddedLocalesInPreview(){
		 login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.editMessage("10000004")
		.addLocales()
		.clickSubmitButton()
		.validateUpdatesinpreview("10000004","ZH-CN")
		.logout();
		
	}
	@Test(priority=24)
	//@Test(enabled=false)
	public void update_message_template_by_Carnival_AE()
	{
		login.loginAs("carnival.account","09ht1a0480")
		.isSuccessfulLogin("carnival account")
		.clickMessagesLink()
		.editMessage("edit_message_test_01")
		.deleteEntryIntemplatesFieldbyCarnival()
		.updatetemplatesbyCarnival("CPC16003-Header")
		.updatetemplatesbyCarnival("CPC16003-Hero")
		.updatetemplatesbyCarnival("CPC16003-CTA")
		.clickSubmitButton()
		.validateUpdates("CPC16003-Header","template","3")
		.getTitle()
		.logout();	
	}
	@Test(priority=25)
	//@Test(enabled=false)
	public void update_message_template_to_previous_Carnival_AE()
	{
		login.loginAs("carnival.account","09ht1a0480")
		.isSuccessfulLogin("carnival account")
		.clickMessagesLink()
		.editMessage("edit_message_test_01")
		.deleteEntryIntemplatesFieldbyCarnival()
		.updatetemplatesbyCarnival("Booked Guest - Primary")
		.clickSubmitButton()
		.validateUpdates("edit_message_test_01","template","1")
		.getTitle()
		.logout();	
	}
	
	@Test(priority=24,enabled=true)
	public void ClickPreview(){
		 login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.editMessage("edit_message_test_01")
		.previewmessage()
		//.selectemail
		.logout();
		
	}
	@Test(priority=25)
	public void check_quicklook_for_meaasage()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.clickquicklook()
		.getTitle()
		.logout();
	}
	@Test(priority=26)
	public void mass_advance_workflow()
	{
		login.loginAs("ehi.ae","09ht1a0480123")
		.isSuccessfulLogin("ehi ae")
		.clickMessagesLink()
		.clickMassadvanceworkflow()
		.selectfileMAW()
		//.selectworkflowinMAW()
		.logout();
	}
	/*@Test(priority=27)
	public void message_compare()
	{
		login.loginAs("ehi.ae","09ht1a0480")
		.isSuccessfulLogin("ehi ae")
		.clickMessagesLink()
		.editMessage("edit_message_test_01")
		.deleteEntryInBrandfield()
		.UpdateBrandTo("fathom")
		.deleteEntryIntemplatesField()
		.updatetemplatesTo("Birthday-footer")
		.clicksaveandedit
		.clickMessagehistory
		
		}
		
		
	@Test(priority=28)
	public void message_compare()
	{
		login.loginAs("ehi.ae","09ht1a0480")
		.isSuccessfulLogin("ehi ae")
		.clickMessagesLink()
		.editMessage("edit_message_test_01")	
	}*/
	@Test(priority=29)
	public void clone_message()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.copyMessage("publish_message_test_01")
		.editcopymessagename("cloned_message","clone_description")
		.validateUpdates("cloned_message","workflow","DRAFT")
		.getTitle()
		.logout();
		
	}
	@Test(priority=30)
	//@Test(enabled=false)
	public void update_cloned_message_programs()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.editMessage("cloned_message")
		.deleteEntryInProgramField()
		.updateProgramTo("VIFP")
		.clickSubmitButton()
		.validateUpdates("cloned_message","program","1")
		.getTitle()
		.logout();	
	}
	@Test(priority=31)
	//@Test(enabled=false)
	public void update_cloned_message_template()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.editMessage("cloned_message")
		.deleteEntryIntemplatesField()
		.updatetemplatesTo("CPC16003-Header")
		.updatetemplatesTo("CPC16003-CTA")
		.clickSubmitButton()
		.validateUpdates("cloned_message","template","2")
		.getTitle()
		.logout();	
	}
	@Test(priority=32)
	//@Test(enabled=false)
	public void cloned_message_add_media()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.editMessage("cloned_message")
		.addMediato_message()
		.selectMedia_fromgallery("CPC16003 logo vifp gold")
		.selectwidth_Code("BTN_2_WIDTH")
		.selectALT_tag_code("CTA_ALT")
		.selectHeight_code("CTA_HEIGHT")
		.selectURL_code("CTA_SRC")
		.clickSubmitButton()
		.getTitle()
		.logout();
	}
	
	@Test(priority=34)
	//@Test(enabled=false)
	public void cloned_message_add_html()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.editMessage("cloned_message")
		.select_html_add()
		.addhtml_content_name("test_html_automation")
		.addhtml_code("BODY")
		//.addhtml_source("##test&html**<body>www.lacek.com")
		.clickSaveButton()
		.getTitle()
		.logout();
	}
	@Test(priority=35)
	//@Test(enabled=false)
	public void cloned_message_add_hyperlink()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.editMessage("cloned_message")
		.addHyperlink_to_message()
		.addName_to_Hyperlink("test-hyperlink")
		.addURL_to_hyperlink("www.msp.com")
		.addName_code_hyperlink("CTA_NAME_10")
		.addURL_code_hyperlink("CTA_URL")
		.clickSaveButton()
		.getTitle()
		.logout();
	}
	@Test(priority=36)
	//@Test(enabled=false)
	public void cloned_message_delete_media()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.editMessage("cloned_message")
		.deleteMessage_media()
		.clickSubmitButton()
		.getTitle()
		.logout();
		}
	
	@Test(priority=37)
	//@Test(enabled=false)
	public void cloned_message_archive()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.archiveMessage("cloned_message")
		.getTitle()
		.logout();	
	}
}
	
	
	
	
	
	
	
	
	

