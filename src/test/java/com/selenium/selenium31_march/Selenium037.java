package com.selenium.selenium31_march;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium037 {
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
        String URL = "https://the-internet.herokuapp.com/drag_and_drop";
        driver.get(URL);

        Actions actions=new Actions(driver);

        WebElement from=driver.findElement(By.id("column-a"));
        WebElement to=driver.findElement(By.id("column-b"));

        // Drag and Drop
        //actions.dragAndDrop(from,to).perform();

        // Click and Hold
        actions.clickAndHold(from).moveToElement(to).release(to).build().perform();

       //Thread.sleep(4000);

       driver.get("https://awesomeqa.com/selenium/upload.html");
       WebElement uploadFileInput=driver.findElement(By.id("fileToUpload"));
       String dir=System.getProperty("user.dir");
        System.out.println(dir);
       uploadFileInput.sendKeys(dir+"\\src\\test\\java\\com\\selenium\\selenium31_march\\textFile.txt");
       driver.findElement(By.name("submit")).click();
       Thread.sleep(3000);

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
