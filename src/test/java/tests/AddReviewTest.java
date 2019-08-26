package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddReviewPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class AddReviewTest extends TestBase
{
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	AddReviewPage reviewObject;
	String productName="Apple MacBook Pro 13-inch";
	@Test(priority = 1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.OpenRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.UserRegisteration("Asmaa", "Esam", "asmaaaaawea@gmail.com", "12345678");
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
	public void UserCanAddReviewOnProducts()
	{
		reviewObject = new AddReviewPage(driver);
		detailsObject.OpenAddReview();
		reviewObject.AddReview("SpongePop", "Hi Hi cptin");
		Assert.assertTrue(reviewObject.successMsg.getText().contains("Product review is successfully added."));
	}
	@Test(priority = 4)
	public void RegisteredUserCanLogout()
	{
		registerObject.userLogout();
	}

}
