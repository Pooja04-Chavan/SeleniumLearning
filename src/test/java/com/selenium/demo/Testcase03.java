package com.selenium.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase03 {
    @Test
    public void testVWOLogin(){
        // system.property to setup the path of the Drivers
        // Chrome -> ChromeDriver
        // Edge -> EdgeDriver
        // Firefox -> GeckoDriver
        // Safari -> Safaridriver
      //  Assert.assertTrue(false); // Main - TestNG

        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());

        driver.quit();

    }

}
