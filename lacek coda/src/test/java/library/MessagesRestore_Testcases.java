package library;


import org.testng.annotations.Test;
import Utility.TestBase;

public class MessagesRestore_Testcases extends TestBase{
	
	@Test
	public void test_is_empty()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.getTitle();
	}
}
