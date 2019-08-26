package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase
{

	public SearchPage(WebDriver driver) 
	{
		super(driver);
	}
	@FindBy(id = "small-searchterms")
	WebElement searchArea;
	@FindBy(css = "input.button-1.search-box-button")
	WebElement searchBtn;
	@FindBy(id = "ui-id-1")
	List<WebElement> searchList;
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	WebElement productTitle;
	public void ProductSearch(String productName)
	{
		setTextElementText(searchArea, productName);
		ClickButton(searchBtn);
	}
	public void OpenProductDetailsPage()
	{
		ClickButton(productTitle);
	}
	public void SearchUsingAutoSuggest(String searchTxt)
	{
		setTextElementText(searchArea, searchTxt);
		searchList.get(0).click();
	}
}
