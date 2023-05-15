package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class DriverManager extends Utils {
    String browserName = "firefox";
    public void openBrowser(){
        // Open Chrome browser
        if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        // Open Edge browser
        } else if (browserName.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        // Open Firefox browser
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Your browser name " + browserName + " is wrong or not implemented");
        }
        // Open URL
        driver.get("https://demo.nopcommerce.com/");
        // Maximize the window
        driver.manage().window().maximize();
        // Implying implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    public void closeBrowser(){
        // Close the browser
        driver.close();
    }

}
