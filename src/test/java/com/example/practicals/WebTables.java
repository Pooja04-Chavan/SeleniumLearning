package com.example.practicals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTables {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        Thread.sleep(2000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

      List<WebElement> totalrows= driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr"));
        System.out.println(totalrows.size());
        List<WebElement> totalColumns= driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr/th"));
        System.out.println(totalColumns.size());
        System.out.println(totalrows.get(3).getText());

    }
}
