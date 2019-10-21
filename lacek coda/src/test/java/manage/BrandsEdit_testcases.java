package manage;

import Utility.TestBase;
import org.testng.annotations.Test;

public class BrandsEdit_testcases extends TestBase{

	//EDIT brands
	@Test(priority=0)
	public void update_brand_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickBrands()
		.editBrand("edit_brand_test_01")
		.updateNameTo("edit_brand_test_010")		
		.clickSubmit()
		.validateUpdates("edit_brand_test_010","name","edit_brand_test_010")
		.getTitle()
		.logout();
	}
	@Test(priority=1)
	public void update_brand_name_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickBrands()
		.editBrand("edit_brand_test_010")
		.updateNameTo("edit_brand_test_01")		
		.clickSubmit()
		.validateUpdates("edit_brand_test_01","name","edit_brand_test_01")
		.getTitle()
		.logout();
	}	
	@Test(priority=2)
	public void update_brand_color()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickBrands()
		.editBrand("edit_brand_test_01")
		.updateColorTo("#0ce6b3")
		.clickSubmit()
		.getTitle()
		.logout();
	}
	@Test(priority=3)
	public void update_brand_color_to_previous_color()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickBrands()
		.editBrand("edit_brand_test_01")
		.updateColorTo("#e60935")
		.clickSubmit()
		.getTitle()
		.logout();
	}
	@Test(priority=4)
	public void update_brand_url()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickBrands()
		.editBrand("edit_brand_test_01")
		.updateUrlTo("http://www.aida.de")
		.clickSubmit()
		.validateUpdates("edit_brand_test_01","url","http://www.aida.de")
		.getTitle()
		.logout();
	}
	@Test(priority=5)
	public void update_brand_url_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickBrands()
		.editBrand("edit_brand_test_01")
		.updateUrlTo("http://www.lacek.com/")
		.clickSubmit()
		.validateUpdates("edit_brand_test_01","url","http://www.lacek.com/")
		.getTitle()
		.logout();
	}
	@Test(priority=6)
	public void inactivate_brand()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickBrands()
		.editBrand("edit_brand_test_01")
		.inactivateBrand()
		.clickSubmit()
		.validateUpdates("edit_brand_test_01","status","INACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=7)
	public void activate_brand()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickBrands()
		.editBrand("edit_brand_test_01")
		.activateBrand()
		.clickSubmit()
		.validateUpdates("edit_brand_test_01","status","ACTIVE")
		.getTitle()
		.logout();
	}
//	@Test(priority=8)
//	public void empty_name_field_in_brands_edit_page()
//	{
//		login.loginAs("automation.admin","Monday#223")
//		.isSuccessfulLogin("automation admin")
//		.clickBrands()
//		.editBrand("edit_brand_test_01")
//		.deleteName()
//		.failToUpdate()
//		.getTitle()
//		.logout();
//	}
//	@Test(priority=9)
//	public void empty_url_field_in_brands_edit_page()
//	{
//		login.loginAs("automation.admin","Monday#223")
//		.isSuccessfulLogin("automation admin")
//		.clickBrands()
//		.editBrand("edit_brand_test_01")
//		.deleteUrl()
//		.failToUpdate()
//		.getTitle()
//		.logout();
//	}
//	@Test(priority=10)
//	public void empty_color_field_in_brands_edit_page()
//	{
//		login.loginAs("automation.admin","Monday#223")
//		.isSuccessfulLogin("automation admin")
//		.clickBrands()
//		.editBrand("edit_brand_test_01")
//		.deleteColor()
//		.failToUpdate()
//		.getTitle()
//		.logout();
//	}
	@Test(priority=11)
	public void archive_brand()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickBrands()
		.archiveBrand("edit_brand_test_01")
		.getTitle();
	}
	@Test(priority=12)
	public void restore_brand()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickBrands()
		.restoreBrand("edit_brand_test_01")
		.getTitle();
	}
}