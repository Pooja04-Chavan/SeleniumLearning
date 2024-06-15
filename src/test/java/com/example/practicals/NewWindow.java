package com.example.practicals;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class NewWindow {
    public static void main(String[] args) throws IOException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> it=windows.iterator();
        String parentWindow=it.next();
        String childWindow=it.next();
        driver.switchTo().window(childWindow);
        driver.get("https://rahulshettyacademy.com/");

        String courseName=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
                .get(1).getText();
        driver.switchTo().window(parentWindow);

        WebElement name=driver.findElement(By.cssSelector("[name='name"));
        name.sendKeys(courseName);

        //Get screenshot of webelement
        File file=name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("logo.png"));

        //get height and width
       System.out.println(name.getRect().getDimension().getHeight());

       System.out.println(name.getRect().getDimension().getWidth());
    }
}
