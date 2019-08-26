package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegisterationPage;

public class MyAccountTest extends TestBase
{
	HomePage homeObject;
	LoginPage loginObject;
	UserRegisterationPage registerObject;
	MyAccountPage myAccountObject;
	String oldPassword = "12345678";
	String newPassword = "123456789";
	String firstName = "Asmaa";
	String lastName = "Esam";
	String email = "asmaaaaaaaaaaaaaaaaa@gmail.com";
	@Test(priority = 1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.OpenRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.UserRegisteration(firstName, lastName, email, oldPassword);
		Assert.assertTrue(registerObject.successMessage.getText().contains("completed"));
	}
	@Test(priority = 2)
	public void RegisteredUserCanChangePassword()
	{
		registerObject.openMyAccountPage();
		myAccountObject = new MyAccountPage(driver);
		myAccountObject.OpenChangePasswordPage();
		myAccountObject.ChangePassword(oldPassword, newPassword);
		Assert.assertTrue(myAccountObject.resultLbl.getText().contains("Password was changed"));
	}
	@Test(priority = 3)
	public void RegisteredUserCanLogout()
	{
		registerObject.userLogout();
	}
	@Test(priority = 4)
	public void RegisteredUserCanLogin()
	{
		homeObject.OpenLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, newPassword);
		Assert.assertTrue(registerObject.logoutBtn.getText().contains("Log out"));
	}

}
