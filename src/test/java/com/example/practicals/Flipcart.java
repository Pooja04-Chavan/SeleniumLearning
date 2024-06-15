package com.example.practicals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.testng.Assert;
public class Flipcart {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.flipkart.com/");
        // Thread.sleep(5000);


        driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("iphone 15");
        // driver.findElement(By.xpath("//*[name()='svg']/*[text()='Search Icon']")).click();
        List<WebElement> svgElements = driver.findElements(By.xpath("//*[local-name()='svg']"));
        svgElements.get(0).click();

        List<WebElement> list_of_iphones = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
        for (WebElement element : list_of_iphones) {

            if (list_of_iphones.size() >= 5) {
               // String productName=list_of_iphones.get(4).getText();
                list_of_iphones.get(4).click();

                break;
            }
        }
        String productName=list_of_iphones.get(4).getText();
       // System.out.println(productName);
        //add to cart button
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ In9uk2']")).click();


        String cartProduct=driver.findElement(By.xpath("//div[@class='gE4Hlh']/a")).getText();
       // System.out.println(cartProduct);

        Assert.assertEquals(productName,cartProduct);
    }
}