package com.example.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Assignment3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String[] product_needed={"iphone","Samsung","Nokia","Blackberry"};
       addProducts(driver,product_needed);



    }
    public static void addProducts(WebDriver driver,String[] product_needed)
    {
        int j=0;
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn.btn-success")));
        driver.findElement(By.cssSelector("button.btn.btn-success")).click();
        WebElement element=driver.findElement(By.xpath("//select[@data-style='btn-info']"));
        Select dropdown=new Select(element);
        dropdown.selectByValue("consult");
        driver.findElement(By.xpath("//span/input[@id='terms']")).click();
        //Thread.sleep(2000);
        driver.findElement(By.id("signInBtn")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-body']/h4[@class='card-title']")));
        //div[@class='card-body']/h4[@class='card-title']
        List<WebElement> product=driver.findElements(By.xpath("//div[@class='card-body']/h4[@class='card-title']"));
        for (int i = 0; i < product.size(); i++) {
            String[] productList=product.get(i).getText().split(" ");
            String formattedString=productList[0];
            System.out.println(formattedString);
            List itemsToAdd= Arrays.asList(product_needed);
            if (itemsToAdd.contains(formattedString)){
                j++;
                driver.findElements(By.cssSelector("button.btn.btn-info")).get(i).click();
                if (j==product_needed.length){
                    break;
                }

            }

        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
        driver.findElement(By.partialLinkText("Checkout")).click();
    }
}
