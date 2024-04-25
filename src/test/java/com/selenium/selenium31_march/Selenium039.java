package com.selenium.selenium31_march;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class Selenium039 {
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
        String URL = "https://app.vwo.com/#/analyze/osa/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1";
        driver.get(URL);
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Before Click " + mainWindowHandle);

        Actions ac=new Actions(driver);
        //xpath-//div[@data-qa='yedexafobi']
        ac.moveToElement(driver.findElement(By.cssSelector("[data-qa='yedexafobi']"))).build().perform();

        Thread.sleep(2000);

        Set<String> windowHandles=driver.getWindowHandles();
        System.out.println(windowHandles);

        Iterator<String> iterator=windowHandles.iterator();
        while (iterator.hasNext())
        {
            String childWindow=iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                System.out.println(driver.getTitle());
            }
        }
        Thread.sleep(2000);




    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
