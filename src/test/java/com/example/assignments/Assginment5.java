package com.example.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assginment5 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
        String chText= driver.findElement(By.xpath("//label[@for='benz']")).getText();
        System.out.println(chText);
        driver.findElement(By.id("dropdown-class-example")).sendKeys(chText);
        driver.findElement(By.id("name")).sendKeys(chText);
        driver.findElement(By.id("alertbtn")).click();
        String alertText=driver.switchTo().alert().getText().split("Hello")[1].trim().split(",")[0];
        System.out.println(alertText);
        Assert.assertEquals(alertText,"Option2");

    }
}
