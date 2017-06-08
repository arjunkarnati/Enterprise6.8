package configuration;

import org.testng.annotations.Test;
import DataBase.DataBaseConfiguration;
import Utility.TestBase;

public class SegmentGroups_TestCases extends TestBase{

	/*create segment groups test cases */
    @Test(priority=0)
	//@Test(enabled=false)
	public void create_a_new_segment_groups_type_single_select()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.clickAddSegementGroupButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("Costa Cruises")
		.addBrand("cunard")
		.addSegementGroupName("selenium_segmentgroups_001")
		.addType("Single Select")
		.addDescription("creating a new segment groups having type single select using selenium WD")
		.clickSubmitButton()
		.validateUpdates("selenium_segmentgroups_001","client","Carnival Corporation & PLC")
		.validateUpdates("selenium_segmentgroups_001","brand","2")
		.validateUpdates("selenium_segmentgroups_001","name","selenium_segmentgroups_001")
		.validateUpdates("selenium_segmentgroups_001","type","Single Select")
		.getTitle()
		.logout();
	}
	@Test(priority=1)
	//@Test(enabled=false)
	public void create_a_duplicate_segment_groups_type_single_select()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.clickAddSegementGroupButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("Costa Cruises")
		.addSegementGroupName("selenium_segmentgroups_001")
		.addType("Single Select")
		.addDescription("creating a new segment groups having type single select using selenium WD")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=2)
	//@Test(enabled=false)
	public void create_a_new_segment_groups_type_multi_select()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.clickAddSegementGroupButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("Costa Cruises")
		.addSegementGroupName("selenium_segmentgroups_003")
		.addType("Multi Select")
		.addDescription("creating a new segment groups having type multi select using selenium WD")
		.clickSubmitButton()
		.validateUpdates("selenium_segmentgroups_003","client","Carnival Corporation & PLC")
		.validateUpdates("selenium_segmentgroups_003","brand","1")
		.validateUpdates("selenium_segmentgroups_003","name","selenium_segmentgroups_003")
		.validateUpdates("selenium_segmentgroups_003","type","Multi Select")
		.getTitle()
		.logout();
	}
	@Test(priority=3)
	//@Test(enabled=false)
	public void select_button_cancel_in_segment_groups_add_page()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.clickAddSegementGroupButton()
		.clickCancelButton()
		.getTitle()
		.logout();
	}
	@Test(priority=4)
	//@Test(enabled=false)
	public void create_a_new_segment_groups_type_multi_select_without_a_client_name()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.clickAddSegementGroupButton()
		.addSegementGroupName("test_selenium_segmentgroups_040")
		.addType("Multi Select")
		.addDescription("creating a new segment groups having type multi select using selenium WD")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=5)
	//@Test(enabled=false)
	public void create_a_new_segment_groups_type_multi_select_without_a_name()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.clickAddSegementGroupButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("Costa Cruises")
		.addType("Multi Select")
		.addDescription("creating a new segment groups having type multi select using selenium WD")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=6)
	//@Test(enabled=false)
	public void create_a_new_segment_groups_type_single_select_without_a_client_name()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.clickAddSegementGroupButton()
		.addSegementGroupName("test_selenium_segmentgroups_050")
		.addType("Single Select")
		.addDescription("creating a new segment groups having type multi select using selenium WD")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=7)
	//@Test(enabled=false)
	public void create_a_new_segment_groups_type_single_select_without_a_name()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.clickAddSegementGroupButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("Costa Cruises")
		.addType("Single Select")
		.addDescription("creating a new segment groups having type multi select using selenium WD")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=8)
	//@Test(enabled=false)
	public void create_a_new_segment_groups_without_a_type()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.clickAddSegementGroupButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("Costa Cruises")
		.addSegementGroupName("test_selenium_segmentgroups_040")
		.addDescription("creating a new segment groups having type multi select using selenium WD")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=30) 
	public void database_delete_segment_groups()
	{	
		DataBaseConfiguration.deleteSegmentGroups();
	}
	/*@Test(priority=31)
	//@Test(enabled=false)
	public void create_test_segment_groups()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.clickAddSegementGroupButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("Costa Cruises")
		.addBrand("cunard")
		.addSegementGroupName("edit_seg_group_test_01")
		.addType("Single Select")
		.addDescription("updateing a segment groups using selenium WD")
		.clickSubmitButton()
		.validateUpdates("edit_seg_group_test_01","client","Carnival Corporation & PLC")
		.validateUpdates("edit_seg_group_test_01","brand","2")
		.validateUpdates("edit_seg_group_test_01","name","selenium_segmentgroups_001")
		.validateUpdates("edit_seg_group_test_01","type","Single Select")
		.getTitle()
		.logout();
	}*/
}