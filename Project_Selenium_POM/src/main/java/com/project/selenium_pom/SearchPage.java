package com.project.selenium_pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageObject{

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "q")
	private WebElement searchBox;
		
	public boolean isInitialized() {
		return searchBox.isDisplayed();
	}
	
	public void searchLink(String search) {
		searchBox.sendKeys(search);
	}

	public LinkPage clickOnSearch() {
		searchBox.submit();
		return new LinkPage(driver);
	}
		
}
