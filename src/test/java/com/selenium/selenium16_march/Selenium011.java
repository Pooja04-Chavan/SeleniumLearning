package com.selenium.selenium16_march;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium011 {

    @Test(groups = "QA", priority=1)
    @Description("Verify the login with valid username and valid password, Login should work")
    public void testVWOLoginPositive() throws InterruptedException {
        WebDriver driver = new EdgeDriver();

        //        1. Open the URL .app.vwo.com/#/login](https://app.vwo.com/#/login)
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");


        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("pooja15@gmail.com");

        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("Pooja@12345");

        driver.findElement(By.id("js-login-btn")).click();

        Thread.sleep(3000);

        driver.close();

    }

    //        **Project #1 - TC ( Negaative) - Invalid username, pass - Error message**
//
//        1. Open the URL .app.vwo.com/#/login](https://app.vwo.com/#/login)
//        2. **Find the Email id** and enter the email as admin@admin.com
//        3. **Find the pass inputbox** and enter passwrod as admin.
//        4. Find and Click on the submit button
//        5. Verify that the error message is shown "Your email, password, IP address or location did not match"

    @Test(groups = "QA", priority =2)
    @Description("Verify the login with invalid username and invalid password, Error message should display")
    public void testVWOLoginNegative()
    {
        WebDriver driver=new EdgeDriver();

        //        1. Open the URL .app.vwo.com/#/login](https://app.vwo.com/#/login)
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");

        // 2. **Find the Email id** and enter the email as admin@admin.com
        //  id, className, name, css Selector, xpath
        //  LinkText and PartialText which are onlu for <a>
        // <input
        // type="email"
        // class="text-input W(100%)"
        // name="username"
        // id="login-username"
        // data-qa="hocewoqisi">

        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("admin@admin.com");

        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("admin");

        driver.findElement(By.id("js-login-btn")).click();

        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        WebElement error_msg = driver.findElement(By.className("notification-box-description"));
        String error_msg_text=error_msg.getText();

        Assert.assertEquals(error_msg_text, "Your email, password, IP address or location did not match");
        System.out.println(error_msg_text);

       driver.close();

    }

    @Test(groups = "QA", priority =3)
    @Description("Verify the login with invalid username and invalid password, Error message should display")
    public void testVWOLoginNegative2()
    {
        WebDriver driver=new EdgeDriver();

        //        1. Open the URL .app.vwo.com/#/login](https://app.vwo.com/#/login)
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");


        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("pooja15@gmail.com");

        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("admin");

        driver.findElement(By.id("js-login-btn")).click();

        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        WebElement error_msg = driver.findElement(By.className("notification-box-description"));
        String error_msg_text=error_msg.getText();

        Assert.assertEquals(error_msg_text, "Your email, password, IP address or location did not match");
        System.out.println(error_msg_text);

        driver.quit();

    }



}
