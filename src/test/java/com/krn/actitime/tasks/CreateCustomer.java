package com.krn.actitime.tasks;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.krn.actitime.pageclass.TasksPage;
import com.krn.actitime.testBase.BaseClass;
import com.krn.actitime.testBase.ExcelLibrary;

public class CreateCustomer extends BaseClass {
	@Test
	public void testCreateCustomer() {
		
		tp.navigateToTasks(driver);
		tp.clickOnAddNew(driver);
		driver.findElement(By.xpath("//div[text()='+ New Customer']")).click();
		
		String Customername=xlib.getexcelData("CreateCustomer", 1, 0);
		String desc=xlib.getexcelData("DeleteCustomer", 1, 1);
		
		driver.findElement(By.xpath("(//input[@placeholder='Enter Customer Name'])[2]")).sendKeys(Customername);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']")).sendKeys(desc);
		driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
		
	}

}
