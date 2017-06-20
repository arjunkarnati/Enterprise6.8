package assets;

import org.testng.annotations.Test;
import DataBase.DataBaseAssets;
import Utility.TestBase;

public class MediaGallery_TestCases extends TestBase{

	//CREATE MEDIA GALLERY 	
	@Test(priority=0)
	//@Test(enabled=false)
	public void create_a_new_media_gallery()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		//.clickAddMediaGalleryButton()
		//.addClientName("Carnival Corporation & PLC")
		//.addBrand("Costa Cruises")
		//.addBrand("Cunard")
		//.addProgram("VIFP")
		//.addImage("selenium02")
		//.addConnector("Exact Target (Carnival NA) | Approved")
		//.addConnector("Exact Target (Carnival NA) | Draft")
		//.clickSubmitButton()
		//.validateUpdates("selenium02","client","Carnival Corporation & PLC")
		//.validateUpdates("selenium02","brand","2")
		//.validateUpdates("selenium02","program","1")
		//.validateUpdates("selenium02","name","Selenium02")
		//.validateUpdates("selenium02","status","ACTIVE")
		//.validateUpdates("selenium02","workflow","DRAFT")
		//.getTitle()
		.logout();		
	}
	@Test(priority=1)
	//@Test(enabled=false)
	public void create_a_new_media_gallery_without_clientname()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.clickAddMediaGalleryButton()
		.failToCreate()
		.getTitle()
		.logout();	
	}
	@Test(priority=2)
	//@Test(enabled=false)
	public void create_a_new_media_gallery_without_uploadig_an_image()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.clickAddMediaGalleryButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("Costa Cruises")
		.addBrand("Cunard")
		.addProgram("VIFP")
		.addConnector("Exact Target (Carnival NA) | Approved")
		.addConnector("Exact Target (Carnival NA) | Draft")
		.failToCreate()
		.getTitle()
		.logout();	
	}	
	@Test(priority=30) 
	public void database_delete_media_gallery() 
	{	
		DataBaseAssets.deleteMediaGallery();
	}	
}