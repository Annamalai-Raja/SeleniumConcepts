package com.selenium.practice;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class switchWindow extends BaseClass {

	@Test
	public void switchwindowTest() throws Exception {
		driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='Switch Window']")).click();
		
		String parentwindow =driver.getWindowHandle();
		
		driver.findElement(By.xpath("//button[@id='new-tab-button']")).click();
		
		Set<String> allwindow = driver.getWindowHandles();
		
		for(String newwindow:allwindow) {
			if(!newwindow.equalsIgnoreCase(parentwindow)) {
				driver.switchTo().window(newwindow);
			}
		}
		 System.out.println("Title of new window: " + driver.getTitle());
		 
		 driver.close();
		driver.switchTo().window(parentwindow);
	}
}
