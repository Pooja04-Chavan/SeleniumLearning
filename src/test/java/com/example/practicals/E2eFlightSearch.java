package com.example.practicals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class E2eFlightSearch {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://spicejet.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);
        List<WebElement> svgRadioButton=driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-zso239'] //*[local-name()='svg']"));
        svgRadioButton.get(0).click();

        driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();
        //from
        driver.findElement(By.xpath("//*[text()='BLR']")).click();
        Thread.sleep(3000);
        //destination
        driver.findElement(By.xpath("//*[text()='HYD']")).click();
        //date
        driver.findElement(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41']")).click();
       //return date
        if(driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']")).getAttribute("style").contains("background-color: rgb(238, 238, 238)"))
        {
            System.out.println("Is Disabled");
            Assert.assertTrue(true);
        }
        else {
            System.out.println("Is enabled");
            Assert.assertTrue(false);
        }

        driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
        Thread.sleep(2000);

        for (int i = 1; i <5 ; i++) {
           driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
        }

        driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-5njf8e r-1otgn73']) [3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='USD']")).click();
        driver.findElement(By.xpath("//*[text()='Senior Citizen']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
        Thread.sleep(2000);
       driver.close();
    }
}
