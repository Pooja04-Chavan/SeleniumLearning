package com.example.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
          Thread.sleep(2000);
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.name("name")).sendKeys("pooja chavan");
        driver.findElement(By.name("email")).sendKeys("poojachavan1597@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("pooja123");
        driver.findElement(By.id("exampleCheck1")).click();

        WebElement element=driver.findElement(By.id("exampleFormControlSelect1"));
        Select dropdown=new Select(element);
        dropdown.selectByVisibleText("Female");
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("15-04-1997");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        String successMessage=driver.findElement(By.cssSelector(".alert-success")).getText();

        System.out.println(successMessage);

        driver.close();
    }
}