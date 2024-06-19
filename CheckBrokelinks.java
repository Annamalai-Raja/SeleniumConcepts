package com.selenium.practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBrokelinks {
	public static WebDriver driver;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	
	
	public void checkLink(String url) throws IOException  {
		try {
			URL link = new URL(url);
			HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
			httpconn.setRequestMethod("HEAD");
			httpconn.setConnectTimeout(3000);
			httpconn.connect();
			int responsecode = httpconn.getResponseCode();
			
			if(responsecode>=400) {
				System.out.println(url +"is a broken code");
			}
			else {
				System.out.println(url + "is not a broken code");
			}
			
			
		} catch (MalformedURLException e) {
			System.out.println(url +"is a broken code");
			e.printStackTrace();
		}

	}
	@Test
	public void testLink() throws Exception {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for(WebElement link :links) {
			String url = link.getAttribute("href");
			if(url!=null&&!url.isEmpty()) {
				checkLink(url);
			}
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();

	}

	
	
}
