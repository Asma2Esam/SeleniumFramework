package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDTandDataProvider extends TestBase
{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	@DataProvider(name = "testData")
	public static Object[][] UserData()
	{
		return new Object[][] {
			{"Asmaa", "Esam", "asmaer3a22322@gmail.com", "123456"},
			{"Saram", "Ahmed", "sarassdfsdfara@gmail.com", "12345678"}};
	}
	@Test(priority = 1, alwaysRun = true, dataProvider = "testData")
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
