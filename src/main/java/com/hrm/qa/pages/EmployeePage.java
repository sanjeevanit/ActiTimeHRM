package com.hrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class EmployeePage extends TestBase {
	
	
	public EmployeePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyPgTitle() {

		return driver.getTitle();
	}

	public void clickEmployee() {
		driver.findElement(
				By.xpath("//select[@name='recordsPerPage' and @id='recordsPerPageSelector']//option[@value='100']"))
				.click();
	}

}
