package assets;

import org.testng.annotations.Test;

import Utility.TestBase;

public class MediaGalleryRestore_testcases extends TestBase{


	@Test(priority=0)
	//@Test(enabled=faldse)
	public void open_archive_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.clickArchiveButton()
		.getTitle()
		.logout();
	}

}
