package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationResultPage extends Utils{
    // Creating object for LoadProp class to call get property method
    LoadProp loadProp = new LoadProp();
    // Storing instance locator for registration confirmation message
    private By _registrationConfirmationMessage = By.xpath("//div[@class=\"result\"]");


    public void verifyUserRegisteredSuccessfully(){
      // Get text from element
      String actualRegistrationCompleteMessage =  getTextFromElement(_registrationConfirmationMessage);
      // Assert to verify the registration display message
      Assert.assertEquals(actualRegistrationCompleteMessage,loadProp.getProperty("registrationResultPage_ExpectedRegistrationCompleteMessage"),"Your registration is not working.");
    }


}
