package com.project.selenium_pom;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkPage extends PageObject {

	public LinkPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(partialLinkText = "Gmail")
	private WebElement linkForGmail;
	
	public boolean isInitialized() {
		return linkForGmail.isDisplayed();
	}
	
	public GmailPage clickOnLink() {
		linkForGmail.click();
		return new GmailPage(driver);	
	}
}
