package configuration;

import org.testng.annotations.Test;

import Utility.TestBase;

public class SegmentsEdit_testcases extends TestBase{

	//EDIT SEGMENTS
	@Test(priority=0)
	public void update_segment_segment_group()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSegments()
		.editSegment("edit_segments_test_01")
		.updateSegmentGroupsTo("Family")
		.clickSubmitButton()
		.validateUpdates("edit_segments_test_01","group","Family")
		.getTitle()
		.logout();
	}
	@Test(priority=1)
	public void update_segment_segment_group_to_previous()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSegments()
		.editSegment("edit_segments_test_01")
		.updateSegmentGroupsTo("Casino")
		.clickSubmitButton()
		.validateUpdates("edit_segments_test_01","group","Casino")
		.getTitle()
		.logout();
	}
	@Test(priority=2)
	public void update_segment_name()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSegments()
		.editSegment("edit_segments_test_01")
		.updateSegementNameTo("edit_segments_test_010")
		.clickSubmitButton()
		.validateUpdates("edit_segments_test_010","name","edit_segments_test_010")
		.getTitle()
		.logout();
	}
	@Test(priority=3)
	public void update_segment_name_to_previous()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSegments()
		.editSegment("edit_segments_test_010")
		.updateSegementNameTo("edit_segments_test_01")
		.clickSubmitButton()
		.validateUpdates("edit_segments_test_01","name","edit_segments_test_01")
		.getTitle()
		.logout();
	}
	@Test(priority=4)
	public void update_segment_code()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSegments()
		.editSegment("edit_segments_test_01")
		.updateCodeTo("00038")
		.clickSubmitButton()
		.validateUpdates("edit_segments_test_01","code","00038")
		.getTitle()
		.logout();
	}
	@Test(priority=5)
	public void update_segment_code_to_previous()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSegments()
		.editSegment("edit_segments_test_01")
		.updateCodeTo("000087")
		.clickSubmitButton()
		.validateUpdates("edit_segments_test_01","code","000087")
		.getTitle()
		.logout();
	}
	@Test(priority=6)
	public void inactivate_segment()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSegments()
		.editSegment("edit_segments_test_01")
		.inactivateSegment()
		.clickSubmitButton()
		//5.12.validateUpdates("edit_segments_test_01","status","INACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=7)
	public void activate_segment()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSegments()
		.editSegment("edit_segments_test_01")
		.activateSegment()
		.clickSubmitButton()
		.validateUpdates("edit_segments_test_01","status","ACTIVE")
		.getTitle()
		.logout();
	}
	//need an update
	@Test(priority=8)
	public void update_segment_clientname()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSegments()
		.editSegment("edit_segments_test_01")
		.updateClientNameTo("DuPont")
		//.updateSegmentGroupsTo("test") need to check for data
//		.clickSubmitButton()
//		.validateUpdates("edit_segments_test_01","client","DuPont")
//		.validateUpdates("edit_segments_test_01","group","test")
		.getTitle()
		.logout();
	}
	@Test(priority=9)
	public void update_segment_clientname_to_previous()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSegments()
		.editSegment("edit_segments_test_01")
		.updateClientNameTo("Carnival Corporation & PLC")
		.updateSegmentGroupsTo("Casino")
		.clickSubmitButton()
		.validateUpdates("edit_segments_test_01","client","Carnival Corporation & PLC")
		.validateUpdates("edit_segments_test_01","group","Casino")
		.getTitle()
		.logout();
	}
	@Test(priority=10)
	public void empty_name_field_in_segements_edit_page()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSegments()
		.editSegment("edit_segments_test_01")
		.deleteName()
		.failToUpdate()
		.getTitle()
		.logout();
	}
	@Test(priority=11)
	public void empty_code_field_in_segements_edit_page()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSegments()
		.editSegment("edit_segments_test_01")
		.deleteCode()
		.failToUpdate()
		.getTitle()
		.logout();
	}
	@Test(priority=12)
	public void select_button_cancel_in_segments_edit_page()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSegments()
		.editSegment("edit_segments_test_01")
		.clickCancelButton()
		.getTitle()
		.logout();
	}
	@Test(priority=13)
	public void archive_segment()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSegments()	
		.archiveSegements("edit_segments_test_01")
		.getTitle();
	}
	@Test(priority=14)
	public void restore_segment()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSegments()
		//.restoreSegment("edit_segments_test_01")
		.getTitle()
		.logout();
	}
}