package org.example;

import org.openqa.selenium.By;

public class RegistrationPage extends Utils{
    private By _firstName = By.xpath("//input[@id=\"FirstName\"]");
    private By _lastName = By.xpath("//input[@id=\"LastName\"]");
    private By _email = By.xpath("//input[@id=\"Email\"]");
    private By _password = By.xpath("//input[@name=\"Password\"]");
    private By _confirmPassword = By.xpath("//input[@name=\"ConfirmPassword\"]");
    private By _registerButton = By.xpath("(//button[contains(@type, \"submit\")])[2]");
    private By _dayOfBirth = By.cssSelector("select[name=DateOfBirthDay]");
    private By _monthOfBirth = By.xpath("//select[@name=\"DateOfBirthMonth\"]");
    private By _yearOfBirth = By.xpath("//select[@name=\"DateOfBirthYear\"]");

    public void fillInRegistrationDetails_FirstTimeRegistration() {
        // Type first name
        typeText(_firstName, "TestFirstName");
        // Type Last name
        typeText(_lastName, "TestLastName");
        // Select Day of birth from dropdown
        selectElementByIndex(_dayOfBirth,9);
        // Select Month of birth from dropdown
        selectElementByValue(_monthOfBirth,"2");
        // Select Year of birth from dropdown
        selectElementByText(_yearOfBirth,"1986");
        // Type email
        typeText(_email, "TestEmail" + timeStamp() + "@gmail.com");
        // Type password
        typeText(_password, "test@5");
        // Type confirm password
        typeText(_confirmPassword, "test@5");
        // Click on Register button
        clickOnElement(_registerButton);

    }

    public void fillInRegistrationDetails_ForRegisteredUser() {
        // Type first name
        typeText(_firstName, "TestFirstName");
        // Type Last name
        typeText(_lastName, "TestLastName");
        // Type email
        typeText(_email, "TestEmail5@gmail.com");
        // Type password
        typeText(_password, "test@5");
        // Type confirm password
        typeText(_confirmPassword, "test@5");
        // Click on Register button
        clickOnElement(_registerButton);


    }
}
