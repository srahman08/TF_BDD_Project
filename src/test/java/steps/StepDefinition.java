package steps;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import page.AddNewAccount;
import page.LoginPage;
import util.BrowserFactory;


public class StepDefinition {
	WebDriver driver;
	LoginPage loginPage;
	AddNewAccount addnew;
	@Before
	public void beforeRun() {
		driver= BrowserFactory.startBrowser();
		loginPage=PageFactory.initElements(driver, LoginPage.class);
		addnew=PageFactory.initElements(driver, AddNewAccount.class);
	}
	@Given("^User is on the Techfios Login page$")
	public void User_is_on_the_Techfios_Login_page() throws InterruptedException {
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		Thread.sleep(2000);
	}
	
	@Given("^User enters username as \"([^\"]*)\"$")
	public void User_enters_username_as(String userName) throws InterruptedException {
		loginPage.enterUserName(userName);

	}
			
	@Given("^User enters password as \"([^\"]*)\"$")
	public void User_enters_password_as(String password) throws InterruptedException { 
		loginPage.enterPassword(password);
		Thread.sleep(1000);

	}
	@When("^User clicks on signin button$")
	public void User_clicks_on_signin_button() throws InterruptedException {
		loginPage.clickOnSignInButton();
		Thread.sleep(2000);

	}
	
	@Then("^User should land on Dashboard page$")
	public void User_should_land_on_Dashboard_page() throws IOException, InterruptedException {
		Thread.sleep(3000);
		loginPage.takeScreenshotAtEndOfTest(driver);
		Assert.assertEquals("===ERROR===", "Dashboard- iBilling", loginPage.getPageTitle());
		loginPage.takeScreenshotAtEndOfTest(driver);
		
		}
	
	@Given("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_userName_and_password(String userName, String password) throws Throwable {
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
	}
	
	@When("^The user enters Bank&Cash button$")
	public void the_user_enters_Bank_Cash_button()  {
		addnew.bankAndCashTab();
	}

	@When("^User enters New customer button$")
	public void user_enters_New_customer_button()  {
	    addnew.newAccountTab();
	}

	@Then("^User land on New Account page$")
	public void user_land_on_New_Account_page() {
	   addnew.accountsPageValidation();
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and_and(String arg1, String arg2, String arg3)  {
	    addnew.accountTitleName(arg1);
	    addnew.initBalance(arg2);
	    addnew.contactPersonName(arg3);
	}

	@When("^click on the Save Button$")
	public void click_on_the_Save_Button() {
	   addnew.clickSubmit();
	}

	@Then("^account should be created$")
	public void account_should_be_created() throws IOException  {
		addnew.accountCreatedSuccess();
		loginPage.takeScreenshotAtEndOfTest(driver);

	}
	
	  @After 
	  public void tearDown() { 
		  driver.close();
		  driver.quit(); }
	  
	 
}
