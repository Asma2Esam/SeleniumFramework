package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchUsingAutoSuggestTest extends TestBase
{
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	@Test
	public void UserCanSearchForProducts()
	{
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		searchObject.SearchUsingAutoSuggest("MacB");
		Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(), productName);
	}

}
