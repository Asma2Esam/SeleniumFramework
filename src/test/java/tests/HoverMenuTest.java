package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class HoverMenuTest extends TestBase
{
	HomePage homeObject;
	@Test
	public void UserCanSelectSubPriductFromHoverMenu()
	{
		homeObject = new HomePage(driver);
		homeObject.SelectNotebooksMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}

}
