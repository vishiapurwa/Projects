package com.project.selenium_pom;

import java.util.Iterator;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailPage extends PageObject{

	public GmailPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Sign in")
	private WebElement signInButton;
	
	public boolean isInitialized() {
		return signInButton.isDisplayed();
	}
	
	public SignInPage clickOnSignInButton() {
		signInButton.click();
		return new SignInPage(driver);
	}
	
	
	public boolean  switchToNewWindow() {
		Set<String> handles = driver.getWindowHandles(); 
		String parent =driver.getWindowHandle();
		Iterator<String> iterator= handles.iterator();
		while(iterator.hasNext())
		{
		String child_window=iterator.next();
		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		System.out.println(driver.switchTo().window(child_window).getTitle());
		}
		}
		return true;
	}
	
	
}
