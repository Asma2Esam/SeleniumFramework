package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishlistPage;

public class AddProductToWishlistTest extends TestBase
{
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	WishlistPage wishlistObject;
	@Test
	public void UserCanSearchForProducts()
	{
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		searchObject.SearchUsingAutoSuggest("MacB");
		Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(), productName);
	}
	public void UserCanAddProductToWishlist()
	{
		detailsObject.SelectWishlistOption();
		detailsObject.OpenWishlistLink();
		Assert.assertTrue(wishlistObject.titleMsg.getText().contains("Wishlist"));
	}
}
