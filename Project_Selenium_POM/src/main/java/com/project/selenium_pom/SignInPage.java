package com.project.selenium_pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageObject{

	public SignInPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@type='email']")
	private WebElement userEmail;
	
	@FindBy(id = "identifierNext")
	private WebElement nextButton;
	
	@FindBy(id = "logo")
	private WebElement title;
	
	public boolean isInitialized() {
		return userEmail.isDisplayed();
	}
	
	public void sendEmail(String email) {
		userEmail.sendKeys(email);
	}
	
	public String clickOnNextButton() {
		nextButton.click();
		return title.getText();
	}

}
