package assets;

import org.testng.annotations.Test;

import Utility.TestBase;

public class MediaGalleryPublish_testcases extends TestBase{
	
	//PUBLISH MEDIA GALLERY 
	@Test(priority=0)
	public void publish_media_gallery()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.publishMediaGallery("publish_image_test_01")
		.checkAll()
		.clickPublisButton()
		.getTitle()
		.logout();
	}
	@Test(priority=1)
	public void cancel_publish_campaign()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.publishMediaGallery("publish_image_test_01")
		.clickCancelButton()
		.getTitle()
		.logout();
	}
	@Test(priority=2)
	public void publish_media_gallery_Carnival_AE()
	{
		login.loginAs("carnival.account","09ht1a0480")
		.isSuccessfulLogin("carnival account")
		.clickMediaGallery()
		.publishMediaGallery("publish_image_test_01")
		.checkAll()
		.clickPublisButton()
		.getTitle()
		.logout();
	}
	@Test(priority=3)
	public void cancel_publish_campaign_Carnival_AE()
	{
		login.loginAs("carnival.account","09ht1a0480")
		.isSuccessfulLogin("carnival account")
		.clickMediaGallery()
		.publishMediaGallery("publish_image_test_01")
		.clickCancelButton()
		.getTitle()
		.logout();
	}
	
}