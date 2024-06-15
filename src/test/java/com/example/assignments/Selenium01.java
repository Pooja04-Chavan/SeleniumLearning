package com.example.assignments;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium01 {
    public static void main(String[] args) throws InterruptedException {
        // to open browser
        WebDriver driver=new ChromeDriver();
        Thread.sleep(2000);
        // to delete all cookies
        //driver.manage().deleteAllCookies();

        // to set the size of the window
        Dimension d=new Dimension(500,500);
        driver.manage().window().setSize(d);
        Thread.sleep(2000);

       // to set the position of the window
        Point p=new Point(100,150);
        driver.manage().window().setPosition(p);
        Thread.sleep(2000);
        driver.quit();
    }
}
