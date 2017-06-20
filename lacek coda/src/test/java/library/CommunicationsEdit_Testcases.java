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
		.updateProgramTo("VIFP")
		.updateProgramTo("smm1")
		.clickSubmitButton()
		.validateUpdates("edit_comm_test_01","program","2")
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
	public void Verify_access_EHIQA(){
		login.loginAs("ehi_qa","09ht1a0480")
		.isSuccessfulLogin("ehi qa")
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
		.editCommunications("140")
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
	public void comm_massadvance_workflow()
	{
		login.loginAs("ehi.ae","09ht1a0480123")
		.isSuccessfulLogin("ehi ae")
		.clickCommunicationsLink()
		//.commMassadvanceworkflow()
		;
	}
	@Test(priority=21)
	public void manage_workflow_ehi_qa() 
	{
		login.loginAs("ehi.qa","09ht1a0480")
		.isSuccessfulLogin("ehi qa")
		.clickCommunicationsLink()
		.slectManageworkflowbyehi_qa("edit_ehi_comm_test_01")
		//.manageworkflow_ehi_qa()
		
		;
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
}