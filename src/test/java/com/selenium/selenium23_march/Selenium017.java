package com.selenium.selenium23_march;

import io.qameta.allure.Description;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium017 {

    // Atomic Test Cases
    // TC who don't have any dep.
    // They serve single purpose 0

    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        driver=new EdgeDriver();
    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testVWOLoginPositive(){

        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();
    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testVWOLoginNegative(){

        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();
    }

@AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
