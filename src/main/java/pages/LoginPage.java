package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log;

import java.time.Duration;
import java.util.Objects;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By emailField = By.id("email");
    private final By passwordField = By.id("pass");
    private final By loginButton = By.id("send2");
    private final By errorMessage = By.xpath("//div[@class='message-error error message']/div");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Log.info("Login Page initialized.");
    }

    public void performLogin(String email, String password) {
        enterText(emailField, email);
        enterText(passwordField, password);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        Log.info("Login initialized.");
    }

    public boolean isLoginSuccessful() {
        try {
            // Wait for the URL to contain "customer/account"
            wait.until(ExpectedConditions.urlContains("customer/account"));

            // Check if the current URL contains "customer/account"
            boolean loginSuccessful = Objects.requireNonNull(driver.getCurrentUrl()).contains("customer/account");

            // Log the result
            if (loginSuccessful) {
                Log.info("Login Successful.");
            } else {
                Log.warn("Login Unsuccessful. URL does not contain 'customer/account'.");
            }

            return loginSuccessful;
        } catch (TimeoutException e) {
            // Log the timeout exception
            Log.error("Timeout occurred while waiting for login to complete: " + e.getMessage());
            return false;
        }
    }

    private void enterText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    public String getErrorMessage() {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return errorElement.getText();
    }
}
