package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager extends Utils {
    // Creating object for LoadProp class to call get property method
    LoadProp loadProp = new LoadProp();

    public void openBrowser(){
        // Open Chrome browser
        if (loadProp.getProperty("browserName").equalsIgnoreCase(loadProp.getProperty("chromebrowser"))) {
            driver = new ChromeDriver();
        // Open Edge browser
        } else if (loadProp.getProperty("browserName").equalsIgnoreCase(loadProp.getProperty("Edgebrowser"))){
            driver = new EdgeDriver();
        // Open Firefox browser
        } else if (loadProp.getProperty("browserName").equalsIgnoreCase(loadProp.getProperty("firefoxbroswer"))) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Your browser name " + loadProp.getProperty("browserName") + " is wrong or not implemented");
        }
        // Open URL
        openTheUrl(loadProp.getProperty("url"));
        // Maximize the window
        maximizeTheWindow();
        // Implying implicit wait
        implicitWait();
    }


    public void closeBrowser(){
        // Close the browser
        driver.close();
    }

}
