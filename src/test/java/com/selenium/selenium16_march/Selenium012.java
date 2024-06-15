package com.selenium.selenium16_march;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Selenium012 {

    // Locators
    // 1. ID, ClassName, Name, byTag F(n) -> GetText and GetAttribute (Webelements)

    // 2. LinkText & Partial Text
    // 3.Css Selectors
    // 4. Xpath

    @Test
    @Description("Verify the current url, title of vwo app")
    public void testVWOLogin12(){

        WebDriver driver= new EdgeDriver();
        driver.get("https://app.vwo.com");

        // Linked text
        //WebElement anchor_tag= driver.findElement(By.linkText("Start a free trial"));

        WebElement anchor_tag=driver.findElement(By.partialLinkText("Start a free"));
        System.out.println(anchor_tag.getAttribute("href"));
        anchor_tag.click();


        driver.quit();

    }
}
