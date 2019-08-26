package tests;

//import java.io.FileReader;
//import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDTandJson extends TestBase
{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	CSVReader reader;
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccessfully()
	{
			homeObject = new HomePage(driver);
			homeObject.OpenRegisterationPage();
			registerObject = new UserRegisterationPage(driver);
			//registerObject.UserRegisteration(fname, lname, email, password);
			Assert.assertTrue(registerObject.successMessage.getText().contains("completed"));
			registerObject.userLogout();
			homeObject.OpenLoginPage();
			loginObject = new LoginPage(driver);
			//loginObject.UserLogin(email, password);
			Assert.assertTrue(registerObject.logoutBtn.getText().contains("Log out"));
			registerObject.userLogout();
	}
}
