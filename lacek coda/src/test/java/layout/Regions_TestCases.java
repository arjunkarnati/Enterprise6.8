package layout;

import org.testng.annotations.Test;
import DataBase.DataBaseLayout;
import Utility.TestBase;

public class Regions_TestCases extends TestBase{

	//CREATE REGION 
	@Test(priority=0)
	//@Test(enabled=false)
	public void create_a_new_region()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRegions()
		.clickAddRegionButton()
		.addRegionName("selenium_test_001")
		.addDescription("creating a region using selenium")
		.clickSubmitButton()
		.validateUpdates("selenium_test_001","name","selenium_test_001")
		.validateUpdates("selenium_test_001","status","ACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=1)
	//@Test(enabled=false)
	public void create_a_new_region_with_a_duplicate_name()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRegions()
		.clickAddRegionButton()
		.addRegionName("selenium_test_001")
		.addDescription("creating a region using selenium")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=2)
	//@Test(enabled=false)
	public void create_a_new_region_without_a_name()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRegions()
		.clickAddRegionButton()
		.addDescription("creating a region using selenium")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=5) 
	public void database_delete_region() 
	{	
		DataBaseLayout.deleteRegion();
	}
	/*@Test(priority=30)
	//@Test(enabled=false)
	public void create_test_region()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRegions()
		.clickAddRegionButton()
		.addRegionName("edit_region_test_01")
		.addDescription("still using selenium to test")
		.clickSubmitButton()
		.validateUpdates("edit_region_test_01","name","selenium_test_001")
		.validateUpdates("edit_region_test_01","status","ACTIVE")
		.getTitle()
		.logout();
	}*/
}