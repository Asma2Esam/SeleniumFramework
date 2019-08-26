package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class EmailFriendTest extends TestBase
{
	
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailFriendPage emailObject;
	String productName="Apple MacBook Pro 13-inch";
	@Test(priority = 1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.OpenRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.UserRegisteration("Asmaa", "Esam", "asmaa98a@gmail.com", "12345678");
		Assert.assertTrue(registerObject.successMessage.getText().contains("completed"));
	}
	@Test(priority = 2)
	public void UserCanSearchForProducts()
	{
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		searchObject.SearchUsingAutoSuggest("MacB");
		Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(), productName);
	}
	@Test(priority = 3)
	public void RegisteredUserCanSendProductToFriend()
	{
		detailsObject.OpenSendEmail();
		emailObject = new EmailFriendPage(driver);
		emailObject.EmailFriend("dsf@dsf.co", "Hello my friend");
		Assert.assertTrue(emailObject.successMsg.getText().contains("Your message has been sent."));
	}
	@Test(priority = 4)
	public void RegisteredUserCanLogout()
	{
		registerObject.userLogout();
	}
	
}