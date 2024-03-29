package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase
{

	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}
	@FindBy (id = "Email")
	WebElement emailTxtBox;
	@FindBy (id = "Password")
	WebElement passwordTxtBox;
	@FindBy (xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/input")
	WebElement loginBtn;
	public void UserLogin(String email, String password)
	{
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		ClickButton(loginBtn);
	}
	

}
