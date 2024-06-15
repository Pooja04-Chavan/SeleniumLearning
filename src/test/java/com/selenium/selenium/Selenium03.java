package com.selenium.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class Selenium03 {

    @Test
    public void testMethod() {
        // Extension to the Edge Browser
        // YouTube video -. Ad blocker Extension
        // Selenium ?

        EdgeOptions edgeOptions=new EdgeOptions();
       // edgeOptions.addArguments("--headless");
        edgeOptions.addExtensions(new File("/Users/Admin/Downloads/AdBlocker.crx"));
        WebDriver driver=new EdgeDriver(edgeOptions);
        driver.get("https://youtube.com");
        System.out.println(driver.getTitle());

        driver.quit();

    }
}
