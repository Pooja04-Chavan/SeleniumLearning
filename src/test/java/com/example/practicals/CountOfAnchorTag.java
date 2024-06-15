package com.example.practicals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class CountOfAnchorTag {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

       int a= driver.findElements(By.tagName("a")).size();
        System.out.println(a);
        //limit the webdriver count links from footer only
        WebElement footerLinks=driver.findElement(By.id("gf-BIG"));

        System.out.println(footerLinks.findElements(By.tagName("a")).size());

        WebElement columnLink=footerLinks.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int coulmnLinkCount=columnLink.findElements(By.tagName("a")).size();
        System.out.println(coulmnLinkCount);

        //click on all links present in column and check page open or not
        for (int i = 1; i < coulmnLinkCount; i++)
        {
            String clickOnLinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
            columnLink.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
            Thread.sleep(5000);
        }
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> it= windows.iterator();
        while (it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
    }
}
