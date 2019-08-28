package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegisteration extends TestBase
{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	@Given("^the user in the homepage$")
	public void the_user_in_the_homepage ()
	{
		homeObject = new HomePage(driver);
		homeObject.OpenRegisterationPage();
	}
	@When("^I click in register link $")
	public void I_click_in_register_link ()
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	@When("^I entered the user data$")
	public void I_entered_the_user_data ()
	{
		registerObject = new UserRegisterationPage(driver);
		registerObject.UserRegisteration("Asmaa", "Esam", "dfsf@fds.com", "12345678");
	}
	@Then("^The registeration page displayed successfully$")
	public void The_registeration_page_displayed_successfully ()
	{
		registerObject.userLogout();
	}
	
}
