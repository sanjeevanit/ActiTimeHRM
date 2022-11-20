package com.hrm.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class ReviewLeavePage extends TestBase {
	public ReviewLeavePage() {
		PageFactory.initElements(driver, this);
	}

	public String validatePgTitle() {

		return driver.getTitle();
	}

}
