package org.example;

import org.openqa.selenium.By;

public class LogInPage extends Utils{
    // Storing locators as instance variables
    private By _eMail = By.xpath("//input[contains(@class, 'email')]");
    private By _password = By.xpath("//input[contains(@class,\"password\")]");
    private By _logInButton = By.xpath("//div[@class=\"buttons\"]//button[@class=\"button-1 login-button\"]");


    public void fillInLoginDetails() {
        // Type your email
        typeText(_eMail, "TestEmail5@gmail.com");
        // Type your password
        typeText(_password, "test@5");
        // Click on login button
        clickOnElement(_logInButton);
    }

}
