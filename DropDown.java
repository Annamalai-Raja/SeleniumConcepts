package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDown extends BaseClass{

	
	@Test
	public void dropdownTest() throws Exception {
		driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='Dropdown']")).click();
		
		WebElement dd = driver.findElement(By.xpath("//button[@id='dropdownMenuButton']"));
		Select select = new Select(dd);
		select.selectByVisibleText("Page Scroll");
		
	}
}
