package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase
{
	HomePage home;
	ContactUsPage contactObject;
	String email = "asmaaaaaa@gmail.com";
	String name = "Asmaa";
	String enquiry ="what should i do if i have something that annoynig me and criticizing me";
	@Test
	public void UserCanContactUs()
	{
		home = new HomePage(driver);
		contactObject = new ContactUsPage(driver);
		home.OpenContactUsPage();
		contactObject.ContactUS(name, email, enquiry);
		Assert.assertTrue(contactObject.successMsg.getText().contains("successfully "));
	}
}
