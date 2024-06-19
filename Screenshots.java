package com.selenium.practice;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

public class Screenshots extends BaseClass {

	@Test
	public void screenshotTest() throws Exception {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File save_location = new File("E:\\Selenium\\practice\\src\\test\\resources\\screenshot.png");
		FileUtils.copyFile(screenshot, save_location);
	}
}
