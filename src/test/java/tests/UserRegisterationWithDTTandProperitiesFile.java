package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperities;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDTTandProperitiesFile extends TestBase
{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	String firstname = LoadProperities.userData.getProperty("firstname");
	String lastname = LoadProperities.userData.getProperty("lastname");
	String email = LoadProperities.userData.getProperty("email");
	String password = LoadProperities.userData.getProperty("password");
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.OpenRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.UserRegisteration(firstname, lastname, email, password);
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
		loginObject.UserLogin(email, password);
		Assert.assertTrue(registerObject.logoutBtn.getText().contains("Log out"));
	}

}
