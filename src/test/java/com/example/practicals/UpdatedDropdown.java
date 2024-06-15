package com.example.practicals;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);

        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
       /* int i=1;
        while(i<5){
            driver.findElement(By.id("hrefIncAdt")).click();//click 4 times
            i++;
        }*/

        for (int i = 1; i <5 ; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();//click 4 times
        }

        for (int i = 1; i <3 ; i++) {
            driver.findElement(By.id("hrefIncChd")).click();//click 4 times
        }
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        driver.findElement(By.id("btnclosepaxoption")).click();

        driver.close();
    }
}
