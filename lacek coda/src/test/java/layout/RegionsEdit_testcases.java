package layout;

import org.testng.annotations.Test;

import Utility.TestBase;

public class RegionsEdit_testcases extends TestBase{

	//EDIT REGION
	@Test(priority=0)
	public void update_region_name()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRegions()
		.editRegion("edit_region_test_01")
		.updateRegionName("edit_region_test_010")	
		.clickSubmitButton()
		.validateUpdates("edit_region_test_010","name","edit_region_test_010")
		.getTitle()
		.logout();
	}
	@Test(priority=1)
	public void update_region_name_to_previous()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRegions()
		.editRegion("edit_region_test_010")
		.updateRegionName("edit_region_test_01")	
		.clickSubmitButton()
		.validateUpdates("edit_region_test_01","name","edit_region_test_01")
		.getTitle()
		.logout();
	}
	@Test(priority=2)
	public void update_region_description()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRegions()
		.editRegion("edit_region_test_01")
		.updateDescription("still using selenium to test")
		.clickSubmitButton()
		.getTitle()
		.logout();
	}
	@Test(priority=3)
	public void inactivate_region()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRegions()
		.editRegion("edit_region_test_01")
		.isActive(false)
		.clickSubmitButton()
		.validateUpdates("edit_region_test_01","status","INACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=4)
	public void activate_region()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRegions()
		.editRegion("edit_region_test_01")
		.isActive(true)
		.clickSubmitButton()
		.validateUpdates("edit_region_test_01","status","ACTIVE")
		.getTitle()
		.logout();
	}
@Test(priority=5)
	public void archive_region()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRegions()
		.archiveRegion("edit_region_test_01")
		.getTitle()
		.logout();
	}
	@Test(priority=6)
	public void restore_region()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRegions()
		.restoreRegion("edit_region_test_01")
		.getTitle()
		.logout();
	}
}