package library;

import org.testng.annotations.Test;
import Utility.TestBase;

public class CommunicationsEdit_Testcases extends TestBase{

	@Test(priority=0)
	//@Test(enabled=false)
	public void update_communication_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.editCommunications("edit_comm_test_01")
		.updateCommunicationName("edit_comm_test_010")
		.clickSubmitButton()
		.validateUpdates("edit_comm_test_010","name","edit_comm_test_010")
		.getTitle()
		.logout();	
	}
	@Test(priority=1)
	//@Test(enabled=false)
	public void update_communication_name_to_previous_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.editCommunications("edit_comm_test_010")
		.updateCommunicationName("edit_comm_test_01")
		.clickSubmitButton()
		.validateUpdates("edit_comm_test_01","name","edit_comm_test_01")
		.getTitle()
		.logout();	
	}
	@Test(priority=2)
	//@Test(enabled=false)
	public void update_communication_client_field()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.editCommunications("edit_comm_test_01")
		.getTitle()
		.logout();	
	}
	@Test(priority=3)
	//@Test(enabled=false)
	public void update_track_clientname_to_previous_client()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()		
		.getTitle()
		.logout();	
	}
	@Test(priority=4)
	//@Test(enabled=false)
	public void update_communcation_brands()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.editCommunications("edit_comm_test_01")
		.deleteEntryInBrandField()
		.UpdateBrandTo("cunard")
		.UpdateBrandTo("Fathom")
		.UpdateBrandTo("AIDA Cruises")
		.clickSubmitButton()
		.validateUpdates("edit_comm_test_01","brand","3")
		.getTitle()
		.logout();	
	}
	@Test(priority=5)
	//@Test(enabled=false)
	public void update_communcation_brands_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.editCommunications("edit_comm_test_01")
		.deleteEntryInBrandField()
		.UpdateBrandTo("cunard")
		.UpdateBrandTo("Fathom")
		.clickSubmitButton()
		.validateUpdates("edit_comm_test_01","brand","2")
		.getTitle()
		.logout();	
	}
	
	@Test(priority=6)
	//@Test(enabled=false)
	public void update_communication_tracks()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.editCommunications("edit_comm_test_01")
		.deleteEntryInTrackField()
		.updateTrackTo("TrackA1")
		.clickSubmitButton()
		.validateUpdates("edit_comm_test_01","track","1")
		.getTitle()
		.logout();	
	}
	@Test(priority=7)
	//@Test(enabled=false)
	public void update_communication_tracks_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.editCommunications("edit_comm_test_01")
		.deleteEntryInTrackField()
		.updateTrackTo("TrackA1")
		.updateTrackTo("TrackW1")
		.clickSubmitButton()
		.validateUpdates("edit_comm_test_01","track","2")
		.getTitle()
		.logout();	
	}
	@Test(priority=8)
	//@Test(enabled=false)
	public void update_communication_programs()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.editCommunications("edit_comm_test_01")
		.deleteEntryInProgramField()
		.updateProgramTo("edit_program_test_01")
		//.updateProgramTo("smm1")
		.clickSubmitButton()
		.validateUpdates("edit_comm_test_01","program","1")
		.getTitle()
		.logout();	
	}
	@Test(priority=9)
	//@Test(enabled=false)
	public void update_communication_programs_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.editCommunications("edit_comm_test_01")
		.deleteEntryInProgramField()
		.updateProgramTo("VIFP")
		.clickSubmitButton()
		.validateUpdates("edit_comm_test_01","program","1")
		.getTitle()
		.logout();	
	}
	@Test(priority=10)
	//@Test(enabled=false)
	public void update_communication_segment_groups()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.editCommunications("edit_comm_test_01")
		.getTitle()
		.logout();		
	}
	@Test(priority=11)
	//@Test(enabled=false)
	public void update_communication_workflow_to_approved()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.editCommunications("edit_comm_test_01")
		.setWorkFlowTo("APPROVED","edit_comm_test_01")		
		.clickSubmitButton()
		.validateUpdates("edit_comm_test_01","workflow","APPROVED")
		.getTitle()
		.logout();	
	}
	@Test(priority=12)
	//@Test(enabled=false)
	public void update_track_workflow_to_draft()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()	
		.editCommunications("edit_comm_test_01")
		.setWorkFlowTo("DRAFT","edit_comm_test_01")	
		.clickSubmitButton()
		.validateUpdates("edit_comm_test_01","workflow","DRAFT")
		.getTitle()
		.logout();	
	}
	//archive and inactivate campaign test cases
	@Test(priority=13)
	//@Test(enabled=false)
	public void inactivate_communication()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.editCommunications("edit_comm_test_01")
		.isActive(false)
		.clickSubmitButton()
		.validateUpdates("edit_comm_test_01","status","INACTIVE")
		.getTitle()
		.logout();	
	}
	@Test(priority=14)
	//@Test(enabled=false)
	public void activate_communication()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.editCommunications("edit_comm_test_01")
		.isActive(false)
		.clickSubmitButton()
		.validateUpdates("edit_comm_test_01","status","ACTIVE")
		.getTitle()
		.logout();	
	}
	@Test(priority=15)
	//@Test(enabled=false)
	public void archive_communication()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.archiveCommunication("edit_comm_test_01")
		.getTitle()
		.logout();	
	}
	@Test(priority=16)
	//@Test(enabled=false)
	public void restore_communication()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.retoreCommunication("edit_comm_test_01")
		.getTitle()
		.logout();	
	}
	@Test(priority=17)
	public void uncheck_publishCommunications(){
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.publishCommunications("edit_comm_test_01")
		.uncheckMessages()
		.publishwarningmessgae();
	}
	/*@Test(priority=18)
	public void delete_targetcriteria(){
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.editCommunications("edit_comm_test_01")
		.deleteprimarymessage()
		.clickSubmit();
	}*/
	@Test(priority=18)
	public void Verify_access_EHIAE(){
		login.loginAs("ehi.ae","09ht1a0480@123")
		.isSuccessfulLogin("ehi ae")
		.clickCommunicationsLink()
		.previewCommunications("edit_ehi_comm_test_01")
		.verifyaccess()
		.logout();
		
	}
	@Test(priority=18)
	public void clienttesting_to_internaltesting(){
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.editCommunications("edit_ehi_comm_test_01")
		//.updateworkflow("CLIENT TSTING")
		//.clientesingtointernaltesting()
		//.openPublish("https://qa-b10.mms.lacek.net/dev/publish","automation.admin","Monday#223")
		//.RunPublish()
		//.openPublish("https://qa-b10.mms.lacek.net/","automation.admin","Monday#223")
		//.validateUpdates("140","workflow","INTERNAL TESTING")
		.getTitle()
		.logout();	
		}
		
	
//	@Test(priority=19)
//	public void addlocales()
	//{
//		login.loginAs("automation.admin","Monday#223")
//		.isSuccessfulLogin("automation admin")
//		.clickCommunicationsLink()
//		.edit140("140")
//		.editlocales("en-ie", "es-es");
//	}	
	
	//@Test(priority=20)
	//public void Checking_features(){
	//	login.loginAs("automation.admin", "Monday#223")
	//	.isSuccessfulLogin("automation admin")
	//	.clickCommunicationsLink()
	//	.editCommunications("edit_comm_test_01")
	//	.clickPreviwButton();
	//}
	@Test(priority=20)
	public void comm_massadvance_workflow() throws Exception
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.searchCommunications("edit_comm_test_01")
		.commMassadvanceworkflow()
		.changeAssignWorkflow("APPROVED", "edit_comm_test_01")
		.commMessageWorkflow("APPROVED", "edit_comm_test_01")
		.saveMassadvanceworkflow()
		.validateUpdates("edit_comm_test_01","workflow","APPROVED")
		.getTitle()
		.logout();
}
	@Test(priority=21)
	public void updatecomm_massadvance_workflow() throws Exception 
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.searchCommunications("edit_comm_test_01")
		.commMassadvanceworkflow()
		.changeAssignWorkflow("DRAFT", "edit_comm_test_01")
		.commMessageWorkflow("DRAFT", "edit_comm_test_01")
		.saveMassadvanceworkflow()
		.validateUpdates("edit_comm_test_01","workflow","DRAFT")
		.getTitle()
		.logout();
}
	/*@Test(priority=22)
	public void manage_workflow_ehi_qa() 
	{
		login.loginAs("ehi_qa","09ht1a0480")
		.isSuccessfulLogin("ehi QA")
		.clickCommunicationsLink()
		.slectManageworkflowbyehi_qa("142")
		.manageWorkflowehiqa("APPROVED","142")
		.saveManageworkflow()
		.validateUpdates("142","workflow","APPROVED")
		.getTitle()
		.logout();
}
	@Test(priority=23)
	public void updatemanage_workflow_ehi_qa() 
	{
		login.loginAs("ehi_qa","09ht1a0480")
		.isSuccessfulLogin("ehi QA")
		.clickCommunicationsLink()
		.slectManageworkflowbyehi_qa("142")
		.manageWorkflowehiqa("DRAFT","142")
		.saveManageworkflow()
		.validateUpdates("142","workflow","DRAFT")
		.getTitle()
		.logout();
	}*/
	@Test(priority=24)
	public void add_messageto_communication()
	{
		login.loginAs("ehi.ae","09ht1a0480123")
		.isSuccessfulLogin("ehi ae")
		.clickCommunicationsLink()
		.editCommunications("edit_ehi_comm_test_01")
		.addmessage("H000-00-067")
		.clickSubmitButton()
		.validateUpdates("H000-00-067","name" ," expectedresult")
		.getTitle()
		.logout();
	}
	@Test(priority=25)
	public void delete_messagefrom_communication()
	{
		login.loginAs("automation.admin", "Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.editCommunications("edit_ehi_comm_test_01")
		.deleteMessage("H000-00-067")
		.selectRemovemessage()
		.clickSaveButton();
		}
	@Test(priority=26)
	public void all_messages_to_all_regions()
	{
		login.loginAs("ehi.ae","09ht1a0480123")
		.isSuccessfulLogin("ehi ae")
		.clickCommunicationsLink()
		.editCommunications("edit_ehi_comm_test_01")
		.addallmessagestocomm()
		.clickSubmitButton()
		.getTitle()
		.logout();
	}
	@Test(priority=27)
	public void clear_all_messagaes_from_comm()
	{
		login.loginAs("ehi.ae","09ht1a0480@123")
		.isSuccessfulLogin("ehi ae")
		.clickCommunicationsLink()
		.editCommunications("edit_ehi_comm_test_01")
		.clearallMessagesfrom()
		.clickSubmitButton()
		.getTitle()
		.logout();
	   
	}
	@Test(priority=28)
	public void update_description()
	{
		login.loginAs("ehi.ae","09ht1a0480@123")
		.isSuccessfulLogin("ehi ae")
		.clickCommunicationsLink()
		.editCommunications("edit_ehi_comm_test_01")
		.updateDescription("Test Automation haha!!!")
		.clickSubmitButton()
		.validateUpdates("edit_ehi_comm_test_01","Description","Test Automation haha!!!")
		.getTitle()
		.logout();
		
		
	}
	@Test(priority=29)
	public void update_description_to_previous()
	{
		login.loginAs("ehi.ae","09ht1a0480@123")
		.isSuccessfulLogin("ehi ae")
		.clickCommunicationsLink()
		.editCommunications("edit_ehi_comm_test_01")
		.updateDescription("Test Automation for EHI")
		.clickSubmitButton()
		.validateUpdates("edit_ehi_comm_test_01","Description","Test Automation for EHI")
		.getTitle()
		.logout();
	}
	@Test(priority=30)
	public void clone_communication()
	{
		login.loginAs("ehi.ae","09ht1a0480@123")
		.isSuccessfulLogin("ehi ae")
		.clickCommunicationsLink()
		.clonecommunication("edit_ehi_comm_test_01")
		.editNameinsaveas("cloned_comm_ehi_ae")
		.validateUpdates("cloned_comm_ehi_ae","Description","Test Automation for EHI")
		.getTitle()
		.logout();
		
	}
	
	//depends on test=30
	@Test(priority=31)
	public void edit_clone_communication()
	{
		login.loginAs("ehi.ae","09ht1a0480@123")
		.isSuccessfulLogin("ehi ae")
		.clickCommunicationsLink()	
		.editCommunications("cloned_comm_ehi_ae")
		.updateDescription("cloned_comm_edited")
		.UpdateBrandTo("Alamo")
		.updateProgramTo("Enterprise plus")
		.clickSubmitButton()
		.validateUpdates("cloned_comm_ehi_ae","Description","cloned_comm_edited")
		.validateUpdates("edit_comm_test_01","brand","1")
		.getTitle()
		.logout();	
	}
	@Test(priority=32)
	public void clone_comm_massadvance_workflow() throws Exception
	{
		login.loginAs("ehi.ae","09ht1a0480@123")
		.isSuccessfulLogin("ehi ae")
		.clickCommunicationsLink()
		.searchCommunications("cloned_comm_ehi_ae")
		.commMassadvanceworkflow()
		.changeAssignWorkflow("Internal Testing", "cloned_comm_ehi_ae")
		.commMessageWorkflow("Internal Testing", "cloned_comm_ehi_ae")
		.saveMassadvanceworkflow()
		.validateUpdates("cloned_comm_ehi_ae","workflow","INTERNAL TESTING")
		.getTitle()
		.logout();
}
	@Test(priority=33)
	public void clone_comm_massadvance_clienttesting_workflow() throws Exception
	{
		login.loginAs("ehi.ae","09ht1a0480@123")
		.isSuccessfulLogin("ehi ae")
		.clickCommunicationsLink()
		.searchCommunications("cloned_comm_ehi_ae")
		.commMassadvanceworkflow()
		.changeAssignWorkflow("Client Testing", "cloned_comm_ehi_ae")
		.commMessageWorkflow("Client Testing", "cloned_comm_ehi_ae")
		.saveMassadvanceworkflow()
		.validateUpdates("cloned_comm_ehi_ae","workflow","CLIENT TESTING")
		.getTitle()
		.logout();
}
	@Test(priority=34)
	public void add_messageto_cloned_communication()
	{
		login.loginAs("ehi.ae","09ht1a0480@123")
		.isSuccessfulLogin("ehi ae")
		.clickCommunicationsLink()
		.editCommunications("cloned_comm_ehi_ae")
		.addmessage("H000-00-067")
		.clickSubmitButton()
		.validateUpdates("cloned_comm_ehi_ae","name" ,"cloned_comm_ehi_ae")
		.getTitle()
		.logout();
	}
	@Test(priority=35)
	public void delete_messagefrom_cloned_communication()
	{
		login.loginAs("ehi.ae","09ht1a0480@123")
		.isSuccessfulLogin("ehi ae")
		.clickCommunicationsLink()
		.editCommunications("cloned_comm_ehi_ae")
		.deleteMessage("H000-00-067")
		.selectRemovemessage()
		.clickSaveButton();
		}
	@Test(priority=36)
	//@Test(enabled=false)
	public void archive_clone_communication()
	{
		login.loginAs("ehi.ae","09ht1a0480@123")
		.isSuccessfulLogin("ehi ae")
		.clickCommunicationsLink()
		.archiveCommunication("cloned_comm_ehi_ae")
		.getTitle()
		.logout();	
	}
	
	@Test(priority=37)
	public void non_admin_preview_edit()
	{
		login.loginAs("ehi.ae","09ht1a0480@123")
		.isSuccessfulLogin("ehi ae")
		.clickCommunicationsLink()
		.searchCommunications("edit_ehi_comm_test_01")
		.clickpreviewbutton()
		.clickDownloadpreview()
		.getTitle()
		.logout();	
		
		
	}
	
	@Test(priority=38)
	public void non_admin_acf_edit()
	{
		login.loginAs("ehi.ae","09ht1a0480@123")
		.isSuccessfulLogin("ehi ae")
		.clickCommunicationsLink()
		.editCommunications("edit_ehi_comm_test_01")
		.edit_acf_client("National")
		.getTitle()
		.logout();	
	}
	
	@Test(priority=38)
	public void add_message_ehi_ae()
	{
		login.loginAs("ehi.ae","09ht1a0480@123")
		.isSuccessfulLogin("ehi ae")
		.clickCommunicationsLink()
		.editCommunications("edit_ehi_comm_test_01")
		.search_msg_to_region_ehi_ae("H00000044")
		.click_add_buton();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}