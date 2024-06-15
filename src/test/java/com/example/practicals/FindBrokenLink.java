package com.example.practicals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class FindBrokenLink {
    public static void main(String[] args) throws MalformedURLException, IOException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //broken URL

        //Step 1 - IS to get all urls tied up to the links using Selenium

        //  Java methods will call URL's and gets you the status code

        //if status code >400 then that url is not working-> link which tied to url is broken

        //a[href*="soapui"]'
        List<WebElement> links=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a=new SoftAssert();

        for(WebElement link: links)
        {
          String url=link.getAttribute("href");
          HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
          conn.setRequestMethod("HEAD");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
          conn.connect();
          int responseCode=conn.getResponseCode();
          a.assertTrue(responseCode<400,"The link with text "+link.getText()+" is broken with code "+responseCode);

        }
        a.assertAll();
    }
}
