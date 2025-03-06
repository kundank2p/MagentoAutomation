package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;
import utils.DriverManager;

import java.time.Duration;

public class LoginSteps {
    private final LoginPage loginPage = new LoginPage(DriverManager.getDriver());

    @Given("I am on the login page")
    public void navigateToLoginPage() {
        DriverManager.getDriver().get("https://magento.softwaretestingboard.com/customer/account/login/");
    }

    @When("I enter registered email and password")
    public void enterValidCredentials() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15));


        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("send2")));
        emailElement.sendKeys(SignupSteps.getGeneratedEmail());
        passwordElement.sendKeys("P@ssw0rd123!");
        signInButton.click();
    }


    @Then("I should be redirected to my account page after login")
    public void verifySuccessfulLogin() {
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful!");
    }

    @When("I enter incorrect login credentials")
    public void enterIncorrectLoginDetails() {
        loginPage.performLogin("invalidUser@example.com", "WrongPassword123");
    }

    @Then("I should see an error message {string}")
    public void verifyErrorMessage(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match!");
    }
}
