package com.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class home {
	WebDriver driver;
	
	public  home(WebDriver driver){
		this.driver = driver;
	}
	//By.className("gb_b gb_cb gb_R");  
	
	By account =By.xpath(".//*[@id='gb']/div[1]/div[1]/div[2]/div[5]/div[1]/a");
	By logout = By.id("gb_71");//.//*[@id='gb_71'] 
	
	
	public WebElement account(){
		return driver.findElement(account);
	}
	
	public WebElement logout(){
		return driver.findElement(logout);
	}

}
