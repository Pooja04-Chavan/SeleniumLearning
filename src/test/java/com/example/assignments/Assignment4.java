package com.example.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Assignment4 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Multiple Windows")).click();
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> it=windows.iterator();
        String parent= it.next();
        String child= it.next();
        driver.switchTo().window(child);

       String childText= driver.findElement(By.cssSelector(".example h3")).getText();
        System.out.println(childText);

        driver.switchTo().window(parent);
        String parentText=driver.findElement(By.cssSelector(".example h3")).getText();
        System.out.println(parentText);
    }
}
