package library;


import Utility.TestBase;
import org.testng.annotations.Test;

public class MessagesRestore_Testcases extends TestBase{
	
	@Test
	public void test_is_empty()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.getTitle();
	}
}
