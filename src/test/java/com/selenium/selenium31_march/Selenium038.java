package com.selenium.selenium31_march;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class Selenium038 {
    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }


    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testPositive() throws InterruptedException {
        String URL = "https://the-internet.herokuapp.com/windows";
        driver.get(URL);
        driver.manage().window().maximize();

        String mainWindowHandle=driver.getWindowHandle();
        System.out.println("Before click"+mainWindowHandle);
        WebElement link=driver.findElement(By.linkText("Click Here"));
        link.click();

        Set<String> windowHandles=driver.getWindowHandles();

        // All the Windows Tab have a unique name
        for (String handles: windowHandles)
        {
            driver.switchTo().window(handles);
            System.out.println(handles);
            if (driver.getPageSource().contains("New window")){
                System.out.println("Test case passed");
            }
        }

        driver.switchTo().window(mainWindowHandle);
        Thread.sleep(2000);




    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
