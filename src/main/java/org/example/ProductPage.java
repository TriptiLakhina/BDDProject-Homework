package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductPage extends Utils{
    private By _addToCartButton = By.xpath("//button[contains(@id,'add-to-cart')]");
    private By _addToWishlistButton = By.xpath("//button[contains(@id,'add-to-wishlist')]");
    private By _addToCompareButton = By.xpath("(//button[contains(@class,'button-2 add-to-compare')])[1]");
    private By _emailAFriendButton = By.xpath("(//button[contains(@class,'button-2 email-a-friend')])[1]") ;
    private By _shoppingCartButton_Header = By.cssSelector("span.cart-label");
    private By _productName_Title = By.cssSelector("div.product-name");



    public void clickOnEmailAFriendButton(){
        // Click on Email a friend button
        explicitWait_ElementToBeClickable(_emailAFriendButton);
        clickOnElement(_emailAFriendButton);

    }

    public void verifyUserIsOnProductPage(){
 //       Assert.assertEquals(getCurrentUrl().contains(getTextFromElement(_productName_Title)),true,"User is not directed to the correct product page");
        Assert.assertEquals(verifyUrlContainsElement(_productName_Title),true,"User is not directed to the correct product page");
    }
}
