package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();
    LogInPage logInPage = new LogInPage();
    ProductPage productPage = new ProductPage();
    EmailAFriendPage emailAFriendPage = new EmailAFriendPage();





    @Given("I am on homepage")
    public void iAmOnHomepage() {
        homePage.verifyHomepageURL();
    }

    @And("I click on the register link")
    public void iClickOnTheRegisterLink() {
        homePage.clickOnRegisterLink();
    }

    @When("I enter required registration details")
    public void i_enter_required_registration_details() {
        registrationPage.fillInRegistrationDetails_FirstTimeRegistration();

    }
    @Then("I should be able to register successfully")
    public void i_should_be_able_to_register_successfully() {
        registrationResultPage.verifyUserRegisteredSuccessfully();

    }


    @Given("I am a registered user")
    public void iAmARegisteredUser() {
        homePage.clickOnRegisterLink();
        registrationPage.fillInRegistrationDetails_ForRegisteredUser();
    }

    @When("I log in")
    public void iLogIn() {
        homePage.clickOnLoginLink();
        logInPage.fillInLoginDetails();
        homePage.verifyUserIsLoggedIn();
    }

    @And("I add the product to cart")
    public void iAddTheProductToCart() {
        homePage.addToCartButton_AppleMacBookPro13Inch();
        productPage.verifyUserIsOnProductPage();
    }

    @And("I click on Email a friend Button")
    public void iClickOnEmailAFriendButton() {
        productPage.clickOnEmailAFriendButton();
    }

    @And("I fill in Email a friend details")
    public void iFillInEmailAFriendDetails() {
        emailAFriendPage.fillInEmailAFriendDetails_RegisteredUser();
    }

    @Then("I should be able to see Email a friend success message")
    public void iShouldBeAbleToSeeEmailAFriendSuccessMessage() {
        emailAFriendPage.captureActualEmailAFriendMessage();
    }




}