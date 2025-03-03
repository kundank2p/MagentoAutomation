package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.SignupPage;
import utils.DriverManager;
import java.util.Objects;

public class SignupSteps {
    private final SignupPage signupPage = new SignupPage(DriverManager.getDriver());
    private static String generatedEmail;
    public static String getGeneratedEmail() {
        return generatedEmail;
    }

    @Given("I am on the signup page")
    public void navigateToSignupPage() {
        DriverManager.getDriver().get("https://magento.softwaretestingboard.com/customer/account/create/");
    }

    @When("I enter valid registration details")
    public void enterValidDetails() {
        generatedEmail = "kundan" + System.currentTimeMillis() + "@magento.com";
        signupPage.completeRegistration("Kundan", "Prasad", generatedEmail, "P@ssw0rd123!");
    }


    @Then("I should be redirected to my account page")
    public void verifyAccountPage() {
        boolean signupSuccess = signupPage.isSignupSuccessful();
        Assert.assertTrue(signupSuccess, "Signup was not successful! Current URL: " + DriverManager.getDriver().getCurrentUrl());
    }

    @When("I log out")
    public void logout() {
        signupPage.logout();
    }

    @Then("I should be on the login page")
    public void verifyLoginPage() {
        Assert.assertTrue(Objects.requireNonNull(DriverManager.getDriver().getCurrentUrl()).contains("magento.softwaretestingboard.com"), "Login page is not displayed!");
    }
}