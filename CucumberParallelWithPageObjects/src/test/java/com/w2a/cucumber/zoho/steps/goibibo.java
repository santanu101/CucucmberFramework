package com.w2a.cucumber.zoho.steps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.w2a.zoho.utilities.DriverManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class goibibo {
	WebDriver driver = null;
	
	 @Given("^launch chrome$")
	 
	 public void userhomepage(){
		// System.setProperty("webdriver.chrome.driver","E:\\Jars\\chrome\\chromedriver.exe");
		// WebDriver driver = new ChromeDriver();
		 driver = DriverManager.getDriver();
		 driver.navigate().to("https://www.goibibo.com/");
	 }
	 @Then("^user enter '(.*?)' and '(.*?)'$")
		 public void user_enter (String arg1, String arg2) throws InterruptedException 
		 {
		 driver = DriverManager.getDriver();
		 System.out.println(arg1+arg2);
		 Thread.sleep(8000);
		      WebElement src = driver.findElement(By.xpath("//input[@id='gosuggest_inputSrc']"));
		      src.sendKeys(arg1);
		      Thread.sleep(1000);
		      src.sendKeys(Keys.DOWN);
		      src.sendKeys(Keys.ENTER);
		      Thread.sleep(5000);
		      WebElement src1= driver.findElement(By.xpath("//input[@id='gosuggest_inputDest']"));
		      src1.sendKeys(arg2);
		      Thread.sleep(1000);
		      src1.sendKeys(Keys.DOWN);
		      src1.sendKeys(Keys.ENTER);
		      
		      driver.findElement(By.xpath("//input[@id='departureCalendar']")).click();
		      driver.findElement(By.xpath("//div[@id='fare_20200728']")).click();
		      //driver.findElement(By.xpath("//*[@id='departureCalendar']")).sendKeys(arg3);
		      
		      
		  
		 }
	 @Then("^user click on search$")
		public void user_click_on_search() throws Throwable {
			
		driver.findElement(By.xpath("//button[@id='gi_search_btn']")).click();
		   
		}
	 @Then("^user click on Evening Flight$")
		public void user_click_on_Evening() throws Throwable {
			
		WebElement evening= driver.findElement(By.xpath("//span[contains(text(), '4pm - 9pm')]"));
		evening.click();
		   
	 }

@Then("^user will get all the prices from the table$")
public void user_will_get_all_the_prices_from_the_table()throws Throwable {
	
	//get all the prices from the table

	List<WebElement> price = driver.findElements(By.xpath("//*[@class='ico20 fb quicks']"));

	System.out.println(price.size());

	//put all the prices into array list and get the lowest prices

	ArrayList<Integer> prices=new ArrayList<Integer>();

	for(int i=0;i<price.size();i++){

	//System.out.println(price.get(i).getText());

	Integer priceInt = Integer.valueOf(price.get(i).getText().replace(",", ""));

	prices.add(priceInt);

	}

	Integer minPrice = Collections.min(prices);

	System.out.println("Min Price is "+minPrice);
}


@Then("^user will get fastest flight$")
public void user_will_get_fastest_flight()throws Throwable {
	Thread.sleep(5000);
	WebElement fastest= driver.findElement(By.xpath("//div[text()='Stops']/following::span[1]"));
	fastest.click();
	
}

@Then("^user will click on Book$")
public void user_will_click_on_Book()throws Throwable {
	Thread.sleep(5000);
	WebElement Book= driver.findElement(By.xpath("(//input[@type='button' and @value='BOOK'])[1]"));
	Book.click();
	System.out.println("book button clicked");
}
}
   