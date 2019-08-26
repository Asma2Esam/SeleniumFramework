package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase
{
	public ProductDetailsPage(WebDriver driver) 
	{
		super(driver);
	}
	@FindBy(css = "strong.current-item")
	public WebElement productNameBreadCrumb;
	@FindBy(css = "span.price-value-4")
	public WebElement productPriceLbl;
	@FindBy(xpath = "//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[10]/div[3]/input")
	public WebElement emailFriendBtn;
	@FindBy(linkText = "Add your review")
	public WebElement addReviewLink;
	@FindBy(id = "add-to-wishlist-button-4")
	public WebElement wishlistOpt;
	@FindBy(linkText = "wishlist")
	public WebElement wishlistLink;
	public void OpenSendEmail()
	{
		ClickButton(emailFriendBtn);
	}
	public void OpenAddReview()
	{
		ClickButton(addReviewLink);
	}
	public void SelectWishlistOption()
	{
		ClickButton(wishlistOpt);
	}
	public void OpenWishlistLink()
	{
		ClickButton(wishlistLink);
	}
}
