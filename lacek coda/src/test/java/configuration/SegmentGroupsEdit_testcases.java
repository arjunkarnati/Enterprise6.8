package configuration;

import org.testng.annotations.Test;

import Utility.TestBase;

public class SegmentGroupsEdit_testcases extends TestBase{

	//EDIT SEGMENT GROUPS
	@Test(priority=0)
	public void update_segment_groups_brand()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.editSegmentGroup("edit_seg_group_test_01")
		.deleteEntryInBrandField()
		.updateBrandTo("Costa Cruises")
		.clickSubmitButton()
		.validateUpdates("edit_seg_group_test_01","brand","1")
		.getTitle()
		.logout();
	}	
	@Test(priority=1)
	public void update_segment_groups_brand_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.editSegmentGroup("edit_seg_group_test_01")
		.deleteEntryInBrandField()
		.updateBrandTo("Costa Cruises")
		.updateBrandTo("cunard")
		.clickSubmitButton()
		.validateUpdates("edit_seg_group_test_01","brand","2")
		.getTitle()
		.logout();
	}
	@Test(priority=2)
	public void update_segment_groups_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.editSegmentGroup("edit_seg_group_test_01")
		.updateSegementGroupNameTo("edit_seg_group_test_010")
		.clickSubmitButton()
		.validateUpdates("edit_seg_group_test_010","name","edit_seg_group_test_010")
		.getTitle()
		.logout();
	}		
	@Test(priority=3)
	public void update_segment_groups_name_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.editSegmentGroup("edit_seg_group_test_010")
		.updateSegementGroupNameTo("edit_seg_group_test_01")
		.clickSubmitButton()
		.validateUpdates("edit_seg_group_test_01","name","edit_seg_group_test_01")
		.getTitle()
		.logout();
	}
	@Test(priority=4)
	public void update_segment_groups_type()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.editSegmentGroup("edit_seg_group_test_01")
		.updateTypeTo("Multi Select")
		.clickSubmitButton()
		.validateUpdates("edit_seg_group_test_01","type","Multi Select")
		.getTitle()
		.logout();
	}
	@Test(priority=5)
	public void update_segment_groups_type_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.editSegmentGroup("edit_seg_group_test_01")
		.updateTypeTo("Single Select")
		.clickSubmitButton()
		.validateUpdates("edit_seg_group_test_01","type","Single Select")
		.getTitle()
		.logout();
	}
	@Test(priority=6)
	public void update_segment_groups_description()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.editSegmentGroup("edit_seg_group_test_01")
		.updateDescriptionTo("updateing a segment groups using selenium WD")
		.clickSubmitButton()
		.getTitle()
		.logout();
	}	
	@Test(priority=7)
	public void inactivate_segment_groups()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.editSegmentGroup("edit_seg_group_test_01")
		.inactivateSegmentGroup()
		.clickSubmitButton()
		.validateUpdates("edit_seg_group_test_01","status","INACTIVE")
		.getTitle()
		.logout();
	}	
	@Test(priority=8)
	public void activate_segment_groups()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.editSegmentGroup("edit_seg_group_test_01")
		.activateSegmentGroup()
		.clickSubmitButton()
		.validateUpdates("edit_seg_group_test_01","status","ACTIVE")
		.getTitle()
		.logout();
	}	
	@Test(priority=9)
	public void update_segment_groups_clientname()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.editSegmentGroup("edit_seg_group_test_01")
		.updateClientNameTo("DuPont")
		.clickSubmitButton()
		.validateUpdates("edit_seg_group_test_01","client","DuPont")
		.getTitle()
		.logout();
	}	
	@Test(priority=10)
	public void update_segment_groups_clientname_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.editSegmentGroup("edit_seg_group_test_01")
		.updateClientNameTo("Carnival Corporation & PLC")
		.deleteEntryInBrandField()
		.updateBrandTo("Cunard")
		.clickSubmitButton()
		.validateUpdates("edit_seg_group_test_01","client","Carnival Corporation & PLC")
		//.validateUpdates("edit_seg_group_test_01","brand","1")
		.getTitle()
		.logout();
	}
	@Test(priority=11)
	public void empty_name_field_in_segmentGroups_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.editSegmentGroup("edit_seg_group_test_01")
		.updateClientNameTo("Carnival Corporation & PLC")
		.deleteName()
		.failToUpdate()
		.getTitle()
		.logout();
	}
	@Test(priority=12)
	public void select_button_cancel_in_segmentgroups_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.editSegmentGroup("edit_seg_group_test_01")
		.clickCancelButton()
		.getTitle()
		.logout();
	}
	@Test(priority=13)
	public void archive_segment_groups()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()	
		.archiveSegementgroups("edit_seg_group_test_01")
		.getTitle();
	}
	@Test(priority=14)
	public void restore_segment_groups()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.restoreSegmentgroup("edit_seg_group_test_01")
		.getTitle();	
	}	
}