package com.example.practicals;

import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Hello {
    public static void main(String[] args) throws InterruptedException {
       // System.out.println("hello world");

        WebDriver driver=new ChromeDriver();
        driver.get("http://spicejet.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-5njf8e r-1otgn73']) [3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='USD']")).click();
     /*   List<WebElement> currency=driver.findElements(By.xpath("(//div[@class='css-1dbjc4n r-150rngu r-eqz5dr r-16y2uox r-1wbh5a2 r-11yh6sk r-1rnoaur r-1sncvnh']) [3]"));
        for (WebElement element:currency)
        {
            System.out.println(element.getText());
        }

        List<WebElement> radioButton=driver. findElements(By.xpath("(//div[@class='css-1dbjc4n r-18u37iz r-1w6e6rj']) [2]"));
        for (WebElement element:radioButton)
        {
            System.out.println(element.getText());
        }
*/
 driver.findElement(By.xpath("//*[text()='Senior Citizen']")).click();

    }
}
