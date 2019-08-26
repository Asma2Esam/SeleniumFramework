package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends PageBase
{
	public UserRegisterationPage(WebDriver driver) 
	{
		super(driver);
	}
	@FindBy (id = "gender-female")
	WebElement genderRdoBtn;
	@FindBy (id = "FirstName")
	WebElement fnTxtBox;
	@FindBy (id = "LastName")
	WebElement lnTxtBox;
	@FindBy (id = "Email")
	WebElement emailTxtBox;
	@FindBy (id = "Password")
	WebElement passwordTxtBox;
	@FindBy (id = "ConfirmPassword")
	WebElement confirmPasswordTxtBox;
	@FindBy (id = "register-button")
	WebElement registerBtn;
	@FindBy (css = "div.result")
	public WebElement successMessage;
	@FindBy (linkText = "Log out")
	public WebElement logoutBtn;
	@FindBy (linkText = "My account")
	WebElement myAccountPage;
	public void UserRegisteration(String firstName, String lastName, String email, String password)
	{
		ClickButton(genderRdoBtn);
		setTextElementText(fnTxtBox, firstName);
		setTextElementText(lnTxtBox, lastName);
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		setTextElementText(confirmPasswordTxtBox, password);
		ClickButton(registerBtn);
	}
	public void userLogout()
	{
		ClickButton(logoutBtn);
	}
	public void openMyAccountPage()
	{
		ClickButton(myAccountPage);
	}

}
