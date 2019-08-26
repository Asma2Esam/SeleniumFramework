package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase
{
	public EmailFriendPage(WebDriver driver) 
	{
		super(driver);
	}
	@FindBy(id = "FriendEmail")
	WebElement friendEmailTxtBox;
	@FindBy(id= "PersonalMessage")
	WebElement messageTxtBox;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/input")
	WebElement sendBtn;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]")
	public WebElement successMsg;
	public void EmailFriend(String friendEmail, String message)
	{
		setTextElementText(friendEmailTxtBox, friendEmail);
		setTextElementText(messageTxtBox, message);
		ClickButton(sendBtn);
	}

}
