package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Utils extends BasePage{
    // Reusable method for click on element - No return type, with parameters
    public static void clickOnElement(By by){
        driver.findElement(by).click();
    }

    // Reusable method for typing the text - No return type, with parameters
    public static void typeText(By by,String text){
        driver.findElement(by).sendKeys(text);
    }

    // Reusable method for getting the text from element - with return type, with parameters
    public static String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    // Reusable method for Timestamp
    public static long timeStamp(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.getTime();
    }

    // Reusable method to open the URL
    public static void openTheUrl(String url){
        driver.get(url);
    }

    // Reusable method for maximizing the window
    public static void maximizeTheWindow(){
        driver.manage().window().maximize();
    }

    // Reusable method for Implicit wait
    public static void implicitWait(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // Reusable method for explicit wait with condition Element to be clickable
    public static void explicitWait_ElementToBeClickable(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    // Reusable method for explicit wait with condition Invisibility of Element located
    public static void explicitWait_InvisibilityOfElementLocated(By by){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    // Reusable method for explicit wait with condition URL matches
    public static void explicitWait_UrlMatches(String url,int timeInSeconds){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.urlMatches(url));
    }

    // Reusable method for explicit wait with condition Text to be present in element located
    public static void explicitWait_TextToBePresentInElementLocated(By by, String text){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(by,text));
    }

    // Reusable method for explicit wait with condition visibility of element located
    public static void explicitWait_VisibilityOfElementLocated(By by,int timeInSeconds){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // Reusable method for getting text from elements for list
    public static List<WebElement> getTextFromElements(By by){
        List< WebElement> fullList = driver.findElements(by);
        for (WebElement nameOfEachElement:fullList){
            System.out.println(nameOfEachElement.getText());
        }return (fullList);
    }

    public static boolean getTextFromElements_Contains(By by, String text) {
        List<WebElement> productList = driver.findElements(by);
        for (WebElement productTitle : productList) {
            productTitle.getText();
            if (productTitle.getText().contains(text)) {
                return true;
            }
        }
        return false;
    }

    // Reusable method for select option from text
    public static void selectElementByText (By by,String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);

    }

    // Reusable method for select option from value
    public static void selectElementByValue (By by,String value){
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

    // Reusable method for select option from index
    public static void selectElementByIndex(By by,int index){
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
    }

    // Reusable method for getting text from alert message
    public static String handleAlertMessage_GetText() {
        String alertMessage = driver.switchTo().alert().getText();
        return alertMessage;
    }

    // Reusable method for accepting the alert message
    public static void handleAlertMessage_Accept(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    // Reusable method to find presence of elements on web page
    public static void arrayListSizeNotEqualToZero(By by, String textToPrint, String textToPrintInElseCondition) {
        if (driver.findElements(by).size() != 0) {
            System.out.println(textToPrint);
        } else {
            System.out.println(textToPrintInElseCondition);
        }
    }

    // Reusable method to get the current URL
    public static String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    // Reusable method to get the window handle
    public static String getWindowHandle(){
        return driver.getWindowHandle();
    }

    public static String currentTimeStamp(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyhhmmss");
        return sdf.format(date);
    }

    public static void captureScreenshot_pom(String filename){
        // Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);

        // Call getScreenshot as method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        // Move image file to new destination
        File destFile=new File("src\\test\\Screenshots\\" +filename+""+currentTimeStamp()+".png");

        // Copy file at destination
        try {

            FileUtils.copyFile(SrcFile,destFile);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean verifyUrlContainsElement(By by){
        getCurrentUrl().contains(getTextFromElement(by));
        return true;
    }

    public boolean verifyUrlContainsText(String text){
        getCurrentUrl().contains(text);
        return true;
    }

}
