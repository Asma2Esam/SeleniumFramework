package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcellReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDTandExcell extends TestBase
{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	@DataProvider(name = "ExcellData")
	public Object[][] UserRegisterData() throws IOException
	{
		ExcellReader er = new ExcellReader();
			return er.GetExcellData();
	}
	@Test(priority = 1, alwaysRun = true, dataProvider = "ExcellData")
	public void UserCanRegisterSuccessfully(String fname, String lname, String email, String password)
	{
		homeObject = new HomePage(driver);
		homeObject.OpenRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.UserRegisteration(fname, lname, email, password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("completed"));
		registerObject.userLogout();
		homeObject.OpenLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, password);
		Assert.assertTrue(registerObject.logoutBtn.getText().contains("Log out"));
		registerObject.userLogout();
	}
}
