package configuration;

import org.testng.annotations.Test;
import DataBase.DataBaseConfiguration;
import Utility.TestBase;

public class Segments_TestCases extends TestBase{

	/*create segment test cases */
	@Test(priority=0)
	public void create_a_new_segment()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegments()
		.clickAddSegmentButton()
		.addClientName("Carnival Corporation & PLC")
		.addSegmentGroups("Casino")
		.addSegementName("selenium_segments_007")
		.addCode("0014")	
		.addDescription("creating a new prgram using selenium WD")
		.clickSubmitButton()	
		.validateUpdates("selenium_segments_007","client","Carnival Corporation & PLC")
		.validateUpdates("selenium_segments_007","group","Casino")
		.validateUpdates("selenium_segments_007","code","0014")
		.validateUpdates("selenium_segments_007","status","ACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=1)
	//@Test(enabled=false)
	public void select_cancel_button_in_segements_add_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegments()
		.clickAddSegmentButton()
		.clickCancelButton()
		.getTitle()
		.logout();
	}
	@Test(priority=2)
	//@Test(enabled=false)
	public void create_a_new_segment_without_a_clienname()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegments()
		.clickAddSegmentButton()
		.addSegementName("test_selenium_segments_02")
		.addCode("00783")	
		.addDescription("creating a new prgram using selenium WD")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=3)
	//@Test(enabled=false)
	public void create_a_new_segment_without_a_segment_group()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegments()
		.clickAddSegmentButton()
		.addClientName("Carnival Corporation & PLC")
		.addSegementName("test_selenium_segments_03")
		.addCode("002")	
		.addDescription("creating a new prgram using selenium WD")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=4)
	//@Test(enabled=false)
	public void create_a_new_segment_without_a_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegments()
		.clickAddSegmentButton()
		.addClientName("Carnival Corporation & PLC")
		.addSegmentGroups("Casino")
		.addCode("0901")	
		.addDescription("creating a new prgram using selenium WD")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=5)
	//@Test(enabled=false)
	public void create_a_new_segment_without_a_code()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegments()
		.clickAddSegmentButton()
		.addClientName("Carnival Corporation & PLC")
		.addSegmentGroups("Casino")
		.addSegementName("test_selenium_segments_04")
		.addDescription("creating a new prgram using selenium WD")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=6)
	//@Test(enabled=false)
	public void create_a_new_segment_without_a_non_numerical_code()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegments()
		.clickAddSegmentButton()
		.addClientName("Carnival Corporation & PLC")
		.addSegmentGroups("Casino")
		.addSegementName("test_selenium_segments_07")
		.addCode("test")	
		.addDescription("creating a new prgram using selenium WD")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=30) 
	public void database_delete_segment_groups()
	{	
		DataBaseConfiguration.deleteSegments();
	}
	/*@Test(priority=31)
	public void create_test_segment()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegments()
		.clickAddSegmentButton()
		.addClientName("Carnival Corporation & PLC")
		.addSegmentGroups("Casino")
		.addSegementName("edit_segments_test_01")
		.addCode("0014")	
		.addDescription("edit_segments_test_01edit_segments_test_01edit_segments_test_01edit_segments_test_01")
		.clickSubmitButton()	
		.validateUpdates("edit_segments_test_01","client","Carnival Corporation & PLC")
		.validateUpdates("edit_segments_test_01","group","Casino")
		.validateUpdates("edit_segments_test_01","code","000087")
		.validateUpdates("edit_segments_test_01","status","ACTIVE")
		.getTitle()
		.logout();
	}*/
}