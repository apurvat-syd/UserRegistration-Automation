package com.krn.actitime.pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TasksPage {
	public void navigateToTasks(WebDriver driver) {
		driver.findElement(By.id("container_tasks")).click();
	}
	public void clickOnAddNew(WebDriver driver) {
		driver.findElement(By.xpath("//div[text()='Add New']")).click();
	}
	public void createCustomer(WebDriver driver) {
		navigateToTasks(driver);
		clickOnAddNew(driver);
	}
	
	

}
