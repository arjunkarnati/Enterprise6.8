package library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utility.PageBase;

public class CommunicationsPreviewPage extends PageBase {

	public CommunicationsPreviewPage(WebDriver driver) 
	{
		super(driver);
	}

	public CommunicationsPreviewPage verifyaccess() {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath(library.getProperty("comm_preview_thumbnails"))).click();
		driver.findElement(By.xpath(library.getProperty("send_thumbnail_preview"))).click();
		
		return new CommunicationsPreviewPage(driver);
	}

	

}
