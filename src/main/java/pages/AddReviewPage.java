package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddReviewPage extends PageBase
{
	public AddReviewPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (id = "AddProductReview_Title")
	WebElement reviewTitleTxtBox;
	@FindBy (id = "AddProductReview_ReviewText")
	WebElement reviewTextTxtBox;
	@FindBy (id = "addproductrating_4")
	WebElement ratingRdoBtn;
	@FindBy (css = "input.button-1.write-product-review-button")
	WebElement submitBtn;
	@FindBy (css = "div.result")
	public WebElement successMsg;
	public void AddReview (String title, String text)
	{
		setTextElementText(reviewTitleTxtBox, title);
		setTextElementText(reviewTextTxtBox, text);
		ClickButton(ratingRdoBtn);
		ClickButton(submitBtn);
	}
}
