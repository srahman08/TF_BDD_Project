package page;

import java.util.List;
import java.util.Random;

import javax.swing.text.Element;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewAccount {

	WebDriver driver;
	int randomNumber;

	public AddNewAccount(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Bank & Cash')]")
	WebElement Bank_And_Cash;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'New Account')]")
	WebElement New_Account;

	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement Account_Title;
	@FindBy(how = How.XPATH, using = "//input[@id='description']")
	WebElement Description;
	@FindBy(how = How.XPATH, using = "//input[@id='balance']")
	WebElement Balance;
	@FindBy(how = How.XPATH, using = "//input[@id='account_number']")
	WebElement Account_Number;
	@FindBy(how = How.XPATH, using = "//input[@id='contact_person']")
	WebElement Contact_Person;
	@FindBy(how = How.XPATH, using = "//input[@id='contact_phone']")
	WebElement Phone_Contact;
	@FindBy(how = How.XPATH, using = "//input[@id='ib_url']")
	WebElement Banking_URL;
	@FindBy(how = How.XPATH, using = "(//button[@type='submit'])[2]")
	WebElement Submit_Button;
	@FindBy(how = How.XPATH, using = "//i[@class='fa-fw fa fa-check']")
	WebElement ACCOUNT_CREATED_SUCCESS;
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),' Accounts ')]")
	WebElement NEW_ACCOUNT_PAGE;

	public void bankAndCashTab() {
		Bank_And_Cash.click();
	}

	public void newAccountTab() {

		New_Account.click();
	}

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Accounts')]")
	WebElement Accounts_Header;

	public static int randomNumberGenerator(int theRandomNumber) {
		Random rnd = new Random();
		int randomNumber = rnd.nextInt(theRandomNumber);
		return randomNumber;
	}

	public void accountsPageValidation() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(Accounts_Header));
		Assert.assertEquals("Page Not Found !!", "Accounts", Accounts_Header.getText());

	}

	String accountTitle;

	public void accountTitleName(String newAccountTile) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(Description));
		// Thread.sleep(2000);
		int randomNumber = randomNumberGenerator(99);
		accountTitle = newAccountTile + randomNumber;
		Account_Title.sendKeys(accountTitle);
	}

	public void accountDescription(String accountDesc) {
		int randomNumber = randomNumberGenerator(99);
		Description.sendKeys(accountDesc + randomNumber);
	}

	public void initBalance(CharSequence accountBalance) {
		CharSequence blcCharSequence = "accountBalance";
		int randomNumber = randomNumberGenerator(9999);
		accountBalance = "accountBalance" + randomNumber;
		Balance.sendKeys(accountBalance);
	}

	public void accountNUmber(String accountNumb) {
		int randomNumber = randomNumberGenerator(99);
		accountNumb = accountNumb + randomNumber;
		Account_Number.sendKeys(accountNumb);
	}

	public void contactPersonName(String contactPerson) {
		int randomNumber = randomNumberGenerator(99);
		contactPerson = contactPerson + randomNumber;
		Contact_Person.sendKeys(contactPerson);
	}

	public void phoneNumber(String phoneNumber) {
		int randomNumber = randomNumberGenerator(9999);
		phoneNumber = phoneNumber + randomNumber;
		Phone_Contact.sendKeys(phoneNumber);
	}

	public void bankURL(String bankingURLaddress) {
		Banking_URL.sendKeys(bankingURLaddress);
	}

	public void clickSubmit() {
		Submit_Button.click();
	}

	public void accountCreatedSuccess() {
		String expectedtext = "Account Created Successfully";
		String acutalText = ACCOUNT_CREATED_SUCCESS.getText();

		System.out.println(ACCOUNT_CREATED_SUCCESS.getText());

		if (expectedtext.contains(acutalText)) {
			System.out.println("*********walaaaaaaa**********");

		} else
			System.out.println(">>>>>>you are screwed<<<<<<<");

	}

}