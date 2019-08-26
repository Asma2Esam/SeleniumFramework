package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase
{
	public HomePage(WebDriver driver) 
	{
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}
	@FindBy(linkText = "Register")
	WebElement registerLink;
	@FindBy(linkText = "Log in")
	WebElement loginLink;
	@FindBy(linkText= "Contact us")
	WebElement contactPage;
	@FindBy(id= "customerCurrency")
	WebElement currencyList;
	@FindBy(linkText= "Computers")
	WebElement computersMenu;
	@FindBy(linkText= "Notebooks")
	WebElement notebooksLink;
	public void OpenRegisterationPage()
	{
		ClickButton(registerLink);
	}
	public void OpenLoginPage()
	{
		ClickButton(loginLink);
	}
	public void OpenContactUsPage()
	{
		ScrollToButtom();
		ClickButton(contactPage);
	}
	public void OpenCurrencyList()
	{
		select = new Select(currencyList);
		select.selectByVisibleText("Euro");
	}
	public void SelectNotebooksMenu()
	{
		action.moveToElement(computersMenu).moveToElement(notebooksLink).click().build().perform();
	}

}
