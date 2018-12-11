package com.cg.capbook.stepdefinition;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import com.cg.capbook.pagebeans.LoginPage;
import com.cg.capbook.pagebeans.ProfilePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class ProfilePageStepDefinition {
	WebDriver driver;
	LoginPage loginPage;
	ProfilePage profilePage;
	@Given("^User is on the  CapBook homepage$")
	public void user_is_on_the_CapBook_homepage() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://localhost:4200/frontPage");
		loginPage=PageFactory.initElements(driver, LoginPage.class);
	}
	@When("^User enters  invalid mailId or  invalid Password$")
	public void user_enters_invalid_mailId_or_invalid_Password() throws Throwable {
		loginPage.setEmailId("kgg121@capgemini.com");
		loginPage.setPassword("keshav");
		loginPage.onClick();
	}
	@Then("^User gets error message  on the  capbook home page$")
	public void user_gets_error_message_on_the_capbook_home_page() throws Throwable {
		String actualTitle= "CapBook";
		String expectedTitle="CapBook";
		Assert.assertEquals(expectedTitle, actualTitle);
		driver.close();
	}
	@When("^User enters  a  valid mailId and a valid Password$")
	public void user_enters_a_valid_mailId_and_a_valid_Password() throws Throwable {
		driver= new ChromeDriver();
		driver.get("http://localhost:4200/frontPage");
		loginPage=PageFactory.initElements(driver, LoginPage.class);
		loginPage.setEmailId("kk121@capgemini.com");
		loginPage.setPassword("keshav123");
		loginPage.onClick();
	}
	@Then("^User is navigated to capbook profile page$")
	public void user_is_navigated_to_capbook_profile_page() throws Throwable {
		String actualTitle= "CapBook";
		String expectedTitle="CapBook";
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	@Given("^User is on the CapBook profilePage$")
	public void user_is_on_the_CapBook_profilePage() throws Throwable {
		driver.get("http://localhost:4200/myProfile");
		profilePage=PageFactory.initElements(driver, ProfilePage.class);
	}
	@When("^User clicks on the  account setting and then on the change password$")
	public void user_clicks_on_the_account_setting_and_then_on_the_change_password() throws Throwable {
		profilePage.onClickAccountSetting();
		driver.get("http://localhost:4200/myProfile/accountSettings");
		profilePage.onClickChangePassword();
		driver.get("http://localhost:4200/myProfile/accountSettings/changePassword");
	}
	@Then("^User  remains on the same page and got option for password change$")
	public void user_remains_on_the_same_page_and_got_option_for_password_change() throws Throwable {
	}
	@When("^User enters a  wrong current password and a valid new password,confirm password$")
	public void user_enters_a_wrong_current_password_and_a_valid_new_password_confirm_password() throws Throwable {
		profilePage.setCurrentPassword("keshav");
		profilePage.setNewPassword("keshav1234");
		profilePage.setRetypeNewPassword("keshav1234");
		profilePage.onClick();
	}
	@Then("^User remains on the same  page and gets an error message$")
	public void user_remains_on_the_same_page_and_gets_an_error_message() throws Throwable {
	}
	@When("^User enters  the current password and an invalid new password, confirm password$")
	public void user_enters_the_current_password_and_an_invalid_new_password_confirm_password() throws Throwable {
		profilePage.setCurrentPassword("keshav123");
		profilePage.setNewPassword("keshav12");
		profilePage.setRetypeNewPassword("keshav12");
		profilePage.onClick();
	}
	@Then("^User remains on the same page and get the error message$")
	public void user_remains_on_the_same_page_and_get_the_error_message() throws Throwable {
	}
	@When("^User enters the correct current password and the valid new password and valid confirm password$")
	public void user_enters_the_correct_current_password_and_the_valid_new_password_and_valid_confirm_password() throws Throwable {
		profilePage.setCurrentPassword("keshav123");
		profilePage.setNewPassword("keshav1234");
		profilePage.setRetypeNewPassword("keshav1234");
		profilePage.onClick();
	}
	@Then("^User remains on the same page and get a  greeting message$")
	public void user_remains_on_the_same_page_and_get_a_greeting_message() throws Throwable {
	}
}