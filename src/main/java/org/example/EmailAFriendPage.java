package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class EmailAFriendPage extends Utils{
    // Creating object for LoadProp class to call get property method
    LoadProp loadProp = new LoadProp();
    // Storing locators
    private By _friendEmail = By.xpath("(//input[starts-with(@placeholder, \"Enter\")])[1]");
    private By _yourEmail = By.xpath("(//input[starts-with(@placeholder, \"Enter\")])[2]");
    private By _personalMessage = By.xpath("//textarea[contains(@placeholder, \"personal \")]");
    private By _sendEmailButton = By.xpath("//button[@class=\"button-1 send-email-a-friend-button\"]");
    private By _emailAFriendErrorMessage = By.xpath("//div[@class= \"message-error validation-summary-errors\"]");
    private By _message1ProductName_ReferAProduct = By.xpath("//a[@href=\"/apple-macbook-pro-13-inch\"]");
    private By _message2_ReferAProduct = By.xpath("//div[@class=\"page-body\"]/div[2]");


    public void fillInEmailAFriendDetails_RegisteredUser() {
        // explicit wait added for firefox browser synchronization
        explicitWait_ElementToBeClickable(_friendEmail);
        // Type friend's email
        typeText(_friendEmail, loadProp.getProperty("emailAFriendPage_FriendEmail_registeredUser"));
        // Type your email address
        typeText(_yourEmail,loadProp.getProperty("emailAFriendPage_YourEmail_registeredUser"));
        // Type Personal message
        typeText(_personalMessage,loadProp.getProperty("emailAFriendPage_PersonalMessage"));
        // Click on Send Email button
        clickOnElement(_sendEmailButton);
    }


    public void captureActualEmailAFriendMessage() {
        loadProp.getProperty("emailAFriendPage_ExpectedReferAFriendMessage");
        // Capture & print the message displayed
        String message1ProductName_ReferAProduct = getTextFromElement(_message1ProductName_ReferAProduct);
        String message2_ReferAProduct = getTextFromElement(_message2_ReferAProduct);
        System.out.println("Message displayed to the user on referring a product to a friend: \n" + message1ProductName_ReferAProduct);
        System.out.println(message2_ReferAProduct);
        // Assert to verify if the actual display message matches the expected display message
        Assert.assertEquals(message2_ReferAProduct, loadProp.getProperty("emailAFriendPage_ExpectedReferAFriendMessage"), "The display message is not same");

    }
}
