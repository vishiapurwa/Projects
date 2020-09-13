package com.project.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.project.pagebeans.ConferenceBean;
import com.project.utils.Utils;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ConferenceStepDefinitions {
	private WebDriver driver;
	private ConferenceBean conferenceBean;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\apurwa\\chromedriver.exe");
		driver =Utils.getWebDriver();
	}

	@Given("^User is on Conference Page$")
	public void user_is_on_conference_page() throws Throwable {
		driver.get("C:\\Users\\apurwa\\Downloads\\ConferenceBooking\\ConferenceRegistartion.html");
		conferenceBean = PageFactory.initElements(driver, ConferenceBean.class);
	}

	@When("^User hit 'Next' button without entering 'FirstName'$")
	public void user_hit_next_button_without_entering_firstname() throws Throwable {
		conferenceBean.setFirstName("");
		conferenceBean.submit();
	}

	@When("^User hit 'Next' button without entering 'LastName'$")
	public void user_hit_next_button_without_entering_lastname() throws Throwable {
		conferenceBean.setFirstName("Apurwa");
		conferenceBean.setLastName("");
		conferenceBean.submit();
	}

	@When("^User hit 'Next' button without entering 'Email'$")
	public void user_hit_next_button_without_entering_email() throws Throwable {
		conferenceBean.setLastName("Sharma");
		conferenceBean.setEmail("");
		conferenceBean.submit();
	}

	@When("^User hit 'Next' button without entering 'ContactNo'$")
	public void user_hit_next_button_without_entering_contactno() throws Throwable {
		conferenceBean.setEmail("abc@gmail.com");
		conferenceBean.setContactNo("");
		conferenceBean.submit();
	}

	@When("^User hit 'Next' button after entering invalid 'ContactNo'$")
	public void user_hit_next_button_after_entering_invalid_contactno() throws Throwable {
		conferenceBean.setContactNo("987618990");
		conferenceBean.submit();
	}

	@When("^User hit 'Next' button without selecting 'NumberOfPeopleAttending'$")
	public void user_hit_next_button_without_selecting_numberofpeopleattending() throws Throwable {
		conferenceBean.setContactNo("2");
		conferenceBean.submit();
	}

	@When("^User hit 'Next' button without entering 'Address1'$")
	public void user_hit_next_button_without_entering_address1() throws Throwable {
		conferenceBean.setNoOfPeopleAttending(1);
		conferenceBean.setAddress1("");
		conferenceBean.submit();
	}

	@When("^User hit 'Next' button without entering 'Address2'$")
	public void user_hit_next_button_without_entering_address2() throws Throwable {
		conferenceBean.setAddress1("House No-12/4");
		conferenceBean.setAddress2("");
		conferenceBean.submit();
	}

	@When("^User hit 'Next' button without slecting 'City'$")
	public void user_hit_next_button_without_slecting_city() throws Throwable {
		conferenceBean.setAddress2("Jai Prakash Ngar");
		conferenceBean.setCity(0);
		conferenceBean.submit();
	}

	@When("^User hit 'Next' button without slecting 'State'$")
	public void user_hit_next_button_without_slecting_state() throws Throwable {
		conferenceBean.setCity(2);
		conferenceBean.setState(0);
		conferenceBean.submit();
	}

	@When("^User hit 'Next' button without slecting 'Membership'$")
	public void user_hit_next_button_without_slecting_membership() throws Throwable {
		conferenceBean.setState(2);
		// conferenceBean.selectMember();
		conferenceBean.submit();
	}

	@When("^User fill the all the fields with valid credentials$")
	public void user_fill_the_all_the_fields_with_valid_credentials() throws Throwable {
		conferenceBean.setFirstName("Apurwa");
		conferenceBean.setLastName("Sharma");
		conferenceBean.setEmail("abc@gmail.com");
		conferenceBean.setContactNo("9876189902");
		conferenceBean.setNoOfPeopleAttending(1);
		conferenceBean.setAddress1("House No-12/4");
		conferenceBean.setAddress2("Jai Prakash Ngar");
		conferenceBean.setCity(2);
		conferenceBean.setState(2);
		conferenceBean.selectMember();
		conferenceBean.submit();
	}

	@Then("^Displays 'Please fill the First Name'$")
	public void displays_please_fill_the_first_name() throws Throwable {
		String expectedMessage = "Please fill the First Name";
		String actualMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.switchTo().alert().accept();
	}

	@Then("^Displays 'Please fill the Last Name'$")
	public void displays_please_fill_the_last_name() throws Throwable {
		String expectedMessage = "Please fill the Last Name";
		String actualMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.switchTo().alert().accept();

	}

	@Then("^Displays 'Please fill the Email'$")
	public void displays_please_fill_the_email() throws Throwable {
		String expectedMessage = "Please fill the Email";
		String actualMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.switchTo().alert().accept();

	}

	@Then("^Displays 'Please fill the ContactNo'$")
	public void displays_please_fill_the_contactno() throws Throwable {
		String expectedMessage = "Please fill the Contact No.";
		String actualMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.switchTo().alert().accept();

	}

	@Then("^Displays 'Enter 10 digit ContactNo'$")
	public void displays_enter_10_digit_contactno() throws Throwable {
		String expectedMessage = "Enter 10-digit Contact no.";
		String actualMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.switchTo().alert().accept();

	}

	@Then("^Displays 'Please select Number Of People Attending'$")
	public void displays_please_select_number_of_people_attending() throws Throwable {
		String expectedMessage = "Please fill the Number of people attending";
		String actualMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.switchTo().alert().accept();

	}

	@Then("^Displays 'Please fill the Building & Room No'$")
	public void displays_please_fill_the_building_room_no() throws Throwable {
		String expectedMessage = "Please fill the Building & Room No";
		String actualMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.switchTo().alert().accept();
		// driver.close();
	}

	@Then("^Displays 'Please fill the Area name'$")
	public void displays_please_fill_the_area_name() throws Throwable {
		String expectedMessage = "Please fill the Area name";
		String actualMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.switchTo().alert().accept();

	}

	@Then("^Displays 'Please select city'$")
	public void displays_please_select_city() throws Throwable {
		String expectedMessage = "Please select city";
		String actualMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.switchTo().alert().accept();

	}

	@Then("^Displays 'Please select state'$")
	public void displays_please_select_state() throws Throwable {
		String expectedMessage = "Please select state";
		String actualMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.switchTo().alert().accept();

	}

	@Then("^Displays 'Please select membership status'$")
	public void displays_please_select_membership_status() throws Throwable {
		String expectedMessage = "Please Select MemeberShip status";
		String actualMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.switchTo().alert().accept();

	}

	@Then("^Displays 'Personal Details are Validated'$")
	public void displays_personal_details_are_validated() throws Throwable {
		String expectedMessage = "Personal details are validated.";
		String actualMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.switchTo().alert().accept();
		driver.close();
	}

}
