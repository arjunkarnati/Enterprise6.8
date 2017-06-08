package access;

import org.testng.annotations.Test;
import DataBase.DataBaseAccess;
import Utility.TestBase;

public class Users_TestCases extends TestBase{

	/*create user test cases */
	@Test(priority=0,enabled=true)
	public void create_an_admin_user()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		.addFirstName("Selenium01")
		.addLastName("seleniumuser1")
		.addEmail("test.lacek5@gmail.com")
		.addPhoneNumber(207000000)
		.addUserName("selenium010")
		.addPassWord("Monday#2")	
		.confirmPassWord("Monday#2")
		.addClient("Carnival Corporation & PLC")
		.addClient("DuPont")
		.addClient("Alaska Airlines")
		.isAdmin(true)
		.Submit()	
		.validateUpdates("seleniumuser1","first name","Selenium01")
		.validateUpdates("seleniumuser1","last name","seleniumuser1")
		.validateUpdates("seleniumuser1", "user name", "selenium010")
		.validateUpdates("seleniumuser1","email","test.lacek5@gmail.com")
		.validateUpdates("seleniumuser1","client","3")
		.validateUpdates("seleniumuser1","admin","YES")
		.validateUpdates("seleniumuser1","status","ACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=1,enabled=true)
	public void create_a_non_admin_user()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		.addFirstName("Selenium022")
		.addLastName("seleniumest02")
		.addEmail("test.lacek4@gmail.com")
		.addPhoneNumber(207000000)
		.addUserName("seleniumtest009")
		.addPassWord("Monday#2")
		.confirmPassWord("Monday#2")
		.addClient("Carnival Corporation & PLC")
		.addClient("Alaska Airlines")
		.isAdmin(false)
		.Submit()	
		.validateUpdates("seleniumest02","first name","Selenium022")
		.validateUpdates("seleniumest02","last name","seleniumest02")
		.validateUpdates("seleniumest02", "user name", "seleniumtest009")
		.validateUpdates("seleniumest02","email","test.lacek4@gmail.com")
		.validateUpdates("seleniumest02","client","2")
		.validateUpdates("seleniumest02","admin","NO")
		.validateUpdates("seleniumest02","status","ACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=2)
	//@Test(enabled=false)
	public void create_an_admin_user_without_a_first_name()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		//.addFirstName("Selenium01")
		.addLastName("seleniumest03")
		.addEmail("prbitmus1@gmail.com")
		.addPhoneNumber(2070000000)
		.addUserName("selenium01")
		.addPassWord("Monday#2")
		.confirmPassWord("Monday#2")
		.addClient("Carnival Corporation & PLC")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=3)
	//@Test(enabled=false)
	public void create_an_admin_user_without_a_last_name()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		.addFirstName("Selenium01")
		//.addLastName("seleniumest03")
		.addEmail("prbitmus1@gmail.com")
		.addPhoneNumber(207000000)
		.addUserName("selenium01")
		.addPassWord("Monday#2")
		.confirmPassWord("Monday#2")
		.addClient("Carnival Corporation & PLC")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=4)
	//@Test(enabled=false)
	public void create_an_admin_user_without_an_email_address()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		.addFirstName("Selenium01")
		.addLastName("seleniumest03")
		//.addEmail("test.lacek@gmail.com")
		.addPhoneNumber(207000000)
		.addUserName("selenium01")
		.addPassWord("Monday#2")
		.confirmPassWord("Monday#2")
		.addClient("Carnival Corporation & PLC")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=5)
	//@Test(enabled=false)
	public void create_an_admin_user_without_a_username()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		.addFirstName("Selenium01")
		.addLastName("seleniumest03")
		.addEmail("prbitmus1@gmail.com")
		.addPhoneNumber(207000000)
		//.addUserName("selenium01")
		.addPassWord("Monday#2")
		.confirmPassWord("Monday#2")
		.addClient("Carnival Corporation & PLC")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=6)
	//@Test(enabled=false)
	public void create_an_admin_user_without_a_password()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		.addFirstName("Selenium01")
		.addLastName("seleniumest03")
		.addEmail("prbitmus1@gmail.com")
		.addPhoneNumber(207000000)
		.addUserName("selenium01")
		//.addPassWord("Monday#2")	
		.confirmPassWord("Monday#2")
		.addClient("Carnival Corporation & PLC")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=7)
	//@Test(enabled=false)
	public void create_a_non_admin_user_without_a_first_name()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		//.addFirstName("Selenium01")
		.addLastName("seleniumest03")
		.addEmail("prbitmus1@gmail.com")
		.addPhoneNumber(207000000)
		.addUserName("selenium01")
		.addPassWord("Monday#2")
		.confirmPassWord("Monday#2")
		.addClient("Carnival Corporation & PLC")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=8)
	//@Test(enabled=false)
	public void create_a_non_admin_user_without_a_last_name()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		.addFirstName("Selenium01")
		//.addLastName("seleniumest03")
		.addEmail("prbitmus1@gmail.com")
		.addPhoneNumber(207000000)
		.addUserName("selenium01")
		.addPassWord("Monday#2")	
		.confirmPassWord("Monday#2")
		.addClient("Carnival Corporation & PLC")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=9)
	//@Test(enabled=false)
	public void create_a_non_admin_user_without_an_email_address()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		.addFirstName("Selenium01")
		.addLastName("seleniumest03")
		//.addEmail("test.lacek@gmail.com")
		.addPhoneNumber(207000000)
		.addUserName("selenium01")
		.addPassWord("Monday#2")	
		.confirmPassWord("Monday#2")
		.addClient("Carnival Corporation & PLC")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=10)
	//@Test(enabled=false)
	public void create_a_non_admin_user_without_a_username()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		.addFirstName("Selenium01")
		.addLastName("seleniumest03")
		.addEmail("prbitmus1@gmail.com")
		.addPhoneNumber(207000000)
		//.addUserName("selenium01")
		.addPassWord("Monday#2")
		.confirmPassWord("Monday#2")
		.addClient("Carnival Corporation & PLC")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=11)
	//@Test(enabled=false)
	public void create_a_non_admin_user_without_a_password()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		.addFirstName("Selenium01")
		.addLastName("seleniumest03")
		.addEmail("prbitmus1@gmail.com")
		.addPhoneNumber(207000000)
		.addUserName("selenium01")
		//.addPassWord("Monday#2")	
		.confirmPassWord("Monday#2")
		.addClient("Carnival Corporation & PLC")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=12)
	//@Test(enabled=false)
	public void select_button_cancel_in_user_add_page()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		.Cancel()
		.getTitle()
		.logout();
	}
	@Test(priority=14)
	//@Test(enabled=false)
	public void create_a_duplicate_user()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		.addFirstName("Prince")
		.addLastName("Kabuika")
		.addEmail("prince.kabuika@lacek.com")
		.addPhoneNumber(0)
		.addUserName("prince.kabuika")
		.addPassWord("Monday#2")
		.confirmPassWord("Monday#2")
		.addClient("Copa Airlines")
		.addClient("US Bank")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=15)
	//@Test(enabled=false)
	public void create_a_user_with_an_invalid_email_address_format()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		.addFirstName("testinvalid")
		.addLastName("testinvalid2")
		.addEmail("javajava")
		.addPhoneNumber(0)
		.addUserName("testinvalid")
		.addPassWord("Monday#2")
		.confirmPassWord("Monday#2")
		.addClient("Carnival Corporation & PLC")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=16)
	//@Test(enabled=false)
	public void fail_to_create_user_when_first_name_field_is_empty()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		//.addFirstName("testinvalid")
		.addLastName("testinvalid2")
		.addEmail("prbitmus1@gmail.com")
		.addPhoneNumber(0)
		.addUserName("testinvalid")
		.addPassWord("Monday#2")
		.confirmPassWord("Monday#2")
		.addClient("Carnival Corporation & PLC")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=17)
	//@Test(enabled=false)
	public void fail_to_create_user_when_last_name_field_is_empty()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		.addFirstName("testinvalid")
		//.addLastName("testinvalid2")
		.addEmail("prbitmus1@gmail.com")
		.addPhoneNumber(0)
		.addUserName("testinvalid")
		.addPassWord("Monday#2")
		.confirmPassWord("Monday#2")
		.addClient("Carnival Corporation & PLC")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=18)
	//@Test(enabled=false)
	public void fail_to_create_user_when_email_address_field_is_empty()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		.addFirstName("testinvalid")
		.addLastName("testinvalid2")
		//.addEmail("prince.kabuika@lacek.com")
		.addPhoneNumber(0)
		.addUserName("testinvalid")
		.addPassWord("Monday#2")
		.confirmPassWord("Monday#2")
		.addClient("Carnival Corporation & PLC")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=19)
	//@Test(enabled=false)
	public void fail_to_create_user_when_username_field_is_empty()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		.addFirstName("testinvalid")
		.addLastName("testinvalid2")
		.addEmail("prbitmus1@gmail.com")
		.addPhoneNumber(0)
		//.addUserName("testinvalid")
		.addPassWord("Monday#2")
		.confirmPassWord("Monday#2")
		.addClient("Carnival Corporation & PLC")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=20)
	//@Test(enabled=false)
	public void fail_to_create_user_when_password_field_is_empty()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		.addFirstName("testinvalid")
		.addLastName("testinvalid2")
		.addEmail("prbitmus1@gmail.com")
		.addPhoneNumber(0)
		.addUserName("testinvalid")
		//.addPassWord("Monday#2")
		.confirmPassWord("Monday#2")
		.addClient("Carnival Corporation & PLC")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=21)
	//@Test(enabled=false)
	public void fail_to_create_user_when_confirm_password_field_is_empty()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		.addFirstName("testinvalid")
		.addLastName("testinvalid2")
		.addEmail("prbitmus1@gmail.com")
		.addPhoneNumber(0)
		.addUserName("testinvalid")
		.addPassWord("Monday#2")
		//.confirmPassWord("Monday#2")
		.addClient("Carnival Corporation & PLC")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=22)
	//@Test(enabled=false)
	public void fail_to_create_user_when_confirm_password_field_does_not_match_the_password()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		.addFirstName("testinvalid")
		.addLastName("testinvalid2")
		.addEmail("prbitmus1@gmail.com")
		.addPhoneNumber(0)
		.addUserName("testinvalid")
		.addPassWord("Monday#2")
		.confirmPassWord("Monday#20")
		.addClient("Carnival Corporation & PLC")
		.failToCreate()
		.getTitle()
		.logout();
	}
	/*@Test(priority=23)
	//@Test(enabled=false)
	public void CCL_AE_fail_to_add_otherclient()
	{
		login.loginAs("carniaval.accoutn", "09ht1a0480")
		.isSuccessfulLogin("carnival account")
		.clickUsers()
		.clickAddUserButton()
		.addFirstName("CCLaccount")
		.addLastName("test")
		.addEmail("arjun.karnati@lacek.com")
		.addUserName("cclaccount.test")
		.addPassWord("09ht1a0480")
		.addClient("enterprise")
		.failToCreate()
		.getTitle()
		.logout();
		
	}*/
	@Test(priority=80) 
	public void database_delete_user() 
	{			
		DataBaseAccess.deleteUser();	
	}
	/*@Test(priority=90,enabled=true)
	public void create_test_admin_user()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		.addFirstName("automation")
		.addLastName("edit_user_test_01")
		.addEmail("arjun.karnati@lacek.com")
		.addPhoneNumber(207000000)
		.addUserName("edit_user_test_01")
		.addPassWord("Monday#2")	
		.confirmPassWord("Monday#2")
		.addClient("Carnival Corporation & PLC")
		.isAdmin(true)
		.Submit()	
		.validateUpdates("edit_user_test_01","first name","automation")
		.validateUpdates("edit_user_test_01","last name","edit_user_test_01")
		.validateUpdates("edit_user_test_01","client","1")
		.validateUpdates("edit_user_test_01","admin","YES")
		.validateUpdates("edit_user_test_01","status","ACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=91)
	//@Test(enabled=false)
	public void create_a_non_admin_ehi_ae()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		.addFirstName("ehi")
		.addLastName("ae")
		.addEmail("arjun.karnati@lacek.com")
		.addPhoneNumber(207000000)
		.addUserName("ehi.ae")
		.addPassWord("09ht1a0480123")
		.confirmPassWord("09ht1a0480123")
		.addClient("Enterprise Holdings Inc")
		.addRole("Ehi Account Executive")
		.Submit()
		.validateUpdates("ehi.ae","first name","ehi")
		.validateUpdates("ehi.ae","admin","NO")
		.getTitle()
		.logout();
	}
	@Test(priority=92)
	//@Test(enabled=false)
	public void create_a_non_admin_ehi_qa()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		.addFirstName("remanth")
		.addLastName("newtest")
		.addEmail("arjun.karnati@lacek.com")
		.addPhoneNumber(207000000)
		.addUserName("remanth_ehi_qa")
		.addPassWord("09ht1a0480123")
		.confirmPassWord("09ht1a0480123")
		.addClient("Enterprise Holdings Inc")
		.addRole("Ehi Quality Assurance")
		.Submit()
		.validateUpdates("remanth_ehi_qa","first name","remanth")
		.validateUpdates("remanth_ehi_qa","admin","NO")
		.getTitle()
		.logout();
	}
	@Test(priority=0,enabled=true)
	public void create_non_admin_carnival_account()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickAddUserButton()
		.addFirstName("carnival")
		.addLastName("account")
		.addEmail("arjun.karnati@lacek.com")
		.addPhoneNumber(207000000)
		.addUserName("carnival.account")
		.addPassWord("09ht1a0480")	
		.confirmPassWord("09ht1a0480")
		.addClient("Carnival Corporation & PLC")
		.addRole("CCL Account Executive")
		.Submit()	
		.validateUpdates("carnival.account","last name","account")
		.validateUpdates("carnival.account","email","arjun.karnati@lacek.com")
		.validateUpdates("carnival.account","admin","NO")
		.validateUpdates("carnival.account","status","ACTIVE")
		.getTitle()
		.logout();
	}*/
	
	//2nd commit
	
}