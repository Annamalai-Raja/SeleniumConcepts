package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class PageScroll extends BaseClass {
	@Test	
	public void pagescollTest() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='Page Scroll']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0 , document.body.scrollHeight)");
	}
}
