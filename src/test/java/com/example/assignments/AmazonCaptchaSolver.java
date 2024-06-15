package com.example.assignments;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;
import java.util.Scanner;

public class AmazonCaptchaSolver {
    public static void main(String[] args) throws Exception {
        // Initialize the WebDriver
       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Navigate to the Amazon CAPTCHA page
        driver.get("https://www.amazon.com/errors/validateCaptcha");

        // Wait for the CAPTCHA to load
        Thread.sleep(2000);

        // Locate the CAPTCHA image
        WebElement captchaImage = driver.findElement(By.xpath("//img[@src='https://images-na.ssl-images-amazon.com/captcha/twhhswbk/Captcha_clknabhjiv.jpg']"));

        // Get the CAPTCHA image URL
        String captchaUrl = captchaImage.getAttribute("src");

        // Download the CAPTCHA image
        File captchaFile = new File("captcha.png");
        try (InputStream in = new URL(captchaUrl).openStream();
             FileOutputStream out = new FileOutputStream(captchaFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }

        // Encode the CAPTCHA image in Base64
        byte[] fileContent = FileUtils.readFileToByteArray(captchaFile);
        String encodedCaptcha = Base64.getEncoder().encodeToString(fileContent);

        // Your 2Captcha API key
        String apiKey = "YOUR_2CAPTCHA_API_KEY";

        // Submit the CAPTCHA to 2Captcha
        String captchaId = submitCaptcha(apiKey, encodedCaptcha);

        // Wait for the CAPTCHA to be solved
        Thread.sleep(20000);

        // Get the CAPTCHA solution
        String captchaSolution = getCaptchaSolution(apiKey, captchaId);

        // Enter the CAPTCHA solution in the input field
        WebElement captchaInput = driver.findElement(By.xpath("//input[@id='captchacharacters']"));
        captchaInput.sendKeys(captchaSolution);

        // Submit the form or proceed as needed
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        // Close the WebDriver
        driver.quit();
    }


    private static String submitCaptcha(String apiKey, String encodedCaptcha) throws Exception {
        String submitUrl = "http://2captcha.com/in.php";
        String response;

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(submitUrl);
            StringEntity entity = new StringEntity("method=base64&key=" + apiKey + "&body=" + encodedCaptcha);
            httpPost.setEntity(entity);
            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");

            HttpResponse httpResponse = client.execute(httpPost);
            response = new Scanner(httpResponse.getEntity().getContent()).useDelimiter("\\A").next();
        }

        if (response.startsWith("OK|")) {
            return response.split("\\|")[1];
        } else {
            throw new RuntimeException("Failed to submit CAPTCHA: " + response);
        }
    }

    private static String getCaptchaSolution(String apiKey, String captchaId) throws Exception {
        String resultUrl = "http://2captcha.com/res.php?key=" + apiKey + "&action=get&id=" + captchaId;
        String response;

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpResponse httpResponse;
            do {
                httpResponse = client.execute(new HttpPost(resultUrl));
                response = new Scanner(httpResponse.getEntity().getContent()).useDelimiter("\\A").next();
                if (response.startsWith("CAPCHA_NOT_READY")) {
                    Thread.sleep(5000);
                }
            } while (response.startsWith("CAPCHA_NOT_READY"));
        }

        if (response.startsWith("OK|")) {
            return response.split("\\|")[1];
        } else {
            throw new RuntimeException("Failed to get CAPTCHA solution: " + response);
        }
    }


}
