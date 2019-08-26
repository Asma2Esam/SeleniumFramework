package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase
{
	public ContactUsPage(WebDriver driver) 
	{
		super(driver);
	}
	@FindBy(id = "FullName")
	WebElement nameTxtBox;
	@FindBy(id= "Email")
	WebElement emailTxtBox;
	@FindBy(id = "Enquiry")
	WebElement enquiryTxtBox;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/input")
	WebElement submitBtn;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]")
	public WebElement successMsg;
	public void ContactUS(String name, String email, String enquiry)
	{
		setTextElementText(nameTxtBox, name);
		setTextElementText(emailTxtBox, email);
		setTextElementText(enquiryTxtBox, enquiry);
		ClickButton(submitBtn);
	}

}
