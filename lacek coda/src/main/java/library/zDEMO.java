package library;





import org.testng.annotations.Test;

import DataBase.DataBaseHelper;
import Utility.TestBase;

public class zDEMO extends TestBase{



	@Test(priority=0) 
		public void readr() 
	{	
		DataBaseHelper.waitForAjax(driver);
	}	
}
	
	
	

	
	



//	@Test(priority=17)
//	//@Test(enabled=false)
//	public void test_db_connection()
//	{
//		login.loginAs("prince.kabuika", "Monday#1")
//		.isSuccessfulLogin("Prince Kabuika")
//		.clickConnectors()
//		.display("All")
//		.editConnector("Exact Target (Dev) - Draft")
//		.addBrand("costa cruises")
//		.setWorkflowTo("Approved")
//		.isActive(false)
//	
//		;
//		
//		;
//	}}


//	@Test(priority=17)
//	//@Test(enabled=false)
//	public void test_db_connection()
//	{
//		login.loginAs("prince.kabuika", "Monday#1")
//		.isSuccessfulLogin("Prince Kabuika")
//		.clickWorkflow()
//		.checkWorkflowUpdate("publish", "YES", "Approved")
//		.checkWorkflowUpdate("status", "ACTIVE", "Approved")
//		.checkWorkflowUpdate("name", "APPROVED", "Approved")
//	
//		;
//		
//		;
//	}}

//	//////////////////COMMUNICATION IN TRACK////////////////////////////////
//
//
////		@Test(priority=15)
////		//@Test(enabled=false)
////		public void test_1()
////		{
////		login.loginAs("prince.kabuika", "Monday#1").isSuccessfulLogin("Prince Kabuika")
////		.clickTracksLink()
////		.editTracks("test_carnival_track_03")
////		.edit_track_test_carnival_track_03()
////		.clickCommunicationsLibrary()
////		.addCommunicationInTrack("Email I2.1")
////		.clickSelectedCommunications();
////		//.checkCommunication("Email I3.1")
////		//.clickSelectedCommunications()
////		//.dragAndDrop(1);
////		}
//	
//		@Test(priority=15)
//		//@Test(enabled=false)
//		public void test_2()
//		{
//		login.loginAs("prince.kabuika", "Monday#1").isSuccessfulLogin("Prince Kabuika")
//		.clickTracksLink()
//		.editTracks("test_carnival_track_03")
//		.clickCommunicationsLibrary()
//		.addCommunicationInTrack("Email I2.1")
//		.clickSelectedCommunications()
//		.checkCommunication("Email I2.1")
//		.uncheckCommunication("Email I2.1")
//		.dragAndDrop(1)
//		.dragAndDrop(2);
//		
//		}
//
//		


//	@Test(priority=16)
//	//@Test(enabled=false)
//	public void test_3()
//	{
//		login.loginAs("prince.kabuika", "Monday#1").isSuccessfulLogin("Prince Kabuika")
//		.clickCampaignsLink()
//		.editCampaign("test_carnival_camp_1")
//		.archiveCampaign()
//		.clickSubmit()
//		;
//	}
//	
//	@Test(priority=17)
//	//@Test(enabled=false)
//	public void test_4()
//	{
//		login.loginAs("prince.kabuika", "Monday#1").isSuccessfulLogin("Prince Kabuika")
//		.clickCampaignsLink()
//		.restoreCampaign("test_carnival_camp_1")	
//		;
//	}







