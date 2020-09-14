package com.project.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.project.pagebeans.PaymentBean;
import com.project.utils.Utils;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PaymentStefDefinitions {
	private WebDriver driver;
	private PaymentBean paymentBean;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\apurwa\\chromedriver.exe");
		driver = Utils.getWebDriver();
	}

	@Given("^User is on payment page$")
	public void user_is_on_payment_page() throws Throwable {
		driver.get("C:\\Users\\apurwa\\Downloads\\ConferenceBooking\\PaymentDetails.html");
		paymentBean = PageFactory.initElements(driver, PaymentBean.class);
	}

	@When("^User hit 'Register' button without entering 'FirstName'$")
	public void user_hit_register_button_without_entering_firstname() throws Throwable {
		paymentBean.setFirstName("");
		paymentBean.submit();
	}

	@When("^User hit 'Register' button without entering 'LastName'$")
	public void user_hit_register_button_without_entering_lastname() throws Throwable {
		paymentBean.setFirstName("Apurwa");
		paymentBean.setLastName("");
		paymentBean.submit();
	}

	@When("^User hit 'Register' button without entering 'DebitCardNumber'$")
	public void user_hit_register_button_without_entering_debitcardnumber() throws Throwable {
		paymentBean.setLastName("Sharma");
		paymentBean.setCardNumber("");
		paymentBean.submit();
	}

	@When("^User hit 'Register' button without entering 'CVV'$")
	public void user_hit_register_button_without_entering_cvv() throws Throwable {
		paymentBean.setCardNumber("1028018911");
		paymentBean.setCvv("");
		paymentBean.submit();
	}

	@When("^User hit 'Register' button without entering 'ExpirationMonth'$")
	public void user_hit_register_button_without_entering_expirationmonth() throws Throwable {
		paymentBean.setCvv("123");
		paymentBean.setExpirationMonth("");
		paymentBean.submit();
	}

	@When("^User hit 'Register' button without entering 'ExpirationYear'$")
	public void user_hit_register_button_without_entering_expirationyear() throws Throwable {
		paymentBean.setExpirationMonth("09");
		paymentBean.setExpirationYear("");
		paymentBean.submit();
	}

	@When("^User provides all valid payment details$")
	public void user_provides_all_valid_payment_details() throws Throwable {
		paymentBean.setFirstName("Apurwa");
		paymentBean.setLastName("Sharma");
		paymentBean.setCardNumber("1028018911");
		paymentBean.setCvv("123");
		paymentBean.setExpirationMonth("09");
		paymentBean.setExpirationYear("25");
		paymentBean.submit();
	}

	@Then("^Displays 'Please fill the FirstName'$")
	public void displays_please_fill_the_first_name() throws Throwable {
		String expectedMessage = "Please fill the First Name";
		String actualMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.switchTo().alert().accept();
	}

	@Then("^Displays 'Please fill the LastName'$")
	public void displays_please_fill_the_last_name() throws Throwable {
		String expectedMessage = "Please fill the Last Name";
		String actualMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.switchTo().alert().accept();
	}

	@Then("^Displays 'Please fill the Debit card Number'$")
	public void displays_please_fill_the_debit_card_number() throws Throwable {
		String expectedMessage = "Please fill the Debit card Number";
		String actualMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.switchTo().alert().accept();
	}

	@Then("^Displays 'Please fill the CVV'$")
	public void displays_please_fill_the_cvv() throws Throwable {
		String expectedMessage = "Please fill the CVV";
		String actualMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.switchTo().alert().accept();
	}

	@Then("^Displays 'Please fill expiration month'$")
	public void displays_please_fill_expiration_month() throws Throwable {
		String expectedMessage = "Please fill expiration month";
		String actualMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.switchTo().alert().accept();
	}

	@Then("^Displays 'Please fill expiration year'$")
	public void displays_please_fill_expiration_year() throws Throwable {
		String expectedMessage = "Please fill the expiration year";
		String actualMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.switchTo().alert().accept();
	}

	@Then("^Displays 'Registarion successful!!!'$")
	public void displays_registarion_successful() throws Throwable {
		String expectedMessage = "Registarion successful!!!";
		String actualMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.switchTo().alert().accept();
	}

	@After
	public void tearDownScenarioEnv() {
		driver.close();
		driver = null;
	}
}
