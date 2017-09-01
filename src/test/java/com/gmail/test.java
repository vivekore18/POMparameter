package com.gmail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gmail.home;
import com.gmail.login;

public class test {
	WebDriver driver;
	
	@Parameters({"url"})
	@BeforeTest
	public void login(String url) {
		
		System.setProperty("webdriver.gecko.driver", "D:\\neon\\POMpara\\src\\test\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		System.out.println("CurrentUrl: "+driver.getCurrentUrl());
	}
	
	@Parameters({"uname" , "upass"})
	@Test
	public void method(String uname, String upass) throws InterruptedException{	
		login l =new login(driver);
		l.username().sendKeys(uname);
		l.nextbtu().click();
		Thread.sleep(2000);
		l.password().sendKeys(upass);
		l.nextbtp().click();
		System.out.println("Title: "+driver.getTitle());
				
		home h =new home(driver);
		Thread.sleep(3000);
		h.account().click();
		Thread.sleep(3000);
		h.logout().click();
		System.out.println("Title :"+driver.getTitle());
		
	}
	
	@AfterTest
	public void teardown() throws InterruptedException{
		Thread.sleep(5000);
		driver.close();
	}
}
