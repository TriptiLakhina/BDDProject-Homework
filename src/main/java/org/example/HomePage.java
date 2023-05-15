package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;


public class HomePage extends Utils{
    LoadProp loadProp = new LoadProp();
    // Storing locators as global variables
    private By _registerLink = By.xpath("//a[@href=\"/register?returnUrl=%2F\"]");
    private By _logo_Homepage = By.cssSelector("div.header-logo");
    private By _loginLink = By.xpath("//a[@href=\"/login?returnUrl=%2F\"]");
    private By _addToCartButton_AppleMacBookPro13Inch = By.xpath("//div[@class=\"product-grid home-page-product-grid\"]/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/button[1]");
    private By _log_OutLink = By.cssSelector("a.ico-logout");


    public void verifyHomepageURL(){
//        String MainWindow = getWindowHandle();
        String homepageURL = getCurrentUrl();
        System.out.println("Homepage URL is: " + homepageURL);
        Assert.assertEquals(homepageURL,loadProp.getProperty("url"),"Url does not match");
        Assert.assertEquals(homepageURL.contains(getTextFromElement(_logo_Homepage)),true,"URL does not match to the directed page");
    }

    public void clickOnRegisterLink() {
        // Click on register link
        clickOnElement(_registerLink);
    }

    public void clickOnLoginLink() {
        // Click on login link on homepage
        clickOnElement(_loginLink);

    }

    public void addToCartButton_AppleMacBookPro13Inch() {
        // Click on add to cart button of Apple MacBook Pro 13-inch
        clickOnElement(_addToCartButton_AppleMacBookPro13Inch);
    }

    public void verifyUserIsLoggedIn(){
        // Assert to verify user is logged in
        Assert.assertEquals(verifyUrlContainsElement(_log_OutLink),true,"User is not logged in.");
    }

}
