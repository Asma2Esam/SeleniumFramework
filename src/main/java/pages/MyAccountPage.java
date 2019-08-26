package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase
{
	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
	}
	@FindBy (xpath = "/html/body/div[6]/div[3]/div/div[1]/div/div[2]/ul/li[7]/a")
	WebElement changePasswordPage;
	@FindBy (id = "OldPassword")
	WebElement oldPasswordTxtBox;
	@FindBy (id = "NewPassword")
	WebElement newPasswordTxtBox;
	@FindBy (id = "ConfirmNewPassword")
	WebElement confirmPasswordTxtBox;
	@FindBy (xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/form/div[2]/input")
	WebElement changePasswordBtn;
	@FindBy (css = "div.result")
	public WebElement resultLbl;
	public void OpenChangePasswordPage()
	{
		ClickButton(changePasswordPage);
	}
	public void ChangePassword(String oldPassword, String newPassword)
	{
		ClickButton(changePasswordPage);
		setTextElementText(oldPasswordTxtBox, oldPassword);
		setTextElementText(newPasswordTxtBox, newPassword);
		setTextElementText(confirmPasswordTxtBox, newPassword);
		ClickButton(changePasswordBtn);
	}
	
	

}
