package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationResultPage extends Utils{
    // Storing instance locator for registration confirmation message
    private By _registrationConfirmationMessage = By.xpath("//div[@class=\"result\"]");
    private String expectedRegistrationCompleteMessage = "Registration Completed";

    public void verifyUserRegisteredSuccessfully(){
        // Get text from element
      String actualRegistrationCompleteMessage =  getTextFromElement(_registrationConfirmationMessage);
      // Assert to verify the registration display message
        Assert.assertEquals(actualRegistrationCompleteMessage,expectedRegistrationCompleteMessage,"Your registration is not working.");
    }


}
