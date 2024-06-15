package com.example.practicals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandles {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> iterator=windows.iterator();
        String parent=iterator.next();
        String child= iterator.next();

        driver.switchTo().window(child);
        driver.findElement(By.cssSelector(".im-para.red")).getText();
        String emailId=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];

        driver.switchTo().window(parent);
        driver.findElement(By.id("username")).sendKeys(emailId);
    }
}
