package assets;

import org.testng.annotations.Test;

import Utility.TestBase;

public class MediaGalleryEdit_testcases extends TestBase{

	//EDIT MEDIA GALLERY 
	@Test(priority=0)
	public void update_media_gallery_brand()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.editMediaGallery("edit_image_test_01")
		.deleteEntryInBrandField()
		.UpdateBrandTo("cunard")	
		.clickSubmitButton()
		.validateUpdates("edit_image_test_01","brand","1")
		.getTitle()
		.logout();
	}
	@Test(priority=1)
	public void update_media_gallery_brand_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.editMediaGallery("edit_image_test_01")
		.deleteEntryInBrandField()
		.UpdateBrandTo("cunard")	
		.UpdateBrandTo("Fathom")	
		.UpdateBrandTo("Costa Cruises")	
		.UpdateBrandTo("Princess Cruises")	
		.clickSubmitButton()
		.validateUpdates("edit_image_test_01","brand","4")
		.getTitle()
		.logout();
	}
	@Test(priority=2)
	//@Test(enabled=false)
	public void update_media_gallery_program()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.editMediaGallery("edit_image_test_01")
		.deleteEntryInProgramField()
		.updateProgramTo("VIFP")	
		.clickSubmitButton()
		.validateUpdates("edit_image_test_01","program","1")
		.getTitle()
		.logout();
	}
	@Test(priority=3)
	//@Test(enabled=false)
	public void update_media_gallery_program_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.editMediaGallery("edit_image_test_01")
		.deleteEntryInProgramField()
		.updateProgramTo("VIFP")	
		.clickSubmitButton()
		.validateUpdates("edit_image_test_01","program","1")
		.getTitle()
		.logout();
	}
	@Test(priority=4)
	public void update_media_gallery_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()	
		.editMediaGallery("edit_image_test_01")
		.updateImageName("edit_image_test_010")	
		.clickSubmitButton()
		.validateUpdates("edit_image_test_01","name","edit_image_test_010")
		.getTitle()
		.logout();
	}
	@Test(priority=5)
	public void update_media_gallery_name_to_previous_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()	
		.editMediaGallery("edit_image_test_010")
		.updateImageName("edit_image_test_01")	
		.clickSubmitButton()
		.validateUpdates("edit_image_test_01","name","edit_image_test_01")
		.getTitle()
		.logout();
	}
	@Test(priority=6)
	public void update_media_gallery_description()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()	
		.editMediaGallery("edit_image_test_01")
		.updateDescription("description with selenium webdriver")
		.clickSubmitButton()
		.getTitle()
		.logout();
	}
	//@Test(priority=7)
	public void update_media_gallery_image()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.editMediaGallery("edit_image_test_01")
		.updateImage("selenium09")
		.clickSubmitButton()
		.getTitle()
		.logout();
	}
	//@Test(priority=8)
	public void update_media_gallery_image_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.editMediaGallery("edit_image_test_01")
		.updateImage("selenium08")
		.clickSubmitButton()
		.getTitle()
		.logout();
	}
	@Test(priority=9)
	public void update_media_gallery_Alt_Tag()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.editMediaGallery("edit_image_test_01")
		.updateAltTag("coda_image_regression_010")
		.clickSubmitButton()
		.validateUpdates("edit_image_test_01","alt-tag","coda_image_regression_010")
		.getTitle()
		.logout();
	}
	@Test(priority=10)
	public void update_media_gallery_Alt_Tag_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.editMediaGallery("edit_image_test_01")
		.updateAltTag("edit_image_test_01")
		.clickSubmitButton()
		.validateUpdates("edit_image_test_01","alt-tag","edit_image_test_01")
		.getTitle()
		.logout();
	}
	@Test(priority=11)
	public void update_media_gallery_connectors()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.editMediaGallery("edit_image_test_01")
		.deleteEntryInConnectorField()
		.deleteEntryInConnectorField()
		.updateConnector("Exact Target (Carnival NA) | Approved")
		.updateConnector("Exact Target (Carnival NA) | Draft")
		.clickSubmitButton()
		.getTitle()
		.logout();
	}
	@Test(priority=12)
	public void update_media_gallery_workflow_to_draft()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.editMediaGallery("edit_image_test_01")
		.setWorkFlowTo("DRAFT","edit_image_test_01")
		.validateUpdates("edit_image_test_01","workflow","DRAFT")
		.getTitle()
		.logout();
	}
	@Test(priority=13)
	public void update_media_gallery_workflow_to_approved()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.editMediaGallery("edit_image_test_01")
		.setWorkFlowTo("APPROVED","edit_image_test_01")
		.validateUpdates("edit_image_test_01","workflow","APPROVED")
		.getTitle()
		.logout();
	}
	@Test(priority=14)
	public void update_media_gallery_clientname()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()	
		.editMediaGallery("edit_image_test_01")
		//.updateClientNameTo("DuPont")
		//.clickSubmitButton()
		//.validateUpdates("edit_image_test_01","client","DuPont")
		.getTitle()
		.logout();
	}
	@Test(priority=15)
	public void update_media_gallery_clientname_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.editMediaGallery("edit_image_test_01")
		.updateClientNameTo("Carnival Corporation & PLC")
		.deleteEntryInBrandField()
		.UpdateBrandTo("Costa Cruises")
		.deleteEntryInProgramField()
		.updateProgramTo("VIFP")
		.deleteEntryInConnectorField()
		.deleteEntryInConnectorField()
		.updateConnector("Exact Target (Carnival NA) | Approved")
		.updateConnector("Exact Target (Carnival NA) | Draft")
		.clickSubmitButton()
		.validateUpdates("edit_image_test_01","client","Carnival Corporation & PLC")
		.getTitle()
		.logout();
	}
	@Test(priority=16)
	public void inactivate_media_gallery()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.editMediaGallery("edit_image_test_01")
		.isActive(false)
		.clickSubmitButton()
		.validateUpdates("edit_image_test_01","status","INACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=17)
	public void activate_media_gallery()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.editMediaGallery("edit_image_test_01")
		.isActive(true)
		.clickSubmitButton()
		.validateUpdates("edit_image_test_01","status","ACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=18)
	public void archive_media_gallery()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.archiveMediagallery("edit_image_test_01")
		.getTitle()
		.logout();
	}
	@Test(priority=19)
	public void restore_media_gallery()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.restoreMediaGallery("edit_image_test_01")
		.getTitle()
		.logout();
	}
	/*@Test(priority=20)
	public void check_imgaltTag()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.editMediaGallery("ERAC PRM SHU 307717151 FRFR R2.jpg")
		.validatealttag("English", "ERAC PRM SHU 307717151 USEN.jpg")
		.validatealttag("Germany", "ERAC PRM SHU 307717151 DEDE R3.jpg")
		.validatealttag("Spanish","ERAC PRM SHU 307717151 ESES R2.jpg")
		.logout();

	}*/
	@Test(priority=20)
	public void delete_messagemedia_connectors()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.editMediaGallery("Primary - CTA FPO")
		.deleteEntryInConnectorField()
		.clickSubmitButton()
		//.clickMessagesLink()
		//.editMessage("edit_message_test_01")
		//.checkmissingconnector();
		.logout();

	}
	@Test(priority=21)
	public void update_messagemedia_connectors()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.editMediaGallery("Primary - CTA FPO")
		.deleteEntryInConnectorField()
		.updateConnector("Exact Target (Carnival NA) | Approved")
		.updateConnector("Exact Target (Carnival NA) | Draft")
		.clickSubmitButton()
		.logout();
	}
	@Test(priority=22)
	public void update_media_gallery_workflow_to_draft_Carnival_AE()
	{
		login.loginAs("carnival.account","09ht1a0480")
		.isSuccessfulLogin("carnival account")
		.clickMediaGallery()
		.editMediaGallery("edit_image_test_01")
		.setWorkFlowTo("DRAFT","edit_image_test_01")
		.validateUpdates("edit_image_test_01","workflow","DRAFT")
		.getTitle()
		.logout();
	}
	@Test(priority=23)
	public void update_media_gallery_workflow_to_approved_Carnival_AE()
	{
		login.loginAs("carnival.account","09ht1a0480")
		.isSuccessfulLogin("carnival account")
		.clickMediaGallery()
		.editMediaGallery("edit_image_test_01")
		.setWorkFlowTo("APPROVED","edit_image_test_01")
		.validateUpdates("edit_image_test_01","workflow","APPROVED")
		.getTitle()
		.logout();
	}
	@Test(priority=24)
	public void update_media_gallery_workflow_to_approved_EHI_AE()
	{
		login.loginAs("ehi.ae","09ht1a0480123")
		.isSuccessfulLogin("ehi ae")
		.clickMediaGallery()
		.editMediaGallery("edit_ehi_test_01")
		.setWorkFlowTo("APPROVED","edit_ehi_test_01")
		.validateUpdates("edit_ehi_test_01","workflow","APPROVED")
		.getTitle()
		.logout();
	}
	@Test(priority=25)
	public void update_media_gallery_workflow_to_draft_EHI_AE()
	{
		login.loginAs("ehi.ae","09ht1a0480123")
		.isSuccessfulLogin("ehi ae")
		.clickMediaGallery()
		.editMediaGallery("edit_ehi_test_01")
		.setWorkFlowTo("DRAFT","edit_ehi_test_01")
		.validateUpdates("edit_ehi_test_01","workflow","DRAFT")
		.getTitle()
		.logout();
	}
	
	
	@Test(priority=26)
	public void manage_workflow_in_media()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.manageworkflow("APPROVED","edit_image_test_01")
		.validateUpdates("edit_image_test_01","manage","APPROVED")
		.getTitle()
		.logout();
		
	}
	@Test(priority=27)
	public void update_manage_workflow_in_media()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		//.manageworkflow("DRAFT","edit_image_test_01")
		//.validateUpdates("edit_image_test_01","manage","DRAFT")
		.getTitle()
		.logout();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}