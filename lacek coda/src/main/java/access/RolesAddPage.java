package access;

import Utility.PageBase;
import layout.RegionsAddPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RolesAddPage extends PageBase {

	public RolesAddPage(WebDriver driver) 
	{
		super(driver);
	}
	//add role name
	public RolesAddPage addRoleName(String rolename)
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("role_add_name"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("role_add_name"))).sendKeys(rolename);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_add_page_title"));
		return new RolesAddPage(driver);
	}
	//add parent role
	public RolesAddPage addParentRole(String parentrolename)
	{
		readconfig(); 
		Select defaultlocales = new Select(driver.findElement(By.id(elementslocator.getProperty("role_add_parent_role"))));
		defaultlocales.selectByVisibleText(parentrolename);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_add_page_title"));
		return new RolesAddPage(driver);
	}
	//add business rule
	public RolesAddPage addBusinessRule(String businessrule)
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("role_add_business_rule"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("role_add_business_rule"))).sendKeys(businessrule);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_add_page_title"));
		return new RolesAddPage(driver);
	}
	//add client
	public RolesAddPage addClient(String clientname)
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("role_add_client"))).click();
		driver.findElement(By.id(elementslocator.getProperty("role_add_client_search_field"))).sendKeys(clientname);
		driver.findElement(By.id(elementslocator.getProperty("role_add_client_search_field"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.findElement(By.id(elementslocator.getProperty("role_add_client"))).getText(),clientname);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_add_page_title"));
		return new RolesAddPage(driver);
	}
	//add permission
	public RolesAddPage addPermissionGroup(String permissionname)
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("role_add_permission_groups"))).sendKeys(permissionname);
		driver.findElement(By.id(elementslocator.getProperty("role_add_permission_groups"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_add_page_title"));
		return new RolesAddPage(driver);
	}
	//add access level
	public RolesAddPage addAccessLevel(int accesslevel)
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("role_add_access_level"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("role_add_access_level"))).sendKeys(String.valueOf(accesslevel));
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_add_page_title"));
		return new RolesAddPage(driver);
	}
	//add access level
	public RolesAddPage emptyAccessLevel()
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("role_add_access_level"))).clear();
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_add_page_title"));
		return new RolesAddPage(driver);
	}
	//click cancel button
	public RolesPage Cancel()
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("role_add_cancel"))).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//asssert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_page_title"));
		return new RolesPage(driver);
	}
	//click submit button
	public RolesPage Submit()
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("role_add_submit"))).click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_page_title"));
		return new RolesPage(driver);
	}
	//click save for failed
	public RegionsAddPage failToCreate()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("role_add_submit"))).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_add_page_title"));
		return new RegionsAddPage(driver);
	}
}