package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;


public class ChangeCurrencyTest extends TestBase
{

	HomePage homeObject;
	ProductDetailsPage detailsObject;
	String productName="Apple MacBook Pro 13-inch";
	@Test (priority=1)
	public void UserCanChangeCurrency()
	{
		homeObject = new HomePage (driver);
		homeObject.OpenCurrencyList();
	}
	SearchPage searchObject;
	@Test (priority=2)
	public void UserCanSearchForProducts()
	{
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		searchObject.SearchUsingAutoSuggest("MacB");
		Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(), productName);
		Assert.assertTrue(detailsObject.productPriceLbl.getText().contains("Ђ"));
		System.out.println(detailsObject.productPriceLbl.getText());
	}
	

}
