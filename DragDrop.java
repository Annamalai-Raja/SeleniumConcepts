package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragDrop extends BaseClass{

	@Test
	public void draddropTest() throws Exception {
		driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='Drag and Drop']")).click();
		
		WebElement dragElement =driver.findElement(By.xpath("//div[@id='image']//img"));
		WebElement dropElemment = 	driver.findElement(By.xpath("//div[@id='box']"));
		
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.dragAndDrop(dragElement, dropElemment);
		Thread.sleep(2000);
	}
}
