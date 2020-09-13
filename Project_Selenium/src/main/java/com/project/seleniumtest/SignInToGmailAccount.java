package com.project.seleniumtest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignInToGmailAccount {
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\apurwa\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys("gmail");
		search.submit();
		
		driver.findElement(By.partialLinkText("Gmail")).click();
		driver.findElement(By.linkText("Sign in")).click();
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
		WebElement userEmail=driver.findElement(By.xpath("//input[@type='email']"));
		userEmail.sendKeys("vishiapurwa");
		driver.findElement(By.id("identifierNext")).click();
		driver.close();
		driver.quit();
		
	}
	
}
