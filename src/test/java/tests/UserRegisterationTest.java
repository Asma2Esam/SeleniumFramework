package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTest extends TestBase
{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.OpenRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.UserRegisteration("Asmaa", "Esam", "asmaaaaaa@gmail.com", "12345678");
		Assert.assertTrue(registerObject.successMessage.getText().contains("completed"));
	}
	@Test(dependsOnMethods = {"UserCanRegisterSuccessfully"})
	public void RegisteredUserCanLogout()
	{
		registerObject.userLogout();
	}
	@Test(dependsOnMethods = {"RegisteredUserCanLogout"})
	public void RegisteredUserCanLogin()
	{
		homeObject.OpenLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin("asmaaaaaa@gmail.com", "12345678");
		Assert.assertTrue(registerObject.logoutBtn.getText().contains("Log out"));
	}

}
