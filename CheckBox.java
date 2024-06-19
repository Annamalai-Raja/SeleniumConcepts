package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CheckBox extends BaseClass{

	@Test
	public void checkboxTest() throws Exception {
		driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='Checkbox']")).click();
		
		WebElement checkbox =	driver.findElement(By.id("checkbox-1"));
		
		if(!checkbox.isSelected()) {
			checkbox.click();
		}
	}
	
	
}
