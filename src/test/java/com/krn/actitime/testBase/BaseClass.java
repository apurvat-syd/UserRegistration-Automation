package com.krn.actitime.testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.krn.actitime.pageclass.TasksPage;

public class BaseClass {
	public WebDriver driver;
	public ExcelLibrary xlib;
	public TasksPage tp;

	@BeforeClass
	public void openBrowser() {
		driver = new ChromeDriver();
		System.setProperty("WebDriver.chrome.driver", "/apurva/workspace/actitime/chromedriver");
		tp=new TasksPage();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void login() {
		ExcelLibrary xlib=new ExcelLibrary();
		String un=xlib.getexcelData("Login", 1, 0);
		String pw=xlib.getexcelData("Login", 1, 1);
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();

	}

	@AfterMethod
	public void logout() {
		driver.findElement(By.id("logoutLink")).click();

	}

	@AfterClass
	public void closeBrowser() {
		driver.close();

	}
}
