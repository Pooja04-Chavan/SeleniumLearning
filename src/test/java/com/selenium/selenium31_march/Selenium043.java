package com.selenium.selenium31_march;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium043 {
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

        try {

            String URL = "https://google.com";
            driver.get(URL);

            driver.manage().window().maximize();

            WebElement element = driver.findElement(By.xpath("//*[@class='gLFyf']"));
            driver.navigate().refresh();
            WebElement element2 = driver.findElement(By.xpath("//*[@class='gLFyf']"));

            element2.sendKeys("The Testing Academy");

            // Refresh, Navigate other Page, change in DOM elements (Ajax Calls) - VueJS, AngularJS

            //  b1 - found driver
            // b1 remove
            // b1.click -> ? No such element

            //        driver.switchTo().frame(1);
            //driver.switchTo().alert().accept();

        }catch (StaleElementReferenceException | NoSuchElementException ex){
            ex.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
