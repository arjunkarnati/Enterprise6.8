package access;

import org.testng.annotations.Test;
import Utility.TestBase;

public class UsersEdit_testcases extends TestBase{

	//EDIT USER
	@Test(priority=0)
	public void update_user_fisrt_name()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.editUser("edit_user_test_01")
		.updateFirstNameTo("automation01")
		//.Submit()
		.Save()
		.validateUpdates("edit_user_test_01","first name","automation01")
		.getTitle();
	}
	@Test(priority=1)
	public void update_user_first_name_to_previous()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()	
		.editUser("edit_user_test_01")
		.updateFirstNameTo("automation")
		//.Submit()
		.Save()
		.validateUpdates("edit_user_test_01","first name","automation")
		.getTitle()
		.logout();
	}	
	@Test(priority=2)
	public void update_user_last_name()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.editUser("edit_user_test_01")
		.updateLastNameTo("set01")
		//.Submit()
		.Save()
		.validateUpdates("set01","last name","set01")
		.getTitle()
		.logout();
	}
	@Test(priority=3)
	public void update_user_last_name_to_previous()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.editUser("edit_user_test_01")
		.updateLastNameTo("edit_user_test_01")
		//.Submit()
		.Save()
		.validateUpdates("edit_user_test_01","last name","edit_user_test_01")
		.getTitle()
		.logout();
	}		
	@Test(priority=4)
	public void update_user_email_address()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.editUser("edit_user_test_01")
		.updateEmailTo("prbitmus2@gmail.com")
		.getTitle()
		.logout();
	}
	@Test(priority=5)
	public void update_user_email_address_to_previous()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.editUser("edit_user_test_01")
		.updateEmailTo("prbitmus1@gmail.com")
		.getTitle()
		.logout();
	}	
	@Test(priority=6)
	public void update_user_phone_number()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.editUser("edit_user_test_01")
		.updatePhoneNumberTo(2071111111)
		//.Submit()
		.Save()
		.getTitle()
		.logout();
	}	
	@Test(priority=7)
	public void update_user_phone_number_to_previous()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.editUser("edit_user_test_01")
		.updatePhoneNumberTo(2070000000)
		//.Submit()
		.Save()
		.getTitle()
		.logout();
	}	
	@Test(priority=8)
	public void update_user_username()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.editUser("edit_user_test_01")
		.updateUserNameTo("edit_user_test_010")
		//.Submit()
		.Save()
		.validateUpdates("edit_user_test_010","user name","edit_user_test_010")
		.getTitle()
		.logout();
	}	
	@Test(priority=9)
	public void update_user_username_to_previous()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.editUser("edit_user_test_010")
		.updateUserNameTo("edit_user_test_01")
		//.Submit()
		.Save()
		.validateUpdates("edit_user_test_01","user name","edit_user_test_01")
		.getTitle()
		.logout();
	}		
	@Test(priority=10)
	public void update_user_password()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.editUser("edit_user_test_01")
		.updatePassWordTo("2Monday#2")
		.getTitle()
		.logout();
	}	
	@Test(priority=11)
	public void update_user_password_to_previous()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.editUser("edit_user_test_01")
		.updatePassWordTo("3Monday#2")
		.getTitle()
		.logout();
	}
	@Test(priority=12)
	public void update_user_clients()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()	
		.editUser("edit_user_test_01")
		.deleteField("client")
		.updateClient("DuPont")
		//.Submit()
		.Save()
		.validateUpdates("edit_user_test_01","client","1")
		.getTitle()
		.logout();
	}		
	@Test(priority=13)
	public void update_user_clients_to_previous()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.editUser("edit_user_test_01")
		.deleteField("client")
		.updateClient("Carnival Corporation & PLC")
		//.Submit()
		.Save()
		.validateUpdates("edit_user_test_01","client","1")
		.getTitle()
		.logout();
	}	
	@Test(priority=14)
	public void update_admin_role()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.editUser("edit_user_test_01")
		.isAdmin(false)
		//.Submit()
		.Save()
		.validateUpdates("edit_user_test_01","admin","NO")
		.getTitle()
		.logout();
	}	
	@Test(priority=15)
	public void update_user_role()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.editUser("edit_user_test_01")
		.getTitle()
		.logout();
	}	
	@Test(priority=16)
	public void update_user_role_to_previous()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.editUser("edit_user_test_01")
		.getTitle()
		.logout();
	}	
	@Test(priority=17)
	public void update_admin_role_to_previous()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.editUser("edit_user_test_01")
		.isAdmin(true)
		//.Submit()
		.Save()
		.validateUpdates("edit_user_test_01","admin","YES")
		.getTitle()
		.logout();
	}	
	@Test(priority=18)
	public void inactivate_user()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.editUser("edit_user_test_01")
		.isActive(false)
		//.Submit()
		.Save()
		.validateUpdates("edit_user_test_01","status","INACTIVE")
		.getTitle()
		.logout();
	}		
	@Test(priority=19)
	public void activate_user()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.editUser("edit_user_test_01")
		.isActive(true)
		//.Submit()
		.Save()
		.validateUpdates("edit_user_test_01","status","ACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=20)
	public void archive_user()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.archiveUser("edit_user_test_01")
		.getTitle();
	}
	@Test(priority=21)
	public void restore_user()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickArchiveButton()
		.restoreUser("edit_user_test_01")
		.getTitle();
	}
	@Test(priority=22)
	public void select_button_cancel_in_user_edit_page()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.editUser("edit_user_test_01")
		.Cancel()
		.getTitle()
		.logout();
	}	
	@Test(priority=23)
		public void user_edit_otheruser(){
			login.loginAs("automation.admin","Monday#2")
			.isSuccessfulLogin("automation admin")
			.clickUsers()
			.editUser("remanth")
			.isActive(false)
			.Save()
			.validateUpdates("remanth","status","INACTIVE")
			.getTitle()
			.logout();
    }
	@Test(priority=24)
	public void user_edit_otheruserprevious(){
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.editUser("remanth")
		.isActive(true)
		.Save()
		.validateUpdates("remanth","status","ACTIVE")
		.getTitle()
		.logout();
	}
	/*@Test(priority=25)
	public void update_EHIQA_password()
	{
		login.loginAs("remanth.test","09ht1a0480")
		.isSuccessfulLogin("remanth.test")
		.clickUsers()
		.addPassWord("Monday#2")
		.confirmPassWord("Monday#2")
		.getTitle()
		.logout();
	}	
	@Test(priority=26)
	public void update_EHIQA_password_to_previous()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.editUser("edit_user_test_01")
		.updatePassWordTo("09ht1a0480")
		.getTitle()
		.logout();
	}*/
	
	}
