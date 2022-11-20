package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class LoginPage extends TestBase {
	@FindBy(name="username")
	WebElement username;

	@FindBy(name="pwd")
	WebElement password;

	@FindBy(xpath = "//a[@id='loginButton']")
	WebElement loginButton;

	@FindBy(xpath = "//input[@name='remember']")
	WebElement keepmeLoggedinCheckBox;

	@FindBy(xpath = "//a[@id='toPasswordRecoveryPageLink']")
	WebElement forgotYourPasswordLink;

	@FindBy(xpath = "//div[@class='atLogoImg']")
	WebElement actiTimeLogo;

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateActiTimeLogo() {
		return actiTimeLogo.isDisplayed();
	}

	public HomePage login(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginButton.click();
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();", loginBtn);
		 */

		return new HomePage();
	}

}
