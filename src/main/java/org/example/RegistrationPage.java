package org.example;

import org.openqa.selenium.By;

public class RegistrationPage extends Utils{
    // Creating object for LoadProp class to call get property method
    LoadProp loadProp = new LoadProp();
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
        typeText(_firstName,loadProp.getProperty("registrationPage_FirstName"));
        // Type Last name
        typeText(_lastName,loadProp.getProperty("registrationPage_LastName"));
        // Select Day of birth from dropdown
        selectElementByIndex(_dayOfBirth, Integer.parseInt(loadProp.getProperty("registrationPage_DayOfBirth")));
        // Select Month of birth from dropdown
        selectElementByValue(_monthOfBirth,loadProp.getProperty("registrationPage_MonthOfBirth"));
        // Select Year of birth from dropdown
        selectElementByText(_yearOfBirth,loadProp.getProperty("registrationPage_YearOfBirth"));
        // Type email
        typeText(_email,loadProp.getProperty("registrationPage_Email_FirstTimeRegistration") + timeStamp() + loadProp.getProperty("registrationPage_EmailDomain_FirstTimeRegistration"));
        // Type password
        typeText(_password,loadProp.getProperty("registrationPage_Password"));
        // Type confirm password
        typeText(_confirmPassword,loadProp.getProperty("registrationPage_ConfirmPassword"));
        // Click on Register button
        clickOnElement(_registerButton);

    }

    public void fillInRegistrationDetails_ForRegisteredUser() {
        // Type first name
        typeText(_firstName,loadProp.getProperty("registrationPage_FirstName"));
        // Type Last name
        typeText(_lastName,loadProp.getProperty("registrationPage_LastName"));
        // Type email
        typeText(_email,loadProp.getProperty("registrationPage_Email_RegisteredUser"));
        // Type password
        typeText(_password,loadProp.getProperty("registrationPage_Password"));
        // Type confirm password
        typeText(_confirmPassword,loadProp.getProperty("registrationPage_ConfirmPassword"));
        // Click on Register button
        clickOnElement(_registerButton);


    }
}
