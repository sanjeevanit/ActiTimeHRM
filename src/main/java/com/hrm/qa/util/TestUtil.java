package com.hrm.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestUtil {
	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPLICIT_WAIT = 30;

	/*
	 * public static void takeScreenshotAtEndOfTest() throws IOException {
	 * 
	 * File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 * String currentDir = System.getProperty("user.dir");
	 * FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" +
	 * System.currentTimeMillis() + ".png")); }
	 */
}
