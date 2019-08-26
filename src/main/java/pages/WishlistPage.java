package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.PageBase;

public class WishlistPage extends PageBase
{
	public WishlistPage(WebDriver driver) 
	{
		super(driver);
	}
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[1]/h1")
	public WebElement titleMsg;
}
