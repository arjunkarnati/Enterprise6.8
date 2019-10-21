package manage;

import DataBase.DataBaseManage;
import Utility.TestBase;
import org.testng.annotations.Test;

public class Brands_testcases extends TestBase{

	/*create brand test cases */
	@Test(priority=0)
	//@Test(enabled=false)
	public void create_a_new_brand()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickBrands()
		.clickAddBrandButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrandName("selenium_brand_0110")
		.addColor("#2a30d4")
		.addUrl("http://www.lacek.com/")
		.clickSubmit()	
		.validateUpdates("selenium_brand_0110","client","Carnival Corporation & PLC")
		.validateUpdates("selenium_brand_0110","name","selenium_brand_0110")
		.validateUpdates("selenium_brand_0110","url","http://www.lacek.com/")
		.validateUpdates("selenium_brand_0110","status","ACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=1)
	//@Test(enabled=false)
	public void create_a_new_brand_without_a_client_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickBrands()
		.clickAddBrandButton()
		.addBrandName("test_selenium_brand_02")
		.addColor("#2a30d4")
		.addUrl("http://www.lacek.com/")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=2)
	//@Test(enabled=false)
	public void create_a_new_brand_witout_a_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickBrands()
		.clickAddBrandButton()
		.addClientName("Carnival Corporation & PLC")
		.addColor("#2a30d4")
		.addUrl("http://www.lacek.com/")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=3)
	//@Test(enabled=false)
	public void create_a_new_brand_without_a_color()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickBrands()
		.clickAddBrandButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrandName("test_selenium_brand_03")
		.addUrl("http://www.lacek.com/")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=4)
	//@Test(enabled=false)
	public void create_a_new_brand_without_a_url()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickBrands()
		.clickAddBrandButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrandName("test_selenium_brand_06")
		.addColor("#2a30d4")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=50)
	//@Test(enabled=false)
	public void delete_brand_from_db()
	{
		DataBaseManage.deleteBrand();
	}
	/*@Test(priority=60)
	//@Test(enabled=false)
	public void create_test_brand()
	{
		login.loginAs("test.data","Monday#223")
		.isSuccessfulLogin("test data")
		.clickBrands()
		.clickAddBrandButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrandName("edit_brand_test_010")
		.addColor("e60935")
		.addUrl("http://www.lacek.com/")
		.clickSubmit()	
		.validateUpdates("edit_brand_test_010","client","Carnival Corporation & PLC")
		.validateUpdates("edit_brand_test_010","name","edit_brand_test_010")
		.validateUpdates("edit_brand_test_010","url","http://www.lacek.com/")
		.validateUpdates("edit_brand_test_010","status","ACTIVE")
		.getTitle()
		.logout();
	}*/
}