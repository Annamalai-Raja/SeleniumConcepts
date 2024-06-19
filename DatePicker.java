package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DatePicker extends BaseClass {

	
	@Test
	public void datepickerTest() throws Exception {
		
		driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='Datepicker']")).click();
		
	WebElement date =	driver.findElement(By.xpath("//input[@id='datepicker']"));
		
		date.sendKeys("03/29/1999");
		/*
		 * while
		 * (!driver.findElement(By.className("datepicker-switch")).getText().contains(
		 * "1999")) { driver.findElement(By.className("datepicker-switch")).click(); }
		 * 
		 * driver.findElement(By.xpath("//td[@class='day'][normalize-space()='29']")).
		 * click();
		 */
	}
}
